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
    	def meal = new Meal(params)
    	meal.account = account
    	if (meal.save()) {
    		render meal as JSON
		} else {
			//TODO Error conditions for backbone?
			response.sendError(404)
		}
    }
    
    def show = {
        if (params.id) {
            println "Reading one with: ${params}"
            def oneMeal = Meal.get(params.id)
            if (oneMeal) {
                render oneMeal as JSON
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
    	
    	def meal = Meal.get(params.id)
    	if (meal) {
    		println "New status is ${params.meal.status}"
    		meal.properties['status'] = params.meal.status
            meal.properties['badFood'] = params.meal.badFood
    		if (meal.save()) {
    			render meal as JSON
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
    	def meal = Meal.get(params.id)
    	if (meal) {
    		meal.delete()
    		result.id = meal.id
    	} else {
    		//TODO Error conditions for backbone?
    		response.sendError(404)
    	}
    	
    	render result as JSON
    }
}
