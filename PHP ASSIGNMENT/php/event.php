<?php
include 'header.html';
?> 
<?php
session_start();
include'dbconnection.php';
// checking session is valid for not 
if (strlen($_SESSION['id'] == 0)) {
    header('location:logout.php');
} else {
    ?><!DOCTYPE html>
    <div class="w3-container w3-black w3-padding-64 w3-large" id="about">
        <div class="w3-content">
            <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">Event</h1>
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


                        </tr>
        <?php
        $cnt = $cnt + 1;
    }
    ?>

                </tbody>
            </table>

            <h2>Our Location!</h2>
            <div class="map">
                <iframe src="https://maps.google.com/maps?q=tarc%20segamat&t=&z=13&ie=UTF8&iwloc=&output=embed" width="1000px" height="700px"></iframe>
            </div>
            <p><a href="loginParticipant.php" class="w3-button w3-xxlarge w3-black">Book now</a></p>
        </div>
        <h1><b> </b></h1>


        <div class="w3-row">
            <div class="w3-col s6">
                <p>  </p>
                <p>  </p>
                <p>  </p>
            </div>
            <div class="w3-col s6">
                <p>  </p>
                <p></p>

            </div>
        </div>


    </div>

    </div>
    </div>


<?php } ?>
<?php
include 'footer.html';
?>
