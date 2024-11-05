
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
    if (isset($_GET['id'])) {
        $adminid = $_GET['id'];
        $msg = mysqli_query($con, "delete from users where id='$adminid'");
        if ($msg) {
            echo "<script>alert('Data deleted');</script>";
        }
    }
    ?><!DOCTYPE html>



    <div class="w3-container w3-black w3-padding-64 w3-large w3-center">
        <table class="w3-table">


            <hr>
            <thead>
                <tr>
                    <th>No.</th>
                    <th class="hidden-phone">First Name</th>
                    <th> Last Name</th>
                    <th> Email Id</th>
                    <th>Contact no.</th>
                    <th>Reg. Date</th>
                </tr>
            </thead>
            <tbody>
                <?php
                $ret = mysqli_query($con, "select * from users");
                $cnt = 1;
                while ($row = mysqli_fetch_array($ret)) {
                    ?>
                    <tr>
                        <td><?php echo $cnt; ?></td>
                        <td><?php echo $row['fname']; ?></td>
                        <td><?php echo $row['lname']; ?></td>
                        <td><?php echo $row['email']; ?></td>
                        <td><?php echo $row['contactno']; ?></td>  <td><?php echo $row['posting_date']; ?></td>

                    </tr>
                    <?php
                    $cnt = $cnt + 1;
                }
                ?>
            </tbody>
        </table>
    </div>
<?php } ?>

<br><br>
<?php
include 'footer.html';
?>