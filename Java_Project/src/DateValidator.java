import java.util.Calendar;
import javax.swing.JOptionPane;


/**
 * ---------------------------------------------------------------------------
 * File name: DateValidator.java <br>
 * Project name: HealthProfileApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Feb 9, 2011<br>
 * Date of Last Modification: Feb 13, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Check that user entered a correct date<br>
 *
 * <hr>
 * Date created: Feb 9, 2011<br>
 * Date last modified: Apr 12, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class DateValidator
{
	private int iDay;//holds day
	private int iMonth;//holds month
	private int iYear;//holds year
	/**
	 * 
	 * Constructor for DateValidator<br>        
	 *
	 * <hr>
	 * Date created: Feb 9, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 * @param Day
	 * @param Month
	 * @param Year
	 * @throws InvalidDateException
	 */
	public DateValidator(Integer Day,Integer Month,Integer Year) throws InvalidDateException
	{
		
			iDay = Day;
			iMonth = Month;
			iYear = Year;
			//create Calendar object for current date
			Calendar now = Calendar.getInstance ( );
			//create Calendar Object to test
			Calendar test = Calendar.getInstance( );
			//set the attributes of test Calendar
			test.set (iYear,iMonth,iDay);
			
			boolean leap = true;//holds the boolean value of leap year  
			
			/* test year for proper input*/
			if (iYear + 120 < now.get (Calendar.YEAR) || now.before (test))
			{	
				throw new InvalidDateException("year");
			}
			/* Test the month for proper input*/
			if (iMonth < 0 || iMonth > 12)
			{	
				throw new InvalidDateException("month");
			}
			
			//algorithm to determine if it is a leap year
			if (iYear % 400 ==  0)
				leap = true;
			else if (iYear % 100 == 0)
				leap = false;
			else if (iYear % 4 == 0)
				leap = true;
			else
				leap = false;
			
			/*Test to see if user has entered a
			 * valid day for that particular month
			 */
			
			//if the day entered for February is greater then 29 in a leap year it is invalid
			if ( leap == true && iMonth == 2)
			{
				if ( iDay < 0 || iDay > 29 )
				{	
					throw new InvalidDateException("day");
				}
			}
			
			//if the day entered for February is greater then 28 in a non leap year it is invalid
			if ( leap == false && iMonth == 2)
			{
				if ( iDay < 0 || iDay > 28)
				{	
					throw new InvalidDateException("day");
				}
			}
			
			//in the months of Apr, Jun, Sep, or Nov a day greater then 30 is invalid
			if( iMonth == 4 ||
				iMonth == 6 ||
				iMonth == 9 ||
				iMonth == 11 )
			{
				if( iDay < 0 || iDay > 30)
				{	
					throw new InvalidDateException("day");
				}
			}
			
			//in the remaining months a day greater than 31 is invalid
			if (iDay < 0 || iDay > 31)
			{	
				throw new InvalidDateException("day");
			}
	}
			
}//end of DateValidator
	
