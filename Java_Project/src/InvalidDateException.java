/**
 * ---------------------------------------------------------------------------
 * File name: InvalidDateException.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Mar 30, 2011<br>
 * Date of Last Modification: Mar 30, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Custom exception class for invalid birth dates<br>
 *
 * <hr>
 * Date created: Apr 5, 2011<br>
 * Date last modified: Apr 5, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class InvalidDateException extends Exception
{
	static final long serialVersionUID = 1;
	private boolean b = true;
	/**
	 * 
	 * Constructor for InvalidDateException Class<br>        
	 *
	 * <hr>
	 * Date created: Apr 5, 2011 <br>
	 * Date last modified: Apr 5, 2011 <br>
	 *
	 * <hr>
	 */
	public InvalidDateException(String strdate)
	{
		super("Error: Invalid " + strdate + " entered");
	}

}
