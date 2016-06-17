package com.mea.happyclients.users.plans;

import java.text.DecimalFormat;

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
        return name + " (" + getFormattedPrice() + ")";
    }

    public String getFormattedPrice() {
        String result = "€0";

        double priceinEuros = (double) getPriceInEuroCents() / 100;
        if (priceinEuros > 0) {
            DecimalFormat df = new DecimalFormat("####.00");
            result = "€" + df.format(priceinEuros);
        }


        return result + " / month";
    }

    public abstract int getPriceInEuroCents();
    public abstract int getNumSmsPerMonth();
    public abstract int getMaxSenderIDs();

}
