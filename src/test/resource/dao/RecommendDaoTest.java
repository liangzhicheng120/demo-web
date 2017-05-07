package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinrui.demo.bean.Recommend;
import com.xinrui.demo.dao.RecommendDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class RecommendDaoTest {

	@Autowired
	private RecommendDao recommendDao;

	@Test
	public void testSave() {
		Recommend recommend = new Recommend();
		recommend.setClzss("test");
		recommend.setAid(1);
		recommend.setLabel("test");
		recommend.setNid(2);
		recommendDao.save(recommend);
	}

	@Test
	public void testDelete() {
		Recommend recommend = new Recommend();
		recommend.setNid(1);
		recommendDao.delete(recommend);
	}

	@Test
	public void testUpdate() {
		Recommend recommend = new Recommend();
		recommend.setAid(1);
		recommend.setNid(1);
		recommend.setCost(10);
		recommendDao.update(recommend);
	}

}
