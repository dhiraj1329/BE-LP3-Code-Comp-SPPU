import java.util.*;
public class Main
{
    public static int knapsack(int[] weights,int[] values,int capacity)
    {
        int n = weights.length;
        
        int dp[][] = new int[n+1][capacity+1];
        
        for(int i=1;i<=n;i++)
        {
            for(int w=0;w<=capacity;w++)
            {
                if(weights[i-1] <= w)
                {
                    dp[i][w] = Math.max(dp[i-1][w],values[i-1]+dp[i-1][w-weights[i-1]]);
                }
                
                else
                {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }
    
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        // int[] weights = {1,3,4,5};
        // int[] values = {10,40,50,70};
        // int capacity = 7;

        Scanner scanner = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        // Input weights and values arrays
        int[] weights = new int[n];
        int[] values = new int[n];
        
        System.out.println("Enter the weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

       
        // Input capacity of the knapsack
        System.out.print("Enter capacity of knapsack: ");
        int capacity = scanner.nextInt();
        
        int maxProfit = knapsack(weights,values,capacity);
        System.out.println("Maximum profit : "+maxProfit);
	}
}
