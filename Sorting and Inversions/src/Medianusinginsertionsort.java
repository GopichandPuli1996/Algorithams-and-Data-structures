import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Medianusinginsertionsort {
	long startTime;
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
			long startTime = System.nanoTime();
			for(int i=0;i<length-1;i++) {
				for(int j=i+1;j<length;j++) {
					if(list[i]>list[j]) {
						int temp = list[j];
						list[j] = list[i];
						list[i] = temp;
					}else {
						continue;
					}
				}
			}
			long endTime = System.nanoTime();
			//sorted array
			System.out.println("sorted array");
			
			for(int i=0;i<length;i++) {
				System.out.println(list[i]);
			}
			
			long executionTime = endTime - startTime;
            System.out.println("File path "+inputFilePath);
            System.out.println("Insertion sort took: " + executionTime + " nanoseconds.");
            int median;
			if(length%2==0) {
				median = length/2 -1;
			}
			else {
				median = length/2;
			}
			//System.out.println("Median index is "+median);
			System.out.println("The median is "+list[median]);
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}
}
