package listAssigment;

public class ListTester {
	public static void main(String[] args) {
	    SinglyLinkedList obj = new SinglyLinkedList();
	    Node n1 = new Node();
	    n1.data = 10;
	    Node n2 = new Node();
	    n2.data = 20;
	    Node n3 = new Node();
	    n3.data = 30;
	    obj.insertAtLast(n1);
	    obj.insertAtLast(n2);
	    obj.insertAtLast(n3);

	    Node n4 = new Node();
	    n4.data = 40;
	    Node n5 = new Node();
	    n5.data = 50;
	    obj.insertAtBeginning(n4);
	   obj.deleteAtBeginning();
	    System.out.println("output");
	    Node n6 = new Node();
	    n6.data = 100;
	  obj.deleteAtLast();
	  obj.insertAtLast(n6);
	    obj.display();

	  }
	}