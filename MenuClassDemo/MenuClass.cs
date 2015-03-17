/*
 * Purpose:Project using C#, Visual Studio 2010, and Generic Lists
 * Author: Lee Miller   zlbm13@imail.etsu.edu
 * Class: Computer Science 2210
 * Date: 10/11/2011 
 */

using System;
using Utils;
using System.Windows.Forms;
using Project1;

namespace MenuClass
{
	enum Choices
	{
		CREATE_A_NEW_LIBRARY = 1,
		OPEN_LIBRARY,
		ADD,
		EDIT,
		REMOVE,
		DISPLAY,
		SAVE,
		EXIT
	}

	/// <summary>
	/// Runs the menu and does user I/O for the application
	/// </summary>
	class MenuDriver
	{
		[STAThread]
		static void Main (string[ ] args)
		{
			ConsoleMenu menu = CreateMenu ( );
			
			SetChoices (menu);

		}  // end of main

		/// <summary>
		/// Sets the Console choices and calls methods corresponding to the user's choice
		/// </summary>
		/// <param name="menu"></param>
		private static void SetChoices (ConsoleMenu menu)
		{
			
			Library library = new Library();
			User currentUser = new User ( );
			Guid g;
			Guid g1;
			currentUser = promptUser ( );	//prompt user for credentials
			Choices choice = (Choices)menu.GetChoice ( );
			//display menu until user exits
			while (choice != Choices.EXIT)
			{
				switch (choice)
				{
					//creates a new library with using the current user's credentials
					case Choices.CREATE_A_NEW_LIBRARY:
						if (library.HasChanges)
						{
							promptForSave(library);
						}
						Console.WriteLine ("You chose to create a new Library");
						Utils.Utilities.PressAnyKey ( );
						library = new Library(currentUser.getName("both"),currentUser.getEmail(),currentUser.getPhone());
						Console.WriteLine ("A new library has been created with your user credentials");
						Utils.Utilities.PressAnyKey ( );
						break;

					//open a library from a file
					case Choices.OPEN_LIBRARY:
						Console.WriteLine ("You chose to open a Library");
						Utils.Utilities.PressAnyKey ( );
						openFileDialog (library);
						break;

					//add a book to the library
					case Choices.ADD:
						Console.WriteLine ("You chose to add a book to the Library");
						Utils.Utilities.PressAnyKey ( );
						g = new Guid (Utilities.StringToGUID(library.ToString()).ToString());
						library = addBook (library);
						g1 = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
						if (g != g1)
							library.HasChanges = true;
						break;

					//edit a book
					case Choices.EDIT:
						Console.WriteLine ("You chose to edit a book in the Library");
						Utils.Utilities.PressAnyKey ( );
						if (checkEmptyLibrary(library))
						{
							Console.WriteLine("The library is empty!");
							Utilities.PressAnyKey ( );
						}
						else
						{
							g = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
							library = editBook(library);
							g1 = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
							if (g != g1)
								library.HasChanges = true;
						}
						break;

					//remove a book
					case Choices.REMOVE:
						Console.WriteLine ("You chose to remove a book from the Library");
						Utils.Utilities.PressAnyKey ( );
						if (checkEmptyLibrary(library))
						{
							Console.WriteLine("The library is empty!");
							Utilities.PressAnyKey ( );
						}
						else
						{
							g = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
							library = deleteBookPrompt (library);
							g1 = new Guid (Utilities.StringToGUID (library.ToString ( )).ToString ( ));
							if (g != g1)
								library.HasChanges = true;
						}
						break;

					//display the library
					case Choices.DISPLAY:
						Console.WriteLine ("You chose to display the whole Library");
						Utils.Utilities.PressAnyKey ( );
						if (checkEmptyLibrary(library))
						{
							Console.WriteLine("The library is empty!");
							Utilities.PressAnyKey ( );
						}
						else
						{
							displayLibrary(library);
							Utils.Utilities.PressAnyKey ( );
						}
						break;

					//save the library
					case Choices.SAVE:
						Console.WriteLine ("You chose to save the Library");
						Utils.Utilities.PressAnyKey ( );
						if (checkEmptyLibrary(library))
						{
							Console.WriteLine("The library is empty!");
							Utils.Utilities.PressAnyKey ( );
						}
						else
						{
							saveFileDialog(library);
							library.HasChanges = false;
						}
						break;

					//exit the app
					case Choices.EXIT:
						Console.WriteLine ("You selected Close");
						Utils.Utilities.PressAnyKey ( );
						break;
				}  // end of switch

				choice = (Choices)menu.GetChoice ( );
			}  // end of while
			if (library.HasChanges)
			{
				promptForSave (library);
			}
			Utils.Utilities.GoodbyeMessage ("Library");
			Utils.Utilities.PressAnyKey ( );
		}

