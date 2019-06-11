/*
 * Write a Java program that calculates and displays the Fibonacci 
 * series, defined by the recursive formula F(n) = F(n-1) + F(n-2).
 * F(0) and F(1) are given on the command line.
 * Define and use a class Fib with the following structure:
 */
package q1;
import java.util.*;
/**
 * @author Cameron Anzola-Ferreira 
 * @class COP5339 001
 * @data 1/21/2018
 */

public class Fib {
  // instance variables store F(0) and F(1):
  int num1;
  int num2;
  
  // constructor
  public Fib(int f0, int f1) 
  {
    num1 = f0;
    num2 = f1;
  }
  
  //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
  // computes F(n) using an ***iterative*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
  // use instance variables that store F(0) and F(1).
  // check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
  public int f(int n) {
    if (n < 0)
    {
      //throw exception;
      return 0;
    }
    else
    {
      int series[] = new int[n+2]; // use n+2 to allow n = 0 and not break program when series[1] = num2
      series[0] = num1;
      series[1] = num2;

      for (int i = 2; i <= n; i++)
      {
        series[i] = series[i-1] + series[i-2];
      }
      return series[n];
    }
  }

  // computes F(n) using the ***recursive*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
  // use instance variables that store F(0) and F(1).
  // check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
  public int fRec(int n) {
    if (n < 0)
    {
      //throw exception;
      return 0;
    }
    else
    {
      if (n == 0) return num1;
      if (n == 1) return num2; 
      return (fRec(n - 1) + fRec(n - 2)); 
    }
  }

  public static void main(String[] args) 
  {
    // get numbers F(0) and F(1) from args[0] and args[1].
    // use either the Scanner class or Integer.parseInt(args[...])
    // you must handle possible exceptions !
    int f0 = 0;
    int f1 = 0;
    int n = 0;
    int error = 0;
    try
    {
      if (args.length == 3)
      {
        f0 = Integer.parseInt(args[0]);
        f1 = Integer.parseInt(args[1]);
        n = Integer.parseInt(args[2]);
      }
      else
      {
        if (args.length != 0)
        {
          System.out.println("The proper amount of arguments was not given");
        }
        Scanner in = new Scanner(System.in);
        System.out.println("input F(0)");
        f0 = in.nextInt();
        System.out.println("input F(1)");
        f1 = in.nextInt();
        System.out.println("input n");
        n = in.nextInt();
      }
    }
    catch (NumberFormatException ex )
    {
      System.out.println("ERROR: integer not used");
      error = 1;
    }
    catch (InputMismatchException ex) 
    {
      System.out.println("ERROR: integer not used");
      error = 1;
    }
    catch (Exception ex) 
    {
      System.out.println("ERROR with inputs");
      error = 1;
    }

    if (error == 0)
    {
      // create a Fib object with params F(0) and F(1)
      Fib fib = new Fib(f0, f1);

      // calculate F(0), ..., F(n) and display them with System.out.println(...) using
      System.out.println("calculate F(0), ..., F(n) using iterative methode:");
      for (int i = 0; i < n; i++)
      {
        System.out.print(fib.f(i));
        if (i != (n-1))
        {
          System.out.print(", ");
        }
      }

      // calculate F(0), ..., F(n) and display them with System.out.println(...) using
      System.out.println("\ncalculate F(0), ..., F(n) using recursive methode:");
      for (int i = 0; i < n; i++)
      {
        System.out.print(fib.fRec(i));
        if (i != (n-1))
        {
          System.out.print(", ");
        }
      }
      System.out.println("\nThank you");
    }
  }
};
//Write javadoc comments for the Fib class.
