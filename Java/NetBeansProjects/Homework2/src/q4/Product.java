package q4;

/**
 * Product object: 
 * represents a item to that was scanned
 * @author cameron
 */
public class Product {
  private int upc;
  private String name;
  private double price;
  
  /**
  * Register constructor: simple constructor
  */
  public Product() { }
  
  /**
  * Product constructor that fills attributes based on UPC
  * @param UPC of a product
  */
  public Product(int num) 
  {
    upc = num;
    name = "Butter";
    price = 2.50;
  }
  
  /**
  * get the UPC of the product
  * @return the UPC of the product
  */
  public int getUPC()
  {
    return upc;
  }
  
  /**
  *  * get the name of the product
  * @return the name of the product
  */
  public String getName()
  {
    return name;
  }
  
  /**
    * get the price of the product
  * @return the price of the product
  */
  public double getPrice()
  {
    return price;
  }
}