		/// <summary>
		/// Builds the console menu
		/// </summary>
		/// <returns>Console menu</returns>
		private static ConsoleMenu CreateMenu ( )
		{
			Console.BackgroundColor = ConsoleColor.White;
			Console.ForegroundColor = ConsoleColor.Blue;
			Console.Title = "Menu Demonstration Application";
			Console.Clear ( );
			Utils.Utilities.WelcomeMessage ("Library");
			Utils.Utilities.PressAnyKey ( );
			ConsoleMenu menu = new ConsoleMenu ("Menu Demo");
			menu = menu + "Create a new Library" + "Open a saved Library" + "Add a Book" + "Edit a Book"
						+ "Remove a Book" + "Display the Library" + "Save the Library" + "Exit";
			return menu;
		}

		/// <summary>
		/// Displays the open file dialog
		/// </summary>
		/// <param name="lib"></param>
		private static void openFileDialog (Library lib)
		{
			OpenFileDialog dialog = new OpenFileDialog ( );
			dialog.InitialDirectory = Application.StartupPath;
			dialog.Title = "Open a Library";
			dialog.Filter = "text files|*.txt|all files|*.*";

			if (dialog.ShowDialog ( ) == DialogResult.Cancel)
				return;

			lib.readTextFile (dialog.FileName);
		}
	
		/// <summary>
		/// Displays the save file dialog
		/// </summary>
		/// <param name="lib"></param>
		private static void saveFileDialog(Library lib) 
		{
			SaveFileDialog dialog = new SaveFileDialog ( );
			dialog.InitialDirectory = Application.StartupPath;
			dialog.Title = "Save Library to File";
			dialog.Filter = "text files|*.txt|all files|*.*";

			if (dialog.ShowDialog ( ) == DialogResult.Cancel)
				return;

			lib.writeTextFile (dialog.FileName);
			lib.HasChanges = false;
		}
	
		/// <summary>
		/// displays the library
		/// </summary>
		/// <param name="lib"></param>
		private static void displayLibrary(Library lib)
		{
			Console.WriteLine (lib.ToString ( ));
		}

		/// <summary>
		/// Calls each method to prompt for the user data
		/// </summary>
		/// <returns>User object</returns>
		private static User promptUser( )
		{
			User user1 = new User();
			user1.setName(PromptUserName().ToString("both"));
			user1.setEmail(PromptUserEmail ( ).ToString ( ));
			user1.setPhone (PromptUserPhoneNumber ( ).pNumber);
			return user1;
		}
		
		
		
		/// <summary>
		/// prompt user for name
		/// </summary>
		/// <returns>Name</returns>
		private static Name PromptUserName ( )
		{
			String name;
			User user1 = new User ( );
			Console.Write ("Could I have your First and Last Name please? ");
			name = Console.ReadLine ( );
			Name name1 = new Name (name);
			while (name1.Success == false)
			{
				Console.Write ("Please try to enter your name again! ");
				name = Console.ReadLine ( );
				name1 = new Name (name);
			}
			return name1;
		}

		/// <summary>
		/// Prompt user for email
		/// </summary>
		/// <returns>EmailAddress</returns>
		private static EmailAddress PromptUserEmail ( )
		{
			String email;
			Utilities.Skip (3);
			Console.Write ("Hello,What is your Email Address? ");
			email = Console.ReadLine ( );
			EmailAddress userEmail = new EmailAddress (email);
			while (userEmail.ValidateEmail (email) == false)
			{
				Utilities.Skip (3);
				Console.Write ("Please try to enter your Email Address again: ");
				email = Console.ReadLine ( );
				userEmail = new EmailAddress (email);
			}
			return userEmail;
		}

		/// <summary>
		/// prompts user for their phone number
		/// </summary>
		/// <returns>Phone Number</returns>
		private static PhoneNumber PromptUserPhoneNumber ( )
		{
			String number;
			Utilities.Skip (3);
			Console.Write ("Good, Could I have your phone number in the format:\n" +
							  "                                      (###)###-####  ");
			number = Console.ReadLine ( );
			PhoneNumber phone = new PhoneNumber (number);
			while (phone.ValidatePhone (number) == false)
			{
				Utilities.Skip (3);
				Console.Write ("Please try to enter your Phone Number again! ");
				number = Console.ReadLine ( );
				phone = new PhoneNumber (number);
			}
			return phone;
		}
		
