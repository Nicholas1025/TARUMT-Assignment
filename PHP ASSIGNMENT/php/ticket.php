<html>
    <head>
        <style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}


.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: white;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}


.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}


</style>
    <script>
function clickAlert(){
	
	alert("Payment Sucessful! Thank You!");
}
</script>
</head>
    <body><h1>Payment</h1>
        <form action="sucessfull.php" method="get"></form>
    <h4>How many person have?</h4>
    <p>Rm 10 per person</p>
<form oninput="[x.value=parseInt(a.value)*10]+parseInt(b.value)">0
    <input type="textbox" id="a" value="">20
<br>Ticket price
<input type="" id="b" value="10"readonly><br>
Total pay RM<output name="x" for="a b"></output>
</form>

<h4>Please key in all the data</h4>
<div class="row">
  <div class="col-75">
    <div class="container">
        <form action="sucessfull.php">
      
        <div class="row">
            <div class="col-50">
            
            <label for="cname">Name of the user's card</label>
            <input type="text" id="cname" name="cardname" placeholder="Please enter your name">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="XXXX-XXXX-XXXX-XXXX" pattern="[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="Please enter the month" min="01" max="12">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018" min="1555" max="2019">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="XXX" min="001" max="999">
              </div>
            </div>
          </div>
          
        </div>
         
                <a href="welcome1.php"><button type="submit"  onclick="clickAlert()">Submit</button></a>
</form> 
      </form>
    </div>
  </div>
</div>
</body>
</html>


