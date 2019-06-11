/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author camer
 */
public class ComplexTest {
  
  public ComplexTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of toString method, of class Complex.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Complex instance = null;
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of r method, of class Complex.
   */
  @Test
  public void testR() {
    System.out.println("r");
    Complex instance = null;
    double expResult = 0.0;
    double result = instance.r();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of i method, of class Complex.
   */
  @Test
  public void testI() {
    System.out.println("i");
    Complex instance = null;
    double expResult = 0.0;
    double result = instance.i();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of add method, of class Complex.
   */
  @Test
  public void testAdd() {
    System.out.println("add");
    Complex other = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.add(other);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of sub method, of class Complex.
   */
  @Test
  public void testSub() {
    System.out.println("sub");
    Complex other = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.sub(other);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of conj method, of class Complex.
   */
  @Test
  public void testConj() {
    System.out.println("conj");
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.conj();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of mult method, of class Complex.
   */
  @Test
  public void testMult() {
    System.out.println("mult");
    Complex other = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.mult(other);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of div method, of class Complex.
   */
  @Test
  public void testDiv() throws Exception {
    System.out.println("div");
    Complex other = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.div(other);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of equals method, of class Complex.
   */
  @Test
  public void testEquals() {
    System.out.println("equals");
    Complex other = null;
    Complex instance = null;
    boolean expResult = false;
    boolean result = instance.equals(other);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
