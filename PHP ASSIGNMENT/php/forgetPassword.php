<style>
    body
    {
        margin: 0;
        padding: 0;
        background-image: url("bg.jpg");
        background-size: cover;
        background-repeat:no-repeat;
        font-family: sans-serif;
    }
    a
    {
        color: white;
    }
    .login-box{
        width:280px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        color: white;
        background: white;
        margin: 0px 0px 0px 500px;
        font-size: 18px;
        padding: 15px;
        border-radius: 10px;
        margin-left: 10px;
    }
    .login-box h1{
        float: left;
        font-size: 30px;
        border-bottom:6px solid crimson;
        color: black; 
    }
    .textbox input{
        margin-bottom: 50px;
        padding: 13px 0;
    }   
    .textbox{
        width: 100%;
        overflow: hidden;
        font-size: 20px;
        padding: 8px 0;
        margin: 8px 0;
        /*    border-bottom: 1px solid #4caf50;*/
        border-bottom: 1px solid #006666;
        color: black;
    }
    .textbox input{
        border: none;
        outline: none;
        background: none;
        color: black;
        font-size: 18px;
        width: 80%;
        float: left;
        margin: 0 10px;
    }
    .btn{
        width:100%;
        background: crimson;
        border: 2px solid red;
        color: black;
        padding: 5px;
        /*    border-radius: 10px;*/
    }
    .errors
    {
        border: 2px solid #FBC2C4;
        background-color: #FBE3E4;
        color: #8A1F11;
        width: 500px;
        margin: 0px 0px 0px 500px;
        border-radius: 10px;
    }
    .success
    {
        border: 2px solid #92CAE4;
        background-color: #D5EDF8;
        color: #205791;
        width: 500px;
        margin: 0px 0px 0px 500px;
        border-radius: 10px;
    }
</style>

<?php
include("header.html");

require_once "databaseParticipant.php";
if ($_POST) {
    $email = $_POST['email'];

    $query = "SELECT * FROM participant WHERE email = '$email";
    //  $result= mysqli_query($dbc, $query);
    // $num = mysqli_num_rows($result);
    //  $row= mysqli_fetch_array($result);
    //  if($num > 0)
    //   {
    //header("Location: successForgetPassword.php?password=$row[6]");
    //header("Location: edit.php?phone=$row[2]");
    //   }header
    //   else
    //  {
    //      echo '<ul class="errors"><li>Invalid <strong>Email</strong>.</li></ul>';
    // }
}
?>
<div class="login-box">
    <h1>Reset Password</h1>

    <form action="successForgetPassword.php" method="post">
        <div class="textbox">
<?php

echo "Enter your email: ";
?>
            <input type="text" name="email" maxlength="50" placeholder="Email" /><br><br>
        </div>

        <br><input class="btn" type="submit" name="submit" value="Submit"/>
        <br><br><input class="btn" type="button" value="Back" onclick="location = 'loginParticipant.php'" />
    </form>
</div>
