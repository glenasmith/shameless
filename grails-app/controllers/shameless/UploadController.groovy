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

     def orig = {

        [ mealInstance : new Meal() ]

    }

    def save = { UploadCommand uc ->

        def meal = new Meal(uc.properties)
        meal.account = springSecurityService.currentUser
        def picture = new Picture(image: uc.picture)
        meal.addToPictures(picture)
        if (uc.hasErrors() || !meal.validate()) {
            println meal.errors
            flash.error = "Something went bad in there"
            render(view: "index", model: [ mealInstance : meal ])
        } else {
            println meal.dump()
            meal.save()
            flash.message = "Saved new Meal in an epic fashion. Upload another?"
        }
        redirect(action: 'index')


    }


}


class UploadCommand {

    String status
    String latitude
    String longitude
    boolean badFood
    byte[] picture

    static constraints = {
        status blank: false
        picture nullable: false
    }


}