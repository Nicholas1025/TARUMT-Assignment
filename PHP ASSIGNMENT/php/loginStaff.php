<?php
session_start();
require_once('dbconnection.php');
// Code for login 
if (isset($_POST['stafflogin'])) {
    $password = $_POST['password'];
    $dec_password = $password;
    $username = $_POST['username'];
    $ret = mysqli_query($con, "SELECT * FROM admin WHERE username='$username' and password='$dec_password'");
    $num = mysqli_fetch_array($ret);
    if ($num > 0) {
        $extra = "welcome.php";
        $_SESSION['stafflogin'] = $_POST['username'];
        $_SESSION['id'] = $num['id'];
        $host = $_SERVER['HTTP_HOST'];
        $uri = rtrim(dirname($_SERVER['PHP_SELF']), '/\\');
        header("location:http://$host$uri/$extra");
        exit();
    } else {
        echo "<script>alert('Invalid username or password');</script>";
        $extra = "index.php";
        $host = $_SERVER['HTTP_HOST'];
        $uri = rtrim(dirname($_SERVER['PHP_SELF']), '/\\');
        exit();
    }
}
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
    <body>
    <center>
        <div class="wrapper w3-container w3-black" >
            <br><br>
            <h2> Staff Login</h2>
            <p>Please fill in your information to login.</p>
            <form name="stafflogin"class="form-login" action="" method="post">

                <p style="color:#F00; padding-top:20px;" align="center">
                    <?php echo $_SESSION['action1']; ?><?php echo $_SESSION['action1'] = ""; ?></p>
                <div class="login-wrap">
                    <input type="text" name="username" class="form-control" placeholder="User ID" autofocus>
                    <br>
                    <input type="password" name="password" class="form-control" placeholder="Password"><br >
                    <input  name="stafflogin" class="w3-grey w3-large" type="submit">

                </div>
            </form>	
        </div> 
    </center>
</body>
</html>
<br></br><br><br><br><br>

<?php
include 'footer.html';
?>