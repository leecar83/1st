/*
 * Purpose:Project 3 using C#, Visual Studio 2010 with Windows Forms
 * Author: Lee Miller   zlbm13@imail.etsu.edu
 * Class: Computer Science 2210
 * Date: 10/26/2011 
 */
namespace WindowsFormsProject3
{
	partial class Splash
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose (bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose ( );
			}
			base.Dispose (disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent ( )
		{
			this.components = new System.ComponentModel.Container ( );
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager (typeof (Splash));
			this.splitContainer1 = new System.Windows.Forms.SplitContainer ( );
			this.splashtimer = new System.Windows.Forms.Timer (this.components);
			this.pictureBox1 = new System.Windows.Forms.PictureBox ( );
			this.label1 = new System.Windows.Forms.Label ( );
			this.label2 = new System.Windows.Forms.Label ( );
			((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit ( );
			this.splitContainer1.Panel1.SuspendLayout ( );
			this.splitContainer1.Panel2.SuspendLayout ( );
			this.splitContainer1.SuspendLayout ( );
			((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit ( );
			this.SuspendLayout ( );
			// 
			// splitContainer1
			// 
			this.splitContainer1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
						| System.Windows.Forms.AnchorStyles.Left)
						| System.Windows.Forms.AnchorStyles.Right)));
			this.splitContainer1.BackColor = System.Drawing.Color.White;
			this.splitContainer1.Location = new System.Drawing.Point (0, 0);
			this.splitContainer1.Margin = new System.Windows.Forms.Padding (0);
			this.splitContainer1.Name = "splitContainer1";
			this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
			// 
			// splitContainer1.Panel1
			// 
			this.splitContainer1.Panel1.Controls.Add (this.pictureBox1);
			// 
			// splitContainer1.Panel2
			// 
			this.splitContainer1.Panel2.BackColor = System.Drawing.Color.White;
			this.splitContainer1.Panel2.Controls.Add (this.label2);
			this.splitContainer1.Panel2.Controls.Add (this.label1);
			this.splitContainer1.Size = new System.Drawing.Size (376, 399);
			this.splitContainer1.SplitterDistance = 299;
			this.splitContainer1.SplitterWidth = 1;
			this.splitContainer1.TabIndex = 0;
			// 
			// splashtimer
			// 
			this.splashtimer.Enabled = true;
			this.splashtimer.Interval = 3000;
			this.splashtimer.Tick += new System.EventHandler (this.splashtimer_Tick);
			// 
			// pictureBox1
			// 
			this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject ("pictureBox1.Image")));
			this.pictureBox1.Location = new System.Drawing.Point (0, 0);
			this.pictureBox1.Margin = new System.Windows.Forms.Padding (0);
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.Size = new System.Drawing.Size (376, 299);
			this.pictureBox1.TabIndex = 0;
			this.pictureBox1.TabStop = false;
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Font = new System.Drawing.Font ("Ravie", 14.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label1.Location = new System.Drawing.Point (25, 23);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size (326, 26);
			this.label1.TabIndex = 0;
			this.label1.Text = "Lee\'s Library Manager";
			this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Font = new System.Drawing.Font ("Ravie", 8.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label2.Location = new System.Drawing.Point (132, 55);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size (112, 17);
			this.label2.TabIndex = 1;
			this.label2.Text = "Version 1.0.0";
			// 
			// Splash
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF (6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size (376, 399);
			this.Controls.Add (this.splitContainer1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject ("$this.Icon")));
			this.Name = "Splash";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Form1";
			this.TransparencyKey = System.Drawing.Color.White;
			this.splitContainer1.Panel1.ResumeLayout (false);
			this.splitContainer1.Panel2.ResumeLayout (false);
			this.splitContainer1.Panel2.PerformLayout ( );
			((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit ( );
			this.splitContainer1.ResumeLayout (false);
			((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit ( );
			this.ResumeLayout (false);

		}

		#endregion

		private System.Windows.Forms.SplitContainer splitContainer1;
		private System.Windows.Forms.Timer splashtimer;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
	}
}