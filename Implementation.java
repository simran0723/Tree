import java.util.ArrayList;
import java.util.List;
import java .util.Scanner;
class Node {
    int data ;
    Node left,right;
 }
public class Implementation {
    public Node create() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of x ");
        int x = sc.nextInt();
        if (x == -1) {
            return null;
        }
        Node newnode = new Node();
        newnode.data = x;
        System.out.println("Enter the left child of : " + x);
        newnode.left = create();
        System.out.println("Enter the right child of : " + x);
        newnode.right = create();
        return newnode;
    }
    static void inorder(Node root , List<Integer> list){
        if(root != null){
            if(root.left != null) inorder(root.left,list);
                list.add(root.data);
                if(root.right != null)inorder(root.right,list);

        }
    }
    static void preorder(Node root , List<Integer> list ){
        if(root  != null){
            list.add(root.data);
            if(root.left != null) preorder(root.left,list);
            if(root.right != null)preorder(root.right,list);
        }
    }
    static void postorder(Node root , List<Integer>list){
        if(root  != null){
            if(root.left != null) postorder(root.left,list);
            if(root.right != null)postorder(root.right,list);
            list.add(root.data);
        }
    }
    public boolean isSameTree(Node p, Node q) {
        if (p == null || q == null){
            return p==q;
        }
        return (p.data == q.data )&& isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
    }
    public int height (Node root){
        if(root== null)
            return -1;
        int lh = height(root.left);
        int rh = height(root.right);
        return  Math.max(lh,rh)+1;
    }

    public Boolean isBalanced(Node root){
         return dfs(root) != -1;
    }
    public int dfs (Node root){
        if(root == null) return 0;
        int left = dfs(root.left);
        if(left == -1) return -1;
        int right = dfs(root.right);
        if(right == -1)return -1;
        int difference = Math.abs(left-right);
        if(difference>1)return -1;
        return Math.max(left,right)+1;
    }
    static void main(String[] args) {
        Implementation obj = new Implementation();
        List<Integer> list = new ArrayList<>();
        Node root = obj.create();
//        Node root2 = obj.create();
        System.out.println("Root of the tree is "+ root.data);
        System.out.println( obj.isBalanced(root));
//        System.out.println("root2 is " + root2.data);
//        boolean sameTree = obj.isSameTree(root, root2);
//        System.out.println(sameTree);
//        System.out.println( obj.height(root));
//        obj.inorder(root,list);
//        System.out.println("Inorder Traversal is "+  list);
//        list.clear();
//        obj.preorder(root,list);
//        System.out.println("Preorder Traversal is " + list);
//        list.clear();
//        obj.postorder(root,list);
//        System.out.println("PostOrder traversal is " + list);
    }
}
