import java.util.Arrays;
import java.util.Scanner;

public class ArrayElements { 
	
	static void findElements(int arr[], int n) { 
		Arrays.sort(arr); 
		  
	    for (int i = 0; i < n - 2; i++) 
	    System.out.print(arr[i] + " ");  
	}  
	public static void main(String args[]) {
		Scanner se = new Scanner(System.in);
		System.out.println("Enter the number of test cases:");
		int testc = se.nextInt();
		for(int i=0;i<testc;i++) {
			System.out.println("Enter the number of elements:");
			int n = se.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = se.nextInt();
			}
			findElements(arr, n);	
		} 
	} 
} 


