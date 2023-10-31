public class ArrayTest {
  public static void main(String[] args) {
    //Example
    Array numbers = new Array(10);
    //operations
    //---
  }
}

class Array {
  private int[] arr;
  private int capacity;
  private int pointer;

  Array(){
    arr = new int[10];
    this.capacity = 10;
    pointer = -1;
  }

  Array(int size){
    arr = new int[size];
    this.capacity = size;
    pointer = -1;
  }

  int capacity(){//count of elements it can contain
    return this.capacity;
  }

  boolean isEmpty(){
    return pointer == -1?true:false;
  }

  boolean isFull() {
    if(pointer == capacity-1) return true;
    return false;
  }

  int size(){//element count
    return pointer+1;
  }

  int[] elements(){//elements contained
    int[] elements = new int[size()];
    for(int i = 0; i < size(); i++) elements[i] = arr[i];
    return elements;
  }
  
  void insert(int n){
    if(!this.isFull()) arr[++pointer] = n;
  }

  void delete(int key) {
    if(key >= 0 && key <= pointer) {
      if(key == pointer) --pointer;
      else {
        for(int i = key; i < pointer; i++) arr[i] = arr[i+1];
        pointer--;
      }
    }
  }

  int binarySearch(int[] array, int start, int end, int val) {
    int middle;
    if(end >= start) {
      middle = (start + end)/2;
      if(array[middle] == val) return middle;
      else if(array[middle] < val) return binarySearch(array, middle+1, end, val);
      else return binarySearch(array, start, middle-1, val);
    }
    return -1;
  }

  int search(int number) {
    int[] array = sort();
    int temp = binarySearch(arr,0,array.length-1,number);
    return temp;
  }

  boolean contains(int num){
    int temp = search(num);
    return temp==-1?false:true;
  }

  void update(int key, int val) {
    arr[key] = val;
  }
  
  //Quick sort
  int partition(int[] array, int left, int right){
    int pivot = array[right];
    int i = left - 1;
    for(int j = left; j <= right; j++){
      if(array[j] < pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    int temp = array[i + 1];
    array[i + 1] = array[right];
    array[right] = temp;
    return i+1;
  }

  void quickSort(int[] array, int left, int right){
    if(left < right) {
      int partitionIndex = partition(array,left,right);
      quickSort(array, left, partitionIndex -1);
      quickSort(array, partitionIndex+1,right);
    }
  }

  int[] sort() {
    int[] elements = elements();
    quickSort(elements, 0, elements.length-1);
    return elements;
  }

  //bubble sort
  int[] sortDescending() {
    int[] elements = elements();
    for(int i = 0; i < elements.length-1; i++)
      for(int j = i+1; j < elements.length; j++) {
        if(arr[j] > arr[i]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      return elements;
  }

  void reverse() {
    int[] temp = new int[pointer+1];
    int i = 0, j = pointer;
    for(;j >= 0; j--) temp[i++] = arr[j];
    i = 0;
    for(;i <= pointer; i++) arr[i] = temp[i];
  }
}