<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta content="en-us" http-equiv="Content-Language" />
		<title>PHP Calendar</title>
		<meta name="author" content="Lee Miller" />
		<meta name="description" content="HW6" />
		<style type="text/css">
		h1 {
			font-size: xx-large;
			text-align: center;
		}
		h2 {
			font-size: large;
			text-align: center;
		}
		.center{
			text-align: center;
		}
		table {
			text-align: center;
			clip: rect(auto, auto, auto, auto);
			vertical-align: middle;
			font-size: medium;
			margin-right: auto;
			margin-left: auto;
			border: 1px solid #000000;
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
		a {
		text-decoration: none;
		}
		a:link {
		COLOR: black;
		}
		a:visited {
		COLOR: black;
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

	
	date_default_timezone_set('America/New_York');	//set timezone
	
	//if there is query string than set date to current
	if(!isset($_GET['d']))
	{
			$date = new DateTime();
			$date->setTimestamp(Time());
	}
	
	//if date is not in correct format than set date to current
	//regular expression obtained from http://www.devnetwork.net/viewtopic.php?f=29&t=13795
	elseif(preg_match('/^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/',$_GET['d']) != 1)
	{
		$date = new DateTime();
		$date->setTimestamp(Time());
	}
	
	else
	{
		$date_input	= $_GET['d'];
		//$date_input = INPUT_DATE;	//set input date constant to string
		$date_array = explode("-",$date_input);	//split $date_input into an array
	
		//set the variables to the values in the date array
		$m = $date_array[1];
		$d = $date_array[2];
		$Y = $date_array[0];
	
		//check to see if date is valid; set to current if bad input
		if(checkdate($m,$d,$Y) === false)
		{
			$date = new DateTime();
			$date->setTimestamp(Time());
		}
		else	//set $date to input if good
		{
			$date = DateTime::createFromFormat('Y-m-d', $date_input);	//create date object from the $date_input string
		}		
	}
	//set walk_date object to $date_input and move to first day of month
	$walk_date = DateTime::createFromFormat('Y-m-d', $date->format('Y-m-d'));
	$walk_date->modify('first day of this month');
	
	
	$change_date = DateTime::createFromFormat('Y-m-d', $date->format('Y-m-d'));
	//$change_date->modify('first day of this month');
	
	//move $walk_date to Sunday
	if($walk_date->format('w') != '0')
	{
		$walk_date->modify('-1 weekdays');
		$walk_date->modify('last sunday this month');
	}
	
	//set $last_day to last day in month
	$last_date = DateTime::createFromFormat('Y-m-d', $date->format('Y-m-d'));
	$last_date->modify('last day of this month');

	function submonth($month)
	{
		$prev_month = DateTime::createFromFormat('Y-m-d',$month->format('Y-m-d'));
		$prev_month->sub(new DateInterval('P1M'));
		if($prev_month->format('m') == $month->format('m'))
		{
			
			$prev_month->sub(new DateInterval('P1M'));
			$prev_month->modify('last day of this month');
			
		}
		return $prev_month->format('Y-m-d');
	}
	
	function addmonth($month)
	{
		$prev_month = DateTime::createFromFormat('Y-m-d',$month->format('Y-m-d'));
		
		if ($month->format('d') == 31)
		{ 
			$prev_month->add(new DateInterval('P1D'));
			$prev_month->modify('last day of this month');
		}
		else
		{
			$prev_month->add(new DateInterval('P1M'));
		}
		return $prev_month->format('Y-m-d');
	}
	
	function subyear($month)
	{
		$prev_month = DateTime::createFromFormat('Y-m-d',$month->format('Y-m-d'));
		$prev_month->sub(new DateInterval('P1Y'));
		return $prev_month->format('Y-m-d');
	}
	
	function addyear($month)
	{
		$prev_month = DateTime::createFromFormat('Y-m-d',$month->format('Y-m-d'));
		$prev_month->add(new DateInterval('P1Y'));
		if($prev_month->format('m') != $month->format('m'))
		{
			$prev_month->sub(new DateInterval('P1M'));
			$prev_month->modify('last day of this month');	
		}
		return $prev_month->format('Y-m-d');
	}
	

?>	
	<h1><?php echo "<span><a href=\"index.php?";
		echo http_build_query(array('d' =>subyear($change_date)));
		echo "\">&lt;&lt;</a></span>&nbsp;&nbsp;&nbsp;\n";
		echo "<a href=\"index.php?";
		echo http_build_query(array('d' =>submonth($change_date)));
		echo "\">&lt;</a><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n";
		echo $date->format('F Y');
		echo "<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n<a href=\"index.php?";
		echo http_build_query(array('d' =>addmonth($change_date)));
		echo "\">&gt;</a></span><span>&nbsp;&nbsp;&nbsp;\n";
		echo "<a href=\"index.php?";
		echo http_build_query(array('d' =>addyear($change_date)));
		echo "\">&gt;&gt;</a></span></h1>\n";
		
		?>
	<table style="width: 60%">
	<tr>
		<td class="black">Sun</td>
		<td class="black">Mon</td>
		<td class="black">Tue</td>
		<td class="black">Wed</td>
		<td class="black">Thu</td>
		<td class="black">Fri</td>
		<td class="black">Sat</td>
	</tr>
<?php	
	do
	{
		echo "<tr>";
		for($i = 1; $i < 8; $i++)	//move through the calendar a week at a time
		{
			if($walk_date->format('m') != $date->format('m')){	//if day is not in the current month gray it out
				echo "<td class=\"graybackground\">";
				echo "<a href=\"view.php?";
				echo http_build_query(array('d' =>$walk_date->format('Y-m-d')));
				echo "\">";
				echo $walk_date->format('j');
				echo "</a>";
				echo "</td>\n";
			}
			else if($walk_date->format('j') == $date->format('j')){	//if day is the inputted date border it in red
				echo "<td class=\"redborder\">";
				echo "<a href=\"view.php?";
				echo http_build_query(array('d' =>$walk_date->format('Y-m-d')));
				echo "\">";
				echo $walk_date->format('j');
				echo "</a>";
				echo "</td>\n";
			}
			else{	//any other day in the month
				echo "<td class=\"thinborder\">";
				echo "<a href=\"view.php?";
				echo http_build_query(array('d' =>$walk_date->format('Y-m-d')));
				echo "\">";
				echo $walk_date->format('j');
				echo "</a>";
				echo "</td>\n";
			}
			$walk_date->modify('+1 day');	//move to next day
		}
		echo "</tr>";	//move to next column of weeks
	}
	while((int)date_timestamp_get($walk_date) <= (int)date_timestamp_get($last_date));	//continue until $walk_date is in next month
?>
	</table> 
	<p class = "center">&nbsp;&nbsp;&nbsp;<a href="add.html">Add New Event</a></p>
</body>
</html>