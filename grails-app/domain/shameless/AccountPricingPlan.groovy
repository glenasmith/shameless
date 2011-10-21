package shameless

class AccountPricingPlan {

    Account account
    PricingPlan pricingPlan

    static constraints = {
        account unique: true
    }
}
