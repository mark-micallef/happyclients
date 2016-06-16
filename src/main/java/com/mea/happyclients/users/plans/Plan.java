package com.mea.happyclients.users.plans;

/**
 * Contains data about a User's subscription plan to the site
 */
public abstract class Plan {


    public static Plan FreePlan = new FreePlan();
    public static Plan BasicPlan = new BasicPlan();
    public static Plan PremiumPlan = new PremiumPlan();

    public static Plan[] plans = new Plan[] {Plan.FreePlan, Plan.BasicPlan, Plan.PremiumPlan};

    String name;

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public abstract int getPriceInEuroCents();
    public abstract int getNumSmsPerMonth();

}
