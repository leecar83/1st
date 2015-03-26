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
using System.Security.Cryptography;


namespace Utils
{
	public class Utilities
	{
		/// <summary>
		/// Displays a welcome message with name of app, author's name, date, and course. 
		/// </summary>
		/// <param name="application">Name of the application displayed</param>
		/// <returns>Welcome String</returns>
		public static void WelcomeMessage(String application)
		{
			Console.ForegroundColor = ConsoleColor.Green;
			String strReturn;
			String strHello = String.Format("Hello! You are using the {0} app"  + "\n",application).PadLeft(60);
			String strName = String.Format("by: Lee Miller" + "\n").PadLeft(47);
			String strDate = String.Format("{0}\n",GetDate()).PadLeft(55);
			String strSubject = String.Format("Computer Science 2210: Data Structures").PadLeft(61);
			strReturn = String.Concat (strHello, strName, strDate, strSubject);
			Console.WriteLine (strReturn);
			Skip (5);
		}
	
		/// <summary>
		/// Displays a goodbye message with the name of the app.
		/// </summary>
		/// <param name="application">Name of the application displayed</param>
		/// <returns>Goodbye String</returns>
		public static void GoodbyeMessage(String application)
		{
			String strReturn = String.Format ("\n\n\n\n\nThank you for using the {0} app" + "\n" +
											"Goodbye!\n\n", application);
			Console.WriteLine (strReturn);
		}

		/// <summary>
		/// Display a Press Any Key to ... message at the bottom of the screen
		/// </summary>
		/// <param name="strVerb">term in the Press Any Key to ... message; default: "continue . . ."</param>
		public static void PressAnyKey (string strVerb = "continue ...")
		{
			Console.ForegroundColor = ConsoleColor.Red;
			if (Console.CursorTop < Console.WindowHeight - 1)
				Console.SetCursorPosition (0, Console.WindowHeight - 1);
			else
				Console.SetCursorPosition (0, Console.CursorTop + 2);

			Console.Write ("Press any key to " + strVerb);
			Console.ReadKey ( );
			Console.Clear ( );
			Console.ForegroundColor = ConsoleColor.Blue;
		}

		/// <summary>
		/// Skip n lines in the console window
		/// </summary>
		/// <param name="n">the number of lines to skip - defaults to 1</param>

		public static void Skip (int n = 1)
		{
			for (int i = 0; i < n; i++)
			{
				Console.WriteLine ( );
			}
		} 

		/// <summary>
		/// Returns a string with the current month, day, and year.
		/// </summary>
		/// <returns>String of current date</returns>
		public static string GetDate()
		{
			DateTime current = DateTime.Now;
			string date = current.ToString ("D");
			return date;
		}

		/// <summary>
		/// Returns a GUID computed from a MD5 of the string
		/// </summary>
		/// <param name="value"></param>
		/// <returns>GUID of inputted string</returns>
		public static Guid StringToGUID (string value)
		{
			// Create a new instance of the MD5CryptoServiceProvider object.
			MD5 md5Hasher = MD5.Create ( );
			// Convert the input string to a byte array and compute the hash.
			byte[] data = md5Hasher.ComputeHash (Encoding.Default.GetBytes (value));
			return new Guid (data);
		}
	}
}
