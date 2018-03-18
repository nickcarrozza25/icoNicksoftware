var startingLoc = "Start";
var currentDirection = startingLoc;

var  score = 0;

var hasbeenVisitedA = false;
var hasbeenVisitedB = false;
var hasbeenVisitedC = false;


function displayScore (){
	document.getElementById("score").innerHTML = "Score: " + score;
	}



function showScene(descrip){
	document.getElementById("scene").innerHTML = descrip;
}


function moveNorth(){
	var message;
	
	if (currentDirection === startingLoc) {
		currentDirection = "Building A";
		//document.getElementById("output")
		message = "You are now at Building A. You are awarded 5 points. Your total score is 5";
		document.getElementById("locationUpdate").innerHTML = message;
		if (hasbeenVisitedA === false) {
			score = score + 5;
			displayScore();
		}
		hasbeenVisitedA = true;



	 } else if (currentDirection === "Building A") {
		currentDirection = "Building B";
		message = "You are now at Building B.";
		document.getElementById("locationUpdate").innerHTML = message;
		if (hasbeenVisitedB === false) {
			score = score + 5;
			displayScore();
		}
		hasbeenVisitedB = true;

	 } else if (currentDirection === "Building B") {
		currentDirection = "Building C";
		message = "You are now at Building C.";
		document.getElementById("locationUpdate").innerHTML = message;
		if (hasbeenVisitedC === false) {
			score = score + 5;
			displayScore();
		}
		hasbeenVisitedC = true;

	 } else {
		message = "There is nothing left to explore, Congrats!";
		document.getElementById("locationUpdate").innerHTML = message;
	}
		showScene(message);
	}



function moveEast () {
	var message;

		message = "Wrong way, please try again."; 
		document.getElementById("locationUpdate").innerHTML = message;
}

function moveWest () {
	var message; 


		message = "Wrong way, please try again."; 
		document.getElementById("locationUpdate").innerHTML = message;
}

function moveSouth () {
var message;

	
		message = "Wrong way, please try again.";

	document.getElementById("locationUpdate").innerHTML = message;
}



	













	

















