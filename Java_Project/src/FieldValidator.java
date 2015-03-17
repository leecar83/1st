import javax.swing.JOptionPane;

/**
 * ---------------------------------------------------------------------------
 * File name: FieldValidator.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Apr 25, 2011<br>
 * Date of Last Modification: Apr 25, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Verifies proper user input into
 * gender, height, weight, fields<br>
 *
 * <hr>
 * Date created: Apr 25, 2011<br>
 * Date last modified: Apr 25, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class FieldValidator
{
	private String strGender;	//holds gender
	private Double dWeight;		//holds weight
	private Double dHeight;		//holds height
	private char cGender;		//holds character for gender
	boolean good = true;		//holds boolean indicating a valid input
	boolean exceptions = false;		//holds boolean indicating an exception is thrown

	/**
	 * 
	 * Constructor for FieldValidator <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param gender
	 * @param height
	 * @param weight
	 * @throws InvalidFieldException
	 */
	public FieldValidator (String gender, String height, String weight)throws InvalidFieldException
	{
		strGender = gender;
		
		try
		{
			//get first letter of gender
			cGender = strGender.charAt (0);
		}
		catch(Exception e)
		{
			good = false;
			throw new InvalidFieldException("Gender");
		}
		
		try
		{
			//parse string
			dHeight = Double.parseDouble (height);
		}
		catch(Exception e)
		{
			good = false;
			throw new InvalidFieldException("Height");
		}
		
		try
		{
			//parse string
			dWeight = Double.parseDouble (weight);
		}
		catch(Exception e)
		{
			good = false;
			throw new InvalidFieldException("Weight");
		}
		
		//check gender height weight for proper values
		if(good)
		{
			if(Character.toLowerCase(cGender) != 'f' && Character.toLowerCase(cGender) != 'm')
			{
				throw new InvalidFieldException("Gender");
			}
			if(dHeight < 24 || dHeight > 120)
			{
				throw new InvalidFieldException("Height");
			}
			if(dWeight < 10 || dWeight > 1000)
			{
				throw new InvalidFieldException("Weight");
			}
		}
	}	
}//end of FieldValidator
