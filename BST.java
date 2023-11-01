import java.util.*;
public class BST {
  //BST root node
  public Node root = null;

  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
      this.data = data;
      this.left = this.right = null;
    }
  }

  public void insert(int data) {
    Node n = new Node(data);
    if(root == null) root = n;
    else {
      Node current = root;
      Node parent = null;
      while(true){
        parent = current;
        if(data < current.data){
          current = current.left;
          if(current == null) {
            parent.left = n;
            return;
          }
        } else {
          current = current.right;
          if(current == null) {
            parent.right = n;
            return;
          }
        }
      }
    }
  }

  Node minimum(Node root) {
    if(root.left != null) return minimum(root.left);
    else return root;
  }

  Node maximum(Node root) {
    if(root.right != null) return minimum(root.right);
    else return root;
  }

  Node delete(Node n, int value) {
    if(n == null) return null;
    else {
      if(value < n.data) n.left = delete(n.left, value);
      else if(value > n.data) delete(n.right, value);
      else {
        //if leave node
        if(n.left == null && n.right == null) n = null;
        else if(n.left == null) n = n.right;
        else if(n.right == null) n = n.left;
        else {
          Node tmp = minimum(n.right);
          n.data = tmp.data;
          n.right = delete(n.right, tmp.data);
        }
      }
      return n;
    }
  }

  List<Node> inOrderTraverse(Node n){
    List<Node> nodes = new ArrayList<Node>();
    if(root == null) return null;
    else {
      if(n.left != null) inOrderTraverse(n.left);
      nodes.add(n);
      if(n.right != null) inOrderTraverse(n.right);
    }
    return nodes;
  }


  public static void main(String[] args){
    //example
    BST tree = new BST();
    //operations
  }



}