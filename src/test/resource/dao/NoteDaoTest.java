package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		param.put("keyword", "json");
		param.put("pageParam", pageParam);
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

}
