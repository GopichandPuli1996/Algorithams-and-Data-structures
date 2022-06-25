import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class R_select {

	public static int randomvalue(int[] arr) {
		int index = new Random().nextInt(arr.length);
		return index;
	}
	
	public static int quicksorting(int[] arr, int first, int last,int median) {
		int index = randomvalue(arr);
		int pivot = partition(arr,index);
		while(first<last) {
			while(first<index) {
				
			}
		}
			
		if(index == median) {
			return arr[index];
		}
		
	}
	
	public static int partition(int arr[], int index) {
		for(int i=0;i<arr.length;i++){
			if()
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
			
			System.out.println(arrlist);
			System.out.println(arrlist.size());
			int length = arrlist.size();
			int rvalue = randomvalue(list);
			int median = (length/2)-1;
			int value = quicksorting(list, 0, length-1,median);
			System.out.println(rvalue);
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}
}
