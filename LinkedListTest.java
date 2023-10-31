public class LinkedListTest {
  //head node
    static Node head;
    static int count;
    //node class
    class Node {
      int value;
      Node next;

      Node(int value){
        this.value = value;
        this.next = null;
      }
    }

    int size(){
      return count;
    }

    boolean isEmpty(){
      return head==null?true:false;
    }

    int[] elements(){
      int[] elems = new int[count];
      int index = 0;
      while(head != null) {
        elems[index++] = head.value;
        head = head.next;
      }
      return elems;
    }

    void insertAtBegin(int val){
      count++;
      Node temp = new Node(val);
      if(this.isEmpty()) {
        this.head = temp;
      } else {
        temp.next = head;
        head = temp;
      }
    }

    void insertAtEnd(int val){
      count++;
      Node temp = new Node(val);
      Node last = head;
      if(this.isEmpty()) {
        this.head = temp;
      } else {
        while(last.next != null) last = last.next;
        last.next = temp;
      }
    }

    void insertAt(int val, int index) {
      if(index > 0 && index <= count){
        count++;
        Node temp = new Node(val);
        Node n = head;
        if(index == 1) insertAtBegin(val);
        else for(int i = 1; i < index-1; i++) n = n.next;
        temp.next = n.next;
        n.next = temp;
      }
    }

    void deleteAtBegin(){
      if(!isEmpty()){
        count--;
        head = head.next;
      }
    }

    void deleteAtEnd(){
      if(!isEmpty()){
        count--;
        Node last = head;
        while(last.next.next != null) {
          last = last.next;
        }
        last.next = null;
      }
    }

    void delete(int index){
      if(!isEmpty()){
        Node temp = head;
        if(index == 1) deleteAtBegin();
        else {
          count--;
          for(int i = 1; i < index-1; i++) temp = head.next;
          temp.next = temp.next.next;
        }
      }
    }

    boolean contains(int val) {
      Node temp = head;
      while(temp != null){
        if(temp.value == val) return true;
        temp = temp.next;
      }
      return false;
    }

    void clear(){
      if(!isEmpty())
        while(head != null) {
          Node temp = head;
          head = head.next;
          temp.next = null;
        }
        count = 0;
    }

    void sort(){
      Node current = head, nextNode = null;
      int temp;
      if(head == null) return;
      else {
        while(current != null){
          nextNode = current.next;
          while(nextNode != null){
            if(current.value > nextNode.value){
              temp = current.value;
              current.value = nextNode.value;
              nextNode.value = temp;
            }
            nextNode = nextNode.next;
          }
          current = current.next;
        }
      }
    }

    void sortDescending(){
      Node current = head, nextNode = null;
      int temp;
      if(head == null) return;
      else {
        while(current != null){
          nextNode = current.next;
          while(nextNode != null){
            if(current.value < nextNode.value){
              temp = current.value;
              current.value = nextNode.value;
              nextNode.value = temp;
            }
            nextNode = nextNode.next;
          }
          current = current.next;
        }
      }
    }

    void reverse(){
      Node current = head, nextNode = null, prev = null;
      while(current != null){
        nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
      }
      head = prev;
    }
    
  public static void main (String[] args){
    //Example
    LinkedListTest list = new LinkedListTest();
    //operations
    //---
  }
}