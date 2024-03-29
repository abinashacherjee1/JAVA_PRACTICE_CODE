import java.util.*;
class GfG {
  static class Node {
      int data;
      Node left, right;

      Node(int value) {
          data = value;
          left = right = null;
      }
  }

  Node cans(Node root, int a, int b) {
      if (root == null || root.data == a || root.data == b)
          return root;
      Node ln = cans(root.left, a, b);
      Node rn = cans(root.right, a, b);
      if (rn == null)
          return ln;
      if (ln == null)
          return rn;
      return root;
  }

  int dist(Node root, int a) {
      if (root == null)
          return -1;
      else if (root.data == a)
          return 0;
      int ld = dist(root.left, a);
      int rd = dist(root.right, a);
      if (ld >= 0)
          return ld + 1;
      return (rd >= 0) ? rd + 1 : -1;
  }

  int findDist(Node root, int a, int b) {
      Node nn = cans(root, a, b);
      int ld = dist(nn, a);
      int rd = dist(nn, b);
      return ld + rd;
  }

  public static void main(String[] args) {
      GfG tree = new GfG();

      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);

      int a = 4, b = 7;
      System.out.println("Distance between " + a + " and " + b + " is " + tree.findDist(root, a, b));
  }
}
