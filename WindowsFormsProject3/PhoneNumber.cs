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
using WindowsFormsProject3;

namespace WindowsFormsProject3
{
	class PhoneNumber
	{
		public String pNumber { get; set; }	//holds the phone number

		/// <summary>
		/// Default Constructor
		/// </summary>
		public PhoneNumber()
		{
			pNumber = "";
		}
	
		/// <summary>
		/// Constructor that check for valid PhoneNumber
		/// </summary>
		/// <param name="number"></param>
		public PhoneNumber(string number)
		{
			String msg = "Invalid input for Phone Number use format (###)###-####";
			if (ValidatePhone (number) == true)
			{
				this.pNumber = number;
			}
			else
			{
				try
				{
					throw new MyException (msg);
				}
				catch (Exception)
				{

				}
			}
		}
		
		/// <summary>
		/// Validates inputted phone number against a regular expression 
		/// </summary>
		/// <param name="number"></param>
		/// <returns>A Boolean indicating a valid phone number</returns>
		public Boolean ValidatePhone(string number)
		{
			String fixedNumber = number.Replace (" ","");
			Regex pattern = new Regex(@"^\([0-9]{3}\)[0-9]{3}-[0-9]{4}$");
			if (pattern.IsMatch (fixedNumber) == true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		/// <summary>
		/// Return the phone number in a formatted string
		/// </summary>
		/// <returns>a string of phone number</returns>
		public override string ToString ( )
		{
			String strReturn = String.Format (pNumber);
			return strReturn;
		}
	}
}
