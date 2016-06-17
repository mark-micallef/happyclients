package com.mea.happyclients.users.plans;

public class FreePlan extends Plan {

    public FreePlan() {
        super();
        name = "Free";
    }

    @Override
    public int getPriceInEuroCents() {
        return 0;
    }

    @Override
    public int getNumSmsPerMonth() {
        return 50;
    }

    @Override
    public int getMaxSenderIDs() {
        return 0;
    }


}
