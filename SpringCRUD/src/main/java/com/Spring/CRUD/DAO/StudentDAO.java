package com.Spring.CRUD.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.Spring.CRUD.Entities.Student;



public class StudentDAO {

	private HibernateTemplate hibernateTemplate;
	
	
	  //save student
		@Transactional
		public int insert(Student student) {
		    System.out.println("Inserting student.. ");
		    Integer id = (Integer) this.hibernateTemplate.save(student);
		    System.out.println("Inserted student with ID: " + id);
		    return id;
		}

		
		//get single data
		public Student geStudent(int id) {
			Student student = this.hibernateTemplate.get(Student.class, id);
			return student;
		}
		
		//get alll data
		public List<Student> geStudents() {
			List<Student>student = this.hibernateTemplate.loadAll(Student.class);
			return student;
		}
		
		//DELETE OPERATION
		@Transactional
		public void deleteStudent(int id) {
			Student student = this.hibernateTemplate.get(Student.class, id);
			this.hibernateTemplate.delete(student);
		}

		
		//update 
		@Transactional
		public void updateStudent(Student student) {
			this.hibernateTemplate.update(student);
		}
		
		
		
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}


		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

}
