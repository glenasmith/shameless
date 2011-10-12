package shameless;
import grails.plugin.spock.IntegrationSpec


class PasswordControllerIntegrationSpec extends IntegrationSpec {

    def "Email forgotten passwords"() {

      given:
      def controller = new PasswordController()
      controller.params.userid = 'admin'
      def originalPassword = Account.findByUsername('admin').password

      when:
      def modelAndView = controller.forgottenPassword()

      then:
      controller.flash.message == "A new password has been generated and emailed to your account"
      def finalPassword = Account.findByUsername('admin').password
      finalPassword != null
      originalPassword != finalPassword

    }

    def "Changing passwords"() {
      given:
      def controller = new PasswordController()
      controller.params.with {
          password = "admin123"
          password_new = "newbie"
          password_new_2 = "newbie"
      }
      controller.springSecurityService = [
              currentUser : [username : 'admin' ]
      ]

      when:
      def mandv = controller.changePassword()

      then:
      controller.flash.message == 'Password change successful'
    }

}