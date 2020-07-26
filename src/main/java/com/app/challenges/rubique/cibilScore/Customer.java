package com.app.challenges.rubique.cibilScore;

public class Customer implements Comparable {

    String name;
    int cibilScore;
    int riskScore;

    public Customer(String name, int cibilScore, int riskScore) {
        this.name = name;
        this.cibilScore = cibilScore;
        this.riskScore = riskScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(int cibilScore) {
        this.cibilScore = cibilScore;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (cibilScore != customer.cibilScore) return false;
        if (riskScore != customer.riskScore) return false;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + cibilScore;
        result = 31 * result + riskScore;
        return result;
    }

    @Override
    public int compareTo(Object other) {

        int retVal = 0;

        Customer otherCustomer = (Customer) other;

        if (this.getCibilScore() > otherCustomer.getCibilScore()) {
            retVal = -1;
        } else if (this.getCibilScore() < otherCustomer.getCibilScore()) {
            retVal = 1;
        } else {
            //CIBIL Same.
            if (this.getRiskScore() > otherCustomer.getRiskScore()) {
                retVal = 1;
            } else if (this.getRiskScore() < otherCustomer.getRiskScore()) {
                retVal = -1;
            } else {
                //RISK: Same
                retVal = (-1) * this.getName().compareTo(otherCustomer.getName());
            }
        }


        return retVal;
    }
}
