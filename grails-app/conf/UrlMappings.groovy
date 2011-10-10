class UrlMappings {

	static mappings = {
		
		"/post/$id?"(resource:"post")
		// You can do individual mappings but you then have to remember to
		// use the parseRequest:true to this mapping here

        "/welcome"(view: "welcome")
		
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
