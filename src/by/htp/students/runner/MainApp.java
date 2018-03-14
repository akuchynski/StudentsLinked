package by.htp.students.runner;

import by.htp.students.bean.Group;
import by.htp.students.bean.Student;

public class MainApp {

	public static void main(String[] args) {

		Student student1 = new Student("Name1", 20, 2016);
		Student student2 = new Student("Name2", 27, 2015);
		Student student3 = new Student("Name3", 22, 2011);
		Student student4 = new Student("Name4", 28, 2013);
		Student student5 = new Student("Name5", 23, 2018);
		Student student6 = new Student("Name6", 22, 2012);
		Student student7 = new Student("Name7", 26, 2018);

		Student student101 = new Student("Name101", 29, 2000);

		Group grp = new Group();

		grp.addNewStudent(student1);
		grp.addNewStudent(student2);
		grp.addNewStudent(student3);
		grp.addNewStudent(student4);
		grp.addNewStudent(student5);
		grp.addNewStudent(student6);
		grp.addNewStudent(student7);

		grp.viewAllStudents();
		grp.findStudent("Name5");
		grp.deleteStudent("Name3");
		grp.viewAllStudents();
		grp.addNewStudent(student101, 2);
		grp.viewAllStudents();
		
	}
}
