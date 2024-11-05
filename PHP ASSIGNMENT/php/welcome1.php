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
include 'headerParticipant.html';
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
            <title>Welcome</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
                <style type="text/css">

                    body{
                        background-image: url("");
                        background-size:1600px;
                        background-repeat:no-repeat;

                    }

                    body{text-align: center; }
                </style>
            </link>
        </meta>
    </head>
    <body>
        <div class="page-header">
            <br> </br>

            <br> </br>
            <br> </br>

            <h1>Hi,Welcome to participant site.</h1>
        </div>
    <html xmlns="http://www.w3.org/1999/xhtml">

            <div id="footer">
                <p>
                    <a href="homepage.php" class="btn btn-danger">Sign Out of Your Account</a>
                </p>
            </div>
        </html>

        <img src="ParticipantBg.png" style="width:100%">
    </body>
</html>
<?php
include 'footer.html';
?>