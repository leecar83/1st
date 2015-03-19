<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta content="en-us" http-equiv="Content-Language" />
<title>Add Event Processor</title>
<meta name="author" content="Lee Miller" />
<meta name="description" content="HW6" />
<style type="text/css">
body {
	font-size: 16px;
	margin-left: 10px;
}
dt {
	font-size: 20px;
	margin-bottom: 4px;
	font-weight: bold
}
dl {
	margin-left: 10px;
	margin-bottom: 4px;
}
dd {
	margin-left: 15px;
	margin-bottom: 10px;
}
span.desc {
	margin-left: 30px;
	margin-top: 4px;
}
a:hover {
COLOR: red;
}
a:active {
COLOR: black;
}
</style>
</head>
<body>
<h1>Validation results</h1>
<?php
	if($_SERVER['REQUEST_METHOD'] != 'POST')
	{
		echo "<p>&nbsp;&nbsp;Request was not POST!</p>";
		echo "<p>&nbsp;&nbsp;&nbsp;<a href=\"hw5.html\">Return to Form</a></p>";
		echo "</body></html>";
		die();
	}
	
	try
	{
		$dbconnection = new PDO(
		'mysql:host=localhost;dbname=zlbm13', 
		'zlbm13', 
		'4955');

		$dbconnection->setAttribute(PDO::ATTR_ERRMODE,
			PDO::ERRMODE_EXCEPTION);
	}
	catch(PDOException $Ex)
	{
		echo "<p>&nbsp;&nbsp;Database Connection Error!</p>";
		echo "<p>&nbsp;&nbsp;&nbsp;<a href=\"add.html\">Return to Form</a></p>";
		echo "</body></html>";
		die();		
	}
	$errors = 0;
?>
	<dl>
		<dt>Event Name</dt>
			<dd>
<?php	
	if(!isset($_POST['Name']))
	{
		echo "<span class=\"desc\">-No Valid Data</span><br />";
		$errors++;
	}
	else
	{
		$name = $_POST['Name']; 
		$name = trim($name);
		if(strlen($name) == 0 || strlen($name) < 3 || strlen($name) > 128)
		{
			echo "<span class=\"desc\">-No Valid Data</span><br />";
			$errors++;
		}
		else
		{
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . $name . "</span><br />";
		}
	}
	?>		
			</dd>
		<dt>Event Date</dt>
			<dd>
<?php			
	if(!isset($_POST['Date']))
	{
		echo "<span class=\"desc\">-No Valid Date</span><br />";
		$errors++;
	}
	else
	{
		$date = $_POST['Date']; 
		$date = trim($date);
		date_default_timezone_set('America/New_York');	//set timezone
		
		//regular expression obtained from http://www.devnetwork.net/viewtopic.php?f=29&t=13795
		if(preg_match('/^(0[1-9]|1[0-2])\/(0[1-9]|[1-2][0-9]|3[0-1])\/[0-9]{4}$/',$_POST['Date']) != 1)
		{
			echo "<span class=\"desc\">-No Valid Date</span><br />";
			$errors++;
		}
		else
		{
			$date_array = explode("/",$date);	//split $date_input into an array
	
			//set the variables to the values in the date array
			$m = $date_array[0];
			$d = $date_array[1];
			$Y = $date_array[2];
	
			//check to see if date is valid
			if(checkdate($m,$d,$Y) === false)
			{
				echo "<span class=\"desc\">-No Valid Date</span><br />";
				$errors++;
			}
			else	//echo date if good
			{
				$date = $Y . '-' . $m . '-' . $d;
				
				echo "<span class=\"desc\">-Valid Data</span><br />";
				echo "Value:<br />";
				echo "<span class=\"desc\">" . htmlspecialchars($date) . "</span><br />";
			}		
		}	
	}
	?>					
			</dd>
		<dt>Event Location</dt>
			<dd>
<?php
	if(!isset($_POST['Location']))
	{
		echo "<span class=\"desc\">-No Valid Data</span><br />";
		$errors++;
	}
	else
	{
		$location = $_POST['Location']; 
		$location = trim($location);
		if(strlen($location) == 0)
		{
			echo "<span class=\"desc\">-No Valid Data</span><br />";
			$errors++;
		}
		else
		{
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($location) . "</span><br />";
		} 
	}
	?>		
			</dd>
		<dt>Availability Status</dt>
			<dd>
<?php
	if(!isset($_POST['Availability']))
	{
		echo "<span class=\"desc\">-No Data Available</span><br />";
		$errors++;
	}
	else
	{
		$availability = $_POST['Availability']; 
		$availability = trim($availability);

		switch ($availability) {
			case 'Available':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($availability) . "</span><br />";
			break;
			case 'Tentative':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($availability) . "</span><br />";
			break;
			case 'Busy':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($availability) . "</span><br />";
			break;
			case 'Unknown':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($availability) . "</span><br />";
			break;
			default:		
			echo "<span class=\"desc\">-No Data Available</span><br />";
		}
	}
?>					
			</dd>
		<dt>Event Category</dt>
			<dd>
<?php
	if(!isset($_POST['Category']))
	{
		echo "<span class=\"desc\">-No Data Available</span><br />";
		$errors++;
	}
	else
	{
		$category = $_POST['Category']; 
		$category = trim($category);

		switch ($category) {
			case 'Home':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($category) . "</span><br />";
			break;
			case 'Work':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($category) . "</span><br />";
			break;
			case 'School':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($category) . "</span><br />";
			break;
			case 'Friends':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($category) . "</span><br />";
			break;
			case 'Other':
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($category) . "</span><br />";	
			break;
			default:
			echo "<span class=\"desc\">-No Data Available</span><br />";			
		}
	}
?>								
			</dd>
		<dt>Event Description</dt>
			<dd>
<?php
	if(!isset($_POST['Description']))
	{
		echo "<span class=\"desc\">-No Valid Data</span><br />";
		$errors++;
	}
	else
	{
		$description = $_POST['Description']; 
		$description = trim($description);
		if(strlen($description) == 0)
		{
			echo "<span class=\"desc\">-No Valid Data</span><br />";
			$errors++;
		}
		else
		{
			echo "<span class=\"desc\">-Valid Data</span><br />";
			echo "Value:<br />";
			echo "<span class=\"desc\">" . htmlspecialchars($description) . "</span><br />";
		} 
	}
	
	if($errors === 0)
	{
		$results = $dbconnection->prepare(
			"INSERT into event (name, date_, location, avail_status, category, description)
			VALUES (:value1, :value2, :value3, :value4, :value5, :value6)");
		$results -> execute(array(
			'value1' => htmlspecialchars($name),
			'value2' => htmlspecialchars($date),
			'value3' => htmlspecialchars($location),
			'value4' => htmlspecialchars($availability),
			'value5' => htmlspecialchars($category),
			'value6' => htmlspecialchars($description)
		));
	
		echo "<script>top.location = \"view.php?" . http_build_query(array('date' =>htmlspecialchars($date))) . "\"</script>";
	}
	
	
	?>					
			</dd>
	</dl>
	<p>&nbsp;&nbsp;&nbsp;<a href="add.html">Return to Form</a></p>

</body>
</html>