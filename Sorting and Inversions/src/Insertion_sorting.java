import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Insertion_sorting {
	
	public static long inversion(int [] arr) {
		long count =0;
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		long startTime;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the file path of the test case: ");
        String inputFilePath = scanner.nextLine();
        try {
            Scanner fileScanner = new Scanner(new File(inputFilePath));
            String singleline = fileScanner.nextLine();
            String[] splitlist = singleline.split(" ");
            int arrlength = splitlist.length;
            int lists[]=new int[arrlength];
            System.out.println("length of the array "+arrlength);
            System.out.println("first element is "+splitlist[1]);
            for(int i=0;i<arrlength;i++) {
            	if(splitlist[i].equals("")) {
            		i++;
            	}
            	lists[i]=Integer.parseInt(splitlist[i]);
            	System.out.println(lists[i]);
            }
            //inversions counts starts here
            long inversionsstarttime = System.nanoTime();
            long count = inversion(lists);
            
            long inversionendtime = System.nanoTime();
            long difference = inversionendtime - inversionsstarttime;
            
            //inversions count ends here
            
            //insertion sorting starts here
            startTime = System.nanoTime();
            for(int i=0;i<arrlength-1;i++) {
            	for(int j=i+1;j<arrlength;j++) {
            		if(lists[i]>lists[j]) {
            			int temp = lists[j];
            			lists[j]=lists[i];
            			lists[i]=temp;
           
            		//count++;
            		}
            	}
            }
            long endTime = System.nanoTime();
            System.out.println("Sorted array");
            for(int i=0;i<arrlength;i++) {
            	System.out.println(lists[i]);
            }
            
            long executionTime = endTime - startTime;
            System.out.println("File path "+inputFilePath);
            System.out.println("Insertion sort took: " + executionTime + " nanoseconds.");
            
            System.out.println("Total number of inversions in insertion sort = "+count);
            System.out.println("inverions count took "+difference+" nanoseconds");
            
            fileScanner.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        

	}

}
