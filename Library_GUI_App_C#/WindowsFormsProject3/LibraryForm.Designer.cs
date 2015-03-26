/*
 * Purpose:Project 3 using C#, Visual Studio 2010 with Windows Forms
 * Author: Lee Miller   zlbm13@imail.etsu.edu
 * Class: Computer Science 2210
 * Date: 10/26/2011 
 */
namespace WindowsFormsProject3
{
	partial class LibraryForm
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
			this.components = new System.ComponentModel.Container();
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LibraryForm));
			this.LibraryListBox = new System.Windows.Forms.ListBox();
			this.menuStrip1 = new System.Windows.Forms.MenuStrip();
			this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.createNewLibraryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.openExistingLibraryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.saveCurrentLibraryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripSeparator();
			this.exitToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
			this.editToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.addABookToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.changeThisBookToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.deleteThisBookToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.aboutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.splitter1 = new System.Windows.Forms.Splitter();
			this.label5 = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.PriceBox = new System.Windows.Forms.TextBox();
			this.AuthorBox = new System.Windows.Forms.TextBox();
			this.TitleBox = new System.Windows.Forms.TextBox();
			this.textBox1 = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.DateBox = new System.Windows.Forms.TextBox();
			this.SecondsTimer = new System.Windows.Forms.Timer(this.components);
			this.userInfoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.menuStrip1.SuspendLayout();
			this.groupBox1.SuspendLayout();
			this.SuspendLayout();
			// 
			// LibraryListBox
			// 
			this.LibraryListBox.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
			this.LibraryListBox.BackColor = System.Drawing.SystemColors.Info;
			this.LibraryListBox.FormattingEnabled = true;
			this.LibraryListBox.Location = new System.Drawing.Point(12, 51);
			this.LibraryListBox.Name = "LibraryListBox";
			this.LibraryListBox.Size = new System.Drawing.Size(200, 173);
			this.LibraryListBox.TabIndex = 0;
			this.LibraryListBox.SelectedIndexChanged += new System.EventHandler(this.LibraryListBox_SelectedIndexChanged_1);
			// 
			// menuStrip1
			// 
			this.menuStrip1.BackColor = System.Drawing.SystemColors.ControlLightLight;
			this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.editToolStripMenuItem,
            this.helpToolStripMenuItem});
			this.menuStrip1.Location = new System.Drawing.Point(0, 0);
			this.menuStrip1.Name = "menuStrip1";
			this.menuStrip1.Size = new System.Drawing.Size(552, 24);
			this.menuStrip1.TabIndex = 1;
			this.menuStrip1.Text = "menuStrip1";
			// 
			// fileToolStripMenuItem
			// 
			this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.createNewLibraryToolStripMenuItem,
            this.openExistingLibraryToolStripMenuItem,
            this.saveCurrentLibraryToolStripMenuItem,
            this.exitToolStripMenuItem,
            this.exitToolStripMenuItem1});
			this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
			this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
			this.fileToolStripMenuItem.Text = "File";
			// 
			// createNewLibraryToolStripMenuItem
			// 
			this.createNewLibraryToolStripMenuItem.Name = "createNewLibraryToolStripMenuItem";
			this.createNewLibraryToolStripMenuItem.Size = new System.Drawing.Size(185, 22);
			this.createNewLibraryToolStripMenuItem.Text = "Create New Library";
			this.createNewLibraryToolStripMenuItem.Click += new System.EventHandler(this.createNewLibraryToolStripMenuItem_Click);
			// 
			// openExistingLibraryToolStripMenuItem
			// 
			this.openExistingLibraryToolStripMenuItem.Name = "openExistingLibraryToolStripMenuItem";
			this.openExistingLibraryToolStripMenuItem.Size = new System.Drawing.Size(185, 22);
			this.openExistingLibraryToolStripMenuItem.Text = "Open Existing Library";
			this.openExistingLibraryToolStripMenuItem.Click += new System.EventHandler(this.openExistingLibraryToolStripMenuItem_Click);
			// 
			// saveCurrentLibraryToolStripMenuItem
			// 
			this.saveCurrentLibraryToolStripMenuItem.Name = "saveCurrentLibraryToolStripMenuItem";
			this.saveCurrentLibraryToolStripMenuItem.Size = new System.Drawing.Size(185, 22);
			this.saveCurrentLibraryToolStripMenuItem.Text = "Save Current Library";
			this.saveCurrentLibraryToolStripMenuItem.Click += new System.EventHandler(this.saveCurrentLibraryToolStripMenuItem_Click);
			// 
			// exitToolStripMenuItem
			// 
			this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
			this.exitToolStripMenuItem.Size = new System.Drawing.Size(182, 6);
			// 
			// exitToolStripMenuItem1
			// 
			this.exitToolStripMenuItem1.Name = "exitToolStripMenuItem1";
			this.exitToolStripMenuItem1.Size = new System.Drawing.Size(185, 22);
			this.exitToolStripMenuItem1.Text = "Exit";
			this.exitToolStripMenuItem1.Click += new System.EventHandler(this.exitToolStripMenuItem1_Click);
			// 
			// editToolStripMenuItem
			// 
			this.editToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addABookToolStripMenuItem,
            this.changeThisBookToolStripMenuItem,
            this.deleteThisBookToolStripMenuItem});
			this.editToolStripMenuItem.Name = "editToolStripMenuItem";
			this.editToolStripMenuItem.Size = new System.Drawing.Size(39, 20);
			this.editToolStripMenuItem.Text = "Edit";
			// 
			// addABookToolStripMenuItem
			// 
			this.addABookToolStripMenuItem.Name = "addABookToolStripMenuItem";
			this.addABookToolStripMenuItem.Size = new System.Drawing.Size(167, 22);
			this.addABookToolStripMenuItem.Text = "Add a Book";
			this.addABookToolStripMenuItem.Click += new System.EventHandler(this.addABookToolStripMenuItem_Click);
			// 
			// changeThisBookToolStripMenuItem
			// 
			this.changeThisBookToolStripMenuItem.Name = "changeThisBookToolStripMenuItem";
			this.changeThisBookToolStripMenuItem.Size = new System.Drawing.Size(167, 22);
			this.changeThisBookToolStripMenuItem.Text = "Change this Book";
			this.changeThisBookToolStripMenuItem.Click += new System.EventHandler(this.changeThisBookToolStripMenuItem_Click);
			// 
			// deleteThisBookToolStripMenuItem
			// 
			this.deleteThisBookToolStripMenuItem.Name = "deleteThisBookToolStripMenuItem";
			this.deleteThisBookToolStripMenuItem.Size = new System.Drawing.Size(167, 22);
			this.deleteThisBookToolStripMenuItem.Text = "Delete This Book";
			this.deleteThisBookToolStripMenuItem.Click += new System.EventHandler(this.deleteThisBookToolStripMenuItem_Click);
			// 
			// helpToolStripMenuItem
			// 
			this.helpToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.aboutToolStripMenuItem,
            this.userInfoToolStripMenuItem});
			this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
			this.helpToolStripMenuItem.Size = new System.Drawing.Size(44, 20);
			this.helpToolStripMenuItem.Text = "Help";
			// 
			// aboutToolStripMenuItem
			// 
			this.aboutToolStripMenuItem.Name = "aboutToolStripMenuItem";
			this.aboutToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
			this.aboutToolStripMenuItem.Text = "About";
			this.aboutToolStripMenuItem.Click += new System.EventHandler(this.aboutToolStripMenuItem_Click);
			// 
			// groupBox1
			// 
			this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.groupBox1.Controls.Add(this.splitter1);
			this.groupBox1.Controls.Add(this.label5);
			this.groupBox1.Controls.Add(this.label4);
			this.groupBox1.Controls.Add(this.label3);
			this.groupBox1.Controls.Add(this.PriceBox);
			this.groupBox1.Controls.Add(this.AuthorBox);
			this.groupBox1.Controls.Add(this.TitleBox);
			this.groupBox1.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.groupBox1.Location = new System.Drawing.Point(230, 38);
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.Size = new System.Drawing.Size(310, 138);
			this.groupBox1.TabIndex = 2;
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = "Book Details";
			// 
			// splitter1
			// 
			this.splitter1.Location = new System.Drawing.Point(3, 18);
			this.splitter1.Name = "splitter1";
			this.splitter1.Size = new System.Drawing.Size(3, 117);
			this.splitter1.TabIndex = 2;
			this.splitter1.TabStop = false;
			// 
			// label5
			// 
			this.label5.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.label5.AutoSize = true;
			this.label5.Location = new System.Drawing.Point(29, 24);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(32, 16);
			this.label5.TabIndex = 0;
			this.label5.Text = "Title";
			// 
			// label4
			// 
			this.label4.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(15, 65);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(46, 16);
			this.label4.TabIndex = 2;
			this.label4.Text = "Author";
			this.label4.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// label3
			// 
			this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(102, 109);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(97, 16);
			this.label3.TabIndex = 4;
			this.label3.Text = "Price of Book $";
			// 
			// PriceBox
			// 
			this.PriceBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.PriceBox.Location = new System.Drawing.Point(222, 106);
			this.PriceBox.Name = "PriceBox";
			this.PriceBox.Size = new System.Drawing.Size(72, 22);
			this.PriceBox.TabIndex = 5;
			this.PriceBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
			// 
			// AuthorBox
			// 
			this.AuthorBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.AuthorBox.Location = new System.Drawing.Point(80, 62);
			this.AuthorBox.Name = "AuthorBox";
			this.AuthorBox.Size = new System.Drawing.Size(214, 22);
			this.AuthorBox.TabIndex = 3;
			// 
			// TitleBox
			// 
			this.TitleBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.TitleBox.Location = new System.Drawing.Point(80, 21);
			this.TitleBox.Name = "TitleBox";
			this.TitleBox.Size = new System.Drawing.Size(214, 22);
			this.TitleBox.TabIndex = 1;
			// 
			// textBox1
			// 
			this.textBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.textBox1.Location = new System.Drawing.Point(455, 193);
			this.textBox1.Name = "textBox1";
			this.textBox1.ReadOnly = true;
			this.textBox1.Size = new System.Drawing.Size(69, 20);
			this.textBox1.TabIndex = 3;
			this.textBox1.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
			// 
			// label1
			// 
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.label1.AutoSize = true;
			this.label1.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label1.Location = new System.Drawing.Point(318, 196);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(112, 16);
			this.label1.TabIndex = 4;
			this.label1.Text = "Number of Books:";
			// 
			// label2
			// 
			this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.label2.AutoSize = true;
			this.label2.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label2.Location = new System.Drawing.Point(12, 32);
			this.label2.Margin = new System.Windows.Forms.Padding(3);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(131, 16);
			this.label2.TabIndex = 5;
			this.label2.Text = "Titles in the Library";
			// 
			// DateBox
			// 
			this.DateBox.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.DateBox.BackColor = System.Drawing.SystemColors.Control;
			this.DateBox.BorderStyle = System.Windows.Forms.BorderStyle.None;
			this.DateBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 6.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.DateBox.Location = new System.Drawing.Point(321, 232);
			this.DateBox.Name = "DateBox";
			this.DateBox.ReadOnly = true;
			this.DateBox.Size = new System.Drawing.Size(203, 11);
			this.DateBox.TabIndex = 6;
			this.DateBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
			// 
			// SecondsTimer
			// 
			this.SecondsTimer.Enabled = true;
			this.SecondsTimer.Tick += new System.EventHandler(this.SecondsTimer_Tick);
			// 
			// userInfoToolStripMenuItem
			// 
			this.userInfoToolStripMenuItem.Name = "userInfoToolStripMenuItem";
			this.userInfoToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
			this.userInfoToolStripMenuItem.Text = "User Info";
			this.userInfoToolStripMenuItem.Click += new System.EventHandler(this.userInfoToolStripMenuItem_Click);
			// 
			// LibraryForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(552, 246);
			this.Controls.Add(this.DateBox);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.textBox1);
			this.Controls.Add(this.groupBox1);
			this.Controls.Add(this.LibraryListBox);
			this.Controls.Add(this.menuStrip1);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MainMenuStrip = this.menuStrip1;
			this.MaximumSize = new System.Drawing.Size(852, 426);
			this.Name = "LibraryForm";
			this.RightToLeftLayout = true;
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Tag = "";
			this.Text = "Library Manager";
			this.Load += new System.EventHandler(this.LibraryForm_Load);
			this.menuStrip1.ResumeLayout(false);
			this.menuStrip1.PerformLayout();
			this.groupBox1.ResumeLayout(false);
			this.groupBox1.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.ListBox LibraryListBox;
		private System.Windows.Forms.MenuStrip menuStrip1;
		private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem createNewLibraryToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem openExistingLibraryToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem saveCurrentLibraryToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem addABookToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem changeThisBookToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem deleteThisBookToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.TextBox textBox1;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.TextBox PriceBox;
		private System.Windows.Forms.TextBox AuthorBox;
		private System.Windows.Forms.TextBox TitleBox;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.TextBox DateBox;
		private System.Windows.Forms.Splitter splitter1;
		private System.Windows.Forms.ToolStripSeparator exitToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem1;
		private System.Windows.Forms.Timer SecondsTimer;
		private System.Windows.Forms.ToolStripMenuItem userInfoToolStripMenuItem;
	}
}

