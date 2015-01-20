//imports all the stuff to read and write
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class pklmnfilewriter
{
  public static void main(String[] args)throws IOException
  {
    Scanner sc = new Scanner(System.in);
    while(0==0)
    {
    System.out.println("Type pokemon gif name");
    String str = sc.nextLine();
    
    PrintWriter outputStream = null;//initializes print writer
    try 
    {
      outputStream = new PrintWriter(new FileWriter(str+".java"));
      outputStream.println("import info.gridworld.actor.Rock; public class "+str+" extends Rock{");
      outputStream.println("public "+str+"(){setColor(null);}");
      outputStream.println("public void act(){}}");
      
    }
    finally {
      if (outputStream != null) {
        outputStream.close();//close file
      }
    }
    }
  }
}