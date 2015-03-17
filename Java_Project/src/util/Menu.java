
package util;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * Class that represents a menu that can be displayed in a console window or in
 * a dialog.<br>
 * 
 * <hr>
 * Date created: Oct 3, 2008<br>
 * Date last modified: Oct 3, 2008<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public class Menu
{
	private final String [ ]	choices		= new String [15];
	private final String		title;
	private int					entries;
	private final int			maxChoices	= 15;

	/**
	 * Default constructor with default title <br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 */
	public Menu ( )
	{
		entries = 0;
		title = "Untitled Menu";
		UIManager.put ("OptionPane.messageFont", new FontUIResource (new Font ("Arial", Font.PLAIN,
						18)));
	}

	/**
	 * Constructor that sets menu title <br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @param menutitle
	 */
	public Menu (String menutitle)
	{
		entries = 0;
		title = menutitle;
		UIManager.put ("OptionPane.messageFont", new FontUIResource (new Font ("Arial", Font.PLAIN,
						18)));
	}

	/**
	 * Add a new choice at the end of the menu if there is room for it <br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @param choice
	 */
	public void addChoice (String choice)
	{
		if (entries < maxChoices)
		{
			choices [entries++ ] = choice;
		}
		else
		{
			JOptionPane.showMessageDialog (null, choice
							+ " could not be added to the menu because the menu is already full");
		}
	}

	/**
	 * Display menu in console window and get user's selection. Verify validity
	 * and return the selection. <br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @return
	 */
	public int getChoice ( )
	{
		int choice = 1;
		boolean successfulChoice = false;
		Scanner kb = new Scanner (System.in);

		while ( !successfulChoice)
		{
			if (entries <= 0)
				return -1;
			displayMenu ( );
			try
			{
				Util.skip (3);
				System.out.print ("\nPlease type the number of your choice: ");
				Util.skip (3);
				choice = kb.nextInt ( );
				if (choice >= 1 && choice <= entries)
					return choice;
				else
					throw new Exception (" ");
			}
			catch (Exception ex)
			{
				System.out.println ("\nYour choice is invalid.\n"
								+ "You must type an integer between 1 and " + entries + ".");
				kb.nextLine ( );
				Util.pressEnter ( );
			}
		}
		return choice; // to make the compiler happy
	}

	/**
	 * Same as getChoice above, but uses a dialog instead <br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @return
	 */
	public int getChoiceDialog ( )
	{
		int choice = 1;
		if (entries <= 0)
			return -1;
		boolean successfulChoice = false;
		String strMenu = this.toString ( ) + "\n\n\nPlease type the number of your choice:";

		while ( !successfulChoice)
		{
			try
			{
				choice = Integer.parseInt (JOptionPane.showInputDialog (strMenu));
				if (choice >= 1 && choice <= entries)
					return choice;
				else
					throw new Exception (" ");
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog (null, "\nYour choice is invalid.\n"
								+ "You must type an integer between 1 and " + entries + ".");
			}
		}
		return choice;
	} // end getChoiceDialog

	/**
	 * Display the menu in a formatted manner on the console window. <br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 */
	private void displayMenu ( )
	{
		Util.skip (4);
		int i;
		System.out.print ("\t" + title + "\n\t");
		for (i = 0; i < title.length ( ); i++ )
		{
			System.out.print ("-");
		}
		System.out.println ("\n");

		for (i = 0; i < entries; i++ )
		{
			System.out.println ("\t" + (i + 1) + ". " + choices [i]);
		}
	} // end displayMenu

	/**
	 * Format the menu as a string for possible display in the console window<br>
	 * 
	 * <hr>
	 * Date created: Oct 3, 2008 <br>
	 * Date last modified: Oct 3, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		int i;
		String result = "\t" + title + "\n\t";

		for (i = 0; i < entries; i++ )
			result += "\n\t" + (i + 1) + ". " + choices [i];

		return result;
	} // end toString

} // end Menu

