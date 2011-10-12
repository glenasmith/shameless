import shameless.*

fixture {

    basicPlan(PricingPlan, name: 'Basic', dollarsPerMonth: 0.0)
    premiumPlan(PricingPlan, name: 'Premium', dollarsPerMonth: 10.0)
    enterprisePlan(PricingPlan, name: 'Enterprise', dollarsPerMonth: 10000.0)

}
