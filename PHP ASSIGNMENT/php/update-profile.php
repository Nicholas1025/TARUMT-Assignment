<?php
include 'headerStaff2.html';
?>
<?php
session_start();
include'dbconnection.php';
//Checking session is valid or not
if (strlen($_SESSION['id'] == 0)) {
    header('location:logout.php');
} else {

// for updating user info    
    if (isset($_POST['Submit'])) {
        $eventName = $_POST['eventName'];
        $Electurer = $_POST['Electurer'];
        $Etime = $_POST['Etime'];
        $Edate = $_POST['Edate'];
        $Eprice = $_POST['Eprice'];
        $uID = intval($_GET['uID']);

        $query = mysqli_query($con, "update event set eventName='$eventName',Electurer='$Electurer',Etime='$Etime',Edate='$Edate',Eprice='$Eprice' where eID='$uID' ");
        $_SESSION['msg'] = "Profile Updated successfully";
    }
    ?>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="">
            <meta name="author" content="Dashboard">
            <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

            <title>Admin | Update Profile</title>
            <link href="assets/css/bootstrap.css" rel="stylesheet">
            <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
            <link href="assets/css/style.css" rel="stylesheet">
            <link href="assets/css/style-responsive.css" rel="stylesheet">
        </head>

        <body>

            <?php
            $ret = mysqli_query($con, "select * from event where eID='" . $_GET['uID'] . "'");
            while ($row = mysqli_fetch_array($ret)) {
                ?>



                <section id="main-content">
                    <section class="wrapper">


                        <div class="w3-container w3-black w3-padding-64 w3-large w3-center ">
                            <h3><i class="fa fa-angle-right"></i> <?php echo $row['eventName']; ?>'s Information</h3>



                            <div class="col-md-12">
                                <div class="content-panel">
                                    
                                    <form class="form-horizontal style-form" name="form1" method="post" action="" onSubmit="return valid();">
                                        <p style="color:#F00"><?php echo $_SESSION['msg']; ?><?php echo $_SESSION['msg'] = ""; ?></p>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label" style="padding-left:40px;">Event </label>
                                            <div class="l">
                                                <label>Event Name</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="eventName" value="<?php echo $row['eventName']; ?>" >
                                            </div>
                                            <div class="l">
                                                <label>Lecturer</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="Electurer" value="<?php echo $row['Electurer']; ?>" >
                                            </div> 
                                            <div class="l">
                                                <label for="Etime">Event time</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="time" class="form-control" name="Etime" value="<?php echo $row['Etime']; ?>" >
                                            </div> 
                                            <div class="l">
                                                <label>Event date</label>5
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="date" class="form-control" name="Edate" value="<?php echo $row['Edate']; ?>" >
                                            </div> 
                                            <div class="l">
                                                <label>Price</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="Eprice" value="<?php echo $row['Eprice']; ?>" >
                                            </div>   

                                        </div>


                                        <div style="margin-left:100px;">
                                            <input type="submit" name="Submit" value="Update" class="btn btn-theme"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </section>
                <?php } ?>
            </section></section>
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="assets/js/common-scripts.js"></script>
        <script>
                                    $(function () {
                                        $('select.styled').customSelect();
                                    });

        </script>

    </body>
    </html>
<?php } ?>
<?php
include 'footer.html';
?>