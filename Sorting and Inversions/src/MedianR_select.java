import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MedianR_select {
	
	public static int Random(int p, int r) {
		Random rand = new Random();
		int index = rand.nextInt(r-p)+p;
		return index;
	}
	//referred from the Introduction to algorithms book by Cormen  page no: 179
	public static int Random_Partition(int[] arrlist,int p,int r){
		int i = Random(p,r);
		exchangevalue(arrlist[i],arrlist[r]);
		return Partition(arrlist,p,r);
	}
	//referred from the Introduction to algorithms book by Cormen  page no: 171
	public static int Partition(int[] arr,int p,int r) { 
		int pivotvalue = arr[r];
		int i = p-1;
		for(int j=p;j<r;j++) {
			if(arr[j]<=pivotvalue) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		int index = i+1;
		return index;
	}
	
	public static void exchangevalue(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		
	}

	//referred from the Introduction to algorithms book by Cormen  page no: 216
	public static int Random_select(int[] A,int first,int last,int i) {
		if(first-last==0) {
			return A[first];
		}
		int q = Random_Partition(A,first,last);
		int k = q-first+1;
		if(i==k) {
			return A[q];
		}
		else if(i<k) {
			return Random_select(A,first,q-1,i);
		}
		else {
			return Random_select(A, q+1,last,i-k);
		}
	}
	
	public static void main(String[] args) {
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
			System.out.println(arrlist.size());
			int length1 = arrlist.size();
			int middle;
			if(length1%2==0) {
				middle = length1/2;
			}
			else {
				middle = (length1-1)/2;
			}
		
		long startTime = System.nanoTime();
		int middlelement = Random_select(list,0,length1-1,middle);
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("File path "+inputFilePath);
		System.out.println("R-select took: " + executionTime + " nanoseconds.");
		System.out.println("The middle element is "+middlelement);
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}
}
