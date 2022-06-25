import java.util.Scanner;

public class Binaryform {
	
	public static int bit_length(int v, int n) {
		//int fun[] = new int[n+1];
		int sum = 0;
		while(v>0) {
			if(v == 1) {
				sum = sum + v;
				break;
			}
			int rem = v%2;
			sum = sum + rem;
			int quo = v/2;
			v =  quo;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		System.out.println("Quadratic method");
		int sum =0;
		for(int i=0;i<=n;i++) {
			if(i==0) {
				arr[i] = 0;
			}
			int t = i;
			while (t>0) {
				if(t == 1) {
					sum = sum + t;
					break;
				}
				 
				int rem = t%2;
				sum = sum + rem;
				int quo = t/2;
				t =  quo;
			}
			arr[i] = sum;
			sum = 0;
		}
		
		for(int i=0;i<=n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//method 2
		System.out.println("function method");
		for(int i=0;i<=n;i++) {
			int value = bit_length(i,n);
			System.out.print(value+" ");
		}
		System.out.println();
		System.out.println("linear method");
		int ar[] = new int[n+1];
		int i=0;
		for(i=0;i<=n;i++) {
			ar[i] = i;
		}
		int tot=0;
		i=0;
		while(i<=n) {
			if(ar[i]==0) {
				tot=tot+ar[i];
				i++;
				tot=0;
				System.out.print(tot+" ");
				continue;
			}
			if(ar[i]==1) {
				tot=tot+ar[i];
				System.out.print(tot+" ");
				i++;
				tot=0;
				continue;
			}
			int rem2=ar[i]%2;
			tot = tot + rem2;
			int quo2 = ar[i]/2;
			ar[i] = quo2;
		}
	}

}
