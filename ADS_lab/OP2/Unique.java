import java.util.Scanner;

public class Unique { 
    static void printUnique(int l, int r) { 
        for (int i=l ; i<=r ; i++) { 
            int num = i; 
            boolean visited[] = new boolean[10]; 

            while (num != 0) {  
                if (visited[num % 10]) 
                    break; 
       
                visited[num%10] = true; 
       
                num = num/10; 
            } 
            if (num == 0) 
                System.out.print(i + " "); 
        } 
    } 
    public static void main(String args[]) { 
        Scanner se = new Scanner(System.in);
		System.out.println("Enter the left range and right range:");
		int l = se.nextInt();
		int r = se.nextInt();
        printUnique(l, r); 
    } 
} 
