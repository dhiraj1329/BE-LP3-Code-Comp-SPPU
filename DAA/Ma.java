// import java.util.Arrays;
// import java.util.Comparator;
import java.util.*;

class Item
{
    double weight;
    double value;
    
    public Item(double weight,double value)
    {
        this.weight = weight;
        this.value = value;
    }
}


public class Ma
{
    private static Comparator<Item> comparator = (Item a,Item b) ->
    {
        double r1 = a.value/a.weight;
        double r2 = b.value/b.weight;
        return Double.compare(r2,r1);
    };
    
    public static double getmaxValue(Item[] items,double capacity)
    {
        Arrays.sort(items,comparator);
        
        double totalValue = 0.0;
        
        for(Item item : items)
        {
            if(capacity >= item.weight)
            {
                totalValue = totalValue + item.value;
                capacity = capacity - item.weight;
            }
            
            else
            {
                totalValue = totalValue + item.value * (capacity / item.weight);
                break;
            }
        }
        
        return totalValue;
    }
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        // Item [] items = {
        //     new Item(10,60),
        //     new Item(20,100),
        //     new Item(30,120)
        // };
        
        // double capacity = 50;
        
        
        Scanner scanner = new Scanner(System.in);

        // User inputs number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        // User inputs item weights and values
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight for item " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            System.out.print("Enter value for item " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            items[i] = new Item(weight, value);
        }

        // User inputs knapsack capacity
        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();
        
        double maxValue = getmaxValue(items,capacity);
        System.out.println("Maximum value in knapsack : "+maxValue);
	}
}

