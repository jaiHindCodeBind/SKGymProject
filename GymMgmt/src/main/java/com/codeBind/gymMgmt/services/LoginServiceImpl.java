package com.codeBind.gymMgmt.services;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeBind.gymMgmt.GymException;
import com.codeBind.gymMgmt.dao.UserMasterDao;
import com.codeBind.gymMgmt.dao.UserMstDao;
import com.codeBind.gymMgmt.forms.LoginForm;
import com.codeBind.gymMgmt.model.MstGroup;
import com.codeBind.gymMgmt.model.MstGroupModule;
import com.codeBind.gymMgmt.model.UserGrpAccess;
import com.codeBind.gymMgmt.model.UserMst;
import com.codeBind.gymMgmt.model.Vo.AccessGroupVo;
import com.codeBind.gymMgmt.model.Vo.MstGroupVo;
import com.codeBind.gymMgmt.model.Vo.UserVo;
import com.codeBind.gymMgmt.util.Constants;
import com.codeBind.gymMgmt.util.SortByString;


@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);

	@Resource(name="userMasterDao")
	private UserMasterDao userMasterDao;
	

	@Autowired
	private UserMstDao userMstDao;
	
	/* (non-Javadoc)
	 * @see com.codeBind.gymMgmt.services.LoginService#authenticateUser(com.codeBind.gymMgmt.forms.LoginForm)
	 */
	@Override
	public UserVo authenticateUser(LoginForm form) throws GymException {
		logger.info("Entering authenticateUser()...");
		UserVo userVo = new UserVo();
		UserMst usr = null;
		String userName = form.getUserName();
		String password = form.getPassword();
		try {
			// Get user Details By UserNm
			usr = userMstDao.getOne(userName);

			chkLoginValidation(usr,password);
			
			for (MstGroup usrGrp : usr.getMstGroup()) {
				userVo.setGymCode(usrGrp.getGrpCode());
				userVo.setGymNm(usrGrp.getGrpNm());
				//userVo.setUserTp(usrGrp.getGrpNm());
			}
			if(usr.getGymMaster() != null) {
				userVo.setGymCode(usr.getGymMaster().getGymCode());
				userVo.setGymNm(usr.getGymMaster().getGymNm());
			}
			userVo.setUserNM(usr.getUserNM());
			userVo.setLoginId(usr.getLoginId());
			userVo.setUserTp(usr.getUserTP());
			userVo.setAccessGroupList(new ArrayList<AccessGroupVo>());
			setUserGrpDtls(userVo, usr);
			
			
		} catch(GymException e) {
			throw e;
		}
		
		logger.info("Exiting authenticateUser().. ");
		return userVo;
	}


	private void setUserGrpDtls(UserVo userVo, UserMst usr) {
		logger.info("Entering setUserGrpDtls()...");
		
		Set<MstGroupVo> groups = new HashSet<MstGroupVo>();
		if (usr.getUserGrpAccess() != null) {
			//String[] grpId = new String[usr.getUserAccessModules().size()];
			//String[] grpNm = new String[usr.getUserAccessModules().size()];
			int i = 0;
			for (MstGroup usrGrp : usr.getMstGroup()) {		
				for (UserGrpAccess userAcc : usr.getUserGrpAccess()) {
					if (userAcc.getUserGroup().getGrpCode().equals(usrGrp.getGrpCode())) {
							//grpId[i] = userAcc.getUserGroup().getGrpId().toString();
							//grpNm[i] = userAcc.getUserGroup().getGrpNm();
							MstGroupVo grpVo = new MstGroupVo();
						// copy group module details to vo object
						BeanUtils.copyProperties(grpVo, userAcc.getUserGroup());
						buildAccessGroupList(userVo, userAcc.getUserGroup().getMstGroupModule());
						groups.add(grpVo);
						userVo.setMstGroupVo(groups);
						}
					}
			}
			//userVo.setGrpId(grpId);
		//userVo.setGrpNm(grpNm);
		}
		logger.info("Exiting setUserGrpDtls().. ");
	}


	/**@method use to set user Access Dtls
	 * @param userVo
	 * @param mstGroupModule
	 */
	private void buildAccessGroupList(UserVo userVo, Set<MstGroupModule> mstGroupModule) {
		System.out.println("Entering buildAccessGroupList()..");
		
	try {
		for (MstGroupModule grpModule : mstGroupModule) {
			if (grpModule.getCrAccess() || grpModule.getVwAccess() || grpModule.getMdAccess() || grpModule.getDelAccess()) {

				AccessGroupVo vo = new AccessGroupVo();
				vo.setCrAccess(grpModule.getCrAccess() ? 1 : 0);
				vo.setVwAccess(grpModule.getVwAccess() ? 1 : 0);
				vo.setMdAccess(grpModule.getMdAccess() ? 1 : 0);
				vo.setDelAccess(grpModule.getDelAccess() ? 1 : 0);
				vo.setMstModuleCode(grpModule.getGroupModulePk().getMstModuleId());
				vo.setMstModuleNm(grpModule.getMstModule().getModuleNm());
				vo.setGrpCode(grpModule.getGroupModulePk().getGrpId());
				vo.setToolTipDesc(grpModule.getMstModule().getToolTipDesc());

				if (grpModule.getMstModule().getMstScetion() == null) {
					vo.setSectionCode("N/A");
					vo.setSectionNm("N/A");
					vo.setSectionSrNo(0);
					vo.setSecToolTipDesc("N/A");
				} else {
					vo.setSectionCode(grpModule.getMstModule().getMstScetion().getSectionCode());
					vo.setSectionNm(grpModule.getMstModule().getMstScetion().getSectionNm());
					//vo.setSectionSrNo(grpModule.getMstModule().getMstScetion().getSectionSrNo());
					//vo.setSecToolTipDesc(grpModule.getMstModule().getMstScetion().getSec);
				}
				vo.setSearchPath(grpModule.getMstModule().getSearchPath());

				/*
				 * Do not add to accessGroup list if module id already exist in
				 * list. Prevents duplicates in left pane
				 */
				boolean addAccLst = true;
				/*
				 * for(AccessGroupVo accessGroupVo : userVo.getAccessGroupLst())
				 * { accessGroupVo.getModuleId().equals(vo.getModuleId()) }
				 */
				if(userVo.getAccessGroupList() != null && !userVo.getAccessGroupList().isEmpty()) {
					for (int i = 0; i < userVo.getAccessGroupList().size(); i++) {

						if (userVo.getAccessGroupList().get(i).getMstModuleCode().equals(vo.getMstModuleCode())) {
							// Update access as per new module access
							if (vo.getVwAccess() == 1) {
								userVo.getAccessGroupList().get(i).setVwAccess(1);
							}
							if (vo.getCrAccess() == 1) {
								userVo.getAccessGroupList().get(i).setCrAccess(1);
							}
							if (vo.getMdAccess() == 1) {
								userVo.getAccessGroupList().get(i).setMdAccess(1);
							}
							if (vo.getDelAccess() == 1) {
								userVo.getAccessGroupList().get(i).setDelAccess(1);
							}
							if (vo.getApproveAccess() == 1) {
								userVo.getAccessGroupList().get(i).setApproveAccess(1);
							}
							addAccLst = false;
							break;
						}
					}
				}
				if (addAccLst) {
					userVo.getAccessGroupList().add(vo);
				}
			}
		}
		
		ArrayList<AccessGroupVo> coll = userVo.getAccessGroupList();
		Collections.sort(coll, new SortByString());
		userVo.setAccessGroupList(coll);
	} catch(Exception e) {
		System.out.println("An error occured while processing your request. Please contact administrator.");
	}
		logger.info("Exiting buildAccessGroupList()...");
	}


	private ArrayList<AccessGroupVo> setUserAccessGropupList() {
		logger.info("Entering authenticateUser().. ");
		 ArrayList<AccessGroupVo> accessGroupVoList = null;
		 
		
		logger.info("Exiting authenticateUser().. ");
		return accessGroupVoList;
	}


	/**
	 * @Method used for check login validation
	 * @param User usr
	 * @param String password
	 * @throws FPException
	 */
	private void chkLoginValidation(UserMst usr, String password) throws GymException {
		logger.info("Entering chkLoginValidation()...");
		
		if (usr == null) {
			logger.error("No access to user");
			throw new GymException("User not having access..");
		}

		if (!usr.getStatus().equals(Constants.STATUS_ACTIVE)) {
			logger.error("user is not authorized");
			throw new GymException("User is not authorized, please contact administrator.");
		}

		// for encryption of password
		//password = PasswordService.getInstance().encrypt(password);
		if (!password.equals(usr.getPassword())) {
			//logger.error("Local Authentication failed. Incorrect password");
			throw new GymException("Invalid User Name or Password");
		}

		logger.info("Exiting chkLoginValidation()...");
	}
	
	
}
