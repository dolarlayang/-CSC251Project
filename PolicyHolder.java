/*
 * Create a PolicyHolder class that will represent a person that is associated with an insurance policy.

Move the appropriate fields and methods of the Policy class into the PolicyHolder class 
(Hint: the fields and methods you move into the PolicyHolder class should be directly associated with a policy holder).

There should be no duplication of fields or methods in the Policy and PolicyHolder classes.
 */

public class PolicyHolder {
    private String holderFirstName;
    private String holderLastName;
    private int holderAge;
    private String holderSmokingStatus;
    private double holderHeight;
    private double holderWeight;

        //Constructors
    //No Arg
    public PolicyHolder() {
        holderFirstName = "";
        holderLastName = "";
        holderAge = 0;
        holderSmokingStatus = "";
        holderHeight = 0.00;
        holderWeight = 0.00;
    }

    //Constructor w/ Args
    public PolicyHolder(String firstName, String lastName, int age, String smokerStatus, double height, double weight) {
        holderFirstName = firstName;
        holderLastName = lastName;
        holderAge = age;
        holderSmokingStatus = smokerStatus;
        holderHeight = height;
        holderWeight = weight;
    }

    //copy Constructor method
    public PolicyHolder(PolicyHolder pol) { //Renamed for clarity
        holderFirstName = pol.holderFirstName;
        holderLastName = pol.holderLastName;
        holderAge = pol.holderAge;
        holderSmokingStatus = pol.holderSmokingStatus;
        holderHeight = pol.holderHeight;
        holderWeight = pol.holderWeight;
    }

    //Getters and Setters

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

    //toString Method to Display Holder's Information
    public String toString() {
        return String.format("\nPolicyholders First Name: " + getHolderFirstName() +
        "\nPolicyholders Last Name: " + getHolderLastName() +
        "\nPolicyholders Age: " + getHolderAge() +
        "\nPolicyholders Smoking Status: " + getHolderSmokingStatus() +
        "\nPolicyholders Height: " + getHolderHeight() +
        "\nPolicyholders Weight: " + getHolderWeight() +
        "\nPolicyholders BMI: %.2f\n" +
        "Policy Price: %.2f", bmi(getHolderHeight(), getHolderWeight()), calcPrice());
    }
}
