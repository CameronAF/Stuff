package q4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Scanner object: 
 * only method is Scan to take users input
 * @author cameron
 */
public class Scanner {
  private int upc;
  
  /**
  * Scanner constructor: simple constructor
  */
  public Scanner() { }
    
  /**
  * Can method used to take users input
  * User can input 4 digit number or PAY 
  * @return integer of UPC or 999 for PAY
  */
  public int scan()
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    try{
      line = br.readLine();
    }
    catch (IOException e) {}
    if (line.equals("PAY"))
    {
      return 999;
    }
    try 
    {
      upc = Integer.parseInt(line);
    }
    catch (NumberFormatException  e)
    {
      return 0;
    }
    return upc;
  }
}