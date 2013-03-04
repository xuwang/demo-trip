import org.demo.trip.Airport

class BootStrap {

    def init = { servletContext ->
		(new Airport(
					city: "San Francisco",
					country: "US",
					iata: "SFO",
					lat: "37.6188237",
					lng: "-122.3758047",
					name: "San Francisco International Airport",
					state: "CA"
					)).save(flush:true, failOnError:true)
		
		(new Airport(
					city: "Oakland",
					country: "US",
					iata: "OAK",
					lat: "37.7210411",
					lng: "-122.2216345",
					name: "Metropolitan Oakland International Airport",
					state: "CA"
					)).save(flush:true, failOnError:true)
		(new Airport(
					city: "San Jose",
					country: "US",
					iata: "SJC",
					lat: "37.3618854",
					lng: "-121.9288459",
					name: "San Jose International Airport",
					state: "CA"
					)).save(flush:true, failOnError:true)
    }
    def destroy = {
    }
}
