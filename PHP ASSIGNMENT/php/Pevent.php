<?php
include 'headerParticipant.html';
?> 


session_start();


  <!DOCTYPE html>
    <div class="w3-container w3-PaleYellow w3-padding-64 w3-large" id="about">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
        <div class="w3-content">
            <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">Event</h1>
            <table class="w3-table w3-black">

                <hr>
                
                <body>
                    <div class="container">
                        <br />
                        <br />
                        <br />
                       
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Search</span>
                                <input type="text" name="search_text" id="search_text" placeholder="Search by Customer Details" class="form-control" />
                            </div>
                        </div>
                        <br />
                        <div id="result"></div>
                    </div>
                    <div style="clear:both"></div>
                    <br />

                    <br />
                    <br />
                    <br />
                </body>
            </table>

            <h2>Our Location!</h2>
            <div class="map">
                <iframe src="https://maps.google.com/maps?q=tarc%20segamat&t=&z=13&ie=UTF8&iwloc=&output=embed" width="1000px" height="700px"></iframe>
            </div>

            <div class="center">
                <p><a href="booking.php" class="w3-button w3-large w3-black">Book now</a></p>
            </div>
        </div>
        <h1><b> </b></h1>


        


<?php
include 'footer.html';
?>
<script>
    $(document).ready(function () {
        load_data();
        function load_data(query)
        {
            $.ajax({
                url: "fetch.php",
                method: "post",
                data: {query: query},
                success: function (data)
                {
                    $('#result').html(data);
                }
            });
        }

        $('#search_text').keyup(function () {
            var search = $(this).val();
            if (search != '')
            {
                load_data(search);
            } else
            {
                load_data();
            }
        });
    });
</script>