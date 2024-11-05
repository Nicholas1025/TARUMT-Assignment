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
    if (isset($_GET['eventName'])) {
        $adminid = $_GET['eventName'];
        $query = "DELETE FROM EVENT WHERE EVENTNAME = '$adminid'";
        $msg = mysqli_query($con, $query);
        if ($msg) {
            echo "<script>alert('Data deleted');</script>";
        }
    }
    ?><!DOCTYPE html>
    <div class="w3-container w3-pale-red w3-padding-64 w3-large" id="about">
        <div class="w3-content">
            <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">View Event</h1>
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
                        <th class="hidden-phone">Event Name</th>
                        <th>Cooking Lecturer</th>
                        <th>Time</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $ret = mysqli_query($con, "select * from event");
                    $cnt = 1;
                    while ($row = mysqli_fetch_array($ret)) {
                        ?>
                        <tr>
                            <td><?php echo $cnt; ?></td>
                            <td><?php echo $row['eventName']; ?></td>
                            <td><?php echo $row['Electurer']; ?></td>
                            <td><?php echo $row['Etime']; ?></td>
                            <td><?php echo $row['Edate']; ?></td>  
                            <td><?php echo $row['Eprice']; ?></td>  
                            <td>

                                <a href="update-profile.php?uID=<?php echo $row['eID']; ?>"> 
                                    <button class="btn btn-danger btn-xs""><i class="fa fa-pencil"></i></button></a>
                                <a href="index.php?eventName=<?php echo $row['eventName']; ?>"> 
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
