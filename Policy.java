public class Policy {
    private int policyNumber;
    private String providerName;

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


    //toString Method
    public String toString() {
        return String.format("\nPolicy Number: " + getPolicyNumber() +
        "\nProvider Name: " + getProviderName());
    }

    //End of Policy Class File
}
