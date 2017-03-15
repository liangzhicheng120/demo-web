package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinrui.demo.bean.UserInfo;
import com.xinrui.demo.dao.UserInfoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserInfoTest {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Test
	public void testGetPasswordByName() {
		UserInfo userInfo = new UserInfo();
		userInfo.setName("admin");
		userInfoDao.getPasswordByName(userInfo);
	}

}
