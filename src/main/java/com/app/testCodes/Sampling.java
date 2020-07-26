package com.app.testCodes;

import java.math.BigInteger;


public class Sampling {

    public static void main(String[] args) {
        System.out.println(isSampled(BigInteger.valueOf(123451457), "20"));
    }

    public static boolean isSampled(BigInteger accountNumber, String sampledPercentage) {
        if (accountNumber != null && sampledPercentage != null) {
            //sample percentage comes as 10% in string. Extract number out of it

            String sample = "";
            int iSampePercentage = 0;

            try {

                if (sampledPercentage.indexOf("%") != -1) {
                    sample = sampledPercentage.trim().substring(0, sampledPercentage.indexOf("%"));
                    iSampePercentage = Integer.valueOf(sample).intValue();
                } else {
                    sample = sampledPercentage.trim();
                    iSampePercentage = Integer.valueOf(sample).intValue();
                }
            } catch (Exception exp) {
                return false;
            }

            //compare against 4 last digits. multiple by 100 for the sampling percentage
            iSampePercentage = iSampePercentage * 100;


    		/*get the last 2 digits. If the last 2 digits is less than the sample percentage
    		return true else return false */
            try {

                long accountNumberL = accountNumber.longValue();
                long last4DigitsofAccountNumber = accountNumberL % 10000;

                if (last4DigitsofAccountNumber < iSampePercentage) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception exp) {
            }

        }
        //if there is some issue with sample we dont want to bloxk the rule.
        return false;
    }
}
