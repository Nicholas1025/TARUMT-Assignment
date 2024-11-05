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
        $Name = $_POST['Name'];
        $StdId = $_POST['StdId'];
        $event = $_POST['event'];
        $uID = intval($_GET['uID']);

        $query = mysqli_query($con, "update booking set Name='$Name',StdId='$StdId',event='$event'");
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
            $ret = mysqli_query($con, "select * from booking where ID='" . $_GET['uID'] . "'");
            while ($row = mysqli_fetch_array($ret)) {
                ?>



                <section id="main-content">
                    <section class="wrapper">


                        <div class="w3-container w3-black w3-padding-64 w3-large w3-center ">
                            <h3><i class="fa fa-angle-right"></i> <?php echo $row['Name']; ?>'s Information</h3>



                            <div class="col-md-12">
                                <div class="content-panel">
                                    <p align="center" style="color:#F00;"><?php echo $_SESSION['msg']; ?><?php echo $_SESSION['msg'] = ""; ?></p>
                                    <form class="form-horizontal style-form" name="form1" method="post" action="" onSubmit="return valid();">
                                        <p style="color:#F00"><?php echo $_SESSION['msg']; ?><?php echo $_SESSION['msg'] = ""; ?></p>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label" style="padding-left:40px;">Event </label>
                                            <div class="l">
                                                <label>Name</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="Name" value="<?php echo $row['Name']; ?>" >
                                            </div>
                                            <div class="l">
                                                <label>Student ID</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="StdId" value="<?php echo $row['StdId']; ?>" >
                                            </div> 
                                            <div class="l">
                                                <label for="Etime">Event</label>
                                            </div>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="event" value="<?php echo $row['event']; ?>" >
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