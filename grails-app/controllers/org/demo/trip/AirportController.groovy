package org.demo.trip
import grails.converters.*

class AirportController {

    static scaffold = true
	def geoService
	
	def getJson() {
		def airport = null
		if (params.iata) {
			airport = Airport.findByIata(params.iata.toUpperCase())
		}
		if (!airport) {
			airport = new Airport(id:-1, iata:params.iata, name:'Not found')
		}
		render airport as JSON
	}
	
	def geocode() {
		if (params.iata) {
			render geoService.geocodeAirport(params.iata.toUpperCase()) as JSON
		}
		render '{}'
	}
	
	def map() {
		render(view:'map3', model:[airportList: Airport.list()])
	}
	
	def update() {
		def airport = Airport.get( params.id )
		if (airport) {
			def result = geoService.geocodeAirport(params.iata)
			airport.properties = params + result
			if(!airport.hasErrors() && airport.save()) {
				flash.message = "Airport ${airport.id} updated"
				redirect(action:'show', id:airport.id)
			} else {
				render(view:'edit',model:[airport:airport])
			}	
		} else {
			flash.message = "Airport not found with id ${params.id}"
			redirect(action:'edit', id:params.id)
		}
	}
	
	def save() {
		def result = geoService.geocodeAirport(params.iata)
		def airport = new Airport(params + result)
		if(!airport.hasErrors() && airport.save()) {
			flash.message = "Airport ${airport.id} created"
			redirect(action:'show', id:airport.id)
		} else {
			render(view:'edit',model:[airport:airport])
		}	
		
	}
}
