package shameless

class SignupService {

    static transactional = true

    def createAccount(def params, def flash) {
        def account = new Account(params)
        if (account.save()) {
            if (params.pricingPlanId) {
                def pricingPlan = PricingPlan.findById(params.pricingPlanId)
                if (pricingPlan) {
                    AccountPricingPlan app = new AccountPricingPlan(account: account, pricingPlan: pricingPlan)
                    if (app.save()) {
                        flash.message = "Account created successfully"
                    } else {
                        flash.message = "Account failed, duplicate pricing plan"
                    }
                } else {
                    flash.message = "Account failed, could not find pricing plan"
                }
            } else {
                flash.message = "Account failed, bad pricing plan"
            }
        }  else {
            flash.message = "Invalid Account field"
        }

    }


}
