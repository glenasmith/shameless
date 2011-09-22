package shameless

class DashboardController {

    def index() { 
    	
    	def recentPosts = Post.withCriteria {
    		maxResults(20)
    		order("dateCreated", "desc")
    	}
    	[ recentPosts : recentPosts ]
    	
    }
}
