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
using System.Windows.Forms;

namespace MenuClass
{
	class MyException: Exception
	{
		
		/// <summary>
		/// Displays a message indicating an error has occurred
		/// </summary>
		/// <param name="strMsg"></param>
		public MyException(string strMsg)
		{
			MessageBox.Show (null, strMsg, "Whoops!", MessageBoxButtons.OK, MessageBoxIcon.Error);
		}
	}
}
