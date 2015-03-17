

/**
 * ---------------------------------------------------------------------------
 * File name: HealthProfileCollection.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Mar 19, 2011<br>
 * Date of Last Modification: Mar 19, 2011<br>
 * ---------------------------------------------------------------------------
 */
import java.util.*;
import javax.swing.*;
import java.text.*;
/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Mar 19, 2011<br>
 * Date last modified: Apr 12, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class HealthProfileCollection
{
	private ArrayList <Healthprofile> profileList;
	
	/**
	 * 
	 * Constructor for ArrayList of Healthprofiles<br>        
	 *
	 * <hr>
	 * Date created: Mar 19, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 */
	public HealthProfileCollection()
	{
		profileList = new ArrayList <Healthprofile>();
	}
	
	/**
	 * 
	 * Get size of array list <br>        
	 *
	 * <hr>
	 * Date created: Mar 19, 2011 <br>
	 * Date last modified: Mar 19, 2011 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getArraySize()
	{
		return profileList.size ( );
	}
	
	/**
	 * 
	 * Allow user to input a client's info
	 * and add to array list <br>        
	 *
	 * <hr>
	 * Date created: Mar 19, 2011 <br>
	 * Date last modified: Mar 19, 2011 <br>
	 *
	 * <hr>
	 * @throws InvalidDateException 
	 */
	public void setClient()
	{
		String strFirstName;//holds the first name
		String strLastName;//holds the last name
		String strGender;//Holds string of gender
		char cGender;//holds character indicating gender
		String strInput;//holds various inputs
		int iMonth = 0;//holds birth month
		int iDay = 0;//holds birth day
		int iYear = 0;//holds birth year
		boolean b = false;//holds the boolean value of validation tests
		double dHeight = 0;//holds height
		double dWeight = 0;//holds weight
		int iException = 0;//holds value to indicate whether an exception is thrown
		
		//create instance of a HealthProfile object
		Healthprofile profile = new Healthprofile();
		
		//Prompt for first name
		strFirstName = JOptionPane.showInputDialog (null, "Enter your First Name", "Name",JOptionPane.QUESTION_MESSAGE);
		//if no response is entered display error message
		while (strFirstName.isEmpty ( ) == true)
		{	
			JOptionPane.showMessageDialog (null,"You must input a First Name","ERROR!",JOptionPane.ERROR_MESSAGE);
			strFirstName = JOptionPane.showInputDialog (null, "Enter your First Name", "Name",JOptionPane.QUESTION_MESSAGE);
		}
		//set first name of profile
		profile.setFirstName(strFirstName);
		
		//Prompt for last name
		strLastName = JOptionPane.showInputDialog (null, "Enter your Last Name", "Name",JOptionPane.QUESTION_MESSAGE);
		//if no name is entered display error message
		while (strLastName.isEmpty ( ) == true)
		{	
			JOptionPane.showMessageDialog (null,"You must input a Last Name","ERROR!",JOptionPane.ERROR_MESSAGE);
			strLastName = JOptionPane.showInputDialog (null, "Enter your Last Name", "Name",JOptionPane.QUESTION_MESSAGE);
		}
		//set last name of profile
		profile.setLastName (strLastName);
		
		//Prompt for gender
		strGender = JOptionPane.showInputDialog(null, "Enter your Gender: M for male or F for female");
		//get first letter of gender
		cGender = strGender.charAt (0);
		//display error if M or F is not entered
		while (Character.toLowerCase(cGender) != 'f' && Character.toLowerCase(cGender) != 'm')
		{
			JOptionPane.showMessageDialog (null, "Improper input for Gender","Error",JOptionPane.ERROR_MESSAGE);
			strGender = JOptionPane.showInputDialog(null, "Enter your Gender: M for male or F for female");
			cGender = strGender.charAt (0);
		}
		//set gender
		profile.setGender (cGender);
			
		while(b == false)
		{
			while(iException == 0)
			{
				try
				{
					//Prompt for month of birth
					strInput = JOptionPane.showInputDialog (null, "Enter your month of birth in format mm","DOB",
															JOptionPane.QUESTION_MESSAGE);
					//Parse month to integer
					iMonth = Integer.parseInt (strInput);
					iException = 1;
				}
				catch(Exception ex)
				{
					//show error message
					JOptionPane.showMessageDialog (null, "Error: You must enter an integer for the month");
					iException = 0;
				}
			}
			
			
			while(iException == 1)
			{
				try
				{
					//Prompt for day of birth
					strInput = JOptionPane.showInputDialog (null, "Please enter your day of birth in format dd", "DOB",
														JOptionPane.QUESTION_MESSAGE);
					//Parse month to integer
					iDay = Integer.parseInt (strInput);
					iException = 2;
				}
				catch(Exception ex)
				{
					//show error message
					JOptionPane.showMessageDialog (null, "Error: You must enter an integer for day");
					iException = 1;
				}
			}
			
			
			while(iException == 2)
			{
				try
				{
					//prompt for year of birth
					strInput = JOptionPane.showInputDialog (null, "Please enter your year of birth in format yyyy", "DOB",
															JOptionPane.QUESTION_MESSAGE);
					//Parse month to integer
					iYear = Integer.parseInt (strInput);
					iException = 3;
				}
				catch(Exception ex)
				{
					//show error message
					JOptionPane.showMessageDialog (null, "Error: You must enter an integer for Year");
					iException = 2;
				}
			}
			
			try
			{
				//Create instance of date validator object and pass user input as parameters
				DateValidator birth = new DateValidator(iDay, iMonth, iYear);
				b = true;
			}
			catch(InvalidDateException i)
			{
				iException = 0;
				JOptionPane.showMessageDialog (null, i.getMessage ( ));
			}
		}
		//set DOB attribute of healthprofile
		profile.setBirth (iDay, iMonth, iYear);
		
		while(iException == 3)
		{
			//Prompt for height
			strInput = JOptionPane.showInputDialog (null, "Please enter your height in inches", "Height",
											JOptionPane.QUESTION_MESSAGE);
			try
			{
				//Parse height to a double and check for proper input
				dHeight = Double.parseDouble (strInput);
				iException = 4;
				if (dHeight < 24 || dHeight > 120)
				{
					JOptionPane.showMessageDialog(null, "Invalid height entered", "Error",
												JOptionPane.ERROR_MESSAGE);
					iException = 3;
				}
			}
			catch(Exception h)
			{
				JOptionPane.showMessageDialog (null,"Error: You must enter a number for height");
			}
		}
		//set height
		profile.setHeight (dHeight);
		
		while(iException == 4)
		{
			//Prompt for weight 
			strInput = JOptionPane.showInputDialog (null, "Please enter your weight in pounds", "Weight",
			JOptionPane.QUESTION_MESSAGE);
			try
			{
				//Parse weight to double and check for proper input
				dWeight = Double.parseDouble (strInput);
				iException = 5;
				if (dWeight < 30 || dWeight > 2000)
				{
					JOptionPane.showMessageDialog(null, "Invalid weight entered", "Error",
												JOptionPane.ERROR_MESSAGE);
					iException = 4;
				}
			}
			catch(Exception w)
			{
				JOptionPane.showMessageDialog (null, "Error: You must enter a number for weight");
			}	
		}
		//set weight
		profile.setWeight (dWeight);
		
		//add Healthprofile to Arraylist 
		profileList.add (profile);
		
		//create FileMaker object to output to file
		FileMaker m = new FileMaker();
		//refresh file contents from memory
		m.FileWrite (profileList);
	}
	/**
	 * 
	 * Adds a Healthprofile to arraylist using parameters for input
	 * (used to input data read from file) <br>        
	 *
	 * <hr>
	 * Date created: Apr 5, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 * @param fName
	 * @param lName
	 * @param gender
	 * @param month
	 * @param day
	 * @param year
	 * @param height
	 * @param weight
	 */
	public void setClientFromFile(String fName, String lName, String gender, Integer month,  Integer day,
	                 Integer year, Double height, Double weight)
	{
		//create instance of a HealthProfile object
		Healthprofile profile = new Healthprofile();
		//Set char gender to first letter of String of Gender from file
		char gendeR = gender.charAt (0);
		
		//set HealthProfile object parameters to inputs from file
		profile.setBirth (day, month, year);
		profile.setFirstName (fName);
		profile.setLastName (lName);
		profile.setWeight (weight);
		profile.setHeight (height);
		profile.setGender (gendeR);
		
		//add HealthProfile to Arraylist
		profileList.add (profile);
	}
	/**
	 * 
	 * Delete client from healthprofile arraylist <br>        
	 *
	 * <hr>
	 * Date created: Apr 8, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 */
	public void deleteClient()
	{
		String strFirst;//holds first name
		String strLast;//holds last name
		Boolean bFound = false;//boolean value for whether client is found
		int i = 0;//loop variable
		int iIndex = 0;//holds location in array of client
		
		//display error if there are no clients
		if( profileList.isEmpty ( ))
		{
			JOptionPane.showMessageDialog (null,"You haven't entered in any clients yet Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{	
			//Prompt user for name
			strFirst = JOptionPane.showInputDialog (null, "Enter the first name");
			strLast = JOptionPane.showInputDialog (null, "Enter the last name");
			
			//search through HealthProfiles for client with the entered name
			while( bFound != true && i < profileList.size ( ))
			{
				if( profileList.get (i).getFirstName ( ).equalsIgnoreCase (strFirst) &&
					profileList.get (i).getLastName ( ).equalsIgnoreCase (strLast))
				{
					bFound = true;
					iIndex = i;
				}
				i++;
			}
			
			//if not found tell user
			if (bFound == false)
			{
				JOptionPane.showMessageDialog(null, "Sorry name not found");
			}
			
			//display confirmation to delete
			else
			{
				int iDelete = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the client " 
													+ strFirst + " " + strLast + "?");
				if(iDelete == JOptionPane.YES_OPTION)
				{
					profileList.remove (iIndex);
					JOptionPane.showMessageDialog (null, "Profile Deleted");
				}
			}
	
		}
		//create FileMaker object for outputting to file
		FileMaker make = new FileMaker();
		//refresh file contents from memory
		make.FileWrite (profileList);
	}
	
	
	/**
	 * 
	 * Display report of clients' info <br>        
	 *
	 * <hr>
	 * Date created: Feb 13, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 */
	public void dispayReport()
	{
		int i;//loop variable
		String strOutput = "";//holds output Strings
		String strUnderweight = "";//holds the string of underweight clients
		String strOverweight = "";//holds the string of overweight clients
		String strObese = "";//holds the string of obese clients
		double dSum1 = 0;//holds the weight
		double dAvg1 = 0;//holds the average of weight
		double dSum2 = 0;//holds the height
		double dAvg2 = 0;//holds the average of height
		double dSum3 = 0;//holds the BMI
		double dAvg3 = 0;//holds the average of BMI
		
		//display error if there are no profiles entered
		if( profileList.isEmpty ( ))
		{
			JOptionPane.showMessageDialog (null,"You haven't entered in any clients yet Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//make string of underweight clients
			for (i = 0; i < profileList.size(); i++)
			{
				Underweight underProfile = new Underweight(profileList.get(i));
				strOutput += underProfile.toStringUnderweight (profileList.get(i));
			}	
				if (strOutput.isEmpty( ) == true)
				{
					strUnderweight = "There are no underweigh clients\n";
				}
				else 
				{
					strUnderweight = "Underweight: " + strOutput;
				}
			
			
			//make string of overweight clients
			strOutput = "";
			for (i = 0; i < profileList.size(); i++)
			{
				Overweight overProfile = new Overweight(profileList.get(i));
				strOutput += overProfile.toStringOverweight (profileList.get(i));
			}	
				if (strOutput.isEmpty( ) == true)
				{
					strOverweight =  "There are no overweight clients\n";
				}
				else 
				{
					strOverweight =  "Overweight: " + strOutput;
				}
			
			//make string of obese clients
			strOutput = "";
			for (i = 0; i < profileList.size(); i++)
			{
				Obese obeseProfile = new Obese(profileList.get(i));
				strOutput += obeseProfile.toStringObese (profileList.get(i));
			}	
				if (strOutput.isEmpty( ) == true)
				{
					strObese = "There are no obese clients\n";
				}
				else 
				{
					strObese =  "Obese: " + strOutput;
				}
				
			//find the averages of the clients
			for (i = 0; i < profileList.size(); i++)
			{
				dSum1 += profileList.get(i).getWeight ( );
				dSum2 += profileList.get(i).getHeight ( );
				dSum3 += profileList.get(i).calculateBMI ( );
			}
			dAvg1 = dSum1 / profileList.size();
			dAvg2 = dSum2 / profileList.size();
			dAvg3 = dSum3 / profileList.size();
			
			//find the profile with the highest weight
			double dHighestW = profileList.get(0).getWeight ( );
			String strFirstH = profileList.get(0).getFirstName ( );//holds first name of heaviest client
			String strLastH = profileList.get(0).getLastName ( );//holds last name of heaviest client
			for(i = 0; i< profileList.size(); i++)
			{
				if(profileList.get(i).getWeight ( ) > dHighestW)
				{
					dHighestW = profileList.get(i).getWeight ( );
					strFirstH = profileList.get(i).getFirstName ( );
					strLastH = profileList.get(i).getLastName ( );
				}
			}
			
			//find profile with lowest weight
			double dLowestW = profileList.get(0).getWeight ( );
			String strFirstL = profileList.get(0).getFirstName ( );
			String strLastL = profileList.get(0).getFirstName ( );
			for (i = 0; i < profileList.size(); i++)
			{	
				if (profileList.get(i).getWeight ( ) < dLowestW)
				{
					dLowestW = profileList.get(i).getWeight ( );
					strFirstL = profileList.get(i).getFirstName ( );
					strLastL = profileList.get(i).getLastName ( );
				}
			}
			
			//find profile with highest BMI
			double dBMI = profileList.get(0).calculateBMI ( );
			String strFirstBMI = profileList.get(0).getFirstName ( );
			String strLastBMI = profileList.get(0).getLastName ( );
			for (i = 0; i < profileList.size(); i++)
			{
				if(profileList.get(i).calculateBMI ( ) > dBMI)
				{
					dBMI = profileList.get(i).calculateBMI ( );
					strFirstBMI = profileList.get(i).getFirstName ( );
					strLastBMI = profileList.get(i).getLastName ( );
				}
			}
			 
			//make a string with BMI and name of all clients
			String strList = "";
			for(i = 0; i < profileList.size(); i++)
			   {
				   strList += BmiString(profileList.get(i).calculateBMI ( ),profileList.get(i).getFirstName ( ),profileList.get(i).getLastName ( ));
			   }
			
			//Create DecimalFormat object for one decimal place
			DecimalFormat one = new DecimalFormat("0.#");		
			
			//Show report in message box
			JOptionPane.showMessageDialog (null,
											   strUnderweight +
											   strOverweight +
											   strObese + 
											   "The average weight of the clients: " + one.format(dAvg1) + " pounds" +
											   "\nThe average height of the clients: " + one.format (dAvg2) + " inches" + 
											   "\nThe average BMI of the clients: " + one.format (dAvg3)+
											   "\nThe Heaviest client: " + strFirstH + " " + strLastH + " " + one.format(dHighestW)+
											   							" pounds" +
											   "\nThe Lightest client: " + strFirstL + " " + strLastL + " " + one.format(dLowestW)+
					   													" pounds" + 
					   						   "\nClient with highest BMI: " + strFirstBMI + " " + strLastBMI + " " + one.format(dBMI)+
																		" BMI" + 
											   "\nBMIs of clients : \n" + strList +
											   "\n\nBMI VALUES CHART:" +
											   "\nUnderweight: Less than 18.5" +
											   "\nNormal:      Between 18.5 and 24.9" +
											   "\nOverweight:  Between 25 and 29.9" +
											   "\nObese:       30 or greater","Report", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
	 * 
	 * Enter method description here <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 */
	public void displayClients()
	{
		if( profileList.isEmpty ( ))
		{
			JOptionPane.showMessageDialog (null,"You haven't entered in any clients yet Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//Create DecimalFormat object for one decimal place
			DecimalFormat one = new DecimalFormat("0.#");		
			
			//show message box of client info one at a time
			for (int i = 0; i < profileList.size ( ); i++)
			{
				JOptionPane.showMessageDialog (null, profileList.get (i).getFirstName ( ) + " " +
													profileList.get (i).getLastName ( ) + "\n" +
													"Age: " + profileList.get (i).calculateAge ( ) + " years" + "\n" +
													"Height: " + profileList.get (i).getHeight ( ) + " inches" + "\n" +
													"Weight: " + profileList.get (i).getWeight ( ) + " pounds" + "\n" +
													"BMI: " + one.format(profileList.get (i).calculateBMI ( )));
			}
		}
	}
	/**
	 * 
	 * Sort HealthProfiles into alphabetical order <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2011 <br>
	 * Date last modified: Mar 21, 2011 <br>
	 *
	 * <hr>
	 */
	public void sortNames()
	{
		int iStart;//first index in array
		int iIndex;//loop variable
		int iMinIndex;//index of array list
		
		if( profileList.size ( ) < 2)
		{
			JOptionPane.showMessageDialog (null,"You haven't entered at least two clients Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{	
			//sort into alphabetical order by selection sort algorithm
			for (iStart = 0; iStart < (profileList.size ( ) - 1); iStart++)
			{ 
				iMinIndex = iStart;
				Healthprofile minValue = profileList.get(iStart);
				for (iIndex = iStart +1; iIndex < profileList.size ( ); iIndex++)
				{
					if (profileList.get (iIndex).getLastName ( ).toUpperCase ( ).compareTo (minValue.getLastName ( ).toUpperCase ( )) < 0)
					{
						minValue = profileList.get (iIndex);
						iMinIndex = iIndex;
					}
				}
				profileList.set (iMinIndex,profileList.get (iStart));
				profileList.set (iStart, minValue);
			}
			//Tell user the sorting has been completed
			JOptionPane.showMessageDialog (null, "The clients are now sorted by last name");	
		}
	}
	
	/**
	 * 
	 * Sort clients by BMI highest to lowest <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 */
	public void sortBMI()
	{
		//display error if no clients have been entered
		if( profileList.size() < 2)
		{
			JOptionPane.showMessageDialog (null,"You haven't entered at least two clients Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//sort by ascending BMI using selection sort algorithm
			for(int n = profileList.size ( ); n > 1; n--)
			{
				
				int m = getMaxBMI(n);
				if( m != n - 1)
				{
					Healthprofile temp = profileList.get (m);
					profileList.set (m,profileList.get (n-1));
					profileList.set (n-1,temp);
				}
			}
			//display confirmation
			JOptionPane.showMessageDialog (null, "The clients are now sorted by BMI");
		}
	}
		
	/**
	 * 
	 * Sort users by descending weight <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 */
	public void sortWeight()
	{
		//display error if there are no clients
		if( profileList.size () < 2)
		{
			JOptionPane.showMessageDialog (null,"You haven't entered at least two clients Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//sort by descending weight using selection sort algorithm
			for(int n = profileList.size ( ); n > 1; n--)
			{
				
				int m = getMinW(n);
				if( m != n - 1)
				{
					Healthprofile temp = profileList.get (m);
					profileList.set (m,profileList.get (n-1));
					profileList.set (n-1,temp);
				}
			}
			//show confirmation dialog
			JOptionPane.showMessageDialog (null, "The clients are now sorted by weight");
		}
	}
	
	/**
	 * 
	 * Prompt user for client name and display info if found <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 */
	public void searchUser()
	{
		String strFirst;//holds the client's first name
		String strLast;//holds the client's last name
		boolean bFound = false;//boolean indicating whether a matching name is found
		int i = 0;//loop variable
		int iIndex = 0;//position in array list of matching name 
		
		//display error if there are no clients
		if( profileList.isEmpty ( ))
		{
			JOptionPane.showMessageDialog (null,"You haven't entered in any clients yet Silly!","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{
			//Create DecimalFormat object for one decimal place
			DecimalFormat one = new DecimalFormat("0.#");	
			
			//Prompt user for name
			strFirst = JOptionPane.showInputDialog (null, "Enter the first name");
			strLast = JOptionPane.showInputDialog (null, "Enter the last name");
			
			//search through HealthProfiles for client with the entered name
			while( bFound != true && i < profileList.size ( ))
			{
				if( profileList.get (i).getFirstName ( ).equalsIgnoreCase (strFirst) &&
					profileList.get (i).getLastName ( ).equalsIgnoreCase (strLast))
				{
					bFound = true;
					iIndex = i;
				}
				i++;
			}
			
			//if not found tell user
			if (bFound == false)
			{
				JOptionPane.showMessageDialog(null, "Sorry name not found");
			}
			
			//display client info
			else
			{
				JOptionPane.showMessageDialog (null, profileList.get (iIndex).getFirstName ( ) + " " +
													profileList.get (iIndex).getLastName ( ) + "\n" +
													"Age: " + profileList.get (iIndex).calculateAge ( ) + " years" + "\n" +
													"Height: " + profileList.get (iIndex).getHeight ( ) + " inches" + "\n" +
													"Weight: " + profileList.get (iIndex).getWeight ( ) + " pounds" + "\n" +
													"BMI: " + one.format(profileList.get (iIndex).calculateBMI ( )));
			}
	
		}
	}
	
	
	/**
	 * 
	 * Find max BMI of the clients <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 * @param size
	 * @return
	 */
	public int getMaxBMI(int size)
	{
		int iMax = 0;
		//loop through profiles to find highest BMI
		for (int i = 0; i < size ; i++)
			if (profileList.get (i).calculateBMI ( ) > profileList.get (iMax).calculateBMI ( ))
			{
				iMax = i;
			}
		return iMax;
	}
	
	/**
	 * 
	 * Find minimum weight of the clients<br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 * @param size
	 * @return
	 */
	public int getMinW(int size)
	{
		int iMax = 0;
		//loop through profiles to find lowest weight
		for (int i = 0; i < size ; i++)
			if (profileList.get (i).getWeight ( ) < profileList.get (iMax).getWeight ( ))
			{
				iMax = i;
			}
		return iMax;
	}	
	
	/**
	 * 
	 * return a Healthprofile object from arraylist
	 * with an index equal to input parameter <br>        
	 *
	 * <hr>
	 * Date created: Apr 8, 2011 <br>
	 * Date last modified: Apr 12, 2011 <br>
	 *
	 * <hr>
	 * @param i
	 * @return
	 */
	public Healthprofile getProfile(int i)
	{
		Healthprofile p = profileList.get (i);
		return p;
	}
	
	public Healthprofile [] toArray()
	{
		Healthprofile [] array = new Healthprofile[profileList.size ( )];
		profileList.toArray (array);
		return array;
	}
	
	/**
	 * 
	 * Take parameters of BMI, First Name, and Last Name
	 * and return them as a formatted string <br>        
	 *
	 * <hr>
	 * Date created: Feb 19, 2011 <br>
	 * Date last modified: Feb 19, 2011 <br>
	 *
	 * <hr>
	 * @param BMI
	 * @param BMIFName
	 * @param BMILName
	 * @return
	 */
	private static String BmiString(double BMI, String BMIFName, String BMILName)
	{
		String strReturn;//holds a string to return
		DecimalFormat one = new DecimalFormat("0.#");//decimal formatter for one decimal place
		strReturn ="  " + one.format (BMI) + "  " + BMIFName + " " + BMILName + "\n"; 
		return strReturn;
	}
}
	
	
	
	
	