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
using System.Text.RegularExpressions;
using MenuClass;

namespace Project1
{
	class EmailAddress
	{
		private string Address { get; set; }

		/// <summary>
		/// Default Constructor
		/// </summary>
		public EmailAddress()
		{
			Address = "";
		}
	
		/// <summary>
		/// Parameterized Constructor for Email Address
		/// </summary>
		/// <param name="email">EmailAddress</param>
		public EmailAddress(String email)
		{
			String msg = "Invalid input for Email Address";
			if (ValidateEmail (email) == true)
			{
				this.Address = email;
			}
			else
			{
				try
				{
					throw new MyException (msg);
				}
				catch (Exception)
				{
					Console.WriteLine ("\n\n\t\tERROR!\n\n");
				}
			}
		}
	
		/// <summary>
		/// Validates EmailAddress against a regular expression
		/// </summary>
		/// <param name="strMail"></param>
		/// <returns>A Boolean value indicating a valid EmailAddress </returns>
		public Boolean ValidateEmail(String strMail)
		{
			String strFixed = strMail.Trim ( );
			Regex pattern = new Regex (@"^([a-zA-Z0-9_\-\.]+)@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$");
			if (pattern.IsMatch (strFixed) == true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		/// <summary>
		/// Returns a formatted string of email address
		/// </summary>
		/// <returns>string of email address</returns>
		public override string ToString ( )
		{
			String strReturn = String.Format (Address);
			return strReturn;
		}
	}
}
