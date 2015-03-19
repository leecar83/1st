<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta content="en-us" http-equiv="Content-Language" />
		<title>Events</title>
		<meta name="author" content="Lee Miller" />
		<meta name="description" content="HW6" />
		<style type="text/css">
		.xxl{
			font-size: xx-large;
			text-align: center;
		}
		.l{
			font-size: large;
			text-align: center;
		}
		.bottomthin{
			border-bottom-style: solid;
			border-bottom-width: thin;
		}
		.bottom{
			border-bottom-style: solid;
		}
		.center{
			text-align: center;
		}
		.left{
			text-align: left;
		}
		table {
			text-align: center;
			clip: rect(auto, auto, auto, auto);
			vertical-align: middle;
			font-size: medium;
			margin-right: auto;
			margin-left: auto;
			table-layout: fixed;
		}
		.redborder {
			border: thin solid #FF0000;
			background-color: #FFB9BB;

		}
		.graybackground {
			background-color: #E2E2E2;
			border: 1px solid #000000;
		}
		.black {
			border-bottom-style: solid;
			border-bottom-color: #000000;
			background-color: #0099FF
		}
		.thinborder {
			border: 1px solid #000000;
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

<?php
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
		echo "<p>&nbsp;&nbsp;&nbsp;<a href=\"index.html\">Return to Calendar</a></p>";
		echo "</body></html>";
		die();	
	}

	
	if(!isset($_GET['d']))
	{
		echo "<p>&nbsp;&nbsp;No data Sent!</p>";
		echo "<p>&nbsp;&nbsp;&nbsp;<a href=\"index.html\">Return to Calendar</a></p>";
		echo "</body></html>";
		die();	
	}

		$date = $_GET['d']; 
		$date = trim($date);
		date_default_timezone_set('America/New_York');	//set timezone
		
		//regular expression obtained from http://www.devnetwork.net/viewtopic.php?f=29&t=13795
		if(preg_match('/^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/',$_GET['d']) != 1)
		{
			echo "<script>top.location = \"index.php\"</script>";
		}
		else
		{
			$date_array = explode("-",$date);	//split $date_input into an array
	
			//set the variables to the values in the date array
			$m = $date_array[1];
			$d = $date_array[2];
			$Y = $date_array[0];
	
			//check to see if date is valid
			if(checkdate($m,$d,$Y) === false)
			{
				echo "<script>top.location = \"index.php\"</script>";
			}
		}	
	
	
	
	
	$results = $dbconnection->prepare(
    "select * from event where date_ = :date");
	$results->execute(array(
		'date' => $_GET['d']
	));

	date_default_timezone_set('America/New_York');	//set timezone
	$date_holder = DateTime::createFromFormat('Y-m-d', $_GET['d']);	//create date object from the $date_input string

echo "<table style=\"width: 30%\">";
echo "<caption style=\"xxl\">Events on " . $date_holder->format('F') . " " . $date_holder->format('d'). ", " . $date_holder->format('Y') . "</caption>";
?>
     <thead>
        <tr>
            <th class="bottom">Name</th>
            <th class="bottom">Location</th>
            <th class="bottom">Availability</th>
            <th class="bottom">Category</th>
        </tr>
    </thead>
	
	<tbody>
<?php
	foreach($results as $row)
	{
		echo "<tr>" . 
		"<td>" . htmlspecialchars("$row[name]") . "</td>\n" .
		"<td>" . htmlspecialchars("$row[location]") . "</td>\n" .
		"<td>" . htmlspecialchars("$row[avail_status]") . "</td>\n" .
		"<td>" . htmlspecialchars("$row[category]") . "</td>\n</tr>\n" .
		"<tr><td class=\"left\" colspan=\"4\">Description: "  . htmlspecialchars("$row[description]") . "</td></tr><tr><td>&nbsp;</td></tr>";
	}
?>
	</tbody>
</table>
<?php
echo "<p class=\"center\"><a href=\"index.php?" . http_build_query(array('d' =>$date_holder->format('Y-m-d'))) . "\">Return to Calendar</a></p>"; ?>
</body>
</html>