package shameless

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
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
    	
    	def recentPosts = Post.withCriteria {
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
    	[ recentPosts : recentPosts ]
    	
    }
    
    def renderImage = {
    	def picture = Picture.get(params.id)
    	if (picture) {
	        response.setContentLength(picture.image.length)
	        response.outputStream.write(picture.image)
	    } else {
	        response.sendError(404)
	    }
    }

}
