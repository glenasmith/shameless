package shameless

import spock.lang.*
import grails.plugin.spock.*

class AccountControllerSpec extends ControllerSpec {

    def "ensure list returns account"() {
        given:
        mockDomain(Account, [ new Account(username: "glen"), new Account(), new Account()])

        when:
        def response = controller.list()

        then:
        response.accountInstanceList.size() == 3
    }

    def "check index is redirecting"() {
        when:
        def mav = controller.index()

        then:
        controller.redirectArgs.action == "list"
    }

    def "simple expecter"() {
        expect:
        true == true
    }
}
