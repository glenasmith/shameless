modules = {

    less {
        resource url: '/js/less-1.1.3.min.js'
    }

    seefooddiet {
        resource url: '/less/seefooddiet.less', attrs: [type: 'css', rel: 'stylesheet/less']
    }

    twitter {
        resource url: '/css/bootstrap.min.css'
    }

    twitterLess {
        //dependsOn 'less'
        resource url: '/less/bootstrap.less', attrs: [type: 'css', rel: 'stylesheet/less']

    }

    jqueryValidate {
        dependsOn 'jquery'
        resource url: '/js/jquery.validate.js'
    }


    jqPlot {
        dependsOn 'jquery'

        resource url: '/css/jquery.jqplot.css'
        resource url: "/js/jquery.jqplot.js"
        resource url: "/js/jqplot-plugins/jqplot.barRenderer.min.js"
        resource url: "/js/jqplot-plugins/jqplot.categoryAxisRenderer.min.js"
        resource url: "/js/jqplot-plugins/jqplot.pointLabels.min.js"


    }

   backbone {
        dependsOn 'jquery'

        resource url: '/js/json2.js', disposition: 'head' // for old browsers
        resource url: '/js/underscore-min.js', disposition: 'head'
        resource url: '/js/backbone.js', disposition: 'head'
        //resource url:'/js/mustache.js'
        resource url: '/js/handlebars.1.0.0.beta.3.js', disposition: 'head'
    }

    dashboard {
        dependsOn 'backbone,jquery-ui'
        resource url: '/js/dashboard.js'
    }

    backboneDashboard {
        dependsOn 'backbone,jquery-ui'
        resource url: '/js/backbone-dashboard.js'
    }


}