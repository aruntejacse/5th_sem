import java.util.Scanner;

public class Main 
{ 
    public static void main(String[] args)
    { 
    	int n, m;
    	Scanner se = new Scanner(System.in);
    	n = se.nextInt();
    	m = se.nextInt();
        int[][] a = new int[n][m];
        System.out.print("Please enter 1's and 0's for each cell in 2D array:");
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		a[i][j] = se.nextInt();
        	}
        }
        System.out.println("Number of Islands is: " + 
                           countIslands(a)); 
     } 
  

     static int countIslands(int a[][]) 
     { 
        int n = a.length; 
        int m = a[0].length; 
  
        DisjointUnionSets dus = new DisjointUnionSets(n*m); 
  
        for (int j=0; j<n; j++) 
        { 
            for (int k=0; k<m; k++) 
            { 
                // If cell is 0, nothing to do 
                if (a[j][k] == 0) 
                    continue;
  
                if (j+1 < n && a[j+1][k]==1) 
                    dus.union(j*(m)+k, (j+1)*(m)+k); 
                if (j-1 >= 0 && a[j-1][k]==1) 
                    dus.union(j*(m)+k, (j-1)*(m)+k); 
                if (k+1 < m && a[j][k+1]==1) 
                    dus.union(j*(m)+k, (j)*(m)+k+1); 
                if (k-1 >= 0 && a[j][k-1]==1) 
                    dus.union(j*(m)+k, (j)*(m)+k-1); 
                if (j+1<n && k+1<m && a[j+1][k+1]==1) 
                    dus.union(j*(m)+k, (j+1)*(m)+k+1); 
                if (j+1<n && k-1>=0 && a[j+1][k-1]==1) 
                    dus.union(j*m+k, (j+1)*(m)+k-1); 
                if (j-1>=0 && k+1<m && a[j-1][k+1]==1) 
                    dus.union(j*m+k, (j-1)*m+k+1); 
                if (j-1>=0 && k-1>=0 && a[j-1][k-1]==1) 
                    dus.union(j*m+k, (j-1)*m+k-1); 
            } 
        } 
  
        // Array to note down frequency of each set 
        int[] c = new int[n*m]; 
        int numberOfIslands = 0; 
        for (int j=0; j<n; j++) 
        { 
            for (int k=0; k<m; k++) 
            { 
                if (a[j][k]==1) 
                { 
  
                    int x = dus.find(j*m+k); 
                    if (c[x]==0) 
                    { 
                        numberOfIslands++; 
                        c[x]++; 
                    } 
  
                    else
                        c[x]++; 
                } 
            } 
        } 
        return numberOfIslands; 
    } 
} 
  
class DisjointUnionSets 
{ 
    int[] rank, parent; 
    int n; 
  
    public DisjointUnionSets(int n) 
    { 
        rank = new int[n]; 
        parent = new int[n]; 
        this.n = n; 
        makeSet(); 
    } 
  
    void makeSet() 
    { 
 
        for (int i=0; i<n; i++) 
            parent[i] = i; 
    } 
  
    int find(int x) 
    { 
        if (parent[x] != x) 
        { 
            return find(parent[x]); 
        } 
  
        return x; 
    } 
   
    void union(int x, int y) 
    { 

        int xRoot = find(x); 
        int yRoot = find(y); 

        if (xRoot == yRoot) 
            return; 
 
        if (rank[xRoot] < rank[yRoot]) 
            parent[xRoot] = yRoot; 

        else if(rank[yRoot]<rank[xRoot]) 
            parent[yRoot] = xRoot; 
  
        else  
        { 
            parent[yRoot] = xRoot; 
            rank[xRoot] = rank[xRoot] + 1; 
        } 
    } 
} 