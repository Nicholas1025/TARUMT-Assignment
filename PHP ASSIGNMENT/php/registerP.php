<?php
include 'header.html';
session_start();
require_once('dbconnection.php');

//Code for Registration 
if (isset($_POST['signup'])) {
    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $contact = $_POST['contact'];
    $enc_password = $password;
    $sql = mysqli_query($con, "select id from users where email='$email'");
    $row = mysqli_num_rows($sql);
    if ($row > 0) {
        echo "<script>alert('Email id already exist with another account. Please try with other email id');</script>";
    } else {
        $msg = mysqli_query($con, "insert into users(fname,lname,email,password,contactno) values('$fname','$lname','$email','$enc_password','$contact')");

        if ($msg) {
            echo "<script>alert('Register successfully');</script>";
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <style type="text/css">
            body{ font: 14px sans-serif;
                  background-color: black}
            .wrapper{ width: 350px; padding: 20px; }
        </style>
    </head>
   
    <center>
        <div class="wrapper w3-container w3-black" >
            <br><br>
            <h2>Sign Up</h2>
            <p>Please fill this form to create an account.</p>
            <form name="registration" method="post" action="" enctype="multipart/form-data">
                <div class="form-group ">
                    <label>First Name</label>
                    <input type="text" name="fname" class="form-control" value="" required>
                    <span class="help-block"></span>
                    <div class="form-group ">

                        <label>Last Name</label>
                        <input type="text" name="lname" class="form-control" value="" required>
                        <span class="help-block"></span>


                        <div class="form-group ">
                            <label>Email Address</label>
                            <input type="text" name="email" class="form-control" value="" required>
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group ">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" value="" required>
                            <span class="help-block"></span>
                        </div>    
                        <div class="form-group ">
                            <label>Contact No.</label>
                            <input type="text" name="contact" class="form-control" value="" required>
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" name="signup" value="Sign Up">
                            <input type="reset" class="btn btn-default" value="Reset">
                        </div>
                        <p>Already have an account? <a href="loginParticipant.php">Login here</a>.</p>

                    </div>
                </div>
            </form>
        </div>
    </center>
</html>
<br><br><br><br><br>
<?php
include 'footer.html';
?>