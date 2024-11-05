<?php
$connect = mysqli_connect("localhost", "root", "", "database");
$output = '';
if(isset($_POST["query"]))
{
	$search = mysqli_real_escape_string($connect, $_POST["query"]);
	$query = "
	SELECT * FROM event
	WHERE eventName LIKE '%".$search."%'
	OR Electurer LIKE '%".$search."%' 
	";
}
else
{
	$query = "
	SELECT * FROM event ORDER BY eID";
}
$result = mysqli_query($connect, $query);
if(mysqli_num_rows($result) > 0)
{
	$output .= '<div class="table-responsive">
					<table class="table table bordered">
						<tr>
							<th>Event Name</th>
							<th>Lecturer</th>
							<th>Time</th>
							<th>Date</th>
							<th>Price</th>
						</tr>';
	while($row = mysqli_fetch_array($result))
	{
		$output .= '
			<tr>
				<td>'.$row["eventName"].'</td>
				<td>'.$row["Electurer"].'</td>
				<td>'.$row["Etime"].'</td>
				<td>'.$row["Edate"].'</td>
				<td>'.$row["Eprice"].'</td>
			</tr>
		';
	}
	echo $output;
}
else
{
	echo 'Data Not Found';
}
?>