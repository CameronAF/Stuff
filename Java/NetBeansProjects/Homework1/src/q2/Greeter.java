package q2;
/**
 * @author Cameron Anzola-Ferreira 
 * @class COP5339 001
 * @data 1/21/2018
 */
public class Greeter
{
  private String name;
  
  /**
    Constructs a Greeter object that can greet a person or 
    entity.
    @param aName the name of the person or entity who should
    be addressed in the greetings.
  */
  public Greeter(String aName)
  {
    name = aName;
  }
  
  /**
     return the greeter name
     @return greater name
  */
  public String getName()
  {
    return name;
  }
  /**
     Greet with a "Hello" message.
     @return a message containing "Hello" and the name of
     the greeted person or entity.
  */
  public String sayHello()
  {
    return "Hello, " + name + "!";
  }
  
  /**
     swaps the names of this greeter and another instance.
     @param other the name of a instance of Greeter class
   */
  public void swapNames(Greeter other) 
  {
    String tempName = other.name;
    other.name = this.name;
    this.name = tempName;
  }
  
  /**
     returns a new Greeter object with its name being the qualifier string 
     followed by and the executing greeters name
     @param qualifier
     @return a new greater class
   */
  public Greeter createQualifiedGreeter(String qualifier) 
  {
    return new Greeter(name + " " + qualifier);
  }
}
