/**
 * 
 */
package com.codeBind.gymMgmt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codeBind.gymMgmt.GymException;
import com.codeBind.gymMgmt.forms.LoginForm;
import com.codeBind.gymMgmt.model.Vo.UserVo;
import com.codeBind.gymMgmt.services.LoginService;
import com.codeBind.gymMgmt.services.UserMstService;
import com.codeBind.gymMgmt.util.Constants;
import com.codeBind.gymMgmt.util.GYMBaseController;


/**
 * @author Akshay
 *
 */
@Controller
public class LoginController extends GYMBaseController {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	public static final String  DASHBOARD = "dashBoard";
	private static final String LOGIN = "login"; 
	
	@Autowired
	private UserMstService userMstService;
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	/**
	 * @param form
	 * @return
	 */
	@RequestMapping("/")
	ModelAndView loadLoginPage(@ModelAttribute("loginForm") LoginForm form) {
		logger.info("Entering loadLoginPage()...");

		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(Constants.LOGIN_CHK_MSG, "hii");

		logger.info("Exiting loadLoginPage()...");
		return new ModelAndView(LOGIN, returnMap);
	}

	/**
	 * @param request
	 * @param response
	 * @param form
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/authenticateLogin.do")
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginForm") LoginForm form,
			BindingResult result) throws Exception {
		logger.info("Entering onSubmit()...");

		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			UserVo userVo = new UserVo();

			// generate new session
			generateNewSession();

			if (!StringUtils.isEmpty(form.getUserName())) {
				userVo = loginService.authenticateUser(form);

				String lang = Constants.DEFAULT_LANGUAGE;

				/*
				 * LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
				 * localeResolver.setLocale(request, response,StringUtil.parseLocaleString(lang));
				 */
				userVo.setLanguage(lang);
				setUserSession(userVo);
			}
			logger.info("Exiting onSubmit()...");
		} catch (GymException e) {
			System.out.println(Constants.LOGIN_CHK_MSG + e.getMessage());
			returnMap.put(Constants.LOGIN_CHK_MSG, e.getMessage());
			result.rejectValue(Constants.STRING_ERROR, e.getMessage());
			return new ModelAndView(LOGIN, returnMap);
		} catch (Exception e) {
			// result.rejectValue(Constants.STRING_ERROR, "An error occured while processing
			// your request. Please contact administrator.");
		}
		logger.info("Exiting onSubmit()...");
		return new ModelAndView(DASHBOARD, returnMap);
	}
}
