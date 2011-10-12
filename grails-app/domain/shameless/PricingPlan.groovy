package shameless

class PricingPlan {

    String name
    BigDecimal dollarsPerMonth

    static constraints = {
        name blank: false
        dollarsPerMonth nullable: false
    }
}
