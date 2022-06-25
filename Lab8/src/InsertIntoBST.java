import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class InsertIntoBST {
	TreeNode root;
	public static class TreeNode {
	    long data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(long data) {
	      this.data = data;
	      this.left = null;
	      this.right = null;
	    }
	  }
	
	
	
	public TreeNode insertval(TreeNode root, int val) {  // referred from https://github.com/striver79/FreeKaTreeSeries/blob/main/L43_insertBSTJava
		if(root == null) {
			root = new TreeNode(val);
			return root;
		}
		TreeNode r = root;
		while(r!=null) {
			if(r.data<=val) {
				if(r.right!=null) {
					r=r.right;
				}else {
					r.right=new TreeNode(val);
					r=null;
				}
			}else {
				if(r.left!=null) {
					r=r.left;
				}else {
					r.left=new TreeNode(val);
					r=null;
				}
			}
		}
		
		return root;
	}
	
	public void in_order(TreeNode root) {
		if(root!=null) {
			in_order(root.left);
			System.out.println(root.data);
			in_order(root.right);
		}else {
			return;
		}
	}
	
	public static int search(TreeNode root, int snum) {
		int flag =0;
		TreeNode r = root;
		while(r!=null) {
			if(snum<r.data) {
				r = r.left;
			}else if(snum>r.data) {
				r=r.right;
			}else if(r.data==snum) {
				flag=1;
				r=null;
			}
		}
		return flag;
	}
	
	public int heightOfBST(TreeNode root) {
		if(root == null) {
			return -1;
		}else {
			int leftHeight = heightOfBST(root.left);
			int rightHeight = heightOfBST(root.right);
			return Math.max(leftHeight,rightHeight)+1;
		}
	}
	
	public int heighttree(TreeNode root) {
		int height=0, qsize = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode r = root;
		queue.add(r);
		while(queue.isEmpty()==false) {
			height++;
			qsize = queue.size();
			while(qsize>0) {
				r = queue.poll();
				if(r.left!=null) {
					queue.add(r.left);
				}
				if(r.right!=null) {
					queue.add(r.right);
				}
				qsize--;
				
			}
			if(queue.isEmpty()==true) {
				height = height-1; // As we consider the bottom leaf height as 0
			}
		}
		return height;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of n length of an array");
		int n = sc.nextInt();
		int list[] = new int[n];
		if(n<=1) {
			System.out.print("Please enter the value which is greater than 1");
			n= sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			list[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(list[i]);
		}
		
		InsertIntoBST bst = new InsertIntoBST();
		TreeNode root=null;
		root = null;
		System.out.println();
		for(int i=0;i<n;i++) {
			root = bst.insertval(root,list[i]);
			System.out.println(root.data+" "+list[i]);
		}
		System.out.println();
		bst.in_order(root);
		
		System.out.println("Enter the number to search");
		int nsearch = sc.nextInt();
		int flag = search(root,nsearch);
		if(flag == 1) {
			System.out.println("Search value "+nsearch+" is present in the BST");
		}else {
			System.out.println("Search value "+nsearch+" is not present in the BST");
		}
		int hg = bst.heightOfBST(root);
		System.out.println("The height of the BST is recursive call "+hg);
		System.out.println("-------------------------------");
		int he = bst.heighttree(root);
		System.out.println("The height of the BST is iteration method "+he);
		sc.close();

	}

}
