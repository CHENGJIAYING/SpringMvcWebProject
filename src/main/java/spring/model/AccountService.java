package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDao aDao;
	
	@Override
	public boolean checkLogin(Account users) {
		return aDao.checkLogin(users);
	}

}
