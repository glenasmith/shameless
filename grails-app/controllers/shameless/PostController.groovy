package shameless

import grails.converters.JSON

class PostController {
	
	// Backbone approach:
	// create = POST /collection
	// read = GET /collection[/id]
	// update = PUT /collection/id
	// delete = DELETE /collection/id
	static allowedMethods = [create: "POST", read: "GET", update: "PUT", delete: "DELETE"]

    def create() {
    	println "Creating with: ${params}"
    	def account = Account.findByUsername("admin")
    	def post = new Post(params)
    	render post as JSON
    }
    
    def read() {
    	println "Reading with: ${params}"
    	render Post.list() as JSON
    }
    
    def update() {
    	println "Updating with: ${params}"
    	def post = new Post(params)
    	render post as JSON
    }
    
    def delete() {
    	println "Deleting with: ${params}"
    	def result = [:]
    	def post = Post.get(params.id)
    	if (post) {
    		post.delete()
    		result.id = post.id
    	}
    	
    	render result as JSON
    }
}
