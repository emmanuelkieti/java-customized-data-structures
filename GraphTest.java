public class GraphTest {
  int size;
  int pointer = -1;
  Node[] nodes;
  int[][] adjMatrix;
  
  //class for creating nodes
  static class Node {
    int data;
    boolean visited;

    Node(int data){
      this.data = data;
      boolean visited = false;
    }
  }

  //Queue for bfs search
  class Queue {
    private Node[] arr;
    private int rear;
    private int front;

    Queue(int size){
      this.arr = new Node[size];
      this.front = 0;
      this.rear = -1;
    }

    boolean isEmpty(){
      return length()==0?true:false;
    }

    int length() {
      return (rear-front)+1;
    }

    void enqueue(Node n){
      arr[++rear] = n;
    }

    int dequeue(){
      return length() > 0?front++:-1;
    }
  }
  
  //Stack for dfs search
  class Stack {
    int pointer;
    Node[] arr;

    Stack(int size){
      arr = new Node[size];
      pointer = -1;
    }

    boolean isEmpty(){
      return pointer == -1;
    }

    void push(Node n) {
      arr[++pointer] = n;
    }

    Node pop(){
      return arr[pointer--];
    }

    int peek(){
      return pointer;
    }
  }//end Stack class

  boolean isEmpty(){
    return pointer == -1;
  }

  boolean isFull(){
    return pointer == size -1;
  }

  int length(){
    return pointer+1;
  }

  void addNode (int data) {
    if(!isFull()){
      Node temp = new Node(data);
      nodes[++pointer] = temp;
    }
  }

  void addEdge(int start, int end) {
    adjMatrix[start][end] = 1;
    adjMatrix[end][start] = 1;
  }

  int[] dfsTraverse(){
    Stack stack = new Stack(length());
    int[] elems = new int[length()];
    int x = 0;
    elems[x++] = nodes[0].data;
    nodes[0].visited = true;
    stack.push(nodes[0]);
    while(!stack.isEmpty()){
      int unvisited = adjUnvisitedNode(stack.peek());
      if(unvisited == -1) stack.pop();
      else {
        nodes[unvisited].visited = true;
        stack.push(nodes[unvisited]);
        elems[x++] = nodes[unvisited].data;
      }
    }
    for(int y:elems) System.out.print(y+", ");
    return elems;
  }

  int[] bfsTraverse(){
    Queue queue = new Queue(length());
    int[] elems = new int[length()];
    int x = 0;
    elems[x++] = nodes[0].data;
    nodes[0].visited = true;
    queue.enqueue(nodes[0]);
    while(!queue.isEmpty()){
      int unvisited;
      int temp = queue.dequeue();
      while((unvisited = adjUnvisitedNode(temp)) != -1){
        nodes[unvisited].visited = true;
        elems[x++] = nodes[unvisited].data;
        queue.enqueue(nodes[unvisited]);
      }
    }
    for(int y:elems) System.out.print(y+", ");
    return elems;
  }

  int adjUnvisitedNode(int index) {
    for(int i = 0; i < length(); i++)
      if(adjMatrix[index][i] == 1 && !nodes[i].visited) return i;
    return -1;
  }

  void display(){
    for(int i = 0; i < length(); i++){
      for(int j = 0; j < length();j++)System.out.print(adjMatrix[i][j] + " ");
      System.out.print('\n');
    }
  }

  GraphTest(int size){
    this.size = size;
    nodes = new Node[size];
    adjMatrix = new int[size][size];

    for(int i = 0; i < size; i++)
      for(int j = 0; j < size;j++) adjMatrix[i][j] = 0;
  }
  public static void main(String[] args){
    //example
    GraphTest graph = new GraphTest(5);
    //operations
    //---
  }
}