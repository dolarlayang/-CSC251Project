public class Policy {
    private int policyNumber;
    private String providerName;
    private String holderFirstName;
    private String holderLastName;
    private int holderAge;
    private String holderSmokingStatus;
    private double holderHeight;
    private double holderWeight;

    //Constructor
    public Policy() {
        int polNum = policyNumber;
        String provName = providerName;
        String firstName = holderFirstName;
        String lastName = holderLastName;
        int age = holderAge;
        String smokerStatus = holderSmokingStatus;
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
    
    public String getHolderSmokingStatus() {
        return holderSmokingStatus;
    }

    public void setHolderSmokingStatus(String holderSmokingStatus) {
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

        if (getHolderSmokingStatus().equalsIgnoreCase("smoker")) {
            cost += 100; //Additional Fee for Smokers
        }

        if (bmi > 35) {
            cost += (bmi - 35) * 20; //Additional Fee for Overweight
        }

        return cost;
    }


    public void displayInformation() {
        //Prints all data
        System.out.println();
        System.out.println("Policy Number: " + getPolicyNumber());
        System.out.println("Provider Name: " + getProviderName());
        System.out.println("Policyholders First Name: " + getHolderFirstName());
        System.out.println("Policyholders Last Name: " + getHolderLastName());
        System.out.println("Policyholders Age: " + getHolderAge());
        System.out.println("Policyholders Smoking Status: " + getHolderSmokingStatus());
        System.out.println("Policyholders Height: " + getHolderHeight());
        System.out.println("Policyholders Weight: " + getHolderWeight());
        System.out.printf("Policyholders BMI: %.2f\n", bmi(getHolderHeight(), getHolderWeight()));
        System.out.printf("Policy Price: %.2f", calcPrice());

    }

}
