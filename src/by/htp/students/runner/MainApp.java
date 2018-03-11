package by.htp.students.runner;

import by.htp.students.bean.Node;
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

		Node node = new Node();

		node.addNewStudent(student1);
		node.addNewStudent(student2);
		node.addNewStudent(student3);
		node.addNewStudent(student4);
		node.addNewStudent(student5);
		node.addNewStudent(student6);
		node.addNewStudent(student7);

		node.viewAllStudents();
		node.findStudent("Name5");
		node.deleteStudent("Name3");
		node.viewAllStudents();
		node.addNewStudent(student101, 2);
		node.viewAllStudents();

	}
}
