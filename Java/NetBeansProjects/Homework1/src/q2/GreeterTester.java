package q2;

/**
 * @author Cameron Anzola-Ferreira 
 * @class COP5339 001
 * @data 1/21/2018
 */
public class GreeterTester {
  public static void main(String[] args)
  {
    Greeter firstGreeter = new Greeter("Cameron");
    System.out.println(firstGreeter.sayHello() + "\n");
    
    Greeter secondGreeter =  firstGreeter.createQualifiedGreeter("Anzola");
    System.out.println("2nd greeter made using createQualifiedGreeter():");
    System.out.println("First Greeter: " + firstGreeter.getName());
    System.out.println("Second Greeter: " + secondGreeter.getName() + "\n");
    
    firstGreeter.swapNames(secondGreeter);
    System.out.println("Greeters after swapNames():");
    System.out.println("First Greeter: " + firstGreeter.getName());
    System.out.println("Second Greeter: " + secondGreeter.getName() + "\n");
  }
}
