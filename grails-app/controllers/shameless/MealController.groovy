package shameless

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class MealController {

    def springSecurityService
	
	// Backbone approach:
	// create = POST /collection  = save() in Grails
	// read = GET /collection[/id] = show() in Grails
	// update = PUT /collection/id = update() in Grails
	// delete = DELETE /collection/id = delete() in Grails
	//static allowedMethods = [save: "POST", show: "GET", update: "PUT", delete: "DELETE"]

    def save = {
    	println "Creating with: ${params}"
    	def account = Account.findByUsername(springSecurityService.currentUser.username)
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
            def recentMeals = Meal.withCriteria {
                createAlias("account", "a")
                eq("a.username", springSecurityService.currentUser.username)
                maxResults(20)
                order("dateCreated", "desc")
            }
            render recentMeals as JSON
        }
    }
    
    def update = {
    	println "Updating with: ${params}"
    	
    	def meal = Meal.get(params.id)
    	if (meal) {
    		println "New status is ${params.meal.status}"
    		meal.properties['status','badFood'] = params.meal
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
