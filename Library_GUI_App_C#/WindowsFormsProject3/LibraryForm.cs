/*
 * Purpose:Project 3 using C#, Visual Studio 2010 with Windows Forms
 * Author: Lee Miller   zlbm13@imail.etsu.edu
 * Class: Computer Science 2210
 * Date: 10/26/2011 
 */
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Utils;

namespace WindowsFormsProject3
{
	public partial class LibraryForm : Form
	{

		Library library = new Library ( );	//Default Library
		Guid g;	//Guid to identify specific library
		Guid g1;	//Guid to identify specific library
		User defaultUser;	//Default user of program

		/// <summary>
		/// Constructor for LibraryForm
		/// </summary>
		public LibraryForm ()
		{
			LoginForm userForm = new LoginForm ( );	//initialize LoginForm instance		
			userForm.ShowDialog ( );	//show LoginForm
			defaultUser = userForm.GetUser ( );	//get the User from the LoginForm
			InitializeComponent ( );	//Initialize the LibraryForm 
		}

		/// <summary>
		/// Methods to call on Window Load
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void LibraryForm_Load (object sender, EventArgs e)
		{
			library.readTextFile ("DefaultLibrary.txt");	//read the default Library file
			setListBox ( );	//set the List Box Contents
			LoadClock ( );	//load the clock
			LibraryListBox.SelectedIndex = -1;	//Set ListBox selected index to nothing
		}

		/// <summary>
		/// Menu item for Creating a Library
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void createNewLibraryToolStripMenuItem_Click (object sender, EventArgs e)
		{
			if (library.HasChanges)
				library.HasChanges = saveFileDialog (library);
			library = new Library (defaultUser.getName ("both"), defaultUser.getEmail ( ), defaultUser.getPhone ( ));
			setListBox ( );

		}

		/// <summary>
		/// Menu Strip for Opening a Library
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void openExistingLibraryToolStripMenuItem_Click (object sender, EventArgs e)
		{
			if (library.HasChanges)
				library.HasChanges = saveFileDialog (library);
			library.HasChanges = openFileDialog (library);
			setListBox ( );
		}

		/// <summary>
		/// Menu item for Saving Library
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void saveCurrentLibraryToolStripMenuItem_Click (object sender, EventArgs e)
		{
			if (checkEmptyLibrary (library))
			{
				MessageBox.Show ("The Library is empty", "Whoops", MessageBoxButtons.OK);
			}
			else
			{
				library.HasChanges = saveFileDialog (library);
			}
		}

		/// <summary>
		/// Menu Item for exiting Program
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void exitToolStripMenuItem1_Click (object sender, EventArgs e)
		{
			if (library.HasChanges)
				promptForSave();
			else
				this.Close ( );
		}

		/// <summary>
		/// Menu Item for Adding a book
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void addABookToolStripMenuItem_Click (object sender, EventArgs e)
		{
			g = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
			library = addBook (library);
			g1 = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
			if (g != g1)
			{
				library.HasChanges = true;
				library.sortByTitle ( );
				setListBox ( );
			}
		}

		/// <summary>
		/// Menu Strip for the Editing Menu
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void changeThisBookToolStripMenuItem_Click (object sender, EventArgs e)
		{
			if (library.Count == 0)
			{
				MessageBox.Show ("There are no Books in the Library to remove!");
			}
			else if (LibraryListBox.SelectedIndex == -1)
			{
				MessageBox.Show ("You must select a Book from the Library in order to remove it!");
			}
			else
			{
				g = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
				library = editBook (library);
				g1 = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
				if (g != g1)
					library.HasChanges = true;
				library.sortByTitle ( );
				setListBox ( );
				clearTextFields ( );
			}
		}

		/// <summary>
		/// Menu Item for deleting a book
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void deleteThisBookToolStripMenuItem_Click (object sender, EventArgs e)
		{
			if (library.Count == 0)
			{
				MessageBox.Show ("There are no Books in the Library to remove!");
			}
			else if (LibraryListBox.SelectedIndex == -1)
			{
				MessageBox.Show ("You must select a Book from the Library in order to remove it!");
			}
			else
			{
				library -= library[LibraryListBox.SelectedIndex];
				library.HasChanges = true;
				setListBox ( );
				clearTextFields ( );
			}
		}

		/// <summary>
		/// Menu Item for the About Window
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void aboutToolStripMenuItem_Click (object sender, EventArgs e)
		{
			AboutBox1 box = new AboutBox1 ( );
			box.ShowDialog ( );
		}

		private void userInfoToolStripMenuItem_Click(object sender, EventArgs e)
		{
			UserInfoBox box = new UserInfoBox( );
			box.Names1 = defaultUser.getName("both");
			box.Number = defaultUser.getPhone( );
			box.Email = defaultUser.getEmail( );
			box.Show( );
		}
		
		/// <summary>
		/// Set the List Box Contents from the Library
		/// </summary>
		private void setListBox( )
		{
			String[] titles = new String[library.Count];
			if (library.Count != 0)
			{
				for (int i = 0; i < library.Count; i++)
				{
					titles [i] = library[i].Title;
				}
			}
			LibraryListBox.DataSource = titles;
			clearTextFields ( );

			textBox1.Text = library.Count.ToString();
		}

