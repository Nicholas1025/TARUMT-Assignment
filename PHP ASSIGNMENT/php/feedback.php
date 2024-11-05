<?php
include 'header.html';
session_start();
require_once('dbconnection.php');
//Code for Registration 
if (isset($_POST['feedback'])) {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $comments = $_POST['comments'];
    $sql = mysqli_query($con, "select id from feedback where email='$email'");
    $row = mysqli_num_rows($sql);
    
        $msg = mysqli_query($con, "insert into feedback(name,email,comments) values('$name','$email','$comments')");

        if ($msg) {
            echo "<script>alert('Feedback Uploaded!! Wei Yik Love You');</script>";
        }
    }

?>


<!-- Contact -->
<div class="w3-container w3-padding-64 w3-black w3-grayscale-min w3-xlarge">
    <div class="w3-content">
        <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">Feedback</h1>
        <p>Find us at some address at some place or call us at 07-1233399</p>
        <p>We offer full-service catering for any event, large or small. We
            understand your needs and we will cater the food to satisfy the biggerst criteria of them all, both look
            and taste.</p>

        <form name="feedback" enctype="multipart/form-data" method="post">
            <p><input class="w3-input w3-padding-16 w3-border" type="text" name="name" placeholder="Name" >
            </p>
            <p><input class="w3-input w3-padding-16 w3-border" type="text" name="email" placeholder="Email" >

            <p><input class="w3-input w3-padding-16 w3-border" type="text" name="comments" placeholder="Message"  >
            <p><button class="w3-button w3-light-grey w3-block" name="feedback" type="submit">SEND MESSAGE</button></p>
        </form>
    </div>
</div>
<?php
include 'footer.html';
?>