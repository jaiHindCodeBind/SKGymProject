package com.codeBind.gymMgmt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.codeBind.gymMgmt.model.UserMst;

@Service(value = "userMasterDao")
public class UserMasterDaoImpl implements UserMasterDao {

	/* (non-Javadoc)
	 * @see com.codeBind.gymMgmt.dao.UserMasterDao#getUserDtlsByUserId(java.lang.String)
	 */
	 @PersistenceContext
     private EntityManager em;
	@Override
	public UserMst getUserDtlsByUserId(String userName) {
		// TODO Auto-generated method stub
		UserMst userMstDtls = null;
		
		

		//Session session =getHibernateTemplate().getSessionFactory().getCurrentSession();
		try {
			//Criteria criteria = em.unwrap(Session.class).createCriteria(UserMst.class);
			Criteria criteria = em.unwrap(Session.class).createCriteria(UserMst.class);
			criteria.add(Restrictions.eq("loginId", userName).ignoreCase());
			userMstDtls = (UserMst) criteria.uniqueResult();
		} catch (Exception e) {
			//throw new FPException("An error occurred while processing your request, please contact administrator.", ErrorCodes.GENERAL_EXCEPTION_KEY);
		}finally{
			//getSession().clear();
		}
		//logger.info("Exiting getUserDtlsByUserId()");
		return userMstDtls;
	}

}