		/// <summary>
		/// Prompts user for intent to save library to file
		/// </summary>
		/// <param name="lib"></param>
		private static void promptForSave(Library lib)
		{
			Console.WriteLine ("Would you like to save the current Library to a file?");
			String response = Console.ReadLine();
			while (!response.StartsWith("y") && !response.StartsWith("Y") &&
				   !response.StartsWith("n") && !response.StartsWith("N"))
			{
				Console.WriteLine("You must answer with a yes or no please!");
				response = Console.ReadLine ( );
			}
			if(response.StartsWith("y") || response.StartsWith("Y"))
			{
				saveFileDialog(lib);
			}
		}
		
		/// <summary>
		/// Adds a book to the library
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Library</returns>
		private static Library addBook(Library lib)
		{
			if (lib.hasOwner ( ))
			{
				Book bookadded = promptBookInfo ( );
				lib += bookadded;
				return lib;
			}
			else
			{
				Console.WriteLine ("Please create a Library before trying to add a book");
				Utilities.PressAnyKey ( );
				return lib;
			}
		}
		
		/// <summary>
		/// prompts user for properties of a new book
		/// </summary>
		/// <returns>Book</returns>
		private static Book promptBookInfo()
		{
			String title = null;
			String author = null;
			String price = null;
			Decimal dPrice = 0;
			bool success = false;

			while (String.IsNullOrWhiteSpace (title))
			{
				Console.WriteLine ("What is the title of the book?");
				title = Console.ReadLine ( );
				if (String.IsNullOrWhiteSpace (title))
				{
					Console.WriteLine ("You must enter a title for the book");
					Utilities.PressAnyKey ( );
				}
			}

			while (String.IsNullOrWhiteSpace (author))
			{
				Console.WriteLine ("Who is the author of the book?");
				author = Console.ReadLine ( );
				if (String.IsNullOrWhiteSpace (author))
				{
					Console.WriteLine ("You must enter an author for the book");
					Utilities.PressAnyKey ( );
				}
			}

			while (String.IsNullOrWhiteSpace (price) || success == false)
			{
				try
				{
					Console.WriteLine ("What is the price of the book?");
					price = Console.ReadLine ( );
					dPrice = Decimal.Parse (price);
					success = true;
				}
				catch(Exception)
				{
					Console.WriteLine ("Invalid input for price of book");
					Utilities.PressAnyKey ( );
				}
			}

			Book book = new Book (title, author, price);
			return book;
		}
		
		/// <summary>
		/// prompts user for a book to remove from the library
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Library</returns>
		private static Library deleteBookPrompt(Library lib)
		{
			if (!lib.hasOwner ( ))
			{
				Console.WriteLine ("There must be a Library opened in order to remove a Book!");
				Utilities.PressAnyKey();
			}
			else if(lib.Count <=0)
			{
				Console.WriteLine("There are no Books in the Library to remove!");
				Utilities.PressAnyKey();
			}
			else
			{
				Console.WriteLine (displayTitleList (lib));
				Console.WriteLine ("What is the title of the Book you would like to remove?");
				String title = Console.ReadLine ( );
				if (lib.containsBook(title) != -1)
				{
					lib -= lib[title];
					lib.HasChanges = true;
					Console.WriteLine("Book successfully removed");
					Utilities.PressAnyKey();
				}
				else
				{
					Console.WriteLine("Sorry that Book cannot be found in the Library");
					Utilities.PressAnyKey();
				}
			}
			return lib;
		}
		
		/// <summary>
		/// prompts user for a book to edit and original with an edited version of book
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Library</returns>
		private static Library editBook(Library lib)
		{
			if (lib.hasOwner())
			{
				Console.WriteLine(displayTitleList (lib));
				Console.WriteLine ("What is the Title of the Book you would like to edit? ");
				String title = Console.ReadLine ( );
				if (String.IsNullOrWhiteSpace(title) || lib.containsBook (title) != -1)
				{
					int index = lib.containsBook (title);
					Book b = launchEditMenu (lib[title]);
					if (b.CompareTo(lib[index]) != 0)
					{
						lib -= lib[index];
						lib += b;
					}
					
				}
				else
				{
					Console.WriteLine ("Sorry that book was not found in the Library");
					Utilities.PressAnyKey ( );
				}
			}
			else
			{
				Console.WriteLine("There is no library open!");
				Utilities.PressAnyKey();
			}
			return lib;
		}
		
