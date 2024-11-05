<?php

include 'headerParticipant.html';
?>
<?php
//including the database connection file
        include_once('dbconnection.php');

        if (isset($_POST['booking'])) {
            $ID = $_POST['ID'];
            $Name = $_POST['Name'];
            $StdId = $_POST['StdId'];
            $event = $_POST['event'];
            if (empty($Name) || empty($StdId) || empty($event) ) {
                
                if (empty($Name)) {
                    echo "<font color='red'>Lecturer is empty.</font><br/>";
                }

                if (empty($StdId)) {
                    echo "<font color='red'>Time is empty.</font><br/>";
                }

                if (empty($event)) {
                    echo "<font color='red'>Date is empty.</font><br/>";
                }


                //link to the previous page
                echo "<br/><a href='javascript:self.history.back();'>Go Back</a>";
            } else {
                // if all the fields are filled (not empty)             
                //insert data to database
                $result = mysqli_query($con, "INSERT INTO booking(Name,StdId,event) "
                        . "VALUES('$Name','$StdId','$event')");

                //display success message
                echo "<font color='green'>Data added successfully.";
                echo "<br/><a href='index.php'>View Result</a>";
            }
        }


        // checking empty fields
        ?>
<style>
    *, *:before, *:after {
        box-sizing: inherit;
    }

    .column {
        float: ;
        width:100%;
        margin-bottom: 16px;
        padding: 0px 43%;
    }

    .card {
        padding: 35px 0;
        text-align: center;
    }


</style>
<!-- About Container -->
 <div class="w3-container w3-black w3-padding-64 w3-large w3-center ">
            <center>
                <h2>Booking</h2>

                <form name="booking" method="post" action="" enctype="multipart/form-data">

                    <div class="form-group">

                        <div class="l">
                            <label>Name</label>
                        </div>

                        <input type="text" name="Name" class="form-control" value="" required>
                        <span class="help-block"></span>


                        <div class="l">
                            <label>Student ID</label>
                        </div>
                        
                        <input type="text" name="StdId" class="form-control" value="" required>
                        <span class="help-block"></span>

                        <div class="l">
                            <label>Event</label>
                        </div>

                        <select name="event" id="event" lass="form-control" value="" required >
                          <option value="Garlic Soup">Garlic Soup</option>
                          <option value="Garlic Beef">Garlic Beef</option>
                          <option value="Curry Soup ">Curry Soup</option>
                          <option value="Garlic Mee">Garlic Mee</option>
                        </select>
                        
                        <div class="sub">
                            <input type="submit" class="btn btn-primary" onClick="return confirm('Do you really want to book?');" name="booking" value="Sign Up">
                        </div>

                    </div>

                </form>
            </center>
        </div>

<br>

<?php

include 'footer.html';
?>