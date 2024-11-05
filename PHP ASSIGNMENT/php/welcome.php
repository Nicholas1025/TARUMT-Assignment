<?php
// Initialize the session
session_start();

//// Check if the user is logged in, if not then redirect him to login page
//if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
//    header("location: login.php");
//    exit;
//}
?>
<?php
include 'headerStaff2.html';
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <style type="text/css">

            body{

                background-image: url("ParticipantBg.png");
                background-size:2500px;
                background-repeat:no-repeat;

            }

            body{text-align: center; }
        </style>
    </head>
    <body>

        <div class="w3-display-middle w3-center">
            <span class="w3-text-white w3-hide-small" style="font-size:50px"><b>

                </b>Welcome to staff site.</h1>
            </span>         
            <a href="login.php" class="w3-button w3-black">Log out</a>
        </div>
    </body> 
</html>



