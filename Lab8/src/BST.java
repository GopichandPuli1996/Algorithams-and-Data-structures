import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BST {
	
	 public static class TreeNode {
		    long data;
		    TreeNode left;
		    TreeNode right;
			//public long val;

		    TreeNode(long data) {
		      this.data = data;
		      this.left = null;
		      this.right = null;
		    }
		  }
	public TreeNode insertIntoBST(TreeNode root, long val) { 
		//referred from https://github.com/striver79/FreeKaTreeSeries/blob/main/L43_insertBSTJava
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
	
	
	public int heightOfBST(TreeNode root) {
		if(root == null) {
			return -1;
		}
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
	
	//Lookup value
	public static int search(TreeNode root, long snum) {
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
	
	// 6th point
	//a) shuffling 
	
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("Enter the input file path to form BST: ");
	     String inputFilePath = scanner.nextLine();
	     BST bt = new BST();
	     try {
	    	 Scanner fileScanner = new Scanner(new File(inputFilePath));
	    	 ArrayList<String> arrlist = new ArrayList<String>();
				
				while(fileScanner.hasNext()) {
					arrlist.add(fileScanner.nextLine());	
				}
				Long[] list = new Long[arrlist.size()];	
				for(int i =0;i<arrlist.size();i++) {
					list[i] = Long.parseLong(arrlist.get(i));
				}
				
				/*for(int i=0;i<arrlist.size();i++) {
					System.out.println(list[i]);
				}*/
				TreeNode root=null;
				//Time taken to create BST
				long startTime = System.nanoTime();
				System.out.println("Length of an array "+arrlist.size());
				for(int i=0;i<arrlist.size();i++) {		
						root = bt.insertIntoBST(root, list[i]);
						//System.out.println(root.data+" "+i);
				}
				long endTime = System.nanoTime();
				long executionTime = endTime - startTime;
		        System.out.println("Binary Search Tree formation took: " + executionTime + " nanoseconds.");
				int hg = bt.heightOfBST(root);
				System.out.println("The height of the BST is "+hg);
				System.out.println();
				//Search the element in the BST
				System.out.print("Enter the search file path to lookup: ");
				String inputlookuppath = scanner.nextLine();
				Scanner fileScanner2 = new Scanner(new File(inputlookuppath));
				 ArrayList<String> arrlistlookup = new ArrayList<String>();
					
					while(fileScanner2.hasNext()) {
						arrlistlookup.add(fileScanner2.nextLine());	
					}
					////lookup search /////////
					Long[] listlookup = new Long[arrlistlookup.size()];
					System.out.println("Length of search keys "+arrlistlookup.size());
					for(int i =0;i<arrlistlookup.size();i++) {
						listlookup[i] = Long.parseLong(arrlistlookup.get(i));
					}
					long startTime2 = System.nanoTime();
					for(int i=0;i<arrlistlookup.size();i++) {
						int flag = search(root,listlookup[i]);
						if(flag == 1) {
							System.out.println("present in BST "+listlookup[i]);
						}else {
							System.out.println("Not present in BST "+listlookup[i]);
						}

					}
					
					long endTime2 = System.nanoTime();
			        long executionTime2 = endTime2 - startTime2;
			        System.out.println("Binary search tree lookup took: " + executionTime2 + " nanoseconds.");
			        System.out.println();
			        //shuffling an array
			        System.out.print("Enter the input file path to shuffle ");
			        inputFilePath = scanner.nextLine(); //please enter the input_files.txt file path
			       Collections.shuffle(arrlist);
			       
			       long[] sufdata = new long[arrlist.size()];
			       for(int i=0;i<arrlist.size();i++) {
			    	   sufdata[i]=Long.parseLong(arrlist.get(i));
			    	   //System.out.println(sufdata[i]);
			       }
			       long startTime3 = System.nanoTime();
			       root = null;
			       for(int i=0;i<arrlist.size();i++) {
			    	   root = bt.insertIntoBST(root, sufdata[i]);
			       }
			       long endTime3 = System.nanoTime();
			        long executionTime3 = endTime3 - startTime3;
			        System.out.println("Binary search tree after shuffling took: " + executionTime3 + " nanoseconds.");
			       int he = bt.heightOfBST(root);
			       System.out.println("The height of the BST after shuffling a array  "+he);
			       System.out.println();
			       /////lookup on dst//////
			       System.out.println("Enter the search file path to lookup after shuffling of the input file elements: ");
			       inputlookuppath = scanner.nextLine(); //enter search_files.txt file path
			       long startTime4 = System.nanoTime();
			       for(int i=0;i<arrlistlookup.size();i++) {
						int flag = search(root,listlookup[i]);
						if(flag == 1) {
							System.out.println("present in BST "+listlookup[i]);
						}else {
							System.out.println("Not present in BST "+listlookup[i]);
						}

					}
			       long endTime4 = System.nanoTime();
			        long executionTime4 = endTime4 - startTime4;
			        System.out.println("Binary search tree after shuffling lookup took: " + executionTime4 + " nanoseconds.");
				
	     }catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	     scanner.close();

	}

}
