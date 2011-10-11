package shameless

import grails.plugin.spock.IntegrationSpec

/**
 * Created by IntelliJ IDEA.
 * User: glen
 * Date: 11/10/11
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
class AccountControllerIntegrationSpec extends IntegrationSpec {

    def "bootstrap always creates admin user"() {

        when:
        def admin = Account.findByUsername("admin")

        then:
        admin != null
        admin.realName =="Admin User"

    }


    def "the same test but an integration edition"() {

        given:
        def account = new Account(username: "Glen", password: "sesame", realName: "Glen Smith")
        account.save()
        new Account(username: "Joe", password: "sesame", realName: "Joe Cool").save()
        def controller = new AccountController()

        when:
        def mandv = controller.list()

        then:
        account != null
        account.errors.errorCount == 0
        mandv.accountInstanceList.size() == 3


    }


}
