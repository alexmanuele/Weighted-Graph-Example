import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class RouteRecommenderTest {

  private static String testInput0 = 
                                     "route 2 15\n" +
                                     "A3 4\n" +
                                     "B3 3\n" +
                                     "C3 5\n" +
                                     "D3 2\n" +
                                     "end\n" +
                                     "end\n" +
                                     "A3 D3 1\n" +
                                     "end\n";
  private static String [] testOutput0 = { 
                                     "At stop A3 take bus #2",
                                     "Get off at stop D3" };

  private static String testInput1 = 
                                    "route 2 15\n" +
                                    "A3 4\n" +
                                    "B3 3\n" +
                                    "C3 5\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "route 4 10\n" +
                                    "B1 3\n" +
                                    "B2 1\n" +
                                    "B3 6\n" +
                                    "B4 2\n" +
                                    "B5 3\n" +
                                    "end\n" +
                                    "end\n" +
                                    "A3 B5 1\n" +
                                    "end\n";
  private static String [] testOutput1 = { 
                                    "At stop A3 take bus #2",
                                    "At stop B3 switch to bus #4",
                                    "Get off at stop B5" };

  private static String testInput2 = 
                                    "route 1 15\n" +
                                    "A3 4\n" +
                                    "B3 3\n" +
                                    "C3 5\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "route 2 15\n" +
                                    "A3 4\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "end\n" +
                                    "A3 D3 1\n" +
                                    "end\n" +
                                    "";
  private static String [] testOutput2 = { 
                                    "At stop A3 take bus #2",
                                    "Get off at stop D3" };


  private static String testInput3 = 
                                    "route 1 15\n" +
                                    "A3 4\n" +
                                    "B3 3\n" +
                                    "C3 5\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "route 2 15\n" +
                                    "A3 0\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "end\n" +
                                    "A3 D3 1\n" +
                                    "end\n" +
                                    "";
  private static String [] testOutput3 = { 
                                    "At stop A3 take bus #1",
                                    "Get off at stop D3" };


  private static String testInput4 = 
                                    "route 2 15\n" +
                                    "A3 4\n" +
                                    "B3 3\n" +
                                    "C3 5\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "route 4 10\n" +
                                    "B1 3\n" +
                                    "B2 1\n" +
                                    "B3 6\n" +
                                    "B4 3\n" +
                                    "end\n" +
                                    "route 3 20\n" +
                                    "D3 3\n" +
                                    "D4 1\n" +
                                    "C4 6\n" +
                                    "B4 4\n" +
                                    "A4 3\n" +
                                    "end\n" +
                                    "end\n" +
                                    "A3 A4 1\n" +
                                    "end\n" +
                                    "";
  private static String [] testOutput4 = { 
                                    "At stop A3 take bus #2",
                                    "At stop B3 switch to bus #4",
                                    "At stop B4 switch to bus #3",
                                    "Get off at stop A4" };

  private static String testInput5 = 
                                    "route 2 15\n" +
                                    "A3 4\n" +
                                    "B3 3\n" +
                                    "C3 5\n" +
                                    "D3 2\n" +
                                    "end\n" +
                                    "route 4 10\n" +
                                    "B1 3\n" +
                                    "B2 1\n" +
                                    "B3 6\n" +
                                    "B4 3\n" +
                                    "end\n" +
                                    "route 3 20\n" +
                                    "D3 3\n" +
                                    "D4 1\n" +
                                    "C4 6\n" +
                                    "B4 4\n" +
                                    "A4 3\n" +
                                    "end\n" +
                                    "end\n" +
                                    "A3 A4 1\n" +
                                    "B1 C4 2\n" +
                                    "end\n" +
                                    "";
  private static String [] testOutput5 = { 
                                    "At stop A3 take bus #2",
                                    "At stop B3 switch to bus #4",
                                    "At stop B4 switch to bus #3",
                                    "Get off at stop A4",
                                    "At stop B1 take bus #4",
                                    "At stop B3 switch to bus #2",
                                    "At stop D3 switch to bus #3",
                                    "Get off at stop C4" };

  private static Scanner mkTest( String input ) {
    return new Scanner( input );
  }
     
  private static ArrayList<String> mkOutput( String [] output ) {
    ArrayList<String> al = new ArrayList<String>();

    for( String s : output ) {
      al.add( s );
    }
    return al;
  }
     
  private static boolean doTest( String input, String [] output ) {
    Tester t = new RouteRecommender();
    ArrayList<String> al = t.compute( mkTest( input ) );
    System.out.println( "Input: " );
    System.out.println( input );
    System.out.println( "Generated output" );
    for( String s : al ) {
      System.out.println( s );
    }
    System.out.println( "Expected output" );
    for( String s : output ) {
    	  System.out.println( s );
    }
    System.out.println( "---------------------------------------------------" );
    return al != null && al.equals( mkOutput( output ) );
  }

  @Test
  void testEmpty() {
    assertTrue( doTest( testInput0, testOutput0 ), "Basic route" );
  }

  @Test
  void test1() {
    assertTrue( doTest( testInput1, testOutput1 ), "One switch route" );
  }

  @Test
  void test2() {
    assertTrue( doTest( testInput2, testOutput2 ), "Take the shorter route" );
  }

  @Test
  void test3() {
    assertTrue( doTest( testInput3, testOutput3 ), "Waiting for bus affects schedule" );
  }

  @Test
  void test4() {
    assertTrue( doTest( testInput4, testOutput4 ), "Multiple bus switches" );
  }

  @Test
  void test5() {
    assertTrue( doTest( testInput5, testOutput5 ), "Multiple queries" );
  }
}
