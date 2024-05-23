package StudentRecordManagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import StudentRecordManagement.DAO.StudentDao;
import StudentRecordManagement.Entity.Student;

import java.util.List;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "!😀!😀!😀!😀!Welcome to the Student Record Management System!😀!😀!😀!😀!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("StudentRecordManagement/Config.xml");
        StudentDao sd = (StudentDao) context.getBean("studentDao");
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean continueLoop = true;
        while(continueLoop) {
        	System.out.println("***************************************");
        	System.out.println("Select a valid option::");
        	System.out.println("Press 1 for adding new student detail.");
            System.out.println("Press 2 to see a student detail.");
            System.out.println("Press 3 to see all the student details.");
            System.out.println("Press 4 to update a student record.");
            System.out.println("Press 5 to delete a student record.");
            System.out.println("Press 6 to exit.☹️");
            System.out.println("***************************************");
            
            choice = sc.nextInt();
            
            switch(choice) {
            
            case 1:
            	System.out.println("Enter the student details:");
            	int id, age;
            	String name, course;
            	sc.nextLine(); // To clear the buffer
            	System.out.println("Enter the name of the student:");
            	name = sc.nextLine();            	
            	System.out.println("Enter the id of the student:");
            	id = sc.nextInt();
            	System.out.println("Enter the age of the student:");
            	age = sc.nextInt();
            	sc.nextLine(); // To clear the buffer
            	System.out.println("Enter the course the student is enrolled into:");
            	course = sc.nextLine();
            	
            	Student student = new Student(id, name, age, course);
            	sd.insertData(student);
            	break;
            case 2:
            	System.out.println("Enter the student id to be searched:");
            	int studentId = sc.nextInt();
            	Student studentDetail = (Student) sd.getARow(studentId);
            	System.out.println("-------------------------------------------");
            	System.out.println("Id : " + studentDetail.getStudentId());
            	System.out.println("Name : " + studentDetail.getStudentName());
            	System.out.println("Age : " + studentDetail.getAge());
            	System.out.println("Course : " + studentDetail.getCourse());
            	System.out.println("-------------------------------------------");
            	break;
            case 3:
            	List<Student> students = sd.getAllData();
            	int index = 0;
            	for(Student s : students) {
            		System.out.println("++++++++++++++Student " + index + "++++++++++++++");
                	System.out.println("Id : " + s.getStudentId());
                	System.out.println("Name : " + s.getStudentName());
                	System.out.println("Age : " + s.getAge());
                	System.out.println("Course : " + s.getCourse());
                	index++;
            	}
            		
            	break;
            case 4:
            	System.out.println("Enter the student Id:");
            	int i = sc.nextInt();
            	Student s = (Student) sd.getARow(i);
            	sc.nextLine(); // To clear the buffer
            	System.out.println("Enter new name or enter space to move further:");
            	String val = sc.nextLine();
            	if(val != " ")
            		s.setStudentName(val);
            	System.out.println("Enter new id or enter space to move further:");
            	val = sc.nextLine();
            	if(val != " ") 
            		s.setStudentId(Integer.parseInt(val));
            	System.out.println("Enter new age or enter space to move further:");
            	val = sc.nextLine();
            	if(val != " ") 
            		s.setAge(Integer.parseInt(val));
            	System.out.println("Enter new course or enter space to move further:");
            	val = sc.nextLine();
            	if(val != " ") 
            		s.setCourse(val);
            	
            	sd.updateData(s);
            	System.out.println("!!!!! Data updated successfully !!!!!");
            	break;
            case 5:
            	System.out.println("Enter the student Id:");
            	int sid = sc.nextInt();
            	sd.deleteData(sid);
				break;
			case 6:
				System.out.println("Thanks for using our application.");
				continueLoop = false;
				break;
			default:
				System.out.println("Select correct option:");
            }
        }
    }
}
