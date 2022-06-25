import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxandMinheap {
	
	public static int minheap(int arr[],int n) {
		int flag=0;
		for(int i=0;i<n;i++) {
			if(i>=(n-2)/2) {
				if((n-1)==(2*i+1)) {
					if(arr[i]<arr[2*i+1]) {
						flag=1;
						return flag;
					}
				}else {
					if(arr[i]<arr[2*i+1] && arr[i]<arr[2*i+2]) {
						flag =1;
						return 1;
					}
				}
				flag =1;
				return flag;
			}
			if(arr[i]<arr[2*i+1] && arr[i]<arr[2*i+2]) {
				flag=1;
			}
			else {
				flag = 0;
				return flag;
			}
		}
		return flag;
	}
	
	public static int Maxheapp(int[] arr,int n) {
		int flag=0;
		for(int i=0;i<n;i++) {
			if(i>=(n-2)/2) {
				if((n-1)==(2*i+1)) {
					if(arr[i]>arr[2*i+1]) {
						flag=1;
						return flag;
					}
				}else {
					if(arr[i]>arr[2*i+1] && arr[i]>arr[2*i+2]) {
						flag =1;
						return 1;
					}
				}
				flag =1;
				return flag;
			}
			if(arr[i]>arr[2*i+1] && arr[i]>arr[2*i+2]) {
				flag=1;
			}
			else {
				flag = 0;
				return flag;
			}
		}
		return flag;
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
			int length = arrlist.size();
			
			
			int f1 = Maxheapp(list,length);
			int f2 = minheap(list,length);
			
			if(f1 == 1)
				System.out.println("max heap");
			else
				System.out.println("not max heap");
			if(f2 == 1)
				System.out.println("min heap");
			else
				System.out.println("not min heap");
			
			if(f1 != 1 && f2 != 1)
				System.out.println("Neither max nor min heap");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}
}
