/**
 * ---------------------------------------------------------------------------
 * File name: Overweight.java <br>
 * Project name: HealthProfileApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Feb 13, 2011<br>
 * Date of Last Modification: Feb 19, 2011<br>
 * ---------------------------------------------------------------------------
 */
import java.text.*;
/**
 * return a string of name and BMI of overweight clients<br>
 *
 * <hr>
 * Date created: Feb 13, 2011<br>
 * Date last modified: Feb 19, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class Overweight
{
	private Healthprofile p;
	
	/**
	 * 
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Feb 13, 2011 <br>
	 * Date last modified: Feb 13, 2011 <br>
	 *
	 * <hr>
	 * @param profile
	 */
	public Overweight(Healthprofile profile)
	{
		p = profile;
	}
	
	/**
	 * 
	 * Return a string with user's name and BMI <br>        
	 *
	 * <hr>
	 * Date created: Feb 13, 2011 <br>
	 * Date last modified: Feb 13, 2011 <br>
	 *
	 * <hr>
	 * @param profile
	 * @return
	 */
	public String toStringOverweight(Healthprofile profile)
	{
		double dBMI;//holds the value of BMI
		String strReturn;//holds a string to be returned
		DecimalFormat one = new DecimalFormat("0.#");//object for formatting
		dBMI = p.calculateBMI ( );
		//if BMI is between 25 & 30 return name and BMI else return empty String
		if (dBMI >= 25 && dBMI < 30)
		{
			strReturn = p.getFirstName ( ) + " " + p.getLastName ( ) + 
				"  BMI: " + one.format (dBMI) + "\n";
		}
		else 
			strReturn = "";
		return strReturn;
	}
}
