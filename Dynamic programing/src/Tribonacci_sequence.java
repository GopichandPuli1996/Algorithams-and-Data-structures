import java.util.Scanner;

public class Tribonacci_sequence {
	
	public static int TribonacciCall(int n){
		if(n==0) {
			return 0;
		}
		if(n==1 || n==2) {
			return 1;
		}
		else {
			return TribonacciCall(n-1)+TribonacciCall(n-2)+TribonacciCall(n-3);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n to find the Tribonacci sequence:");
		int n = sc.nextInt();
		long startTime1 = System.nanoTime();
		int total = TribonacciCall(n);
		long endTime1 = System.nanoTime();
		int arr[] = new int[n+1];
		System.out.println("Recursive calls "+total);
		long executionTime1 = endTime1 - startTime1;
		System.out.println("Time taken for Recursive calls "+executionTime1);
		//Linear method
		long startTime2 = System.nanoTime();
		for(int i=0; i<=n;i++) {
			if(i==0) {
				arr[i]= 0;
				continue;
			}
			if (i==1 || i==2) {
				arr[i] = 1;
			}
			else	
				arr[i] = arr[i-3] + arr[i-1]+ arr[i-2];
		}
		long endTime2 = System.nanoTime();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("Dynamic call "+ arr[n]);
		System.out.println("Time taken for Linear method "+executionTime2);
		sc.close();
	}

}
