public class StackTest {
  private int[] arr;
  private int pointer;
  public int capacity;

  StackTest(int size){
    arr = new int[size];
    pointer = -1;
    capacity = size;
  }

  boolean isEmpty(){
    return pointer == -1?true:false;
  }

  boolean isFull(){
    return pointer==capacity-1?true:false;
  }

  int length() {
    return isEmpty()?0:pointer+1;
  }

  boolean push(int val){
    if(!isFull()) {
      arr[++pointer] = val;
      return true;
    } else return false;
  }

  int pop() {
    return !isEmpty()?arr[pointer--]: -1;
  }

  int peek() {
    return !isEmpty()? arr[pointer]: -1;
  }

  public static void main(String[] args){
    //Example
    StackTest stack = new StackTest(10);
    //operations
    //---
}