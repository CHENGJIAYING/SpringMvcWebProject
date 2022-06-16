package spring.model;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDao implements IAccountDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean checkLogin(Account users) {
		Session session = sessionFactory.openSession();
		
		String hql = "from Account where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("user", users.getUsername());
        query.setParameter("pwd", users.getUserpwd());
        
        Account account = query.uniqueResult();
        session.close();
        
        if(account!=null) {
        	return true;
        }
		return false;
	}

}
