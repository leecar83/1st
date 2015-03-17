import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ---------------------------------------------------------------------------
 * File name: AboutDialog.java <br>
 * Project name: HealthProfileArrayApp <br>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Lee Miller, zlbm13@goldmail.etsu.edu <br>
 * Course:  CSCI 1260-002<br>
 * Creation Date: Apr 24, 2011<br>
 * Date of Last Modification: Apr 24, 2011<br>
 * ---------------------------------------------------------------------------
 */

/**
 * Display an about dialog<br>
 *
 * <hr>
 * Date created: Apr 24, 2011<br>
 * Date last modified: Apr 24, 2011<br>
 * <hr>
 * @author Lee Miller
 */

public class AboutDialog extends JDialog
{
	private static final long	serialVersionUID	= 1L;	//required
	private final int WINDOW_HEIGHT = 280;	//height of window
	private final int WINDOW_WIDTH = 180;	//width of window
	private JPanel picPanel;	//holds picture panel
	private JPanel infoPanel;	//holds information panel
	private JPanel buttonPanel;		//holds buttonpanel 
	private JLabel picLabel;	//holds picture label
	private JLabel infoText;	//holds label of text
	private JButton okButton;	//holds ok button
	
	/**
	 * 
	 * About JDialog Constructor<br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 * @param parent
	 */
	public AboutDialog(JFrame parent)
	{
		super(parent, "About Me", true);	//create JDialog box
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		//close box on close click
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);	//set size of JDialog
		setResizable(false);	//make JDialog unresizeable
		setLayout(new FlowLayout());	//set flowlayout
		buildPicPanel();	//build the picture panel
		buildInfoPanel();	//build the information panel
		buildButtonPanel();	//build the button panel
		add(picPanel);	//add the picture panel
		add(infoPanel);		//add the infopanel
		add(buttonPanel);	//add the buttonpanel
		setLocationRelativeTo(parent);	//set on top of Main Window	
		setVisible(true);	//set visible
	}

	/**
	 * 
	 * Builds the picture pane; <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildPicPanel()
	{
		//create pic panel
		picPanel = new JPanel();
		
		//create label for panel
		picLabel = new JLabel();
		
		
		//Create ImageIcon and pass pic as argument
		ImageIcon me = new ImageIcon("Pic.jpg");
		
		//add ImageIcom to label
		picLabel.setIcon (me);
		
		//add picture label to panel
		picPanel.add (picLabel);
	}

	/**
	 * 
	 * Builds the Info Panel <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildInfoPanel()
	{
		//create info panel
		infoPanel = new JPanel();
		
		//create info label
		infoText = new JLabel("<html><center>Profile Manager</center><center> by Lee Miller </center>" +
								"<center> zlbm13@imail.etsu.edu </center></html>");
		
		//add JTextArea to panel
		infoPanel.add(infoText);
	}

	/**
	 * 
	 * Builds the button panel <br>        
	 *
	 * <hr>
	 * Date created: Apr 28, 2011 <br>
	 * Date last modified: Apr 28, 2011 <br>
	 *
	 * <hr>
	 */
	private void buildButtonPanel()
	{
		//create button panel
		buttonPanel = new JPanel();
		
		//create ok button
		okButton = new JButton("OK");
		
		//add listener to button
		okButton.addActionListener (new ButtonListener());
		
		//add JButton to JPanel
		buttonPanel.add (okButton);
	}
	
	/**
	 * 
	 * actionlistener for ok button<br>
	 *
	 * <hr>
	 * Date created: Apr 28, 2011<br>
	 * Date last modified: Apr 28, 2011<br>
	 * <hr>
	 * @author Lee Miller
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();	//close the window
		}
	}//end  of listener
}//end of AboutDialog