		/// <summary>
		/// Displays a menu for book editing options
		/// </summary>
		/// <param name="b"></param>
		/// <returns>Book</returns>
		private static Book launchEditMenu(Book b)
		{
			String Choice = "0";
			Book book = new Book (b);
			while(Choice != "4")
			{
				Console.WriteLine("\nEditing Menu:\n\n" +
							   "1.Title\n" + 
							   "2.Author\n" + 
							   "3.Price\n" + 
							   "4.Exit\n");
				Choice = Console.ReadLine();
				while (!Choice.Equals("1") && !Choice.Equals("2") &&
					!Choice.Equals("3") && !Choice.Equals("4"))
				{
					Console.WriteLine("\nPlease enter a proper choice");
				}
				switch(Choice)
				{
					case "1":book = editTitle(b);
					break;
					case "2":book = editAuthor(b);
					break;
					case "3":book = editPrice(b);
					break;
				}
				
			}
			return book;
		}
		
		/// <summary>
		/// Edits the title of a book
		/// </summary>
		/// <param name="b"></param>
		/// <returns>Book</returns>
		private static Book editTitle (Book b)
		{
			String title = "";
			while(String.IsNullOrWhiteSpace (title))
			{
				Console.WriteLine ("What is the new title of the book?");
				title = Console.ReadLine ( );
				if (String.IsNullOrWhiteSpace (title))
				{
					Console.WriteLine ("You must enter a title for the book");
					Utilities.PressAnyKey ( );
				}
			}
			b.Title = title;
			return b;
		}

		/// <summary>
		/// edits the author of a book
		/// </summary>
		/// <param name="b"></param>
		/// <returns>book</returns>
		private static Book editAuthor (Book b)
		{
			String author = "";
			while (String.IsNullOrWhiteSpace (author))
			{
				Console.WriteLine ("What is the new author of the book?");
				author = Console.ReadLine ( );
				if (String.IsNullOrWhiteSpace (author))
				{
					Console.WriteLine ("You must enter a author for the book");
					Utilities.PressAnyKey ( );
				}
			}
			b.Author = author;
			return b;
		}
		
		/// <summary>
		/// Edits the price of a book
		/// </summary>
		/// <param name="b"></param>
		/// <returns>Book</returns>
		private static Book editPrice(Book b)
		{
			String price = "";
			Decimal dPrice = 0;
			bool success = false;
			while (String.IsNullOrWhiteSpace (price) || success == false)
			{
				try
				{
					Console.WriteLine ("What is the price of the book?");
					price = Console.ReadLine ( );
					dPrice = Decimal.Parse (price);
					success = true;
				}
				catch (Exception)
				{
					Console.WriteLine ("Invalid input for price of book");
					Utilities.PressAnyKey ( );
				}
			}
			b.Price = dPrice;
			return b;
		}
		
		/// <summary>
		/// checks the library for the existence of a book
		/// </summary>
		/// <param name="b"></param>
		/// <param name="lib"></param>
		/// <returns>Boolean</returns>
		private static bool bookCheck(Book b, Library lib)
		{
			String title = b.Title;
			if (lib.containsBook (title) != -1)
			{
				return true;
			}
			else
				return false;
		}
		
		/// <summary>
		/// Check to see if the library is empty
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Boolean</returns>
		private static bool checkEmptyLibrary(Library lib)
		{
			if (lib.Count == 0)
			{
				return true;
			}
			else
				return false;
		}
	
		/// <summary>
		/// Check to see if library is a default empty library
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>Boolean</returns>
		private static bool checkDefaultLibrary(Library lib)
		{
			if (lib.hasOwner ( ))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		/// <summary>
		/// Formats a string of the book titles
		/// </summary>
		/// <param name="lib"></param>
		/// <returns>string of Book titles</returns>
		public static string displayTitleList (Library lib)
		{
			String strReturn = "Book Titles:\n\n";
			for (int i = 0; i < lib.Count; i++)
			{
				strReturn += String.Format ("{0}\n", lib[i].Title);
			}
			return strReturn;
		}
	
	}
}
