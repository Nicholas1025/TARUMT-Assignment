<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body {font-family: "Lato", sans-serif}
    .mySlides {display: none}
</style>
<?php
include 'headerParticipant.html';
?>
<center>
    <div class="w3-black" id="tour">
        <div class="w3-container w3-content w3-padding-64" style="max-width:800px">
            <h2 class="w3-wide w3-center">PAYMENT</h2>
            <p class="w3-opacity w3-center"><i>Remember to pay your tickets!</i></p><br>


            <div class="w3-row-padding w3-padding-32" style="margin:0 -16px">
                <div class="w3-third w3-margin-bottom">
                    <img src="ticket.jpg" alt="Paris" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>Class of Lecture Mr.Doraemong</b></p>
                        <p class="w3-opacity">Sat 28 Nov 2021</p>
                        <p>Hi,I'm Doraemong ,my brother is Wei Yik, I love cake, my hobby is play football.</p>
                        <button class="w3-button w3-black w3-margin-bottom" onclick="document.getElementById('ticketModal').style.display = 'block'">Buy Tickets</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</center>

<div id="ticketModal" class="w3-modal">
    <div class="w3-modal-content w3-animate-top w3-card-4">
        <header class="w3-container w3-black w3-center w3-padding-32"> 
            <span onclick="document.getElementById('ticketModal').style.display = 'none'" 
                  class="w3-button w3-teal w3-xlarge w3-display-topright">ï¿½</span>
            <h2 class="w3-wide"><i class="fa fa-suitcase w3-margin-right"></i>Tickets</h2>
        </header>
        <div class="w3-container">
            <p><label><i class="fa fa-shopping-cart"></i> Tickets, $15 per person</label></p>       
            <p><form oninput="[x.value=parseInt(a.value)*15]+parseInt(b.value)">0
                each person<input type="textbox" id="a" value="">20 Max persons</p>
                The ticket price<input type="" id="b" value="15"readonly><br>
                Total pay RM<output name="x" for="a b"></output>
                <p><label><i class="fa fa-user"></i> Enter name</label></p>
                <input class="w3-input w3-border" type="text" placeholder="Enter Name">
                <p><label><i class="fa fa-user"></i> Send To</label></p>
                <input class="w3-input w3-border" type="text" placeholder="Enter email">
                <button class="w3-button w3-block w3-black w3-padding-16 w3-section w3-right"><i class="fa fa-check"><a href="https://www.pbebank.com">Pay by using Public Bank</a></i></button>
                <button class="w3-button w3-block w3-black w3-padding-16 w3-section w3-right"><i class="fa fa-check"><a href="https://www.maybank2u.com.my/home/m2u/common/login.do">Pay by using May Bank</a></i></button>
                <button class="w3-button w3-block w3-black w3-padding-16 w3-section w3-right"><i class="fa fa-check"><a href="https://www.ocbc.com.my/group/group-home.html">Pay by using OCBC Bank</a></i></button>
                <button class="w3-button w3-red w3-section" onclick="document.getElementById('ticketModal').style.display = 'none'">Close <i class="fa fa-remove"></i></button>
                <p class="w3-right">Need <a href="https://en.wikipedia.org/wiki/Help!" class="w3-text-blue">help?</a></p>
        </div>
    </div>
</div>

<?php
include 'footer.html';
?>