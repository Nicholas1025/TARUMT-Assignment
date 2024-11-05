
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


    ?><!DOCTYPE html>



    <div class="w3-container w3-black w3-padding-64 w3-large w3-center">
        <table class="w3-table">


            <hr>
            <thead>
                <tr>
                    <th>No.</th>
                    <th class="hidden-phone">name</th>
                    <th> email</th>
                    <th> comments</th>
                    
                </tr>
            </thead>
            <tbody>
                <?php
                $ret = mysqli_query($con, "select * from feedback");
                $cnt = 1;
                while ($row = mysqli_fetch_array($ret)) {
                    ?>
                    <tr>
                        <td><?php echo $cnt; ?></td>
                        <td><?php echo $row['name']; ?></td>
                        <td><?php echo $row['email']; ?></td>
                        <td><?php echo $row['comments']; ?></td>
                        

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