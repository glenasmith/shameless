package shameless

import grails.plugin.spock.IntegrationSpec

class AccountControllerIntegrationSpec extends IntegrationSpec {

    def "redirects work different in integration tests"() {
      given:
      def controller = new AccountController()

      when:
      controller.index()

      then:
      controller.response.redirectedUrl == '/account/list'
    }

    def "bootstrap always creates admin user"() {

        when:
        def admin = Account.findByUsername("admin")

        then:
        admin != null
        admin.realName =="Admin User"

    }


    def "the same test but an integration edition"() {

        given:  "a set of brand new accounts"
        def account = new Account(username: "Glen", password: "sesame", realName: "Glen Smith")
        account.save()
        new Account(username: "Joe", password: "sesame", realName: "Joe Cool").save()
        def controller = new AccountController()

        when:  "I list all accounts"
        def mandv = controller.list()

        then:  "I see a list of accounts"
        account != null
        account.errors.errorCount == 0
        mandv.accountInstanceList.size() == 3


    }


}
