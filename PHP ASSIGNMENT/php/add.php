
<html>
    <head>
        <title>Add Data</title>
        <style type="text/css">
            body{ 

                font: 14px sans-serif; 
            }

            .form-group{
                padding-bottom: 165px;
                width: 160px; 
                margin-right: 3vw ;
            }

            .sub{

                margin-left: 3vw;
                margin-top: 1vw;
            }

            .l{
               
                margin-left:3vw;
            }
            .b{    
                font-size: 20px;
                margin-left: 2.3vw;
            }

        </style>
    </head>

    <body>



        ?>
        <?php
        include 'headerStaff2.html';
        ?>
        <?php
//including the database connection file
        include_once('dbconnection.php');

        if (isset($_POST['addEvent'])) {
            $eID = $_POST['eID'];
            $eventName = $_POST['eventName'];
            $Electurer = $_POST['Electurer'];
            $Etime = $_POST['Etime'];
            $Edate = $_POST['Edate'];
            $Eprice = $_POST['Eprice'];
            if (empty($eventName) || empty($Electurer) || empty($Etime) || empty($Edate) || empty($Eprice)) {
                if (empty($eventName)) {
                    echo "<font color='red'>Name field is empty.</font><br/>";
                }

                if (empty($Electurer)) {
                    echo "<font color='red'>Lecturer is empty.</font><br/>";
                }

                if (empty($Etime)) {
                    echo "<font color='red'>Time is empty.</font><br/>";
                }

                if (empty($Edate)) {
                    echo "<font color='red'>Date is empty.</font><br/>";
                }

                if (empty($Eprice)) {
                    echo "<font color='red'>Price is empty.</font><br/>";
                }


                //link to the previous page
                echo "<br/><a href='javascript:self.history.back();'>Go Back</a>";
            } else {
                // if all the fields are filled (not empty)             
                //insert data to database
                $result = mysqli_query($con, "INSERT INTO event(eventName,Electurer,Etime,Edate,Eprice) "
                        . "VALUES('$eventName','$Electurer','$Etime','$Edate','$Eprice')");

                //display success message
                echo "<font color='green'>Data added successfully.";
                echo "<br/><a href='index.php'>View Result</a>";
            }
        }


        // checking empty fields
        ?>
    </body>

    <html>
        <head>
            <title>Add Data</title>
        </head>


        <!DOCTYPE html>
        <div class="w3-container w3-black w3-padding-64 w3-large w3-center ">
            <center>
                <h2>ADD EVENT</h2>

                <form name="addevent" method="post" action="" enctype="multipart/form-data">

                    <div class="form-group">

                        <div class="l">
                            <label>Event Name</label>
                        </div>

                        <input type="text" name="eventName" class="form-control" value="" required>
                        <span class="help-block"></span>


                        <div class="l">
                            <label>Lecturer</label>
                        </div>

                        <input type="text" name="Electurer" class="form-control" value="" required>
                        <span class="help-block"></span>


                        <form action="/action_page.php">
                            <div class="l">
                                <label for="Etime">Event time</label>
                            </div>
                            <div class="b">
                                <input type="time" name="Etime" class="form-control" value="" required>
                                <span class="help-block"></span>
                            </div>
                        </form>


                        <div class="l">
                            <label>Event date</label>       
                        </div>

                        <input type="date" name="Edate" class="form-control" value="" required>
                        <span class="help-block"></span>


                        <div class="l">
                            <label>Price</label>
                        </div>

                        <input type="text" name="Eprice" class="form-control" value="" required>
                        <span class="help-block"></span>

                        <div class="sub">
                            <input type="submit" class="btn btn-primary" onClick="return confirm('Do you really want to add');" name="addEvent" value="Submit">
                        </div>

                    </div>

                </form>
            </center>
        </div>
    </html>
</html>
<br><br><br><br><br><br><br><br>
<?php
include 'footer.html';
?>