package org.demo.trip

class Airline {
	String name
	String iata
	String frequentFlier
	
	static hasMany = [flights:Flight]
    static constraints = {
		name()
		iata(maxSize:3)
		frequentFlier()
    }
	
	String toString() {
		"${iata}-${name}"
	}
}
