modules = {

	less {
        resource url:'/js/less-1.1.3.min.js'
    }

    seefooddiet {
        resource url:'/less/seefooddiet.less', attrs: [type: 'css', rel: 'stylesheet/less']
    }
    
    twitter {
    	resource url: '/css/bootstrap.min.css'
    }

    twitterLess {
        //dependsOn 'less'
        resource url:'/less/bootstrap.less', attrs: [type: 'css', rel: 'stylesheet/less']
        
    }

    /*

    twitterSupport {
        dependsOn 'less'

		resource url:'/less/reset.less', attrs: [type: 'css', rel: 'stylesheet/less']
		resource url:'/less/variables.less', attrs: [type: 'css', rel: 'stylesheet/less']
		resource url:'/less/mixins.less', attrs: [type: 'css', rel: 'stylesheet/less']
        
		resource url:'/less/scaffolding.less', attrs: [type: 'css', rel: 'stylesheet/less']
        
        resource url:'/less/type.less', attrs: [type: 'css', rel: 'stylesheet/less']
        resource url:'/less/forms.less', attrs: [type: 'css', rel: 'stylesheet/less']
        resource url:'/less/tables.less', attrs: [type: 'css', rel: 'stylesheet/less']
        resource url:'/less/patterns.less', attrs: [type: 'css', rel: 'stylesheet/less']

		resource url:'/less/application.less', attrs: [type: 'css', rel: 'stylesheet/less']

    }
    */
    
    backbone {
    	dependsOn 'jquery'
    	
    	resource url:'/js/json2.js' // for old browsers
    	resource url:'/js/underscore-min.js'
    	resource url:'/js/backbone.js'
    	//resource url:'/js/mustache.js'
    	resource url:'/js/handlebars.1.0.0.beta.3.js'
    }
    
    dashboard {
    	dependsOn 'backbone,jquery-ui'
    	
    	resource url:'/js/dashboard.js'
    }

}