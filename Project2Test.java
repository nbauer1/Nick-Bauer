/**
 * 
 * @author Nick Bauer
 * @version Test
 * ITEC 220
 * Project 2
 * 
 */
public class Project2Test 
{
	public static void main(String[]args)
	{
		View theView = new View();
		Model theModel = new Model();
		new Controller(theView, theModel);
	}
}

/**
 * 
 * CITATIONS:
 * http://www.newthinktank.com/2013/02/mvc-java-tutorial/
 * https://www.javatpoint.com/java-char-to-int
 * https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#deleteCharAt(int)
 * https://stackoverflow.com/questions/18031704/jframe-how-to-disable-window-resizing
 * 
 */