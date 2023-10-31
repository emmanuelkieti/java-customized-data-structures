public class OpenEndedQueue {
  int[] arr;
  int capacity;
  int front;
  int rear;

  OpenEndedQueue(){
    this.arr = new int[10];
    this.capacity = 10;
    this.front = -1;
    this.rear = -1;
  }

  OpenEndedQueue(int size){
    this();
    this.arr = new int[size];
    this.capacity = size;
  }

  boolean isEmpty(){
    return length()==0?true:false;
  }

  int length() {
    return (rear-front)+1;
  }

  boolean isFull(){
    if (rear != capacity-1 || (rear == capacity-1 && front != 0)) return false;
    return true;
  }

  void enqueue(int val){
    if((rear+1)%capacity == front) return;
    if(front == -1 && rear == -1) front = rear = 0;
    else if(rear == capacity-1 && front != 0) rear = 0;
    else rear = (rear + 1)%capacity;

    arr[rear] = val;
  }

  void dequeue(){
    if(front < 0 && rear < 0) return;
    else if(front == rear) front = rear = -1;
    else front = (front+1)%capacity;
  }

  int peek() {
    int temp = -1;
    if(!isEmpty()) temp = arr[front];
    return temp;
  }

  int[] elements () {
    int[] elements = new int[length()];
    int i = front, j = 0;
    while(i <= rear) {
      elements[j++] = arr[i];
      i  =(i+1)%capacity; 
    }
    return elements;
  }


  public static void main(String[] args){
    //example
    OpenEndedQueue queue = new OpenEndedQueue(10);
    //operations
    //---
  }
}