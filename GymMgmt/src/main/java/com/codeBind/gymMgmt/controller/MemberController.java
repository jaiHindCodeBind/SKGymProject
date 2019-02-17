/**
 * 
 */
package com.codeBind.gymMgmt.controller;



import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.codeBind.gymMgmt.GymException;
import com.codeBind.gymMgmt.model.MemberMst;
import com.codeBind.gymMgmt.services.MemberMstService;
import com.codeBind.gymMgmt.util.Constants;
import com.codeBind.gymMgmt.util.GYMBaseController;

/**
 * @author Akshay
 *
 */

@RestController
public class MemberController extends GYMBaseController{
	
	private static final Logger logger = LogManager.getLogger(MemberController.class);

	private static final String CREATE_MEMBER = "createMember"; 
	
	@Autowired
	private MemberMstService memberMstService;
	
	@GetMapping(value = "/test")
	public String getHi() {
		
		return "It's Up and Working...";
	}
	
	@RequestMapping(value = "/loadAddMember.do")
	public ModelAndView loadAddMember() {
		logger.info("Entering loadAddMember()...");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String msg = "We are on new Page";
		
		
		System.out.println("loginId " +getUserSession().getLoginId());
		System.out.println("gymCode " +getUserSession().getGymCode());
		System.out.println("gym Nm " +getUserSession().getGymNm());
		System.out.println("userNM " +getUserSession().getUserNM());
		System.out.println("userTP " +getUserSession().getUserTp());
		
		
		if (!validateUser(Constants.Modules.ADD_MEMBER, Constants.Actions.CREATE_ACTION)) {
			logger.info("Exiting loadEgmRequest in validator()....");
			return new ModelAndView(UNAUTHORIZED_VIEW);
		}
		
		returnMap.put("msg", msg);
		logger.info("Exiting loadAddMember()...");
		return new ModelAndView(CREATE_MEMBER, returnMap);
	}
	
	@PostMapping(value = "/member/createMember")
	public MemberMst saveNewMember(@RequestBody MemberMst memberMst) throws Exception{
		logger.info("Entering saveNewMember()...");
		
		return memberMstService.saveMember(memberMst);
		
	}
	
	@GetMapping(value = "/member/getAllMember.do")
	public Iterable<MemberMst> getAllMember() throws Exception{
		logger.info("Entering getAllMember()...");
			
		return memberMstService.getAllMember();
	}
}
