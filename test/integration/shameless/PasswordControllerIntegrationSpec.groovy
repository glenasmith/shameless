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

}