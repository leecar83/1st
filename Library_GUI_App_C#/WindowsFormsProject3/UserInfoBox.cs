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
	public partial class UserInfoBox : Form
	{
		public string Names1 { get; set; }
		public string Email { get; set; }
		public string Number { get; set; }
		
		public UserInfoBox()
		{
			InitializeComponent();

		}

		private void UserInfoBox_Load(object sender, EventArgs e)
		{
			this.label5.Text = Names1;
			this.label6.Text = Email;
			this.label7.Text = Number;		
		}

		private void button1_Click(object sender, EventArgs e)
		{
			this.Close();
		}


	}
}
