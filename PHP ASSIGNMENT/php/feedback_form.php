<?php
include 'header.html';
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <title>Form Feedback</title>
        <style type="text/css">
            body{ font: 14px sans-serif;
                  background-image: url("ParticipantBg.jpg");}
            .wrapper{ width: 350px; padding: 20px; }

        </style>
    </head>

    <body>
        <center>
            <br></br><br></br>
            <?php
            //  feedback_form.php
// Create a shorthand for the form data:
            $username = $_POST['name'];
            $email = $_POST['email'];
            $comments = $_POST['comments'];

// Print the submitted information:
            echo "<p>Thank you, <b>$username</b>, for the following comments:<br />
              <tt>$comments</tt></p> ";

            print '</ul>';

            echo "<p>We will reply to you at <i>$email</i>.</p>\n";
            ?>
            <a href="feedback.php">[Exit]</a>

        </center>
    </body>

</html>

<?php
include 'footer.html';
?>
       
