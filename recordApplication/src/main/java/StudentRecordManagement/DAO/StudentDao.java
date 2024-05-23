package StudentRecordManagement.DAO;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import StudentRecordManagement.Entity.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	// Inserting data into the database
	@Transactional
	public Integer insertData(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	// Fetching a single row from the database
	public Student getARow(int studentId) {
		Student student = (Student) this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	// Fetching multiple row from the database
	public List<Student> getAllData() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	// Updates a row in the database
	@Transactional
	public void updateData(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	// Deletes a row from the database
	@Transactional
	public void deleteData(int studentId) {
		Student student = (Student) this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
}
