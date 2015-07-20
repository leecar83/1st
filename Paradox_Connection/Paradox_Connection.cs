using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;
using System.Data;

namespace Paradox_Connector
{
	class Program
	{
		static void Main(string[] args)
		{
			string constring = @"Provider=Microsoft.Jet.OLEDB.4.0;Extended Properties=Paradox 7.x;Data Source=C:\Users\LEEBCARLA\Downloads\geog\;";
			OleDbConnection con = new OleDbConnection(constring);
			con.Open( );
			OleDbCommand cmd = new OleDbCommand("SELECT * FROM County", con);
			OleDbDataAdapter adap = new OleDbDataAdapter(cmd);
			DataTable dt = new DataTable( );
			adap.Fill(dt);

			dt = GetDistinctRecords(dt);
			// ... Loop over all rows.
			foreach (DataRow row in dt.Rows)
			{
				// ... Write value of first field as integer.
				Console.WriteLine(row.Field<string>(0));
				con.Close( );
			}
			Console.ReadLine( );
		}
			public static DataTable GetDistinctRecords(DataTable DTwithDuplicateValues)   
			{       
				DataTable DT = new DataTable();       
				DataView dv = DTwithDuplicateValues.DefaultView;    
				//List the column names whose values are to be distinct
				string[] Columns = { "County_Name" };  
				DT = dv.ToTable(true, Columns);     
				return DT;   
			}
		
	}
	
}

