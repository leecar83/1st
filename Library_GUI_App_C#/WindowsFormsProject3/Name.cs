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
using System.Globalization;
using WindowsFormsProject3;

namespace WindowsFormsProject3
{
	class Name
	{
		private string LastName { get; set; }	//holds the last name
		private string FirstName { get; set; }	//holds the first name
		public Boolean Success { get; private set; }	//holds a Boolean indicating a successful parsing operation 

		/// <summary>
		/// Default Constructor
		/// </summary>
		public Name ()
		{
				LastName = "";
				FirstName = "";
		}
		
		/// <summary>
		/// Parameterized Constructor
		/// </summary>
		/// <param name="strName"></param>
		public Name (String strName)
		{
			ParseName (strName);
		}
		
		/// <summary>
		/// Parses user's name and initializes a name object
		/// </summary>
		/// <param name="strName"></param>
		/// <returns>A Boolean value indicating whether a name object was created.</returns>
		private Boolean ParseName(String strName)
		{
				Success = true;
				
				//if inputted string is empty throw an error
				if(String.IsNullOrWhiteSpace(strName) == true)
				{
						String msg = "You must enter a name";
						Success = false;
						try
						{
							throw new MyException (msg);
						}
						catch (Exception)
						{
							
						}
				}
					
				else
				{
					//if there is a , assume Last, First and trim whitespaces
					if (strName.Contains(","))
					{
						int Comma = strName.IndexOf(',');
						String [] Names = strName.Trim().Split(',');
						foreach (String Na in Names)
						{
							Na.Trim();
						}
						this.LastName = Names[0];
						this.FirstName = Names[1];
					}
					//trim outside whitespaces and count number of whitespaces
					else
					{
						String Full = strName.Trim();
						char[] arrayName = Full.ToCharArray();

						int iCounter = 0;

						for (int i = 0; i < arrayName.GetLength (0); i++)
						{
							if (arrayName[i].Equals (' '))
							{
								iCounter++;
							}
						}
						
						//if there is no space between names throw an exception
						if (Full.Contains(" ") == false)
						{
							String msg = "You must enter a separate first and last name";
							Success = false;

							try
							{
								throw new MyException (msg);
							}
							catch (Exception)
							{
				
							}
						}
						//if there was more than 2 whitespaces between names assume bad input
						else if(iCounter > 2)
						{
							String msg = "You have entered too many names";
							Success = false;
							try
							{
								throw new MyException (msg);
							}
							catch (Exception)
							{
				
							}
						}
						
						//trim the remaining whitespaces and set the name properties
						else
						{
							int Space = strName.IndexOf(" ");
							String [] Names = strName.Trim().Split(" ".ToCharArray(),StringSplitOptions.RemoveEmptyEntries);
							foreach (String Na in Names)
							{
									Na.Trim();
							}
							this.FirstName = Names[0];
							this.LastName = Names[1];
						}
					}
				}
				return Success;
		}
	
		/// <summary>
		/// Formats a string of the name depending on the parameter
		/// </summary>
		/// <param name="format"></param>
		/// <returns>A string of the user's name</returns>
		public string ToString(string format = "both")
		{
			
			String strReturn = "";

			//return first and last name
			if (format.Equals ("both"))
			{
				TextInfo textInfo = new CultureInfo ("en-US", false).TextInfo;
				strReturn = String.Format ("{0},{1}", textInfo.ToTitleCase (LastName.ToLower ( )), textInfo.ToTitleCase (FirstName.ToLower ( )));
			}

			//return just the first name
			else if (format.Equals ("first"))
			{
				TextInfo textInfo = new CultureInfo ("en-US", false).TextInfo;
				strReturn = String.Format ("{0}", textInfo.ToTitleCase (FirstName.ToLower ( )));
			}

			//return just the last name
			else
			{
				TextInfo textInfo = new CultureInfo ("en-US", false).TextInfo;
				strReturn = String.Format ("{0}", textInfo.ToTitleCase (LastName.ToLower ( )));
			}
			return strReturn;
		}
	}
}
