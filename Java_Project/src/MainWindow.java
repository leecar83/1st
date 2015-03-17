import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * ---------------------------------------------------------------------------
 * File name: MainWindow.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Apr 23, 2011<br>
 * Date of Last Modification: Apr 23, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * GUI for HealthProfile Collection<br>
 *
 * <hr>
 * Date created: Apr 23, 2011<br>
 * Date last modified: Apr 28, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class MainWindow extends JFrame
{
	private static final long	serialVersionUID	= 1L;		//required for GUI
	private Healthprofile [] profiles;		//holds an array of Healthprofiles
	private Healthprofile [] addProfiles;		//holds a temporary array of Healthprofiles
	private HealthProfileCollection collection;	//holds a HealthProfileCollection object referencing an <Array List>
	private String strPath = "HealthProfiles.dat";		//holds file name of default data file
	private final int WINDOW_HEIGHT = 220;		//holds window height
	private final int WINDOW_LENGTH = 420;		//holds window width
	private BufferedImage imageIcon = null;		//holds icon for GUI
	private JPanel profilePanel;		//holds profile panel
	private JPanel textPanel;		//holds text label panel
	private JPanel textPanelInput;		//holds text field panel
	private JPanel bDate;		//holds panel for DOB input fields
	private JList list;		//holds JList of profiles
	private int listIndex = -1;	 	//hold index of name selected in list
	private JScrollPane scrollPane;		//holds scrollpane
	private JMenuBar menuBar;	//holds menubar
	private JMenu fileMenu;		//holds file menu
	private JMenu editMenu;		//holds edit menu
	private JMenu helpMenu;		//holds help menu
	private JSeparator separator;	//holds menu item separator
	private JMenuItem exit;		//holds exit menu item
	private JMenuItem open;		//holds open menu item
	private JMenuItem save;		//holds save menu item 
	private JMenuItem saveAs;		//holds save as menu item
	private JMenuItem close;		//holds close menu item
	private JMenuItem add;		//holds add menu item
	private JMenuItem delete;		//holds delete menu item
	private JMenuItem edit;		//holds edit menu item 
	private JMenuItem about;	//holds about menu item
	private JLabel fName;		//holds first name label
	private JLabel lName;		//holds last name label
	private JLabel bdate;		//holds DOB label
	private JLabel sex;		//holds gender label
	private JLabel height;		//holds height label 
	private JLabel weight;		//holds weight label
	private JLabel bmi;		//holds bmi label
	private JTextField enteredFName;		//holds first name field
	private JTextField enteredLName;		//holds last name field
	private JTextField bDateMonth;		//holds birth month field
	private JTextField bDateDay;		//holds birth day field
	private JTextField bDateYear;		//holds birth year field
	private JTextField enteredSex;		//holds gender field
	private JTextField enteredHeight;		//holds height field
	private JTextField enteredWeight;		//holds weight field
	private JTextField BMI;		//holds bmi field
	private DecimalFormat formatter;		//holds decimal formatter object reference
	private DecimalFormat formatter1;		//holds decimal formatter object reference
	private boolean exception = true;		//holds boolean indicating whether exception is thrown
	private boolean changes = false;		//holds boolean indicating whether the profile list has changed
	private boolean fileOpened = false;		//holds boolean indicating whether a file has been opened
	private int iConfirm = 0;		//holds user's response to dialog boxes
	private JFileChooser chooser;		//holds reference to file chooser object
	
	/**
	 * 
	 * Constructor for MainWindow JFrame<br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	public MainWindow ()
	{
		super("Profile Manager");	//call JFrame constructor
		
		//set look and feel to Windows
		try
		{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI (this);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error updating user interface");
		}
		
		//Create FileReader object for reading default file into memory
		FileReader fileIn = new FileReader (strPath);
		
		//if file exists read it into memory
		fileOpened = fileIn.checkFileExists ( );
		if (fileOpened)
		{
			//read file into HealthProfileCollection object
			HealthProfileCollection collection1 = fileIn.readFile ( );
			//convert HealthprofileCollection to an array
			profiles = collection1.toArray();
		}
		
		setIcon();	//call setIcon method to set icon for window
		setSize(WINDOW_LENGTH,WINDOW_HEIGHT); //set size of window
		setLayout(new BorderLayout());	//set layout to BorderLayout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make window disappear when user hits close button
		setResizable(true);	//allow resizing of window
		buildMenuBar();	//build the menubar
		buildScrollPanel();	//build the scrollpanel 
		buildTextPanel();	//build the text panel
		buildInputTextPanel();	//build the text field panel
		add(profilePanel,BorderLayout.WEST);	//set ProfilePanel to left position
		add(textPanel,BorderLayout.CENTER);	//set TextPanel to middle position
		add(textPanelInput,BorderLayout.EAST);	//set text field panel to left position
		setLocationRelativeTo(null);	//have window open in center of screen
		setVisible(true);	//set visible
	}
	
	/**
	 * 
	 * Builds the scroll panel <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildScrollPanel()
	{
		profilePanel = new JPanel();	//create JPanel
		
		//if a file has been opened add its contents to list
		if(fileOpened)
		{
			String [] name = new String[profiles.length];
			for(int i = 0; i < profiles.length; i++)
			{
				name[i] = profiles[i].getFullName ( );
			}
			list = new JList(name);
		}
		else
		{
			list = new JList();	//if no file opened make construct default list
		}
		
		//set list to single selection mode
		list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		//set visible rows to 6
		list.setVisibleRowCount (6);
		//set border 
		list.setBorder (BorderFactory.createTitledBorder (BorderFactory.createLineBorder (Color.red,1),
						"Clients",TitledBorder.LEFT,TitledBorder.TOP,new Font("Dialog",Font.BOLD,16)));
		//set width
		list.setFixedCellWidth (160);
		//set font
		list.setFont(new Font("Dialog",Font.PLAIN,13));
		//set tool tip
		list.setToolTipText ("Current List of Clients");
		//register listener
		list.addListSelectionListener (new ListListener());
		//create scrollPane object passing the list as a parameter
		scrollPane = new JScrollPane(list);
		//set vertical scrollbar to as needed
		scrollPane.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//set horizontal scrollbar to disabled
		scrollPane.setHorizontalScrollBarPolicy (JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//add scrollpane to profilePanel
		profilePanel.add (scrollPane);
	}
	
	/**
	 * 
	 * Build Panel for Text Labels<br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildTextPanel()
	{
		//create JPanel for text and set layout
		textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(7,1));
		
		//create labels and set alignment to right
		fName = new JLabel("First Name:  ");
		fName.setHorizontalAlignment (SwingConstants.RIGHT);
		lName = new JLabel("Last Name:  ");
		lName.setHorizontalAlignment (SwingConstants.RIGHT);
		bdate = new JLabel("D.O.B:  ");
		bdate.setHorizontalAlignment (SwingConstants.RIGHT);
		sex = new JLabel  ("Sex:  ");
		sex.setHorizontalAlignment (SwingConstants.RIGHT);
		height = new JLabel("Height:  ");
		height.setHorizontalAlignment (SwingConstants.RIGHT);
		weight = new JLabel("Weight:  ");
		weight.setHorizontalAlignment (SwingConstants.RIGHT);
		bmi = new JLabel("BMI:  ");
		bmi.setHorizontalAlignment (SwingConstants.RIGHT);
		
		//add text labels to text label panel
		textPanel.add (fName);
		textPanel.add (lName);
		textPanel.add (bdate);
		textPanel.add (sex);
		textPanel.add (height);
		textPanel.add (weight);
		textPanel.add (bmi);
		}
	
	/**
	 * 
	 * Build Text Field Panel <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildInputTextPanel()
	{
		//create text panel for input with a GridLayout and a preferred size
		textPanelInput = new JPanel();
		textPanelInput.setLayout(new GridLayout(7,1));
		textPanelInput.setPreferredSize(new Dimension(140,180));
		
		//create text input fields with tool tips and set alignment to right for numbers
		enteredFName = new JTextField(5);
		enteredFName.setToolTipText ("First Name of current client");
		enteredLName = new JTextField(5);
		enteredLName.setToolTipText ("Last Name of current client");
		enteredSex = new JTextField(5);
		enteredSex.setToolTipText ("Gender of current client");
		enteredHeight = new JTextField(5);
		enteredHeight.setHorizontalAlignment (JTextField.RIGHT);
		enteredHeight.setToolTipText ("Height of current client");
		enteredWeight = new JTextField(5);
		enteredWeight.setHorizontalAlignment (JTextField.RIGHT);
		enteredWeight.setToolTipText ("Weight of current client");
		BMI = new JTextField(5);
		BMI.setHorizontalAlignment (JTextField.RIGHT);
		BMI.setToolTipText ("Body Mass Index of current client");
		BMI.setEditable(false);	//set BMI field to uneditable 
		
		buildDOBPanel();	//build the Date of Birth Panel
		
		//add the Text Fields the to TextPanel
		textPanelInput.add (enteredFName);
		textPanelInput.add (enteredLName);
		textPanelInput.add (bDate);
		textPanelInput.add (enteredSex);
		textPanelInput.add (enteredHeight);
		textPanelInput.add (enteredWeight);
		textPanelInput.add (BMI);
	}
	
	/**
	 * 
	 * Builds the Date of Birth Panel <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildDOBPanel()
	{
		//create DOB panel, set tool tip and set the layout to a Centered FlowLayout
		bDate = new JPanel();
		bDate.setLayout (new FlowLayout(FlowLayout.CENTER,0,0));
		bDate.setToolTipText ("Date of Birth of current client");
		
		//Create labels for month, day, and year
		JLabel month = new JLabel("M ");
		JLabel day = new JLabel("  D ");
		JLabel year = new JLabel("  Year ");
		
		//create DOB text fields with tooltips and set right alignment
		bDateMonth = new JTextField(2);
		bDateMonth.setHorizontalAlignment (JTextField.RIGHT);
		bDateMonth.setToolTipText ("Month");
		bDateDay = new JTextField(2);
		bDateDay.setHorizontalAlignment (JTextField.RIGHT);
		bDateDay.setToolTipText ("Day");
		bDateYear = new JTextField(4);
		bDateYear.setHorizontalAlignment (JTextField.RIGHT);
		bDateYear.setToolTipText ("Year");
		
		//add the text fields to the panel
		bDate.add (month);
		bDate.add (bDateMonth);
		bDate.add (day);
		bDate.add (bDateDay);
		bDate.add (year);
		bDate.add (bDateYear);

	}
	
	/**
	 * 
	 * Builds the menu bar <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildMenuBar()
	{
		//create menuBar
		menuBar = new JMenuBar();
		
		//build the FileMenu
		buildFileMenu();
		buildEditMenu();
		buildHelpMenu();
		
		//add the Menus to the JMenuBar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		//set the JMenuBar
		setJMenuBar(menuBar);
	}
	
	/**
	 * 
	 * Builds the File Menu <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildFileMenu()
	{
		//Create a  File Menu object for MenuBar
		fileMenu = new JMenu("File");
		//add Hot Key F to file menu 
		fileMenu.setMnemonic(KeyEvent.VK_F);
		//add Tool Tip
		fileMenu.setToolTipText ("File Menu");
		
		//create an open menu item for FileMenu
		open = new JMenuItem("Open");
		//create a save menu item for FileMenu
		save = new JMenuItem("Save");
		//create a save as menu item for FileMenu
		saveAs = new JMenuItem("Save As");
		//Create a close menu item for FileMenu
		close = new JMenuItem("Close");
		//Create an Exit menu item for fileMenu
		exit = new JMenuItem("Exit");
		//create separator
		separator = new JSeparator();
		
		//add ActionListeners for file menu items
		open.addActionListener(new OpenListener());
		save.addActionListener (new SaveListener());
		saveAs.addActionListener (new SaveAsListener());
		exit.addActionListener(new ExitListener());
		close.addActionListener (new CloseListener());
		
		//add tool tips
		open.setToolTipText ("Open a Client List File");
		save.setToolTipText ("Save the Client List to the Current File");
		saveAs.setToolTipText ("Choose a File to Save the Client List To");
		close.setToolTipText ("Close the Client File/List");
		exit.setToolTipText ("Exit the Program");
		
		//enable save menu item if a file is opened
		save.setEnabled (fileOpened);
		
		//add file items to file menu
		fileMenu.add (open);
		fileMenu.add (save);
		fileMenu.add (saveAs);
		fileMenu.add (close);
		fileMenu.add (separator);
		fileMenu.add (exit);
	}
	
	/**
	 * 
	 * Builds the Edit Menu <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildEditMenu()
	{
		//Make edit menu object
		editMenu = new JMenu("Edit");
		//add Hot Key F to file menu 
		editMenu.setMnemonic(KeyEvent.VK_E);
		//add Tool Tip
		editMenu.setToolTipText ("Editing menu");
		
		//create add menu item
		add = new JMenuItem("Add");
		//create delete delete item
		delete = new JMenuItem("Delete");
		//create edit edit item
		edit = new JMenuItem("Edit");
		
		//add Tool Tips
		add.setToolTipText ("Add the profile to the list");
		delete.setToolTipText ("Delete the profile from the list");
		edit.setToolTipText ("Edit this profile");
		
		//add listeners
		add.addActionListener (new AddListener());
		delete.addActionListener (new deleteListener());
		edit.addActionListener (new EditListener());
		
		//add file items to file menu
		editMenu.add (add);
		editMenu.add (delete);
		editMenu.add (edit);
	}
	
	/**
	 * 
	 * Builds the Help Menu <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildHelpMenu()
	{
		//create help menu
		helpMenu = new JMenu("Help");
		//add Hot Key h to file menu 
		helpMenu.setMnemonic(KeyEvent.VK_H);
		//add tool tip
		helpMenu.setToolTipText ("Help Menu");
		
		//create about menu item 
		about = new JMenuItem("About");
		
		//add tool tip
		about.setToolTipText ("About the Programmer");
		
		//add listener for about item
		about.addActionListener (new HelpListener());
		
		//add about menu item to help menu
		helpMenu.add (about);
	}
	
	/**
	 * 
	 * ActionListener for open menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class OpenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			displayOpenDialog();
		}
	}
	
	/**
	 * 
	 * ActionListener for save menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			saveToFile();
		}
	}
	
	/**
	 * 
	 * ActionListener for Save As menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class SaveAsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//if the list is edited or a file has been opened display file chooser 
			if(changes || fileOpened)
			{
				displaySaveDialog();
			}
			else
			{
				JOptionPane.showMessageDialog (null, "You have not made any changes necessitating saving the file!");
			}
		}
	}
	
	/**
	 * 
	 * ActionListener for close menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class CloseListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			close();
		}
		
	}
	
	/**
	 * 
	 * ActionListener for exit menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//if list has been changed prompt user for desire to save
			if(changes)
			{
				promptForSave();
			}
			//end program unless user hits cancel button on dialog box
			if(iConfirm != JOptionPane.CANCEL_OPTION)
				System.exit (0);
		}
	}
	
	/**
	 * 
	 * ActionListener for add menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class AddListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{
			addClient();
		}
	}
	
	/**
	 * 
	 * Action Listener for delete menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class deleteListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{
			deleteClient();
		}
	}
	
	/**
	 * 
	 * ActionListener for edit menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class EditListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{
			editClient();
		}
	}
	
	/**
	 * 
	 * ActionListener for help menu item<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			displayAboutDialog();
		}
	}
	
	/**
	 * 
	 * ActionListener for list selector<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			displayFromList();
		}
		
	}
	
	/**
	 * 
	 * Adds a client to the list/array <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void addClient()
	{
		int iConfirm = JOptionPane.showConfirmDialog (null, "Would you like to add this client?");
		//if user confirms desire to add client check for proper data in input fields
		if(iConfirm == JOptionPane.YES_OPTION)
		{
			exception = validateFields();
			//continue if input is good 
			if(exception == false)
			{
				int iNewArraySize = 0;
				//if there not already any clients create array and read text into first index
				if (profiles == null)
				{
					profiles = new Healthprofile[1];
					profiles [0] = new Healthprofile();
					readTextFieldsNew(0);
				}
				//if an array is already present create a temporary array one index bigger than the  current
				else
				{
					iNewArraySize = profiles.length + 1;
					addProfiles = new Healthprofile[iNewArraySize];
					//copy the current clients into the temp array
					for(int i = 0; i < iNewArraySize - 1; i++)
					{
						addProfiles[i] = new Healthprofile ();
						addProfiles[i].setFirstName(profiles[i].getFirstName ( ));
						addProfiles[i].setLastName (profiles[i].getLastName ( ));
						addProfiles[i].setGender (profiles[i].getGender ( ).charAt (0));
						addProfiles[i].setBirth (profiles[i].getBirthDay ( ) ,profiles[i].getBirthMonth ( ),
													profiles[i].getBirthYear ( ));
						addProfiles[i].setHeight (profiles[i].getHeight ( ));
						addProfiles[i].setWeight (profiles[i].getWeight ( ));
					}
					//initialize the last index of temp array and pass the last client to it 
					addProfiles[iNewArraySize - 1] = new Healthprofile();
					readTextFields(addProfiles.length - 1);
					/* Reinitialize the original array with one additional index and
					 * copy the contents of the temp array into it
					 */
					profiles = new Healthprofile[addProfiles.length];
					for(int i = 0; i < addProfiles.length; i++)
					{
						profiles[i] = new Healthprofile();
						profiles[i].setFirstName(addProfiles[i].getFirstName ( ));
						profiles[i].setLastName (addProfiles[i].getLastName ( ));
						profiles[i].setGender (addProfiles[i].getGender ( ).charAt (0));
						profiles[i].setBirth (addProfiles[i].getBirthDay ( ) ,addProfiles[i].getBirthMonth ( ),
													addProfiles[i].getBirthYear ( ));
						profiles[i].setHeight (addProfiles[i].getHeight ( ));
						profiles[i].setWeight (addProfiles[i].getWeight ( ));
					}
				}
				addProfiles = null;
				//update the client list and set changes boolean to true
				updateList1();
				changes = true;
			}
		}
	}
	
	/**
	 * 
	 * Delete client from the list/array <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void deleteClient()
	{
		//make sure the user has selected a populated index in list and confirm the desire to delete it
		if (list.getSelectedIndex ( ) != -1)
		{	
			int iConfirm = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this client?");
			if(iConfirm == JOptionPane.YES_OPTION)
			{
				//if it is the last client left in array then just close() it
				if(profiles.length == 1)
				{
					changes = false;
					close();
				}
				else
				{
					//initialize a temporary array of size one less than the current array
					int iNewArraySize = profiles.length - 1;
					addProfiles = new Healthprofile[iNewArraySize];
					for(int i = 0; i < profiles.length - 1; i++)
					{
						addProfiles[i] = new Healthprofile ();
					}
					
					//move the client profile selected for deletion to the last index of current array
					addProfiles[0] = profiles[profiles.length - 1];
					profiles[profiles.length-1] = profiles[list.getSelectedIndex ( )];
					profiles[list.getSelectedIndex ( )] = addProfiles[0];
					
					/* Copy the contents of the current array into the temporary array with the 
					 * exception of the last index which is the client to be deleted
					 */
					for(int i = 0; i < profiles.length -1 ; i++)
					{	
						addProfiles[i].setFirstName(profiles[i].getFirstName ( ));
						addProfiles[i].setLastName (profiles[i].getLastName ( ));
						addProfiles[i].setGender (profiles[i].getGender ( ).charAt (0));
						addProfiles[i].setBirth (profiles[i].getBirthDay ( ) ,profiles[i].getBirthMonth ( ),
													profiles[i].getBirthYear ( ));
						addProfiles[i].setHeight (profiles[i].getHeight ( ));
						addProfiles[i].setWeight (profiles[i].getWeight ( ));
					}
					
					/* Reinitialize the default array with an index of one less than before
					 * and copy the temp array to it except the last index of course 
					 */
					profiles = new Healthprofile[addProfiles.length];
					for(int i = 0; i < addProfiles.length; i++)
					{
						profiles[i] = new Healthprofile();
						profiles[i].setFirstName(addProfiles[i].getFirstName ( ));
						profiles[i].setLastName (addProfiles[i].getLastName ( ));
						profiles[i].setGender (addProfiles[i].getGender ( ).charAt (0));
						profiles[i].setBirth (addProfiles[i].getBirthDay ( ) ,addProfiles[i].getBirthMonth ( ),
													addProfiles[i].getBirthYear ( ));
						profiles[i].setHeight (addProfiles[i].getHeight ( ));
						profiles[i].setWeight (addProfiles[i].getWeight ( ));
					}
					addProfiles = null;
					//update the client list and set changes boolean to true
					updateList1();
					changes = true;
				}
			}
		}
		else
			JOptionPane.showMessageDialog (null,"You must select a client in order to delete one!");
	}
	
	/**
	 * 
	 * Edits the attributes of a client  <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void editClient()
	{
		//get index of client to be edited
		int iEdit = list.getSelectedIndex ( );
		if (iEdit != -1)
		{	
			//continue if inputed info is good
			exception = validateFields();
			if(exception == false)
			{
				//get client information from text fields and set attributes for the aforementioned array index
				int iConfirm = JOptionPane.showConfirmDialog (null, "Are you sure you want to edit this client?");
				if(iConfirm == JOptionPane.YES_OPTION)
				{
					profiles[iEdit].setFirstName (enteredFName.getText ( ));
					profiles[iEdit].setLastName (enteredLName.getText ( ));
					profiles[iEdit].setGender (enteredSex.getText ( ).charAt (0));
					profiles[iEdit].setBirth (Integer.parseInt (bDateDay.getText ( )),Integer.parseInt (bDateMonth.getText ( )),
													Integer.parseInt (bDateYear.getText ( )));
					profiles[iEdit].setHeight (Double.parseDouble (enteredHeight.getText ( )));
					profiles[iEdit].setWeight (Double.parseDouble (enteredWeight.getText ( )));				
					//update list and set change indicator true
					updateList1();
					displayFromList();
					changes = true;
					
				}
			}
		}
		else
			JOptionPane.showMessageDialog (null,"You must select a client in order to edit their profile!");
	}
	
	/**
	 * 
	 * Takes client info from text fields 
	 * and puts into temporary array <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param iIndex
	 */
	private void readTextFields(int iIndex)
	{
		addProfiles[iIndex].setFirstName (enteredFName.getText ( ));
		addProfiles[iIndex].setLastName (enteredLName.getText ( ));
		addProfiles[iIndex].setGender (enteredSex.getText ( ).charAt (0));
		addProfiles[iIndex].setBirth (Integer.parseInt (bDateDay.getText ( )),Integer.parseInt (bDateMonth.getText ( )),
										Integer.parseInt (bDateYear.getText ( )));
		addProfiles[iIndex].setHeight (Double.parseDouble (enteredHeight.getText ( )));
		addProfiles[iIndex].setWeight (Double.parseDouble (enteredWeight.getText ( )));
	}
	
	/**
	 * 
	 * Takes client info from text fields and
	 *  puts it into default array<br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param iIndex
	 */
	private void readTextFieldsNew(int iIndex)
	{
		profiles[iIndex].setFirstName (enteredFName.getText ( ));
		profiles[iIndex].setLastName (enteredLName.getText ( ));
		profiles[iIndex].setGender (enteredSex.getText ( ).charAt (0));
		profiles[iIndex].setBirth (Integer.parseInt (bDateDay.getText ( )),Integer.parseInt (bDateMonth.getText ( )),
										Integer.parseInt (bDateYear.getText ( )));
		profiles[iIndex].setHeight (Double.parseDouble (enteredHeight.getText ( )));
		profiles[iIndex].setWeight (Double.parseDouble (enteredWeight.getText ( )));
	}
	
	/**
	 * 
	 * Removes all clients from list/array and
	 * reinitializes array with one empty profile <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void close()
	{
		//check to make sure a client list/array is open
		if(list.getFirstVisibleIndex ( ) == -1)
		{
			JOptionPane.showMessageDialog (null,"Nothing is open...");
		}
		else
		{
			//if there have been recent changes prompt user for save
			if(changes)
			{
				promptForSave();
			}
			//reinitialize array with a default empty profile
			profiles = new Healthprofile [1];
			profiles [0]= new Healthprofile ();
			profiles [0].setFirstName ("");
			profiles [0].setLastName ("");
			//update list, remove reference to array, and set text fields empty
			updateList1();
			profiles = null;
			resetTextFields();
			}
		}	
	
	
	/**
	 * 
	 * Saves the client list to the file
	 * previously opened <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void saveToFile()
	{
		//initialize FileMaker and save to file
		FileMaker make = new FileMaker(strPath);
		make.FileWrite (profiles);
		//set recent changes to false and show confirmatiion to user
		changes = false;
		JOptionPane.showMessageDialog (null, "Client profiles saved to " + strPath);
		
	}
	
	/**
	 * 
	 * Displays about me JDialog
	 * by calling constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void displayAboutDialog()
	{
		//display about me JDialog
		AboutDialog about = new AboutDialog(this);
	}
	
	/**
	 * 
	 * Displays window for user to save
	 * client list to their desired path <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void displaySaveDialog()
	{
		//if user inputs are good continue
		exception = validateFields();
		if (exception == false)
		{	
			//JFileChooser object for saving client list to user's choice of path
			chooser = new JFileChooser(strPath);
			int status = chooser.showSaveDialog (null);
			//if user clicks ok continue
			if(status == JFileChooser.APPROVE_OPTION)
			{
				//get the user's selected path
				File choice = chooser.getSelectedFile ( );
				//initialize File Maker to selected path and write to file
				FileMaker make = new FileMaker(choice.getPath ( ));
				make.FileWrite (profiles);
				//enable save JMenuIitem and set recent changes boolean to false
				save.setEnabled (true);
				changes = false;
			}
		}
	}
	
	/**
	 * 
	 * Display open file dialog for
	 * ues to open a file <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void displayOpenDialog()
	{
		//display file chooser window
		chooser = new JFileChooser();
		int status = chooser.showOpenDialog (null);
		//if user opened a file
		if(status == JFileChooser.APPROVE_OPTION)
		{
			//set list/array to file contents and refresh text fields
			updateList();
			resetTextFields();
			//enable save JMenuItem and set file opened boolean to true
			save.setEnabled(true);
			fileOpened = true;
		}
	}
	
	/**
	 * 
	 * Sets the text field values to
	 * the client selected in list <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void displayFromList()
	{
		//formatters for a neater display of values
		formatter = new DecimalFormat("0.0#");
		formatter1 = new DecimalFormat("###0");
		//get index of selected client and set fields if a client has been selected
		listIndex = list.getSelectedIndex ( );
		if(listIndex != -1)
		{
			
			enteredFName.setText(profiles [listIndex].getFirstName ( ));
			enteredLName.setText(profiles [listIndex].getLastName ( ));
			bDateMonth.setText(formatter1.format (profiles [listIndex].getBirthMonth ( )));
			bDateDay.setText(formatter1.format (profiles [listIndex].getBirthDay ( )));
			bDateYear.setText(formatter1.format (profiles [listIndex].getBirthYear ( )));
			enteredSex.setText(profiles [listIndex].getGender ( ));
			enteredHeight.setText(Double.toString (profiles [listIndex].getHeight ( )));
			enteredWeight.setText(Double.toString (profiles [listIndex].getWeight ( )));
			BMI.setText(formatter.format (profiles [listIndex].calculateBMI ( )));
		}
	}
	
	/**
	 * 
	 * Prompt user for saving to file and
	 * calls method for saving if approved <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void promptForSave()
	{
		iConfirm = 0; //holds user's choice for saving
		
		//display a prompt appropriate for whether a file has already been opened
		if(fileOpened)
		{
			iConfirm = JOptionPane.showConfirmDialog (null, "The client list has been modified. Would you like to save your changes to : "
													+ strPath + "?","Save",JOptionPane.YES_NO_CANCEL_OPTION);
		}
		else
		{
			iConfirm = JOptionPane.showConfirmDialog (null, "Would you like to save this client list to a file?",
															"Save", JOptionPane.YES_NO_CANCEL_OPTION);
		}
		
		//if user confirms save to current file if one is opened otherwise prompt user for path
		if(iConfirm == JOptionPane.YES_OPTION)
		{
			if(fileOpened)
			{	
				saveToFile();
			}
			else
			{
				displaySaveDialog();
			}
		}
	}
	
	
	/**
	 * 
	 * updates list from a file <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void updateList()
	{
		//get data from selected file
		File selectedFile = chooser.getSelectedFile ( );
		FileReader reader;	//FileReader to read file
		//HealthProfileCollection to hold values read from file
		collection = new HealthProfileCollection();
		//get path of file being read
		strPath = selectedFile.getPath ( );
		//pass path to reader object
		reader = new FileReader(strPath);
		//read file contents into HealthProfileCollectioj object
		collection = reader.readFile ( );
		//send H.P. collection to array of profiles
		profiles = collection.toArray ( );
		//array of string to hold name of profile to be displayed in list
		String [] name = new String [profiles.length];
		//get names from all profiles in array
		for (int i = 0; i < profiles.length; i++)
		{
			name[i] = profiles [i].getFullName ( );
		}
		//update list with new profile names
		list.setListData (name);
	}
	
	/**
	 * 
	 * updates list from the currrent array <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void updateList1()
	{
		String [] name = new String [profiles.length];
		//get names from all profiles in array
		for (int i = 0; i < profiles.length; i++)
		{
			name[i] = profiles [i].getFullName ( );
		}
		//update list with new profile names
		list.setListData (name);
	}
	
	/**
	 * 
	 * Checks that valid client data
	 * has been entered into text fields <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @return
	 */
	private boolean validateFields()
	{
		int day = 0;
		int month = 0;
		int year = 0;
		exception = true;
		//check to make sure a name is entered for client
		if(enteredFName.getText ( ).isEmpty ( ) || enteredLName.getText ( ).isEmpty())
		{
			JOptionPane.showMessageDialog(null, "You must enter a full name for the client");
		}
		else
			exception = false;
		//if a full name is entered correctly parse DOB fields to integers
		if(exception == false)
		{
			try
			{
				day = Integer.parseInt (bDateDay.getText ( ));
				month = Integer.parseInt(bDateMonth.getText ( ));
				year = Integer.parseInt (bDateYear.getText ( ));
				exception = false;
			}
			catch(Exception e)
			{
				
				JOptionPane.showMessageDialog (null, "You must enter a number for the date fields");
			}
		}
		//if dates are integers check that dates are possible and "Reasonable"
		if(exception == false)
		{
			exception = true;
			try
			{
				//Create instance of date validator object and pass user input as parameters
				DateValidator birth = new DateValidator(day, month, year );
				exception = false;
			}
			catch(InvalidDateException i)
			{
				JOptionPane.showMessageDialog (null, i.getMessage ( ));
			}
		}
		//if DOB is good continue on to check the other text fields
		if(exception == false)
		{
			exception = true;
			try
			{
				//Create instance of field validator object and pass user input as parameters
				FieldValidator fields = new FieldValidator(enteredSex.getText ( ), enteredHeight.getText ( ), enteredWeight.getText ( ));
				exception = false;
			}
			catch(InvalidFieldException e)
			{
				JOptionPane.showMessageDialog (null, e.getMessage ( ));
			}
			
		}
		return exception;
	}

	/**
	 * 
	 * Resets the text fields to empty <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void resetTextFields()
	{
		enteredFName.setText ("");
		enteredLName.setText ("");
		enteredSex.setText ("");
		bDateMonth.setText ("");
		bDateYear.setText ("");
		bDateDay.setText ("");
		enteredHeight.setText ("");
		enteredWeight.setText ("");
		BMI.setText ("");
	}
	
	/**
	 * 
	 * Sets the corner icon for Jframe <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void setIcon()
	{
		try
		{
			imageIcon = ImageIO.read(getClass().getResource ("Weights.png"));
			setIconImage(imageIcon);
		}
		catch(Exception Ex)
		{
			//do nothing, icon is not important
			System.out.print ("image did not work");
		}
	}
	
	
	
}	

