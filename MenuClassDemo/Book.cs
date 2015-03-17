
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MenuClass
{
	public class Book : IEquatable<Book>, IComparable<Book>
	{
		public String Title { get; set; }	//holds the title
		public String Author { get; set; }	//holds the author
		public decimal Price { get; set; }	//holds the price

		/// <summary>
		/// Default Constructor 
		/// </summary>
		public Book ( )
		{
			this.Title = "";
			this.Author = "";
			this.Price = 0;
		}

		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="b"></param>
		public Book(Book b)
		{
			this.Title = b.Title;
			this.Author = b.Author;
			this.Price = b.Price;
		}

		/// <summary>
		/// Parameterized constructor with input verification
		/// </summary>
		/// <param name="title"></param>
		/// <param name="author"></param>
		/// <param name="strPrice"></param>
		public Book (String title, String author, String strPrice)
		{
			decimal price = 0;
			//test inputs and set properties if valid
			try
			{
				price = Decimal.Parse (strPrice);
				if (!String.IsNullOrEmpty (title) && !String.IsNullOrEmpty (author)
											&& Decimal.Compare (price, 0) > 0)
				{
					this.Title = title;
					this.Author = author;
					this.Price = price;
				}
			}
			catch (MyException)
			{
				Console.WriteLine ("bad book input");
				Utils.Utilities.PressAnyKey ( );
			}
		}

		/// <summary>
		/// Returns a horizontally formatted string of the book properties
		/// </summary>
		/// <returns>String</returns>
		public String toString ( )
		{
			String strReturn = String.Format ("Title: " + this.Title + "\nAuthor: " + this.Author +
												"\nPrice: " + this.Price.ToString ( ));
			return strReturn;
		}

		/// <summary>
		/// returns a Boolean value indicating if the books are the same
		/// </summary>
		/// <param name="other"></param>
		/// <returns>Boolean</returns>
		public bool Equals (Book other)
		{
			//if the titles are the same then they are the same
			if (this.Title == other.Title)
			{
				return true;
			}
			else
				return false;
		}

		/// <summary>
		/// Returns a Boolean value indicating if the object is a book
		/// </summary>
		/// <param name="obj"></param>
		/// <returns>Boolean</returns>
		public override bool Equals (object obj)
		{
			if (obj == null)
				return base.Equals (obj);
			if (!(obj is Book))
				throw new InvalidCastException ("The argument is not a Book object");
			else
				return Equals (obj as Book);
		}

		/// <summary>
		/// Returns the hash code of the book title
		/// </summary>
		/// <returns>Integer</returns>
		public override int GetHashCode ( )
		{
			return this.Title.GetHashCode ( );
		}
			
		/// <summary>
		/// Compares to book objects by their title
		/// </summary>
		/// <param name="other"></param>
		/// <returns>Integer</returns>
		public int CompareTo(Book other)
		{
			return Title.CompareTo (other.Title);
		}
	}
	
}

