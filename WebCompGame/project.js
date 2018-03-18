//Nick Carrozza
//Professor Johnson CMPT 120
//December 11 ,2015
//Final Project

//Global Variables
var score = 0;
var used = false;
var input;
var Inventory = [];
var breadcrumbTrail = ["Building A", "Building B", "Building C", "Building D", "Building E", "Building F", "Building G", "Building H", "Building I"];


function addItemToInventory (item) {
 	Inventory.push(item);
 }

//for the user to enter input as "N,S,E,W" to move in a direction
function inputBox (){
	input = document.getElementById("inputBox").value;
	console.log(input);

	if (input === "N" || input === "n") {
		moveNorth();
		document.getElementById("error").innerHTML = "";
	}
	else if (input === "S" || input === "s") {
		moveSouth();
		document.getElementById("error").innerHTML = "";

	}
	else if (input === "E" || input === "e") {
		moveEast();
		document.getElementById("error").innerHTML = "";

	}
	else if (input === "W" || input === "w") {
		moveWest();
		document.getElementById("error").innerHTML = "";
	}
	else if (input === "T" || input === "t") {
		takeButton();	
	}
	else if (input === "H" || input === "h") {
		help();
	} 
	else if (input === "X" || input === "x") {
		searchForItem();
	}
	else if (input === "I'm ready") {
		userStaplePaper();
	}
	
	else {
		document.getElementById("error").innerHTML = "That is not a valid input. Please enter S, N, E, or W.";
	}
}


//function to take an Item
function takeButton(){
	
	if (player.playerLocation.LItem !== null) {
		addItemToInventory(player.playerLocation.LItem);
		player.playerLocation.LItem = null;
	} 
	
		displayInventory();
}

//function to display inventory
function displayInventory() {
			var text = "Inventory: ";
			if (Inventory.length > 1) {
				for (var x = 0; x < Inventory.length; x++) {
				text = text + Inventory[x] + ", ";
				}
			}
			else {
				for (var x = 0; x < Inventory.length; x++) {
				text = text + Inventory[x];
				}
			}
			document.getElementById("Inventory").innerHTML = text;
			
	}	
		

//display a message that informs the user what he/she can enter to move
function help() {
	var message;
	message = "The following are valid text commands: N or n to move North, S or s to move South, W or w to move West, E or e to move East, or T or t to take an item at a given location.";
	document.getElementById("Help").innerHTML = message;
}

//Function to display score on HTML page
function displayScore (points){
	document.getElementById("score").innerHTML = "Score: " + points;
}

function displayUpdate(message) {
	 	document.getElementById("locationUpdate").innerHTML = message;
}



function displayHistory(fivelocations) {
	document.getElementById("History").innerHTML = fivelocations;

}

//below function is to check if an item exists at that location 
//it displays the message with the contingent item 
function searchForItem() {
	if (itemExists === true) {
		document.getElementById("Examine").innerHTML = "There is a(n) " + item + " here. Click the take item button or enter T or t to pick it up!";
	}

	else {
		document.getElementById("Examine").innerHTML = "There are no items here.";
	}
}

//if all items are collected, alert the user of such 
function allItemsCollected () {
	if (Inventory.length === 4) {
		alert("Congrats, you now have all the items you need. But whats next...?");
		used = true;
	}
}

//alert the user that they must continue on with the puzzle at the starting location
function userCorrectLoc () {
	if (Inventory.length === 4 && player.playerLocation.Index === 0){
		alert("It is here that you may perform necessary preliminary actions.")
	}
}

//run the allItemsCollected function by default when player has all items. Ignore after doing it. It only happens once
function useItemsCollected() {
	if (used === false) {
		allItemsCollected();
	}
}

//if the game is over, disable all buttons to confirm for the user that they have won and nothing else is needed
function finalPicture() {
	if (gameOver === true) {
		document.getElementById("winImage").style.background = "url('winImage.jpeg')";
		document.getElementById("North").disabled = true;
		document.getElementById("South").disabled = true;
		document.getElementById("East").disabled = true;
		document.getElementById("West").disabled = true;
		document.getElementById("HelpButton").disabled = true;
		document.getElementById("go").disabled = true;
	}
}

















