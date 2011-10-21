package shameless;
import grails.plugin.spock.IntegrationSpec


class SignupServiceIntegrationSpec extends IntegrationSpec {

    def signupService

    def "Check signup service passes basic goodness"() {

        given:
        def pricingPlan = new PricingPlan(name: "Basic", dollarsPerMonth: 1).save()
        def params = [ username: 'glen', password: 'tester', realName: 'Glen Smith',
                email: 'glen@bytecode.com.au', pricingPlanId: pricingPlan.id ]
        def flash = [:]

        when:
        signupService.createAccount(params, flash)

        then:
        AccountPricingPlan.count() == 1
        Account.findByUsername('glen')
        flash.message =~ /Account created successfully/

    }

}