		/// <summary>
		/// Load the clock into the date box
		/// </summary>
		private void LoadClock()
		{
			this.DateBox.Text = DateTime.Today.ToLongDateString ( ) + "   " + DateTime.Now.ToLongTimeString();
		}
		
		/// <summary>
		/// Clears the TextFields
		/// </summary>
		private void clearTextFields()
		{
			AuthorBox.Text = "";
			TitleBox.Text = "";
			PriceBox.Text = "";
		}

		/// <summary>
		/// Edits a book in the Library
		/// </summary>
		/// <param name="lib"></param>
		/// <returns></returns>
		private Library editBook(Library lib)
		{
				Book bookadded = getBookInfo (this.TitleBox.Text, this.AuthorBox.Text, this.PriceBox.Text);
				Book bookdeleted = lib[LibraryListBox.SelectedIndex];
				if (bookadded.Price != -1)
				{
					lib -= bookdeleted;
					lib += bookadded;
				}
				return lib;
		}

		/// <summary>
		/// Adds a book to the Library
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Library</returns>
		private Library addBook(Library lib)
		{
			if (lib.hasOwner ( ))
			{
				Book bookadded = getBookInfo (this.TitleBox.Text,this.AuthorBox.Text,this.PriceBox.Text);
				if (bookadded.Price != -1)
				{
					lib += bookadded;
				}
				return lib;
			}
			else
			{
				MessageBox.Show("Please create a Library before trying to add a book","Whoops!",MessageBoxButtons.OK);
				return lib;
			}
		}		
		
		/// <summary>
		/// Gets the Book Properties from the input fields
		/// </summary>
		/// <param name="title"></param>
		/// <param name="author"></param>
		/// <param name="price"></param>
		/// <returns>Book</returns>
		private static Book getBookInfo(String title, String author, String price)
		{
			Book b = new Book ( );
			Decimal dPrice = -1;
			String strTitle = null; 
			String strAuthor = null;
			String strPrice = null;

			if (!String.IsNullOrWhiteSpace (title))
			{
				strTitle = title;
			}
			else
			{
				MessageBox.Show ("You must enter a Title for the Book!", "Whoops", MessageBoxButtons.OK);
			}

			if (!String.IsNullOrWhiteSpace (author))
			{
				strAuthor = author;
			}
			else
			{
				MessageBox.Show ("You must enter an Author for the Book!", "Whoops", MessageBoxButtons.OK);
			}

			if (!String.IsNullOrWhiteSpace (price))
			{
				try
				{
					dPrice = Decimal.Parse (price);
					strPrice = price;
				}
				catch (Exception)
				{
					MessageBox.Show ("Invalid input for price of Book", "Whoops", MessageBoxButtons.OK);
				}
			}
			else
			{
				MessageBox.Show ("You must enter a Price for the Book!", "Whoops", MessageBoxButtons.OK);
			}
			b.Title = strTitle;
			b.Author = strAuthor;
			b.Price = dPrice;
			return b;
		}
		
		/// <summary>
		/// Prompts the user for saving library
		/// </summary>
		private void promptForSave()
		{
			DialogResult response = MessageBox.Show("Would you like to save the changes before exiting?","??",MessageBoxButtons.YesNoCancel);
			if (response == DialogResult.Yes)
			{
				saveFileDialog (library);
				this.Close ( );
			}
			else if (response == DialogResult.No)
			{
				this.Close ( );
			}
		}
		
		/// <summary>
		/// Opens a save file dialog
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Boolean</returns>
		private static bool saveFileDialog (Library lib)
		{
			SaveFileDialog dialog = new SaveFileDialog ( );
			dialog.InitialDirectory = Application.StartupPath;
			dialog.Title = "Save Library to File";
			dialog.Filter = "text files|*.txt|all files|*.*";

			if (dialog.ShowDialog ( ) != DialogResult.Cancel)
			{
				return false;
			}
			else
			{
				lib.writeTextFile (dialog.FileName);
				return true;
			}
			
		}

		/// <summary>
		/// Opens a dialog to save library to a file
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Boolean</returns>
		private static bool openFileDialog (Library lib)
		{
			OpenFileDialog dialog = new OpenFileDialog ( );
			dialog.InitialDirectory = Application.StartupPath;
			dialog.Title = "Open a Library";
			dialog.Filter = "text files|*.txt|all files|*.*";

			if (dialog.ShowDialog ( ) == DialogResult.Cancel)
				return false;
			else
			{
				lib.readTextFile (dialog.FileName);
				return true;
			}
			
		}

		/// <summary>
		/// Checks for an empty library
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Boolean</returns>
		private static bool checkEmptyLibrary (Library lib)
		{
			if (lib.Count == 0)
			{
				return true;
			}
			else
				return false;
		}

		/// <summary>
		/// Event Handler Timer
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void SecondsTimer_Tick (object sender, EventArgs e)
		{
			LoadClock ( );
		}

		/// <summary>
		/// Event Handler for a book being selected in library list
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void LibraryListBox_SelectedIndexChanged_1 (object sender, EventArgs e)
		{
			int index = LibraryListBox.SelectedIndex;
			AuthorBox.Text = library[index].Author;
			TitleBox.Text = library[index].Title;
			PriceBox.Text = String.Format (library[index].Price.ToString ( ));
		}



	}
}
