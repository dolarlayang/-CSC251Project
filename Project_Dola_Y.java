import java.util.Scanner;

public class Project_Dola_Y {

    public static void main(String[] args) {
      //Variables
      Scanner usrInput = new Scanner(System.in);
      int usrPolicyNum,
         usrAge;
      
      double usrWeight, 
         usrHeight;
      
      String usrProviderName,
         usrFirstName,
         usrLastName,
         usrSmokerStatus;
      
      
      
      //Created object
      Policy customer = new Policy();
      
    
//      Testing output results;
// 
//      Policy newPolicy = new Policy();
//      newPolicy.setPolicyNumber(1234);
//      newPolicy.setProviderName("State Farm");
//      newPolicy.setHolderFirstName("John");
//      newPolicy.setHolderLastName("Doe");
//      newPolicy.setHolderAge(24);
//      newPolicy.setHolderSmokingStatus(non-smoker);
//      newPolicy.setHolderHeight(62.0);
//      newPolicy.setHolderWeight(250.5);
      
      System.out.print("Please enter the Policy Number: ");
      usrPolicyNum = usrInput.nextInt();
      customer.setPolicyNumber(usrPolicyNum);
      
      //Clear Buffer
      usrInput.nextLine();
      
      System.out.print("Please enter the Provider Name: ");
      usrProviderName = usrInput.nextLine();
      customer.setProviderName(usrProviderName);
      
      System.out.print("Please enter the Policyholders First Name: ");
      usrFirstName = usrInput.nextLine();
      customer.setHolderFirstName(usrFirstName);
      
      System.out.print("Please enter the Policyholders Last Name: ");
      usrLastName = usrInput.nextLine();
      customer.setHolderLastName(usrLastName);
      
      System.out.print("Please enter the Policyholdes Age: ");
      usrAge = usrInput.nextInt();
      customer.setHolderAge(usrAge);
      
      //Clear Buffer
      usrInput.nextLine();
      
      System.out.print("Please enter the Policyholders Smoking Status (smoker/non-smoker): ");
      usrSmokerStatus = usrInput.nextLine();
      customer.setHolderSmokingStatus(usrSmokerStatus);
      
      System.out.print("Please enter the Policyholders Height (in inches): ");
      usrHeight = usrInput.nextDouble();
      customer.setHolderHeight(usrHeight);
      
      System.out.print("Please enter the Policyholders Weight (in pounds): ");
      usrWeight = usrInput.nextDouble();
      customer.setHolderWeight(usrWeight);
          
      customer.displayInformation();
      
      // System.out.println(newPolicy.calcPrice());
    }
    
}
