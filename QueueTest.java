public class QueueTest {
  private int[] arr;
  private int capacity;
  private int rear;
  private int front;

  QueueTest(){
    this.arr = new int[10];
    this.capacity = 10;
    this.front = 0;
    this.rear = -1;
  }

  QueueTest(int size){
    this.arr = new int[size];
    this.capacity = size;
    this.front = 0;
    this.rear = -1;
  }

  boolean isEmpty(){
    return length()==0?true:false;
  }

  int length() {
    return (rear-front)+1;
  }

  boolean isFull(){
    return rear==capacity-1?true:false;
  }

  void enqueue(int val){
    if(!isFull()) arr[++rear] = val;
  }

  int dequeue(){
    return length() > 0?arr[front++]:-1;
  }

  int peek() {
    int temp = -1;
    if(!isEmpty()) temp = arr[front];
    return temp;
  }


  public static void main(String[] args) {
    //Example
    QueueTest queue = new QueueTest(10);
    //operations
    //---
  }
}