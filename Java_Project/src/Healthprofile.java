import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * ---------------------------------------------------------------------------
 * File name: Healthprofile.java <br>
 * Project name: HealthProfileApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Jan 30, 2011<br>
 * Date of Last Modification: Feb 5, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * This class provides a healthprofile object
 * with setters, getters, accessors, and manipulators <br>
 *
 * <hr>
 * Date created: Jan 30, 2011<br>
 * Date last modified: Feb 5, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class Healthprofile
{

	private String strFirstName;//holds the first name
	private String strLastName;//holds the second name
	private int iBirthMonth;//holds the birth month
	private int iBirthDay;//holds the birth day
	private int iBirthYear;//holds the birth year
	private double dHeight;//holds the height
	private double dWeight;//holds the weight 
	Gender person;
	enum Gender {Male,Female};
	
	/**
	 * 
	 * Default Constructor <br>        
	 * 
	 * <hr>
	 * Date created: Jan 30, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 */
	public Healthprofile() 
	{
	}
	
	public void setFirstName(String strFirstName)
	{
		this.strFirstName = strFirstName;
	}
	
	/**
	 * 
	 * Setter for last name <br>        
	 *
	 * <hr>
	 * Date created: Jan 30, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @param strLastName
	 */
	public void setLastName(String strLastName)
	{
		this.strLastName = strLastName;
	}
	
	/**
	 * 
	 * Setter for gender <br>        
	 *
	 * <hr>
	 * Date created: Jan 30, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @param cGender
	 */
	public void setGender(char charGender)
	{
		
		if (charGender == 'm' || charGender == 'M')
			person = Gender.Male;
		else 
		    person = Gender.Female;		
	}
	
	/**
	 * 
	 * Setter for date of birth <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 13, 2011 <br>
	 *
	 * <hr>
	 * @param iBirthDay
	 */
	public void setBirth(int iBirthDay, int iBirthMonth, int iBirthYear)
	{
		this.iBirthDay = iBirthDay;
		this.iBirthMonth = iBirthMonth;
		this.iBirthYear = iBirthYear;
	}
	
	/**
	 * 
	 * Setter for Height <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @param dHeight
	 */
	public void setHeight(double dHeight)
	{
		this.dHeight = dHeight;
	}
	
	/**
	 * 
	 * Setter for Weight <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @param dWeight
	 */
	public void setWeight(double dWeight)
	{
		this.dWeight = dWeight;
	}
	
	/**
	 * 
	 * Getter for first name <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return String
	 */
	public String getFirstName()
	{
		return strFirstName;
	}
	
	/**
	 * 
	 * Getter for last name <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return String
	 */
	public String getLastName()
	{
		return strLastName;
	}
	
	/**
	 * 
	 * returns string of full name <br>        
	 *
	 * <hr>
	 * Date created: Apr 23, 2011 <br>
	 * Date last modified: Apr 23, 2011 <br>
	 *
	 * <hr>
	 * @return
	 */
	public String getFullName()
	{
		
		String strReturn = "";
		
		if (strLastName.isEmpty ( ) && strFirstName.isEmpty ( ))
		{
			strReturn =".";
		}
		else
		{
			strReturn = strLastName + ",   " + strFirstName;
		}
		
		return strReturn;
	}
	/**
	 * 
	 * Getter for gender <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return String
	 */
	public String getGender()
	{
		return person.toString ( );
	}
	
	/**
	 * 
	 * Getter for birth month <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return int
	 */
	public int getBirthMonth()
	{
		return iBirthMonth;
	}
	
	/**
	 * 
	 * Getter for birth month in integers 1-12 <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return int
	 */
	public int getBirthMonth12()
	{
		int iBirthProper = iBirthMonth - 1;
		return iBirthProper;
	}
	
	/**
	 * 
	 * Getter for birth day <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return int
	 */
	public int getBirthDay()
	{
		return iBirthDay;
	}
	
	/**
	 * 
	 * Getter for birth year <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getBirthYear()
	{
		return iBirthYear;
	}
	
	/**
	 * 
	 * Getter for height <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return int
	 */
	public double getHeight()
	{
		return dHeight;
	}
	
	/**
	 * 
	 * Getter for weight <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return double
	 */
	public double getWeight()
	{
		return dWeight;
		
	}
	
	/**
	 * 
	 * Calculates age  <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return int
	 */
	public int calculateAge()
	{
		int iYears;
		//create Calendar object for current date
		Calendar now = Calendar.getInstance ( );
		//create Calendar Object for birthday
		Calendar age = Calendar.getInstance( );
		//set age parameters
		age.set (getBirthYear(),getBirthMonth12(), getBirthDay());
		//subtract current year from birth year
		iYears = now.get (Calendar.YEAR) - age.get (Calendar.YEAR);
		//if birth month is after current one subtract one year
		if (age.get(Calendar.MONTH) > now.get (Calendar.MONTH))
		{
			iYears --;
		}
		//if birth month is same as current and birth day is after current
			//day subtract one year
		if (age.get (Calendar.MONTH) == now.get (Calendar.MONTH) )
		{
			if (age.get (Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))
			{
				iYears --;
			}
		}	
		return iYears;
		
	}
	
	/**
	 * 
	 * Calculates BMI <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return double
	 */
	public double calculateBMI()
	{
		double dBMI;
		//BMI equals weight times 703 divided by height squared
		dBMI = getWeight ( ) * 703 / (getHeight ( ) * getHeight ( ));  
		return dBMI;
	}
	
	/**
	 * 
	 * Calculates BMI Weight Class <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return String
	 */
	public String calculateWeightClass ()
	{
		double dBMI;
		String strClass;
		//compute BMI
		dBMI = getWeight ( ) * 703 / (getHeight ( ) * getHeight ( ));
		//set return String to appropriate weight class
		if (dBMI < 18.5)
		{
			strClass = "Underweight";
		}
		else if (dBMI <= 24.9)
		{
			strClass = "Normal";
		}
		else if (dBMI <= 29.9)
		{
			strClass = "Overweight";
		}
		else
		{
			strClass = "Obese";
		}
		return strClass;
	}	
	
	/**
	 * 
	 * Calculate max heart rate <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return double
	 */
	public double maxHeartRate()
	{
		//Max Heart Rate is 220 minus age
		double dMaxRate = 220 - calculateAge();
		return  dMaxRate;
	}
	
	/**
	 * 
	 * calculate target heart rate <br>        
	 *
	 * <hr>
	 * Date created: Feb 6, 2011 <br>
	 * Date last modified: Feb 6, 2011 <br>
	 *
	 * <hr>
	 * @return String
	 */
	public String targetHeartRate()
	{
		//DecimalFormat object for whole number
		DecimalFormat number = new DecimalFormat("0");
		String strReturn;
		String strLowTarget;
		String strHighTarget;
		//lowest target heart rate is max heart rate times .5
		strLowTarget = number.format((220 - calculateAge()) * .50);
		//highest target heart rate is max heart rate times .85
		strHighTarget = number.format((220 - calculateAge()) * .85);
		strReturn = strLowTarget + "-" +strHighTarget + " beats per minute";
		return strReturn;
	}
	
	
}
