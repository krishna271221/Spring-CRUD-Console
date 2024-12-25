package com.Spring.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.CRUD.DAO.StudentDAO;
import com.Spring.CRUD.Entities.Student;


public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context= new ClassPathXmlApplicationContext("Config.xml");
       StudentDAO studentDAO= (StudentDAO) context.getBean("S1",StudentDAO.class);
       
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       while(go) {
       System.out.println("Press 1 for Add new student");
       System.out.println("Press 2 for display all student");
       System.out.println("Press 3 for get detail of single student");
       System.out.println("Press 4 for delete student");
       System.out.println("Press 5 for Update");
       System.out.println("Press 6 for exit");
      
       try {
		
    	 int input = Integer.parseInt( br.readLine());
    	System.out.println("");
     switch (input) {
		case 1: 
			//add new student
			System.out.println("Enter user Id:");
			int uId=Integer.parseInt(br.readLine());
			
			System.out.println("Enter user Name:");
			String uName= br.readLine();
			
			System.out.println("Enter user City:");
			String uCity= br.readLine();
			
			Student s= new Student(uId, uName, uCity);
			
			int r= studentDAO.insert(s);
			
			System.out.println(r+" Id of student Added");
			System.out.println("**************************************");
			System.out.println();
			break;
			
			
         case 2:
        	 //for display all student
        	 System.out.println("**************************************");
        	 List<Student> students= studentDAO.geStudents();
        	 for (Student st : students) {
        		System.out.println("Id :"+st.getId());
				System.out.println("Name :"+st.getName());
				System.out.println("City :"+st.getCity());
				System.out.println("_____________________________________");
			}
        	 System.out.println();
        	 break;
        	 
        	 
        case 3:
        	//get detail of single student
        	System.out.println("**************************************");
        	 System.out.println("Enter user Id:");
 			int userId=Integer.parseInt(br.readLine());
 			
 			Student geStudent = studentDAO.geStudent(userId);
 			System.out.println("Id :"+geStudent.getId());
			System.out.println("Name :"+geStudent.getName());
			System.out.println("City :"+geStudent.getCity());
			System.out.println("**************************************");
        	break;
        	
        	
        case 4:
        	//delete
        	System.out.println("**************************************");
        	 System.out.println("Enter user Id:");
  			int delId=Integer.parseInt(br.readLine());
  			studentDAO.deleteStudent(delId);
  			System.out.println("ID "+delId+" is deleted from record");
  			System.out.println("**************************************");
  			System.out.println();
        	break;
        	
        	
        case 5:
        	//Update
        	System.out.println("**************************************");
        	System.out.println("Enter user Id:");
  			int upId=Integer.parseInt(br.readLine());
  			
  			System.out.println("Enter New user Name:");
			String upName= br.readLine();
			
			System.out.println("Enter New user City:");
			String upCity= br.readLine();
			
  			Student stud = new Student(upId,upName,upCity);
  			studentDAO.updateStudent(stud);
  			System.out.println(upId +" is updated ");
  			System.out.println("**************************************");
  			System.out.println();
        	break;
        	
        	
        case 6: //exit
        	go=false;
        	break;
        	
        	
		default:
			break;
		}
    	 
	
    } catch (Exception e) {
		System.out.println("invalid input try another!");
		System.out.println(e.getMessage());
	}
       
    }
       System.out.println("Thank you for Visit!");
}

}