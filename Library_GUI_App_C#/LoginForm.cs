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
	public partial class LoginForm : Form
	{

		public User defaultuser;	//default User who logs in

		/// <summary>
		/// Constructor for LoginForm
		/// </summary>
		public LoginForm ( )
		{
			InitializeComponent ( );
		}

		/// <summary>
		/// Exit Button Event Handler
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void button2_Click (object sender, EventArgs e)
		{
			Application.Exit ( );
		}

		/// <summary>
		/// Submit Button Event Handler
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void button1_Click (object sender, EventArgs e)
		{
			if (initializeUser ( ))
			{
				this.Close ( );
			}
		}

		/// <summary>
		/// Initialize a user with the entered text
		/// </summary>
		/// <returns>Boolean</returns>
		private bool initializeUser ( )
		{
			defaultuser = new User (textBox1.Text, textBox2.Text, textBox3.Text);
			try
			{
				defaultuser.ToString ( );
				return true;
			}
			catch (Exception)
			{
				return false;
			}
		}

		/// <summary>
		/// Returns the default user
		/// </summary>
		/// <returns>User</returns>
		public User GetUser ( )
		{
			return defaultuser;
		}


	}
}
