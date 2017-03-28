package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.param.PageParam;
import com.xinrui.demo.dao.NoteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class NoteDaoTest {
	@Autowired
	private NoteDao noteDao;

	@Test
	public void testGetAllByPage() {
		Map<String, Object> param = new HashMap<String, Object>();
		PageParam pageParam = new PageParam("1");
		param.put("keyword", "���");
		param.put("pageParam", pageParam);
		param.put("start", "2017-03-01");
		param.put("end", "2017-03-02");
		List<Note> notes = noteDao.getAllByPage(param);
		for (Note note : notes) {
			System.out.println(note.getContent());
		}
	}

	@Test
	public void testDelete() {
		int id = 1;
		Note note = new Note();
		note.setId(id);
		noteDao.delete(note);
	}

	@Test
	public void testSave() {
		Note note = new Note();
		note.setAid(1);
		note.setContent("��Щ����£���̬���󷵻ص�����һ�㲻����ƴ�õ� HTML ���� JSON");
		List<String> keywords = HanLP.extractKeyword("��Щ����£���̬���󷵻ص�����һ�㲻����ƴ�õ� HTML ���� JSON", 3);
		note.setKeyword(keywords.toString().replace("[", "").replace("]", ""));
		note.setTitle("json");
		note.setNclass("IT");
		noteDao.save(note);
	}

	@Test
	public void testGet() {
		int id = 0;
		Note note = noteDao.get(id);
		System.out.println(note.getContent());
	}
	
	@Test
	public void testUpdate(){
		Note note = new Note();
		note.setId(164);
		note.setContent("���鳬");
		note.setKeyword("����");
		note.setTitle("����");
		note.setNclass("IT");
		noteDao.update(note);
	}
}
