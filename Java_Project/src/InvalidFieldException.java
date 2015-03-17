/**
 * ---------------------------------------------------------------------------
 * File name: InvalidFieldException.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Apr 25, 2011<br>
 * Date of Last Modification: Apr 25, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 25, 2011<br>
 * Date last modified: Apr 25, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class InvalidFieldException extends Exception
{
	static final long serialVersionUID = 1;
	private boolean b = true;
	/**
	 * 
	 * Constructor for InvalidFieldException Class<br>        
	 *
	 * <hr>
	 * Date created: Apr 25, 2011 <br>
	 * Date last modified: Apr 25, 2011 <br>
	 *
	 * <hr>
	 */
	public InvalidFieldException(String strfield)
	{
		super("Error: Invalid " + strfield + " entered ");
	}

}

