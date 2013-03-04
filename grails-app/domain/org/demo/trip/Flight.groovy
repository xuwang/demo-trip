package org.demo.trip

class Flight {
	
	String flightNumber
	Date departureDate
	Date arrivalDate
	Airport departureAirport
	Airport arrivalAirport
	
	static belongsTo = [trip:Trip, airline:Airline]
    static constraints = {
		flightNumber()
		arrivalDate()
		departureAirport()
		arrivalAirport()
		
    }
}
