package by.htp.students.bean;

import java.util.Iterator;

public class Group implements Iterable<Student> {

	private int studentCounter;
	private Node first;

	private class Node {
		Student student;
		Node nodeNext;
		Node nodePrev;
	}

	public int getStudentCounter() {
		return studentCounter;
	}

	public void setStudentCounter(int studentCounter) {
		this.studentCounter = studentCounter;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void addNewStudent(Student student) {

		if (isEmpty()) {

			first = new Node();
			Node nodeNew = new Node();
			nodeNew.student = student;

			first.nodeNext = nodeNew;
			first.nodePrev = nodeNew;

			nodeNew.nodeNext = first;
			nodeNew.nodePrev = first;

			studentCounter++;

		} else {

			Node nodeNew = new Node();
			nodeNew.student = student;

			nodeNew.nodePrev = first.nodePrev;
			first.nodePrev.nodeNext = nodeNew;

			first.nodePrev = nodeNew;

			studentCounter++;

		}
	}

	public void addNewStudent(Student student, int position) {

		Node tempNode = first.nodeNext;
		for (int i = 1; i < studentCounter; i++) {
			if (i == position) {

				Node nodeNew = new Node();
				nodeNew.student = student;

				nodeNew.nodePrev = tempNode.nodePrev;
				tempNode.nodePrev.nodeNext = nodeNew;

				nodeNew.nodeNext = tempNode;
				tempNode.nodePrev = nodeNew;

				studentCounter++;

				System.out.println("Student " + student.getName() + " was added in position " + position);

				break;
			}
			tempNode = tempNode.nodeNext;
		}
	}

	public void deleteStudent(String name) {
		Node tempNode = first.nodeNext;
		while (tempNode != null) {
			if (name == tempNode.student.getName()) {
				System.out.println("Student " + tempNode.student.getName() + " was deleted!");
				tempNode.nodeNext.nodePrev = tempNode.nodePrev;
				tempNode.nodePrev.nodeNext = tempNode.nodeNext;
				studentCounter--;
			}
			tempNode = tempNode.nodeNext;
		}
	}

	public void findStudent(String name) {
		for (Student item : this) {
			if (item.getName() == name) {
				viewStudent(item);
			}
		}
	}

	public void viewStudent(Student student) {
		System.out.println("Student view: " + student.getName() + " " + student.getAge() + " " + student.getYear());
	}

	public void viewAllStudents() {
		System.out.println("======= Student list =======");
		for (Student item : this) {
			System.out.println(item.getName());
		}
		System.out.println("============================");
	}

	@Override
	public Iterator<Student> iterator() {
		return new NodeIterator();
	}

	private class NodeIterator implements Iterator<Student> {

		private Node current = first;

		public boolean hasNext() {
			return current.nodeNext != null;
		}

		public Student next() {
			Student item = current.nodeNext.student;
			current = current.nodeNext;
			return item;
		}
	}
}