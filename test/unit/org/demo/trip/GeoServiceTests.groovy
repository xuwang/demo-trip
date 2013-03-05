package org.demo.trip



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GeoService)
class GeoServiceTests {
	GeoService geoService = new GeoService()
	
    void testGeocodeAirport() {
        def result = geoService.geocodeAirport('sfo')
		assert result.country== 'US'
		assert result.state == 'CA'
		assert result.lat == '37.6188237'
		assert result.lng == '-122.3758047'
		assert result.name == 'San Francisco International Airport'
    }
}
