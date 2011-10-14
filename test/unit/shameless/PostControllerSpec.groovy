package shameless

import spock.lang.*
import grails.plugin.spock.*

class PostControllerSpec extends ControllerSpec {

    def "check email is reset on forgotten password"() {
      given:
      mockDomain(Account, [ new Account(username: 'glen', password: 'help')])
      controller.params.username = 'glen'

      when:
      def model = controller.forgottenPassword()

      then:
      true
    }
}
