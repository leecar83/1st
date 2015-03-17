/**
 * ---------------------------------------------------------------------------
 * File name: Obese.java <br>
 * Project name: HealthProfileApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Feb 13, 2011<br>
 * Date of Last Modification: Feb 19, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Return a string of name and BMI of obese clients<br>
 *
 * <hr>
 * Date created: Feb 13, 2011<br>
 * Date last modified: Feb 19, 2011<br>
 * <hr>
 * @author Lee Miller
 */
import java.text.*;
public class Obese
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
	public Obese(Healthprofile profile)
	{
		p = profile;
	}
	
	/**
	 * 
	 * Return a string of user's anme and BMI <br>        
	 *
	 * <hr>
	 * Date created: Feb 13, 2011 <br>
	 * Date last modified: Feb 13, 2011 <br>
	 *
	 * <hr>
	 * @param profile
	 * @return
	 */
	public String toStringObese(Healthprofile profile)
	{
		double dBMI;//holds value of BMI
		String strReturn;//holds a String to be returned
		dBMI = p.calculateBMI ( );
		DecimalFormat one = new DecimalFormat("0.#");//object for number formatting
		//if BMI is between 25 & 30 return name and BMI else return empty String
		if (dBMI >= 30)
		{
			strReturn = p.getFirstName ( ) + " " + p.getLastName ( ) + 
				"  BMI: " + one.format(dBMI) + "\n";
		}
		else 
			strReturn = "";
		return strReturn;
	}
}
