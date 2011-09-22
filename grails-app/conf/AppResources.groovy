modules = {

	less {
        resource url:'/js/less-1.1.3.min.js'
    }
    
    twitter {
    	resource url: '/css/bootstrap.min.css'
    }

    twitterLess {
        dependsOn 'less'
        resource url:'/less/bootstrap.less', attrs: [type: 'css', rel: 'stylesheet/less']
        
    }

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

}