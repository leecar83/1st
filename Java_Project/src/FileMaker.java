import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * ---------------------------------------------------------------------------
 * File name: FileWriter.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Apr 8, 2011<br>
 * Date of Last Modification: Apr 12, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Writes an arrayList of healthprofiles to a file
 * from memory<br>
 *
 * <hr>
 * Date created: Apr 8, 2011<br>
 * Date last modified: Apr 12, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class FileMaker
{
	private PrintWriter output;//printwriter for text output
	
	/**
	 * 
	 * Constructor for Filemaker<br>        
	 *
	 * <hr>
	 * Date created: Apr 8, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 */
	public FileMaker()
	{
		//create PrintWriter object for writing to file
		try
		{
			output = new PrintWriter("HealthProfiles.dat");
		}
		catch(Exception f)
		{
			JOptionPane.showMessageDialog (null, "Error: unable to write file");
		}
	}
	
	/**
	 * 
	 * Constructor for PrintWriter<br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param strPath
	 */
	public FileMaker(String strPath)
	{
		try
		{
			//create PrintWriter object for writing to file
			output = new PrintWriter(strPath);
		}
		catch(Exception f)
		{
			JOptionPane.showMessageDialog (null, "Error: unable to write file");
		}
	}
	/**
	 * 
	 * Write client arrayList to file <br>        
	 *
	 * <hr>
	 * Date created: Apr 8, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 * @param list
	 */
	public void FileWrite (ArrayList <Healthprofile> list)
	{
		//output client info to file
		try
		{
			
			for(int i = 0; i < list.size ( ); i++)
			{
				output.println(list.get(i).getFirstName ( ) + "," + list.get (i).getLastName ( ) +
							   "," + list.get (i).getGender ( ) +
							   "," + list.get (i).getBirthMonth12 ( ) +
					           "," + list.get (i).getBirthDay ( ) +
					           "," + list.get (i).getBirthYear ( ) +
					           "," + list.get (i).getHeight ( ) +
					           "," + list.get (i).getWeight ( ));
					          
			}
		}
		catch(Exception d)
        {
	        JOptionPane.showMessageDialog(null, "Unable to write data to file");
	    }
		output.close ( );	//close file
	}
	
	/**
	 * 
	 * Write client array to file <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param profiles
	 */
	public void FileWrite (Healthprofile [] profiles)
	{
		//output client info to file
		try
		{
			
			for(int i = 0; i < profiles.length; i++)
			{
				output.println(profiles [i].getFirstName ( ) + "," + profiles [i].getLastName ( ) +
							   "," + profiles [i].getGender ( ) +
							   "," + profiles [i].getBirthMonth ( ) +
					           "," + profiles [i].getBirthDay ( ) +
					           "," + profiles [i].getBirthYear ( ) +
					           "," + profiles [i].getHeight ( ) +
					           "," + profiles [i].getWeight ( ));
					          
			}
		}
		catch(Exception d)
        {
	        JOptionPane.showMessageDialog(null, "Unable to write data to file");
	    }
		output.close ( );	//close file
	}
}
