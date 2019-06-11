package q4;
import java.util.*;

/**
 * Receipt object:
 * a list of items that have been scanned
 * @author cameron
 */
public class Receipt {
  private final LinkedList<Product> items = new LinkedList<Product>();
  
  /**
  * Register constructor: simple constructor
  */
  public Receipt() { }
  
  /**
  * adds an product to items list from UPC
  * @param UPC to get Product
  */
  public void addProduct(int upc)
  {
    items.add(new Product(upc));
  }
  
  /**
  * get the last item in items list
  * @return a the last product in items
  */
  public Product lastItem()
  {
    return items.get(items.size()-1);
  }
  
  /**
  * calculate the total of all items prices in items list
  * @return an int total
  */
  public double getTotal()
  {
    double total = 0;
    for (Product item : items)
    {
      total += item.getPrice();
    }
    return total;
  }
  
  /**
  * Creates a string of all items in list to be printed by register
  * @return a string of all items 
  */
  public String allItems()
  {
    String allItems = "";
    for (Product item : items)
    {
      allItems += item.getName() + "\n";
      allItems += Integer.toString(item.getUPC()) + "\n";
      allItems += Double.toString(item.getPrice()) + "\n";
    }
    return allItems;
  }
}