package by.htp.students.bean;

public class Node {

	Student student;
	int studentCounter;
	Node nodeNext;
	Node nodePrev;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getStudentCounter() {
		return studentCounter;
	}

	public void setStudentCounter(int studentCounter) {
		this.studentCounter = studentCounter;
	}

	public Node getNodeNext() {
		return nodeNext;
	}

	public void setNodeNext(Node nodeNext) {
		this.nodeNext = nodeNext;
	}

	public Node getNodePrev() {
		return nodePrev;
	}

	public void setNodePrev(Node nodePrev) {
		this.nodePrev = nodePrev;
	}

	public void addNewStudent(Student student) {
		if (studentCounter == 0) {

			Node nodeNew = new Node();
			nodeNew.student = student;

			nodeNext = nodeNew;
			nodePrev = nodeNew;

			nodeNew.nodeNext = this;
			nodeNew.nodePrev = this;

			studentCounter++;

		} else {

			Node nodeNew = new Node();
			nodeNew.student = student;

			nodeNew.nodePrev = nodePrev;
			nodePrev.nodeNext = nodeNew;

			nodePrev = nodeNew;

			studentCounter++;

		}
	}

	public void addNewStudent(Student student, int position) {

		Node tempNode = nodeNext;
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

	public void findStudent(String name) {
		Node tempNode = nodeNext;
		while (tempNode != null) {
			if (name == tempNode.student.getName()) {
				viewStudent(tempNode.student);
			}
			tempNode = tempNode.nodeNext;
		}
	}

	public void viewStudent(Student student) {
		System.out.println("Student view: " + student.getName() + " " + student.getAge() + " " + student.getYear());
	}

	public void viewAllStudents() {
		Node tempNode = nodeNext;
		System.out.println("======= Student list =======");
		while (tempNode != null) {
			System.out.println(tempNode.student.getName());
			tempNode = tempNode.nodeNext;
		}
		System.out.println("============================");
	}

	public void deleteStudent(String name) {
		Node tempNode = nodeNext;
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
}
