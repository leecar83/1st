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

namespace WindowsFormsProject3
{
	public partial class Splash : Form
	{
		/// <summary>
		/// Constructor for splash screen
		/// </summary>
		public Splash ( )
		{
			InitializeComponent ( );
		}

		private void splashtimer_Tick (object sender, EventArgs e)
		{
			//close splash screen
			this.Close ( );
		}
	}
}
