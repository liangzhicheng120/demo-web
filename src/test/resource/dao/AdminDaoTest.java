package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinrui.demo.bean.Admin;
import com.xinrui.demo.dao.AdminDao;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.EncryptUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AdminDaoTest {

	@Autowired
	private AdminDao adminDao;

	@Test
	public void testGetPasswordByName() {
		Admin admin = new Admin();
		admin.setName("admin");
		adminDao.getPasswordByName(admin);
	}

	@Test
	public void testSave() throws Exception {
		String username = "���鳬";
		String password = "123";
		Admin admin = new Admin();
		admin.setName("���鳬");
		admin.setPassword(EncryptUtil.encryptMD5(username + password + Constants.SALT));
		adminDao.save(admin);
	}
}
