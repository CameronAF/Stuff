package q4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Register object: 
 * object that uses an instance of scan to populate
 * an instance of Receipts with products
 * @author cameron
 */
public class Register {
  private final Scanner scanner = new Scanner();
  private final Receipt receipt = new Receipt();
  
  /**
  * Register constructor: simple constructor
  */
  public Register(){ 
  }
  
  /**
  * main method that runs an iteration of Register
  */
  public void main()  
  {
    System.out.println("Enter UPC :");
    try {
      int upc = scanner.scan();
      while (done(upc))
      {
        receipt.addProduct(upc);
        displayItem(receipt.lastItem());
        System.out.println("Enter UPC or Enter 'PAY' to finish:");
        upc = scanner.scan();
      }
      displayTotal();
      pay();
      displayReceipt();
    }
    catch (Exception e){}
  }
  
  /**
  * done distinguishes if input was UPC code or PAY
  * method that returns a boolean of true if input is 999 (input: PAY)
  * @param int of UPC code or 999
  * @return bool true for UCP or false for 999
  */
  private boolean done(int input)
  {
    return input != 999;
  }
  
  /**
  * print the UPC, Name, and Price of a product
  * @param an instance of product
  */
  private void displayItem(Product item)
  {
    System.out.println("UPC: " + item.getUPC());
    System.out.println("Name: " + item.getName());
    System.out.println("Price: " + item.getPrice());
  }
  
  /**
  * display the total product prices in a receipt
  */
  private void displayTotal()
  {
    double total = receipt.getTotal();
    System.out.println("TOTAL: " + total);      
  }
  
  /**
  * Requirement: User has to type CASH in order to display total receipt
  */
  private void pay()
  {
    boolean error = true;
    while (error)
    {
      System.out.println("Enter 'CASH' to pay total");
      String line = "";
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
        line = br.readLine();
      }
      catch (IOException e){}
      if (line.equals("CASH"))
      {
        error = false;
      }
    }          
  }
  
  /**
  * User has paid and all of receipt is displayed
  */
  private void displayReceipt()
  {
    String items = receipt.allItems();
    System.out.print(items);
  }
}