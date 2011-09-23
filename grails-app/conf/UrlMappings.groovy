class UrlMappings {

	static mappings = {
		
		"/api/$id?"(controller:'post') {
			action = [GET:"read",POST:"create",PUT:"update",DELETE:"delete"]
		}
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		// create = POST /collection
	// read = GET /collection[/id]
	// update = PUT /collection/id
	// delete = DELETE /collection/id
		
		

		"/"(controller:"dashboard", action: "index")
		"500"(view:'/error')
	}
}
