package shameless

import grails.converters.JSON

class PostController {
	
	// Backbone approach:
	// create = POST /collection
	// read = GET /collection[/id]
	// update = PUT /collection/id
	// delete = DELETE /collection/id
	//static allowedMethods = [save: "POST", show: "GET", update: "PUT", delete: "DELETE"]

    def save = {
    	println "Creating with: ${params}"
    	def account = Account.findByUsername("admin")
    	def post = new Post(params)
    	post.account = account
    	if (post.save()) {
    		render post as JSON
		} else {
			//TODO Error conditions for backbone?
			response.sendError(404)
		}
    }
    
    def show = {
    	println "Reading with: ${params}"
    	render Post.list() as JSON
    }
    
    def update = {
    	println "Updating with: ${params}"
    	
    	def post = Post.get(params.id)
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
    	def post = Post.get(params.id)
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
