
public class Demo {

    public static void main(String[] args) {

        Policy newPolicy = new Policy();
        newPolicy.setPolicyNumber(1234);
        newPolicy.setProviderName("State Farm");
        newPolicy.setHolderFirstName("John");
        newPolicy.setHolderLastName("Doe");
        newPolicy.setHolderAge(24);
        newPolicy.setHolderSmokingStatus(false);
        newPolicy.setHolderHeight(62.0);
        newPolicy.setHolderWeight(250.5);

        System.out.println(newPolicy.calcPrice());
    }

}
