import java.io.File;
import java.util.Scanner;

class Quick_sorting{
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
			String singleline = filescanner.nextLine();
			String splitline[] = singleline.split(" ");
			int arrlength = splitline.length;
			int[] integerarray = new int[arrlength];
			System.out.println("Length of an array "+arrlength);
			for(int i=0;i<arrlength;i++) {
				if(splitline[i].equals("")) {
					i++;
				}
				integerarray[i] = Integer.parseInt(splitline[i]);
				System.out.println(splitline[i]);
				
			}
		
			//sorting starts
			long startTime = System.nanoTime();
			int[] arr = quicksorting(integerarray, 0, arrlength-1);
			long endTime = System.nanoTime();
			System.out.println("After sorting");
			for(int i=0;i<arrlength;i++) {
				System.out.println(arr[i]);
			}
			long executionTime = endTime - startTime;
			System.out.println("File path "+inputFilePath);
			System.out.println("Quick sort took: " + executionTime + " nanoseconds.");
		}catch(Exception e){
			System.out.println(e);
		}
		sc.close();
		
	}
}