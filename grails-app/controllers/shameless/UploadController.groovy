package shameless

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class UploadController {

    def springSecurityService

     static navigation = [
		group:'tabs',
		order:20,
		title:'Upload',
		action:'index',
		isVisible: { SpringSecurityUtils.ifAnyGranted("ROLE_USER,ROLE_ADMIN") }
	]

    def index = {

        [ mealInstance : new Meal() ]

    }

    def save = {

        def meal = new Meal(params)
        meal.account = springSecurityService.currentUser
        if (!meal.validate()) {
            flash.error = "Something went bad in there"
            render(view: "index", model: [ mealInstance : meal ])
        } else {
            meal.save()
            flash.message = "Saved new Meal in an epic fashion. Upload another?"
        }
        redirect(action: 'index')


    }
}
