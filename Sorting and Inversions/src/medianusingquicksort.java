import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class medianusingquicksort{
	static int[] quicksorting(int[] seq, int low, int high) {
		if(low>=high) {
	        return seq;
		}
	    int small = low;
	    int hi = high;
	    int mid = (small+(hi-small)/2);
	    int pivot = seq[mid];
	    
	    while(small<=hi) {
	        while(seq[small]<pivot) {
	            small+=1;
	        }
	        while(seq[hi]>pivot) {
	            hi-=1;
	        }
	        if(small<=hi) {
	            int temp = seq[small];
	            seq[small]=seq[hi];
	            seq[hi]=temp;
	            small+=1;
	            hi-=1;
	        }
	    }
	    quicksorting(seq,low,hi);
	    quicksorting(seq,small,high);
	    return seq;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the file path of the test case: ");
		String inputFilePath = sc.nextLine();
		try {
			Scanner filescanner = new Scanner(new File(inputFilePath));
			ArrayList<String> arrlist = new ArrayList<String>();
			
			while(filescanner.hasNext()) {
				arrlist.add(filescanner.nextLine());
				
			}
			int[] list = new int[arrlist.size()];
			for(int i =0;i<arrlist.size();i++) {
				list[i] = Integer.parseInt(arrlist.get(i));
			}
			int length = arrlist.size();
		
			//sorting starts
			long startTime = System.nanoTime();
			int[] arr = quicksorting(list, 0, length-1);
			long endTime = System.nanoTime();
			System.out.println("After sorting");
			for(int i=0;i<length;i++) {
				System.out.println(arr[i]);
			}
			long executionTime = endTime - startTime;
			System.out.println("File path "+inputFilePath);
			System.out.println("Quick sort took: " + executionTime + " nanoseconds.");
			System.out.println("length of an array "+length);
			int median;
			if(length%2==0) {
				median = length/2 -1;
			}
			else {
				median = length/2;
			}
			//System.out.println("Median index is "+median);
			System.out.println("The median is "+arr[median]);
		}catch(Exception e){
			System.out.println(e);
		}
		sc.close();
		
	}
}