package com.mea.happyclients.users.plans;

public class PremiumPlan extends Plan {

    public PremiumPlan() {
        super();
        name = "Premium";
    }

    @Override
    public int getPriceInEuroCents() {
        return 1995;
    }

    @Override
    public int getNumSmsPerMonth() {
        return 1000;
    }

}
