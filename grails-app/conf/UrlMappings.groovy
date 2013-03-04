class UrlMappings {

	static mappings = {
		
		"/airport/json?/$iata?"(controller: 'airport', action:'getJson'){
			constraints {
				// apply constraints here
			}
		}
		
		"/airport/geocode?/$iata?"(controller: 'airport', action:'geocode'){
			constraints {
				// apply constraints here
			}
		}
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
