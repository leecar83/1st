/*
 * Purpose:Project using C#, Visual Studio 2010, and Generic Lists
 * Author: Lee Miller   zlbm13@imail.etsu.edu
 * Class: Computer Science 2210
 * Date: 10/11/2011 
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Windows.Forms;
using Project1;

namespace MenuClass
{
	public class Library
	{

		private User owner;	//holds the user of the library
		public int Count { get; set; }	//holds the number of books in the library
		public String FileName { get; set; }	//holds the filename where the library is located
		public bool HasChanges { get; set; }	//holds a Boolean indicating if changes have been made to the library
		List<Book> books;	//holds an array list of Book objects

		/// <summary>
		/// Default constructor for Library
		/// </summary>
		public Library()
		{
			owner = new User ( );
			Count = 0;
			FileName = "";
			HasChanges = false;
			books = new List<Book> ( );
		}
		
		/// <summary>
		/// Parameterized constructor for Library
		/// </summary>
		/// <param name="name"></param>
		/// <param name="email"></param>
		/// <param name="phone"></param>
		public Library(String name, String email, String phone)
		{
			owner = new User (name, email, phone);
			Count = 0;
			FileName = "";
			HasChanges = false;
			books = new List<Book> ( );
		}

		/// <summary>
		/// Constructor for Library that accepts a file path
		/// </summary>
		/// <param name="path"></param>
		public Library(String path)
		{
			readTextFile (path);
		}
		
		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="L"></param>
		public Library(Library L)
		{
			this.owner = L.owner;
			this.Count = L.Count;
			this.FileName = L.FileName;
			this.HasChanges = L.HasChanges;
			this.books = L.books;
		}
		
		/// <summary>
		/// Initializes a Library object using an input file
		/// </summary>
		/// <param name="fileName"></param>
		public void readTextFile(String fileName)
		{
			//if file exists initialize parameters
			if (File.Exists(fileName))
			{
				Book b = null;
				Decimal d = 0;
				StreamReader reader = null;
				this.FileName = fileName;
				String[] fields = null;
				Boolean firstLine = true;
				// use StreamReader to read file info into a Library object
				try
				{
					reader = new StreamReader (fileName);
					while (reader.Peek () != -1)
					{
						if (firstLine)
						{
							fields = reader.ReadLine ( ).Split (',');
							owner.setName (fields[0]);
							owner.setEmail (fields[1]);
							owner.setPhone (fields[2]);
							firstLine = false;
						}
						else
						{
							fields = reader.ReadLine ( ).Split (',');
							if (Decimal.TryParse (fields [2], out d))
							{
								b = new Book (fields[0], fields[1], fields[2]);
							}
							books.Add(b);
							Count++;
						}
					
					}
				

				}
				//catch exception if unable to read file
				catch(Exception ex)
				{
						throw new MyException("unable to read from file\n" + ex.Message + "\n"
										+ ex.StackTrace);
				}
				finally
				{
					//close file reader
					if(reader !=null)
					{
						reader.Close();
						HasChanges = false;			
					}
				}

			}
		}
		
		/// <summary>
		/// Write the Library info to a text file
		/// </summary>
		/// <param name="fileName"></param>
		public void writeTextFile(String fileName)
		{
			StreamWriter writer = null;
			//use StreamWriter to print user info
			try
			{
				writer = new StreamWriter(new FileStream (fileName,
													FileMode.Create,FileAccess.Write)); 
				writer.WriteLine(owner.getName("first") + " " + owner.getName("last") + "," + owner.getEmail() 
													+ "," + owner.getPhone());
				//use loop to print books
				for (int i = 0; i < books.Count(); i++)
				{
					writer.WriteLine(books[i].Title + "," + books[i].Author +
											"," + books[i].Price.ToString());
				}
				FileName = fileName;
			}
			//catch exception if unable to read to file
			catch (Exception ex)
			{
				Console.WriteLine("Unable to write to file\n" + ex.Message + "\n"
										+ ex.StackTrace);
				Utils.Utilities.PressAnyKey ( );
			}
			finally
			{
				//close file reader
				if (writer !=null)
					writer.Close();
			}
			
		}
		
		/// <summary>
		/// Adds a book to the library
		/// </summary>
		/// <param name="L"></param>
		/// <param name="B"></param>
		/// <returns>Library</returns>
		public static Library operator + (Library L, Book B)
		{
			Library Temp = new Library (L);
			//if book is not in library then add it
			if (!Temp.books.Contains (B))
			{
				Temp.books.Add (B);
				Temp.HasChanges = true;
				Temp.Count += 1;
			}
			else
			{
				Console.WriteLine ("The Library already contains this Book!");
				Utils.Utilities.PressAnyKey ( );
			}
			return Temp;
		}
		
		/// <summary>
		/// Removes a book from a library
		/// </summary>
		/// <param name="L"></param>
		/// <param name="B"></param>
		/// <returns>Library</returns>
		public static Library operator - (Library L, Book B)
		{
			Library Temp = new Library (L);
			//Remove the book from the library
			if (Temp.books.Remove (B))
			{
				Temp.HasChanges = true;
				Temp.Count -= 1;
			}
			return Temp;
		}

		/// <summary>
		/// Returns the index if book is in Library, -1 if not
		/// </summary>
		/// <param name="title"></param>
		/// <returns>int</returns>
		public int containsBook (String title)
		{
			int index = -1;
			//loop through library looking for a title match
			for (int i = 0; i < books.Count; i++)
			{
				if (title.Equals (books[i].Title, StringComparison.OrdinalIgnoreCase))
				{
					index = i;
				}
			}
			return index;
		}
		
		/// <summary>
		/// Sorts the Library by title
		/// </summary>
		public void sortByTitle()
		{
			books.Sort ( );
		}
		
		/// <summary>
		/// Integer indexer for the Library 
		/// </summary>
		/// <param name="index"></param>
		/// <returns>Book</returns>
		public Book this[int index]
		{
			get
			{
				if (index < 0 || index >= Count)
					throw new IndexOutOfRangeException (String.Format("Subscript {0} is not in the Library", index));
				return books[index];
			}
			set
			{
				if (index < 0 || index >= Count)
					throw new IndexOutOfRangeException (String.Format("Subscript {0} is not in the Library", index));
				books[index] = value;
				HasChanges = true;
			}
		}
		
		/// <summary>
		/// Read only title indexer
		/// </summary>
		/// <param name="title"></param>
		/// <returns>Book</returns>
		public Book this[String title]
		{
			get
			{
				foreach (Book b in books)
					if (b.Title == title)
						return b;

				return null;
			}
		}

		/// <summary>
		/// returns Boolean indicating if Library has an owner
		/// </summary>
		/// <returns>Boolean</returns>
		public bool hasOwner ( )
		{
			if (owner.getName ("first") == "")
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		/// <summary>
		/// Returns a formatted String of the Library owner and the Book's properties
		/// </summary>
		/// <returns>String</returns>
		public override string ToString ( )
		{
			//string of owner properties
			String strReturn = String.Format ("     Owner:\n" +
									  "Name: {0}" + "\n" +
									  "EMail: {1}" + "\n" +
									  "Phone#: {2}" + "\n\n" +
									  "                                Books: \n\n" +
									  "Title                     Author                      Price\n\n",
									  owner.getName("both"),owner.getEmail(),owner.getPhone());
			//loop through library concating string of book properties
			for (int i = 0; i < Count; i++)
			{
				strReturn += String.Format ("{0}".PadLeft (0) + "{1}".PadLeft (26 - books[i].Title.Length) +
											"${2}".PadLeft (35 - books[i].Author.Length) + "\n", books[i].Title, books[i].Author, books[i].Price.ToString ( ));
			}
				return strReturn;
		}
	
		
	}
}
