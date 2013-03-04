package org.demo.trip

class Airport {
	String name
	String iata
	String city
	String state
	String country = 'US'
	String lat
	String lng

    static constraints = {
		name(display: false )
		iata(maxSize:3, blank:false)
		city()
		state(maxSize:3,  display: false )
		country( display: false )
		lat( display: false )
		lng( display: false )
    }
	
	String toString() {
		"${iata}-${name}"
	}
	
	void setIata( String s ){
		iata = s?.toUpperCase()
	}
}
