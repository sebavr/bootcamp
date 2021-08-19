package listAssigment;

public class SinglyLinkedList {
    Node head;
    public SinglyLinkedList()
    {
      head = null;
    }
    public boolean isEmpty()
    {
      return head== null;
    }
    public void deleteAtBeginning() {
      if (isEmpty()) {
        System.out.println("Empty list");
      } else {
        head = head.next;
      }
    }
    public void deleteAtLast()
    {
      if(isEmpty())
      {
        System.out.println("Empty List");
      }
      else
      {
        Node current = head;
        Node previous = null;
          while(current.next != null)
          {
              previous = current;
              current = current.next;
          }
        if(current == head )
        {
          head = null;
        }
        else
        {
          previous.next= null;
        }
      }

    }
    public void insertAtLast(Node newnode)
    {
      if(head ==null)
      {
        head = newnode;
      }
      else
      {
        Node temp = head;
          while(temp.next != null)
          {
            temp = temp.next;
          }
          temp.next = newnode;
      }
    }
    public int nodecount()
    {
      Node temp = head;
      int count=0;
      while(temp!= null)
      {
        temp = temp.next;
        count= count+1;
      }
      return count;
    }

    public void insertAtBeginning(Node newnode)
    {
      newnode.next = head;
      head = newnode;
    }


    public void display() {
      Node temp = head;
      while (temp != null) {
        System.out.println(temp.data);
        temp = temp.next;
      }
    }


    }// end of class