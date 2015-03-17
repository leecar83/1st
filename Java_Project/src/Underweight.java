/**
 * ---------------------------------------------------------------------------
 * File name: Underweight.java <br>
 * Project name: HealthProfileApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Feb 13, 2011<br>
 * Date of Last Modification: Feb 19, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Return a string of name and BMI of underweight clients<br>
 *
 * <hr>
 * Date created: Feb 13, 2011<br>
 * Date last modified: Feb 19, 2011<br>
 * <hr>
 * @author Lee Miller
 */
import java.text.*;

public class Underweight
{
	private Healthprofile p;
	/**
	 * 
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Feb 16, 2011 <br>
	 * Date last modified: Feb 16, 2011 <br>
	 *
	 * <hr>
	 * @param profile
	 */
	public Underweight(Healthprofile profile)
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
	public String toStringUnderweight(Healthprofile profile)
	{
		double dBMI;//holds the value of BMI
		String strReturn;//holds String to be returned
		DecimalFormat one = new DecimalFormat("0.#");//object for decimal formatting
		dBMI = p.calculateBMI ( );
		//if BMI is between 25 & 30 return name and BMI else return empty String
		if (dBMI < 18.5)
		{
			strReturn = p.getFirstName ( ) + " " + p.getLastName ( ) + 
				"  BMI: " + one.format (dBMI) + "\n";
		}
		else 
			strReturn = "";
		return strReturn;
	}
}
