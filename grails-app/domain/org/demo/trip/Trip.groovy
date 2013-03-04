package org.demo.trip

class Trip {
	String name
	
	static hasMany = [flights:Flight]
	
    static constraints = {
		name()
    }
	
	String toString() {
		name
	}
}
