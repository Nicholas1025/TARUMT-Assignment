<?php
session_start();
require_once('dbconnection.php');

// Code for login 
if (isset($_POST['login'])) {
    $password = $_POST['password'];
    $dec_password = $password;
    $useremail = $_POST['uemail'];
    $ret = mysqli_query($con, "SELECT * FROM users WHERE email='$useremail' and password='$dec_password'");
    $num = mysqli_fetch_array($ret);
    if ($num > 0) {
        $extra = "welcome1.php";
        $_SESSION['login'] = $_POST['uemail'];
        $_SESSION['id'] = $num['id'];
        $_SESSION['name'] = $num['fname'];
        $host = $_SERVER['HTTP_HOST'];
        $uri = rtrim(dirname($_SERVER['PHP_SELF']), '/\\');
        header("location:http://$host$uri/$extra");
        exit();
    } else {
        echo "<script>alert('Invalid username or password');</script>";
        $extra = "index.php";
        $host = $_SERVER['HTTP_HOST'];
        $uri = rtrim(dirname($_SERVER['PHP_SELF']), '/\\');
//header("location:http://$host$uri/$extra");
        exit();
    }
}

//Code for Forgot Password
?>
<?php
include 'header.html';
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <style type="text/css">
            body{ font: 14px sans-serif;
                  background-color: black}
            .wrapper{ width: 350px; padding: 20px; }

        </style>
    </head>


    <center>
        <div class="wrapper w3-container w3-black" >
            <br><br><br><br>

            <h2> Participant Login</h2>
            <p>Please fill in your information to login.</p>
            <form name="login" action="" method="post">
                <p style="color:#F00; padding-top:20px;" align="center">
                <div class="login-wrap">
                    <input type="text" class="form-control" name="uemail" value="" placeholder="Enter your registered email"  ><a href="#" class=" icon email"></a>
                    <br>
                    <input type="password" value="" class="form-control" name="password" placeholder="Enter valid password"><a href="#" class="btn btn-theme btn-block"></a>
                    <input class="w3-grey w3-large" type="submit" name="login" value="LOG IN" >
                </div>
            </form>
        </div>
    </center>
</html>

<br></br><br><br><br><br>
<?php
include 'footer.html';
?>