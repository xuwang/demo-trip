package org.demo.trip

import groovy.json.JsonSlurper

class GeoService {
	boolean transactional = false
	
    def geocodeAirport(String iata) {	
		try {
			def base_url = 'http://ws.geonames.org/search?fcode=airp&style=full&type=json&name_equals='
			def result = [:]
			def url =  new URL(base_url + iata)
			def connection = url.openConnection()
			if(connection.responseCode == 200){
				def json = url.text
				def slurper = new JsonSlurper()
				def geo = slurper.parseText(json)
				result.name = geo.geonames.name[0] as String
				result.lat = geo.geonames.lat[0] as String
				result.lng = geo.geonames.lng[0] as String
				result.state = geo.geonames.adminCode1[0] as String
				result.country = geo.geonames.countryCode[0] as String
				return result
			} else {
				log.error("GeocoderService.geocodeAirport FAILED")
				log.error(url)
				log.error(connection.responseCode)
				log.error(connection.responseMessage)
			}
		} catch (Exception e) {
			log.error("GeocoderService.geocodeAirport FAILED")
			log.error(e)
		}
    }
}
