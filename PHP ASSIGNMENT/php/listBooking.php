<?php
include 'headerStaff2.html';
?>

<?php
session_start();
include'dbconnection.php';
// checking session is valid for not 
if (strlen($_SESSION['id'] == 0)) {
    header('location:logout.php');
} else {

// for deleting user
    if (isset($_GET['Name'])) {
        $bookName = $_GET['Name'];
        $query = "DELETE FROM booking WHERE Name = '$bookName'";
        $msg = mysqli_query($con, $query);
        if ($msg) {
            echo "<script>alert('Data deleted');</script>";
        }
    }
    ?><!DOCTYPE html>
    <div class="w3-container w3-pale-red w3-padding-64 w3-large" id="about">
        <div class="w3-content">
            <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">Booking List</h1>
            <div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Search</span>
					<input type="text" name="search_text" id="search_text" placeholder="Search Event" class="form-control" />
				</div>
			</div>
            <table class="w3-table">

                <hr>
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Student ID</th>
                        <th>Event</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $ret = mysqli_query($con, "select * from booking");
                    $cnt = 1;
                    while ($row = mysqli_fetch_array($ret)) {
                        ?>
                        <tr>
                            <td><?php echo $cnt; ?></td>
                            <td><?php echo $row['Name']; ?></td>
                            <td><?php echo $row['StdId']; ?></td>
                            <td><?php echo $row['event']; ?></td>              
                            <td>

                                <a href="updated-booking.php?uID=<?php echo $row['ID']; ?>"> 
                                    <button class="btn btn-danger btn-xs""><i class="fa fa-pencil"></i></button></a>
                                <a href="listBooking.php?Name=<?php echo $row['Name']; ?>"> 
                                    <button class="btn btn-danger btn-xs" onClick="return confirm('Do you really want to delete');"><i class="fa fa-trash-o "></i></button></a>
                            </td>
                        </tr>
                        <?php
                        $cnt = $cnt + 1;
                    }
                    ?>
                </tbody>
            </table>
        </div>
    </div>
<?php } ?>

<br><br><br>
<?php
include 'footer.html';
?>
