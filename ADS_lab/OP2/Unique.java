import java.util.Scanner;

public class Unique { 
    static void find(int l, int r) { 
        for (int i=l ; i<=r ; i++) { 
            int num = i; 
            boolean digitv[] = new boolean[10]; 

            while (num != 0) {  
                if (digitv[num % 10]) 
                    break; 
       
                digitv[num%10] = true; 
       
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
        find(l, r); 
    } 
} 
