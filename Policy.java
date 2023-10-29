public class Policy {
    private int policyNumber;
    private String providerName;
    private static int totalPolicies = 0; //Track policies created
    private PolicyHolder holder;

    //Constructors

    public Policy() {
        policyNumber = 0;
        providerName = "";
    }

    //Using "this" to combat shadowing as I'm using the same name for my fields and args
    public Policy(int policyNumber, String providerName, PolicyHolder user) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.holder = new PolicyHolder(user);
        totalPolicies++;
    } 

    //copies Policy Holder information, creating a new memory address and not just a reference
    public PolicyHolder copyPolicyHolder() {
        return new PolicyHolder(holder);
    }

    //Getters and Setters
    /**
     * Retrieves the holder's policy number
     * @return the Policy Number as an integer
     */
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
     * Retrieves number of policies
     * @return totalPolicies
     */
    public int getTotalPolicies() {
        return totalPolicies;
    }

    //toString Method
    public String toString() {
        return String.format("\nPolicy Number: " + policyNumber +
        "\nProvider Name: " + providerName + holder);
    }

    //End of Policy Class File
}
