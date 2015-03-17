import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * ---------------------------------------------------------------------------
 * File name: FileReader.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Apr 23, 2011<br>
 * Date of Last Modification: Apr 23, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 23, 2011<br>
 * Date last modified: Apr 23, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class FileReader
{
	private File fileIn;	//holds file object
	private Scanner file = null;	//holds scanner object
	private HealthProfileCollection profiles;	//holds a HealthProfileCollection <ArrayList> object
	
	/**
	 * 
	 * FileReader Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param inputFile
	 */
	public FileReader(String inputFile)
	{
		fileIn = new File(inputFile);
	}
	
	/**
	 * 
	 * Checks if file exists <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @return
	 */
	public boolean checkFileExists()
	{
		boolean file = false;
		
		//if file exist return true
		if(fileIn.exists ( )){
			file = true;
		}
		return file;
	}
	
	/**
	 * 
	 * Reads a file into memory as a 
	 * HealthprofileCollection object <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @return
	 */
	public  HealthProfileCollection readFile()
	{
		try
		{
			file = new Scanner(fileIn);	//Scanner object
			profiles = new HealthProfileCollection();	//HealthProfileCollecion object
			
			//read healthprofiles from file and store in Healthprofile collection1
			while(file.hasNext ( ))
			{
				String strInput = file.nextLine ( );
				String [] fields = strInput.split (",");
				try
				{
					profiles.setClientFromFile (fields[0], fields[1], fields[2],Integer.parseInt (fields[3]),
													Integer.parseInt (fields [4]), Integer.parseInt (fields[5]),
													Double.parseDouble (fields[6]), Double.parseDouble (fields[7]));
														
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(null, "Error: Unable to read from file");
					break;
				}

			}
		}
		catch (Exception e )
		{
			JOptionPane.showMessageDialog(null,"Unable to read file");
		}
		
		
		file.close ( );//close file
		return profiles;
	}
}//end of FileReader
