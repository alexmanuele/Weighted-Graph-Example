import java.util.ArrayList;
import java.util.Scanner;

public interface Tester {
  // This method takes a Scanner object contianint the input 
  // and returns an ArrayList object containing the output.
  //
  // Parameters:
  //   Scanner input: is a Scanner object that is a stream of text
  //                  containing the input to your program.
  //
  // Returns: an ArrayList of Strings.  Each string is a line of output 
  //          from your program.
  public ArrayList<String> compute( Scanner log );
}
