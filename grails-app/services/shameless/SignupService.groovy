package shameless

class SignupService {

    static transactional = true

    def createAccount(def params) {
        def account = new Account(params)
        if (account.validate()) {
            account.save()
            if (params.pricingPlanId) {
                def pricingPlan = PricingPlan.findById(pricingPlanId)
                if (pricingPlan) {
                    AccountPricingPlan app = new AccountPricingPlan(account: account, pricingPlan: pricingPlan)
                    if (app.validate()) {
                        app.save()
                        return "Account created successfully"
                    } else {
                        return "Account failed, duplicate pricing plan"
                    }
                } else {
                    return "Account failed, could not find pricing plan"
                }
            } else {
                return "Account failed, bad pricing plan"
            }
        }  else {
            return "Invalid Account field"
        }

    }


}
