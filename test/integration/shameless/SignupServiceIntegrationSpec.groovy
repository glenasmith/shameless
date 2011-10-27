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

    }


}
//
//def "Check signup service with bad values"() {
//
//     given:
//     def params = [ username: 'glen', password: 'tester', realName: 'Glen A Smith',
//             email: 'glen@bytecode.com.au', pricingPlanId: 77 ]
//
//     when:
//     def account = signupService.createAccount(params)
//
//     then:
//     //thrown(SignupException)
//     SignupException se = thrown()
//     "Account failed, could not find pricing plan" == se.message
//     AccountPricingPlan.count() == 0
//     !Account.findByUsername('glen')
//     Account.count() == 1 // Just admin user
//     !account
//
// }
//
