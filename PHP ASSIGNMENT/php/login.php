<html>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,700);
        @import url(//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css);
        .login-form {

            min-height: 10rem;
            margin: auto;
            max-width: 50%;
            padding: .5rem;
        }
        .login-text {

            color: white;
            font-size: 1.5rem;
            margin: 0 auto;
            max-width: 50%;
            padding: .5rem;
            text-align: center;

            .fa-stack-1x {
                color: black;
            }
        }

        .login-username, .login-password {
            background: transparent;
            border: 0 solid;
            border-bottom: 1px solid rgba(white, .5);
            color: white;
            display: block;
            margin: 1rem;
            padding: .5rem;
            transition: 250ms background ease-in;
            width: calc(100% - 3rem);
            &:focus {
                background: white;
                color: black;
                transition: 250ms background ease-in;
            }
        }

        .login-forgot-pass {

            bottom: 0;
            color: white;
            cursor: pointer;
            display: block;
            font-size: 75%;
            left: 0;
            opacity: 0.6;
            padding: .5rem;
            position: absolute;
            text-align: center;

            width: 100%;
            &:hover {
                opacity: 1;
            }
        }
        .login-submit {
            border: 1px solid white;
            background: black;
            color: white;
            display: block;
            margin: 1rem auto;
            min-width: 1px;
            padding: .25rem;
            transition: 250ms background ease-in;
            &:hover, &:focus {
                background: white;
                color: black;
                transition: 250ms background ease-in;
            }
        }
    </style>    

    <?php
    include 'header.html';
    ?>
    <link rel="stylesheet" type="text/css">
    <h5 class="w3-center w3-padding-64"><span class="w3-tag w3-wide">LOGIN</span></h5>
    <form>

        <div >
            <center>
                <i class="fa fa-address-card-o" aria-hidden="true"></i>
                <input type="button" class="w3-btn w3-black" name="particapant_user" value="Staff User Login" onclick=";location = 'loginStaff.php'">

                <br><br>
                <i class="fa fa-user" aria-hidden="true"></i>
                <input type="button" class="w3-btn w3-black" name="particapant_user" value="Particapant User Login" onclick=";location = 'loginParticipant.php'" />

                <br><br>
                <i class="fa fa-user" aria-hidden="true"></i>
                <input type="button" class="w3-btn w3-black" name="particapant_user" value="Sign up" onclick=";location = 'registerP.php'" /> 
            </center>
        </div>
    </form>
</html>
<br><br><br><br><br><br><br><br><br><br>


<?php
include 'footer.html';
?>


