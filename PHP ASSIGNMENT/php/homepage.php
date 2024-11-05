<?php
include 'header.html';
?>
<html>
    <body>
        <script>
            function showHint(str)
            {
                var xmlhttp;
                if (str.length == 0)
                {
                    document.getElementById("txtHint").innerHTML = "";
                    return;
                }
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp = new XMLHttpRequest();
                } else
                {// code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function ()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET", "gethint.php?q=" + str, true);
                xmlhttp.send();
            }
            // Tabbed Menu
            function openMenu(evt, menuName) {
                var i, x, tablinks;
                x = document.getElementsByClassName("menu");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablink");
                for (i = 0; i < x.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
                }
                document.getElementById(menuName).style.display = "block";
                evt.currentTarget.firstElementChild.className += " w3-red";
            }
            document.getElementById("myLink").click();
        </script>


        <style>
            body,
            html {
                height: 100%;

            }

            body,  h6  {
                font-family: "Courier New", monospace;
            }

            .menu {
                display: none
            }

            .bgimg {
                background-repeat: no-repeat;
                background-size: cover;
                background-image: url("ParticipantBg.png");
                min-height: 90%;
            }
        </style>



        <header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
            <img src="ParticipantBg.png" style="width:100%" class="w3-hover-opacity">
            <div class="w3-display-bottomleft w3-padding">
                <span class="w3-tag w3-xlarge">Open from 10am to 12pm</span>
            </div>
            <div class="w3-display-middle w3-center">
                <span class="w3-text-white w3-hide-small" style="font-size:70px"><br><b>TARUC</b></span>
                <span class="w3-text-white w3-hide-small" style="font-size:70px"><br><b>Eating Madness Society</b></span>
                <span class="w3-text-white w3-hide-large w3-hide-medium" style="font-size:60px"><b>thin<br>CRUST
                        PIZZA</b></span>
                <p><a href="#menu" class="w3-button w3-xlarge w3-black">Menu</a></p>
                <p><a href="loginParticipant.php" class="w3-button w3-xlarge w3-black ">Book now</a></p>
            </div>
        </header>

        <div class="w3-container w3-black w3-padding-64 w3-xxlarge" id="menu">
            <div class="w3-content">

                <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">THE MENU</h1>
                <div class="w3-row w3-center w3-border w3-border-dark-grey">
                    <a href="javascript:void(0)" onclick="openMenu(event, 'Pizza');" id="myLink">
                        <div class="w3-col s4 tablink w3-padding-large w3-hover-red">Starters</div>
                    </a>
                    <a href="javascript:void(0)" onclick="openMenu(event, 'Pasta');">
                        <div class="w3-col s4 tablink w3-padding-large w3-hover-red">Main Courses</div>
                    </a>
                    <a href="javascript:void(0)" onclick="openMenu(event, 'Starter');">
                        <div class="w3-col s4 tablink w3-padding-large w3-hover-red">Beverage</div>
                    </a>
                </div>

                <div id="Pizza" class="w3-container menu w3-padding-32 w3-white">
                    <h1><b>House-made kale soup</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$12.50</span></h1>
                    <p class="w3-text-grey">Served with quinoa and broccoli.</p>
                    <hr>

                    <h1><b>Hokkaido scallop</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$15.50</span></h1>
                    <p class="w3-text-grey">Hokkaido scallop carpaccio served with hollandaise, ponzu dressing and Sevruga caviar.</p>
                    <hr>

                    <h1><b>Bone marrow</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$17.00</span></h1>
                    <p class="w3-text-grey">Roasted Wagyu bone marrow served with Porcini mushrooms, and truffle espuma.</p>
                    <hr>

                    <h1><b>Spinach salad</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$16.50</span></h1>
                    <p class="w3-text-grey">Baby spinach salad with toasted pine nuts, 32-months aged parmesan cheese and extra virgin olive oil.</p>
                    <hr>

                    <h1><b>Liver duo</b> <span class="w3-tag w3-red w3-round">Hot!</span><span
                            class="w3-right w3-tag w3-dark-grey w3-round">$20.00</span></h1>
                    <p class="w3-text-grey">Pan-seared duck liver and goose liver pâté served with figs, chocolate brioche and pear compote.</p>
                    <hr>

                    <h1><b>Cream of Porcini mushroom</b> <span class="w3-tag w3-grey w3-round">New</span><span
                            class="w3-right w3-tag w3-dark-grey w3-round">$21.50</span></h1>
                    <p class="w3-text-grey">With truffle espuma.</p>
                </div>

                <div id="Pasta" class="w3-container menu w3-padding-32 w3-white">
                    <h1><b>Garlic Pepper Beef</b> <span class="w3-tag w3-red w3-round">Hot!</span><span
                            class="w3-right w3-tag w3-dark-grey w3-round">$13.50</span></h1>
                    <p class="w3-text-grey">Rib Eye Wagyu Steak, Garlic and Pepper</p>
                    <hr>

                    <h1><b>Ravioli</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$14.50</span></h1>
                    <p class="w3-text-grey">Ravioli filled with cheese</p>
                    <hr>

                    <h1><b>Spaghetti Classica</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$11.00</span></h1>
                    <p class="w3-text-grey">Fresh tomatoes, onions, ground beef</p>
                    <hr>

                    <h1><b>Wagyu beef burger</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$25.50</span></h1>
                    <p class="w3-text-grey">House-made charcoal bun served with cheddar cheese, caramelised onions, tomatoes and shoestring fries.</p>
                </div>


                <div id="Starter" class="w3-container menu w3-padding-32 w3-white">
                    <h1><b>ALVEAR "1927 Dulce Viejo"</b> <span class="w3-tag w3-grey w3-round">Seasonal</span><span
                            class="w3-right w3-tag w3-dark-grey w3-round">$5.50</span></h1>
                    <hr>

                    <h1><b>Kiwi Berry</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$8.50</span></h1>
                    <hr>

                    <h1><b>Hot Chocolate</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$9.50</span></h1>
                    <hr>

                    <h1><b>Garlic Juice</b> <span class="w3-right w3-tag w3-dark-grey w3-round">$10.50</span></h1>
                </div><br>
                <audio controls autoplay>

                    <source src="105.mp3" type="audio/mpeg">
                </audio>
            </div>
        </div>
    </body>
</html>

<?php
include 'footer.html';
?>
       