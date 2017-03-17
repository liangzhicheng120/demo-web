package dao;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> f9b48112b835692ebbfdacdbd0d0c02579280dae
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

<<<<<<< HEAD
import com.xinrui.demo.bean.Note;
=======
>>>>>>> f9b48112b835692ebbfdacdbd0d0c02579280dae
import com.xinrui.demo.dao.NoteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class NoteDaoTest {
	@Autowired
	private NoteDao NoteDao;
	
	@Test
	public void testGetAll() {
<<<<<<< HEAD
		List<Note> notes = NoteDao.getAll();
		for (Note note : notes) {
			System.out.println(note.getAid());
		}
=======
		NoteDao.getAll();
>>>>>>> f9b48112b835692ebbfdacdbd0d0c02579280dae
	}
}
