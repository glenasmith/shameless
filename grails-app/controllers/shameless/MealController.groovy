package shameless

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class MealController {
	
	// Backbone approach:
	// create = POST /collection
	// read = GET /collection[/id]
	// update = PUT /collection/id
	// delete = DELETE /collection/id
	//static allowedMethods = [save: "POST", show: "GET", update: "PUT", delete: "DELETE"]

    def save = {
    	println "Creating with: ${params}"
    	def account = Account.findByUsername("admin")
    	def post = new Meal(params)
    	post.account = account
    	if (post.save()) {
    		render post as JSON
		} else {
			//TODO Error conditions for backbone?
			response.sendError(404)
		}
    }
    
    def show = {
        if (params.id) {
            println "Reading one with: ${params}"
            def onePost = Meal.get(params.id)
            if (onePost) {
                render onePost as JSON
            } else {
                //TODO Error conditions for backbone?
			    response.sendError(404)
            }
        } else {
    	    println "Reading all with: ${params}"
    	    render Meal.list() as JSON
        }
    }
    
    def update = {
    	println "Updating with: ${params}"
    	
    	def post = Meal.get(params.id)
    	if (post) {
    		println "New status is ${params.post.status}"
    		post.properties['status'] = params.post.status
    		if (post.save()) {
    			render post as JSON
    		} else {
    			//TODO Error conditions for backbone?
    			response.sendError(404)
    		}
    	}
    	//TODO Error conditions for backbone?
    	response.sendError(404)
    }
    
    def delete = {
    	println "Deleting with: ${params}"
    	def result = [:]
    	def post = Meal.get(params.id)
    	if (post) {
    		post.delete()
    		result.id = post.id
    	} else {
    		//TODO Error conditions for backbone?
    		response.sendError(404)
    	}
    	
    	render result as JSON
    }
}
