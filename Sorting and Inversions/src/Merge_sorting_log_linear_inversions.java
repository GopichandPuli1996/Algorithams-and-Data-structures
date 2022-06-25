import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Merge_sorting_log_linear_inversions {

	public static void main(String[] args) {
		
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
            for(int i=0;i<arrlength;i++) {
            	if(splitlist[i].equals("")) {
            		i++;
            	}
            	
            	lists[i]=Integer.parseInt(splitlist[i]);
            	System.out.println(lists[i]);
            }
            
            //merge sort starts here
            long startTime = System.nanoTime();
            int arr[]=mergesort(lists);
            
            long endTime = System.nanoTime();
            
            System.out.println("sorted numbers");
            for(int i=0;i<arr.length;i++) {
            	System.out.println(arr[i]);
            }
            
            
            //sorting is completed
            
            //inversion count starts here
            long inversionstarttime = System.nanoTime();
            long totalcount = inversioncount(lists, 0, arr.length-1);
            
            long inversionended = System.nanoTime();
            //count ends
            
            long executionTime = endTime - startTime;
            System.out.println(inputFilePath);
            System.out.println("Merge sort took: " + executionTime + " nanoseconds.");
            
            long difference = inversionended - inversionstarttime;
            System.out.println("total number of inversions in merge sort = "+totalcount);
            System.out.println("inverions count took "+difference+" nanoseconds");
            
            fileScanner.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
	}
	
	static int[] mergesort(int[] arr) {
		
		if(arr.length==1) {
			return arr;
		}
		
		int mid = arr.length/2;
		int left[]=mergesort(Arrays.copyOfRange(arr, 0,mid));
		int right[]=mergesort(Arrays.copyOfRange(arr, mid, arr.length));
		
		return merge(left, right);
		

	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] merging = new int[left.length + right.length];
		
		int i=0;
		int j=0;
		int k=0;
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				merging[k]=left[i];
				i++;
			}else {
				merging[k]=right[j];
				j++;
			}
			k++;
		}
		
		while(i<left.length) {
			merging[k]=left[i];
			i++;
			k++;
		}
		
		while(j<right.length) {
			merging[k]=right[j];
			j++;
			k++;
		}
		return merging;
	}
	
	public static long inversioncount(int arr[], int f, int l) {
		long count=0;
		if(f<l) {
			int m = (f+l)/2;
			count += inversioncount(arr, f, m);
			count += inversioncount(arr,m+1,l);
			
			count += mergeinversion(arr, f, m, l);
		}
		return count;
	}
	
	public static long mergeinversion(int[] arr, int f, int m, int l) {
		int[] left = Arrays.copyOfRange(arr, f, m+1);
		
		int[] right = Arrays.copyOfRange(arr,  m+1, l+1);
		
		int i=0, j=0, k=f;
		long count=0;
		
		while(i<left.length && j<right.length) {
			/*if(left[i] == right[j]) {
				
			} */
		if(left[i]<=right[j]) {
				arr[k]=left[i];
				k++;
				i++;
			}
			else {
				arr[k] = right[j];
				count += (m+1) - (f+i); 
				k++;
				j++;
			}
		}
		
		while(i<left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j<right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}
		return count;
		
	}

}
