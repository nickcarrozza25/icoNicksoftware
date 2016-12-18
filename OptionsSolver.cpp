/*

Developed, designed, and tested by Nick Carrozza


*/



#include <iostream>
#include <cmath>
#include <vector> 

using namespace std; 

//maybe make a function that takes parameters of stock_price and strike_price

double current_stock_price = 24.60;

double strike_price = 40.00; 

double qty_shares_purchased = 120; 

bool callOptionBought = false;

bool putOptionBought = true; 

bool callExercised = true; 

bool putExercised = false; 
 

const double ITM_CALL_OPTION_IV = current_stock_price - strike_price; 

const double ITM_PUT_OPTION_IV = strike_price - current_stock_price; 



int main() {


// To return the intrinsic value of a call option 

	if (callOptionBought == true && current_stock_price > strike_price) {

		cout << "Your call option is in the money!" << endl; 
 
		cout << "The current intrinsic value of the call option is " << ITM_CALL_OPTION_IV << "." << endl;

		cout << "You rendered a profit of " << (current_stock_price - strike_price) * qty_shares_purchased 

			 << " dollars." << endl;

		callExercised = true; 


	} else if (callOptionBought == true && (current_stock_price == strike_price || current_stock_price < strike_price)) {

		cout << "Your call option is worthless." << endl; 

		callExercised = false; 
	

	} else if (putOptionBought == true && strike_price > current_stock_price) { 

		cout << "Your put option is in the money!" << endl; 

		cout << "The current intrinsic value of your put option is " << ITM_PUT_OPTION_IV << "." << endl; 

		cout << "You rendered a profit of " << (strike_price - current_stock_price) * qty_shares_purchased 

			 << " dollars." << endl;

		putExercised = true; 


	} else if (putOptionBought == true && (current_stock_price == strike_price || current_stock_price > strike_price)) {

		cout << "Your put option is worthless." << endl;

		putExercised = false;

	} else {

		return 0;
	}


};





