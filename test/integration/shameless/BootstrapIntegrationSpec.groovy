package shameless;
import grails.plugin.spock.*


class BootstrapIntegrationSpec extends IntegrationSpec {

    def "check that bootstrap code is creating appropriate objects"() {

        expect:
        Account.count() == 1
        Role.count() == 2
        PricingPlan.count() == 3

    }

}