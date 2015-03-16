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

namespace WindowsFormsProject3
{
	public class User
	{
		Name person;	//holds a Person object
		EmailAddress address;	//holds the email address
		PhoneNumber number;	//holds the phone number
		
	
		/// <summary>
		/// Default Constructor
		/// </summary>
		public User()
		{
			person = new Name ( );
			address = new EmailAddress ( );
			number = new PhoneNumber ( );
		}
		
		/// <summary>
		/// Parameterized Constructor
		/// </summary>
		/// <param name="name"></param>
		/// <param name="email"></param>
		/// <param name="phone"></param>
		public User(string name, string email, string phone)
		{
			person = new Name (name);
			address = new EmailAddress (email);
			number = new PhoneNumber (phone);
		}

		/// <summary>
		/// Setter for name
		/// </summary>
		/// <param name="name"></param>
		public void setName (string name)
		{
			person = new Name (name);
		}

		/// <summary>
		/// getter for name
		/// </summary>
		/// <param name="format"></param>
		/// <returns></returns>
		public String getName (string format)
		{
			String PersonsName = person.ToString (format);
			return PersonsName;
		}

		/// <summary>
		/// setter for email address
		/// </summary>
		/// <param name="mail"></param>
		public void setEmail (string mail)
		{
			address = new EmailAddress (mail);
		}
		
		/// <summary>
		/// Getter for Email Address
		/// </summary>
		/// <returns>String</returns>
		public String getEmail ()
		{
			String PersonsEMail = address.ToString ();
			return PersonsEMail;
		}
		
		/// <summary>
		/// Setter for phone number
		/// </summary>
		/// <param name="number"></param>
		public void setPhone(string number)
		{
			this.number = new PhoneNumber (number);
		}
		
		/// <summary>
		/// Getter for phone number
		/// </summary>
		/// <returns></returns>
		public String getPhone()
		{
			String PersonsPhone = number.ToString ( );
			return PersonsPhone;
		}
		
		/// <summary>
		/// Returns a formatted string of the user's name, email, and phone number
		/// </summary>
		/// <returns>string of user info</returns>
		public override String ToString()
		{
			//format a string of user info
			String strReturn = (String.Format ("Glad to meet you. Your information is as follows: \n" +
												"Name : {0} \n" +
												"Email Address: {1} \n" +
												"Phone Number: {2}",
												person.ToString("both"), address, number.ToString()));
			return strReturn;
		}
	}
}
