import javax.swing.SwingUtilities;



/**
 * App to allow user to input healthprofiles
 * and receive output sorted by various methods<br>
 *
 * <hr>
 * Date created: Mar 16, 2011<br>
 * Date last modified: Apr 12, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class HealthProfileCollectionApp
{

	/**
	 * Displays menu allowing user to choose to
	 * enter profiles, perform sorting, and display output <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 * @param args
	 * @throws InvalidDateException 
	 */

	public static void main (String [ ] args)
	{
		SwingUtilities.invokeLater
		(
			new Runnable()
			{
				public void run()
				{
					//GUI
					MainWindow window = new MainWindow();
				}
			}
		);
	}//end of main
		
}//end of class
		

	
	
	
	
	
	




	