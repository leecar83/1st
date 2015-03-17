


/**
 * ---------------------------------------------------------------------------
 * File name: HealthMenu.java <br>
 * Project name: HealthProfileApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Mar 16, 2011<br>
 * Date of Last Modification: Mar 16, 2011<br>
 * ---------------------------------------------------------------------------
 */
package util;
/**
 * Display a menu for user input
 * --is a subclass to menu--<br>
 *
 * <hr>
 * Date created: Mar 16, 2011<br>
 * Date last modified: Mar 16, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class HealthMenu extends Menu
{
	private int iClientCounter;//holds number of clients entered into arrayList
	
	/**
	 * 
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 * @param iClients
	 */
	public HealthMenu(int iClients)
	{
		super("Main Menu");//Constructor for parent class Menu
		iClientCounter = iClients;//set client counter to parameter iClients
	}
	
	/**
	 * 
	 * Add choices to menu <br>        
	 *
	 * <hr>
	 * Date created: Mar 16, 2011 <br>
	 * Date last modified: Mar 16, 2011 <br>
	 *
	 * <hr>
	 */
	public void addChoices()
	{
		//add choices to healthmenu
		super.addChoice ("Add new client health profile information (There are currently "
			+ iClientCounter + " clients)");
		super.addChoice ("Display health profile report");
		super.addChoice ("Display a list of all clients"); 
		super.addChoice ("Sort clients by last name – A - Z");
		super.addChoice ("Sort clients by weight – highest to lowest");
		super.addChoice ("Sort clients by BMI – lowest to highest");
		super.addChoice ("Display one client health profile information");
		super.addChoice ("Remove a profile");
		super.addChoice ("Exit");
	}	
}
