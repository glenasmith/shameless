package shameless

import grails.plugins.springsecurity.Secured

class DashboardController {

    static navigation = [
		group:'tabs',
		order:10,
		title:'Home',
		action:'index',
		//isVisible: { SpringSecurityUtils.ifAnyGranted("ROLE_USER,ROLE_ADMIN") }
	]

    @Secured(['ROLE_USER'])
    def index = { 
    	
    	def recentMeals = Meal.withCriteria {
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
        def badMeals = Meal.withCriteria {
            eq('badFood', true)
    		maxResults(5)
    		order("dateCreated", "desc")
    	}
    	[ recentMeals : recentMeals, badMeals : badMeals ]
    	
    }


    @Secured(['ROLE_USER'])
    def gsp = {

    	def recentMeals = Meal.withCriteria {
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
        def badMeals = Meal.withCriteria {
            eq('badFood', true)
    		maxResults(5)
    		order("dateCreated", "desc")
    	}
    	[ recentMeals : recentMeals, badMeals : badMeals ]

    }

    @Secured(['ROLE_USER'])
    def backbone = {

    	def recentMeals = Meal.withCriteria {
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
    	def badMeals = Meal.withCriteria {
            eq('badFood', true)
    		maxResults(5)
    		order("dateCreated", "desc")
    	}
    	[ recentMeals : recentMeals, badMeals : badMeals ]

    }

    @Secured(['ROLE_USER'])
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
