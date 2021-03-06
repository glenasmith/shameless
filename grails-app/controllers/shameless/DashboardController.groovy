package shameless

import grails.plugins.springsecurity.Secured

class DashboardController {

    def springSecurityService

    static navigation = [
            [
                    group: 'tabs',
                    order: 10,
                    title: 'Home',
                    action: 'index']

	]

    @Secured(['ROLE_USER'])
    def index = { 
    	
    	def recentMeals = Meal.withCriteria {
            createAlias("account", "a")
            eq("a.username", springSecurityService.currentUser.username)
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
        def badMeals = Meal.withCriteria {
            createAlias("account", "a")
            eq("a.username", springSecurityService.currentUser.username)
            eq('badFood', true)
    		maxResults(5)
    		order("dateCreated", "desc")
    	}
    	[ recentMeals : recentMeals, badMeals : badMeals ]
    	
    }


    @Secured(['ROLE_USER'])
    def gsp = {

    	def recentMeals = Meal.withCriteria {
            createAlias("account", "a")
            eq("a.username", springSecurityService.currentUser.username)
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
        def badMeals = Meal.withCriteria {
            createAlias("account", "a")
            eq("a.username", springSecurityService.currentUser.username)
            eq('badFood', true)
    		maxResults(5)
    		order("dateCreated", "desc")
    	}
    	[ recentMeals : recentMeals, badMeals : badMeals ]

    }


    @Secured(['ROLE_USER'])
    def backbone = {

    	def recentMeals = Meal.withCriteria {
            createAlias("account", "a")
            eq("a.username", springSecurityService.currentUser.username)
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
    	def badMeals = Meal.withCriteria {
            createAlias("account", "a")
            eq("a.username", springSecurityService.currentUser.username)
            eq('badFood', true)
    		maxResults(5)
    		order("dateCreated", "desc")
    	}
    	[ recentMeals : recentMeals, badMeals : badMeals ]

    }

    @Secured(['ROLE_USER'])
    // old backbone code for testing
    def orig = {

    }

    
    def renderImage = {
    	def picture = Picture.get(params.id)
    	if (picture) {
            response.setContentType("image/png")
	        response.setContentLength(picture.image.length)
	        response.outputStream.write(picture.image)
	    } else {
	        response.sendError(404)
	    }
    }

}
