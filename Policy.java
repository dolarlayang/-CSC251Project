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
    //* References the policy number*/
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number
     * @param policyNumber holds policy number value
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Retrieves value of the provider's name
     * @return prodiderName
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Set's the value of the providers name
     * @param providerName holds a string value of the providers name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Retrieves a string value of the holder first name
     * @return holderFirstName as a string
     */
    public String getHolderFirstName() {
        return holderFirstName;
    }

    /**
     * Mutulates the value of holder First Name
     * @param holderFirstName holds a string value of the first name
     */
    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    /**
     * Retrieves value of the holder last name
     * @return the value holderLastName as a string
     */
    public String getHolderLastName() {
        return holderLastName;
    }

    /**
     * Mutulates the holder's last name
     * @param holderLastName holders last name
     */
    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    /**
     * Retrieves holder's age
     * @return holderAge as an integer
     */
    public int getHolderAge() {
        return holderAge;
    }

    /**
     * Mutulates the holder's age
     * @param holderAge the users age
     */
    public void setHolderAge(int holderAge) {
        this.holderAge = holderAge;
    }
    
    /**
     * Retrieves the holders smoking status
     * @return smoker status as a string
     */
    public String getHolderSmokingStatus() {
        return holderSmokingStatus;
    }

    /**
     * Mutulates the smoker status
     * @param holderSmokingStatus hold a string value of the smoking status
     */
    public void setHolderSmokingStatus(String holderSmokingStatus) {
        this.holderSmokingStatus = holderSmokingStatus;
    }

    /**
     * Retrieves the holder's height
     * @return the height as a double
     */
    public double getHolderHeight() {
        return holderHeight;
    }

    /**
     * Mutulates the holder's height
     * @param holderHeight users height
     */
    public void setHolderHeight(double holderHeight) {
        this.holderHeight = holderHeight;
    }

    /**
     * Retrieves the holder's weight
     * @return holder's weight
     */
    public double getHolderWeight() {
        return holderWeight;
    }

    /**
     * Mutulates the holders' weight
     * @param holderWeight
     */
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
        return (getHolderWeight() * 703) / (getHolderHeight() * getHolderHeight());
    }

    /**
     * Calculates the cost of the policy
     * @return cost
     */
    public double calcPrice() {
        double cost = 0.00;

        int age = getHolderAge();
        double bmi = bmi(getHolderWeight(), getHolderHeight());

        //Constants
        final double BASEFEE = 600.00;
        final double ADDITIONAL_FEE_AGE = 75.00;
        final double ADDITIONAL_FEE_SMOKER = 100.00;
        final double ADDITIONAL_FEE_BMI = 20;

        final int AGE_THRESHOLD = 50;
        final int BMI_THRESHOLD = 35;

        cost = BASEFEE;

        if (age > AGE_THRESHOLD) {
            cost += ADDITIONAL_FEE_AGE; //Additional Fee for Seniors
        }

        if (getHolderSmokingStatus().equalsIgnoreCase("smoker")) {
            cost += ADDITIONAL_FEE_SMOKER; //Additional Fee for Smokers
        }

        if (bmi > BMI_THRESHOLD) {
            cost += (bmi - BMI_THRESHOLD) * ADDITIONAL_FEE_BMI; //Additional Fee for Overweight
        }

        return cost;
    }

    /** 
     * Displays all pertinant information regarding the policy and user.
     */
    public void displayInformation() {
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
