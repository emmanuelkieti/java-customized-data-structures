import java.util.*;
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

public class TreeTest {
  Node root = null;

  List<Node> inOrderTraverse (Node n){
    List<Node> elements = new ArrayList<>();
    if(n != null) {
      inOrderTraverse(n.left);
      elements.add(n);
      inOrderTraverse(n.right);
    }
    return elements;
  }

  List<Node> preOrderTraverse(Node n){
    List<Node> elements = new ArrayList<>();
    if(n != null){
      elements.add(n);
      preOrderTraverse(n.left);
      preOrderTraverse(n.right);
    }
    return elements;
  }

  List<Node> postOrderTraverse(Node n){
    List<Node> elements = new ArrayList<>();
    if(n != null){
      preOrderTraverse(n.left);
      preOrderTraverse(n.right);
      elements.add(n);
    }
    return elements;
  }

  public static void main(String[] args){
    //example
    TreeTest tree = new TreeTest();
    //operations
    //---
  }
}