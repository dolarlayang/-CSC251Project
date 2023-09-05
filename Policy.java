public class Policy {
    private int policyNumber;
    private String providerName;
    private String holderFirstName;
    private String holderLastName;
    private int holderAge;
    private boolean holderSmokingStatus;
    private double holderHeight;
    private double holderWeight;

    //Constructor
    public Policy() {
        int polNum = policyNumber;
        String provName = providerName;
        String firstName = holderFirstName;
        String lastName = holderLastName;
        int age = holderAge;
        boolean smokerStatus = holderSmokingStatus;
        double height = holderHeight;
        double weight = holderWeight;
    }

    //Getters and Setters
    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getHolderFirstName() {
        return holderFirstName;
    }

    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    public String getHolderLastName() {
        return holderLastName;
    }

    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    public int getHolderAge() {
        return holderAge;
    }

    public void setHolderAge(int holderAge) {
        this.holderAge = holderAge;
    }

    public boolean isHolderSmokingStatus() {
        return holderSmokingStatus;
    }

    public void setHolderSmokingStatus(boolean holderSmokingStatus) {
        this.holderSmokingStatus = holderSmokingStatus;
    }

    public double getHolderHeight() {
        return holderHeight;
    }

    public void setHolderHeight(double holderHeight) {
        this.holderHeight = holderHeight;
    }

    public double getHolderWeight() {
        return holderWeight;
    }

    public void setHolderWeight(double holderWeight) {
        this.holderWeight = holderWeight;
    }

    /**
     * Calculates the BMI by taking in parameter
     * @param weight holder's weight
     * @param height holder's height
     * @return the calculated BMI as a double
     */

    public double bmi(double weight, double height) {
//        weight = getHolderWeight();
//        height = getHolderHeight();
//        return (weight * 703) / (height * height);
        return (getHolderWeight() * 703) / (getHolderHeight() * getHolderHeight());
    }

    public double calcPrice() {
        double cost = 0.00;
        double baseFee = 600.00;
        int age = getHolderAge();
        double bmi = bmi(getHolderWeight(), getHolderHeight());

        cost = baseFee;

        if (age > 50) {
            cost += 75; //Additional Fee for Seniors
        }

        if (isHolderSmokingStatus()) {
            cost += 100; //Additional Fee for Smokers
        }

        if (bmi > 35) {
            cost += (bmi - 35) * 20; //Additional Fee for Overweight
        }

        return cost;
    }

}
