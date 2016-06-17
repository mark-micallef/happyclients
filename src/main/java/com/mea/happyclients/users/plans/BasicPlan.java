package com.mea.happyclients.users.plans;

public class BasicPlan extends Plan {

    public BasicPlan() {
        super();
        name = "Basic";
    }

    @Override
    public int getPriceInEuroCents() {
        return 995;
    }

    @Override
    public int getNumSmsPerMonth() {
        return 500;
    }

    @Override
    public int getMaxSenderIDs() {
        return 1;
    }

}
