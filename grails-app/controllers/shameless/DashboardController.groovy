package shameless

class DashboardController {

    def index() { 
    	
    	def recentPosts = Post.withCriteria {
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
    	[ recentPosts : recentPosts ]
    	
    }
    
    def renderImage() {
    	def picture = Picture.get(params.id)
    	if (picture) {
	        response.setContentLength(picture.image.length)
	        response.outputStream.write(picture.image)
	    } else {
	        response.sendError(404)
	    }
    }

}
