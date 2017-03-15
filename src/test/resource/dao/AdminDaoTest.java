package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinrui.demo.bean.Admin;
import com.xinrui.demo.dao.AdminDao;

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

}
