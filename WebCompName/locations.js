var itemExists;

var item;

var breadcrumbTrail = [];

var Locations = [];

var postMoves = [];

//new instances of the Item object 
var stapler = new Item("Stapler", "Black and staples papers together.");

var paper = new Item("Paper", "Blank and college ruled.");

var pencil = new Item("Pencil", "Yellow and the eraser is just thin enough to continue using it.");

var pen = new Item("Pen", "Blue ink because it makes you memorize better.");

//creating new instances of userLocation with attributes of location, descrip, item, inventory
var startingLocation = new UserLocation("Start", "You are at your starting location.", null, false, 0);
Locations.push(startingLocation);


var buildingA = new UserLocation("Building A", "You are now at Building A.", stapler, false, 1);
Locations.push(buildingA);

var buildingB = new UserLocation("Building B", "You are now at Building B.", pencil, false, 2);
Locations.push(buildingB);

var buildingC = new UserLocation("Building C", "You are now at Building C.", null, false, 3);
Locations.push(buildingC);

var buildingD = new UserLocation("Building D", "You are now at Building D.", pen, false, 4);
Locations.push(buildingD);

var buildingE = new UserLocation("Building E", "You are now at Building E.", paper, false, 5);
Locations.push(buildingE);

var buildingF = new UserLocation("Building F", "You are now at Building F", null, false, 6);
Locations.push(buildingF);

var buildingG = new UserLocation("Building G", "You are now at Building G", null, false, 7);
Locations.push(buildingG);

var buildingH = new UserLocation("Building H", "You are now at Building H", null, false, 8);
Locations.push(buildingH);

var buildingI = new UserLocation("Building I", "You are now at Building I", null, false, 9);
Locations.push(buildingI);

var player = {playerLocation: Locations[0], userPointsEarned: 0, userInventory: Inventory, userBread: breadcrumbTrail};

var North = 0;
var South = 1;
var East = 2;
var West = 3;


function updateButtons() {
	
	document.getElementById("HelpButton").disabled = false;
	document.getElementById("go").disabled = false;
	//East button
	if (player.playerLocation.Index === 0 || player.playerLocation.Index === 4) {
		document.getElementById("East").disabled = false;
	} else {
		document.getElementById("East").disabled = true;
	}
	
	//West button
	if (player.playerLocation.Index === 4 || player.playerLocation.Index === 5){
		document.getElementById("West").disabled = false;	
	} else {
		document.getElementById("West").disabled = true;
	}

	//North button
	if (player.playerLocation.Index === 3 || player.playerLocation.Index === 4 || player.playerLocation.Index === 5) {
		document.getElementById("North").disabled = true;	
	} else {
		document.getElementById("North").disabled = false;	
	}

	//South button
	if (player.playerLocation.Index === 4 || player.playerLocation.Index === 5 || player.playerLocation.Index === 9) {
		document.getElementById("South").disabled = true;	
	} else {
		document.getElementById("South").disabled = false;	
	  }

// if user is at start run the conditional for the pop up message
	if (player.playerLocation.Index === 0) {
		userCorrectLoc();
		
	}

} 

//General Go function passing direction as parameter 
function Go(direction) {
	matrixFunction(player.playerLocation, direction);
}


//this is a constructor, so the name will begin with an uppercase. Location constructor 
function UserLocation(locationName, userDescription, hasItem, hasbeenVisited, locationIndex){
	this.Lname = locationName;
	this.descript = userDescription;
	this.LItem = hasItem;
	this.visited = hasbeenVisited;
	this.Index = locationIndex;
}

//matrix for navigation with location and direction 
function matrixFunction (givenlocation, direction) {
	var message = "";
	var locMatrix = [  
		[Locations[1], Locations[2], Locations[3], null, null, null, Locations[0], Locations[6], Locations[7], Locations[8]],
		[Locations[6], Locations[0], Locations[1], Locations[2], null, null, Locations[7], Locations[8], Locations[9], null],
		[Locations[4], null, null, null, Locations[5], null, null, null, null, null],
		[null, null, null, null, Locations[0], Locations[4], null, null, null, null]
	];

	var newLocation = locMatrix [direction] [givenlocation.Index];
	if (newLocation === null) {
		updateGame(player, givenlocation);

		
		
	} else {
		updateGame(player, newLocation);
		
	  }
	
}

//function that updates the game for location, description, and score
function updateGame(user, loc) {
	var message;
	

	//below takes the player object with attribute playerLocation and tells the function its a location
	player.playerLocation = loc;
	player.userBread.push(loc);
	console.log(player.userBread.length);

	//Update buttons
	updateButtons();

	//If the player has been there display appropriate message and update score
	if (player.playerLocation.visited === false) {
		player.playerLocation.visited = true;
	 	message = player.playerLocation.descript;
		displayUpdate(message);
		console.log(loc.visited);
		player.userPointsEarned = player.userPointsEarned + 5;
		displayScore(player.userPointsEarned);

	} else if (player.playerLocation.visited === true) {
		
		message = "Welcome back to " + player.playerLocation;
		displayUpdate(message);

	 }

	lastFiveMoves();
	useItemsCollected();

}

//function to display only the last five moves on the page
function lastFiveMoves(){
	var list = "";
	if (player.userBread.length < 5) { //If the array is less than 5
		//Prints all of them
		 displayHistory("Your last Five Locations: " + player.userBread.join(", "));
	} else { //Else only print the last five
		var lastFive = player.userBread.slice(player.userBread.length - 5);
		displayHistory("Your last Five Locations: " + lastFive.join(", "));
	}

}
 
function Item(itemName, itemDescription) {
	this.Iname = itemName;
	this.descript = itemDescription;
}

Item.prototype.toString = function() {return this.Iname};


function directionObject (directionName, directionIndex) {
	this.Dname = directionName;
	this.DIndex = directionIndex;
}


function clearExamineParagraph(){
	document.getElementById("Examine").innerHTML = "";
}

UserLocation.prototype.toString = function() {return this.Lname};






	