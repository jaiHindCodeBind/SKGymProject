/**
 * 
 */
package com.codeBind.gymMgmt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codeBind.gymMgmt.forms.LoginForm;
import com.codeBind.gymMgmt.model.UserMst;
import com.codeBind.gymMgmt.services.UserMstService;

/**
 * @author Akshay
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	private UserMstService userMstService;
	
	@RequestMapping("/")
	ModelAndView home(@ModelAttribute("loginForm") LoginForm form) {
		System.out.println("in controller...");
		Map<String, Object> returnMap = new HashMap<String, Object>();
 
		return new ModelAndView("login", returnMap);
	}
	
	@RequestMapping(value = "/authenticateLogin.do")
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginForm") LoginForm form) throws Exception {
		System.out.println("in the authenticate method:::::::");

	
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String msg = "User is not Authorized...";
		
		Optional<UserMst> userMst = null;
		String userName = form.getUserName();
		String password = form.getPassword();
		
		System.out.println("userName:::::::::"+userName);
		System.out.println("password::::::::"+password);
		System.out.println();
		
		userMst = userMstService.getUserLoginDtlsByUserId(userName);
		
		if(userMst != null) {
			if(userMst.get().getPassword().equals(password)) {
				msg = "User is Authorized";
			}
		}
	
		returnMap.put("msg",msg);
		return new ModelAndView("dashBoard", returnMap);
	}
}
