import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/*Part 1: Demonstrates the Policy.java file in use */
/*Part 2: Read input from a file*/

public class Project_Dola_Y {

    public static void main(String[] args) throws IOException {
      // **** Part 1 **** //
      // //Variables
      // Scanner usrInput = new Scanner(System.in);
      // int usrPolicyNum,
      //    usrAge;
      
      // double usrWeight, 
      //    usrHeight;
      
      // String usrProviderName,
      //    usrFirstName,
      //    usrLastName,
      //    usrSmokerStatus;

      // //Created object
      // Policy customer = new Policy();
      
      // System.out.print("Please enter the Policy Number: ");
      // usrPolicyNum = usrInput.nextInt();
      // customer.setPolicyNumber(usrPolicyNum);
      
      // //Clear Buffer
      // usrInput.nextLine();
      
      // System.out.print("Please enter the Provider Name: ");
      // usrProviderName = usrInput.nextLine();
      // customer.setProviderName(usrProviderName);
      
      // System.out.print("Please enter the Policyholders First Name: ");
      // usrFirstName = usrInput.nextLine();
      // customer.setHolderFirstName(usrFirstName);
      
      // System.out.print("Please enter the Policyholders Last Name: ");
      // usrLastName = usrInput.nextLine();
      // customer.setHolderLastName(usrLastName);
      
      // System.out.print("Please enter the Policyholdes Age: ");
      // usrAge = usrInput.nextInt();
      // customer.setHolderAge(usrAge);
      
      // //Clear Buffer
      // usrInput.nextLine();
      
      // System.out.print("Please enter the Policyholders Smoking Status (smoker/non-smoker): ");
      // usrSmokerStatus = usrInput.nextLine();
      // customer.setHolderSmokingStatus(usrSmokerStatus);
      
      // System.out.print("Please enter the Policyholders Height (in inches): ");
      // usrHeight = usrInput.nextDouble();
      // customer.setHolderHeight(usrHeight);
      
      // System.out.print("Please enter the Policyholders Weight (in pounds): ");
      // usrWeight = usrInput.nextDouble();
      // customer.setHolderWeight(usrWeight);
          
      // customer.displayInformation();
      
      // System.out.println(customer.calcPrice());

      // usrInput.close();

   //*** PART 2 ***/
   /* Create file to access PolicyInformation.txt
    * Create scanner to read line by line
      Capture PolicyNum, Policy Name, First Name, Last Name, Age, Smoker Status, Height, and BMI
      Create a new object once a blank line is reached
      Create an ArrayList that stores Policy Objects
   */

   //Variables
   int polNum;
   String provName;
   String firstName;
   String lastName;
   int age;
   String smokerStatus;
   double height;
   double weight;
   
   int totalNonSmokers = 0, 
      totalSmokers = 0;

   ArrayList<Policy> listOfPolicies = new ArrayList<>(); //Stores policy objects

   File policyInfo = new File("PolicyInformation.txt");
   Scanner inputFile = new Scanner(policyInfo);

   while (inputFile.hasNext()) {
      String line = inputFile.nextLine(); //Declare and assign line value to policy number
      polNum = Integer.parseInt(line);

      provName = inputFile.nextLine();

      firstName = inputFile.nextLine();

      lastName = inputFile.nextLine();

      line = inputFile.nextLine(); //Reassign line to age
      age = Integer.parseInt(line);

      smokerStatus = inputFile.nextLine();

      line = inputFile.nextLine(); //Reassign to height value
      height = Integer.parseInt(line);

      line = inputFile.nextLine(); //Reassigns line to weight value
      weight = Integer.parseInt(line);

      if(inputFile.hasNext()) {
         inputFile.nextLine(); //Skips empty line
      }

      //Create object
      Policy newPolicy = new Policy(polNum, provName, firstName, lastName, age, smokerStatus, height, weight); 

      //Sums smokers and non-smokers
      if (smokerStatus.equalsIgnoreCase("smoker")) {
         totalSmokers += 1;
      } else if(smokerStatus.equalsIgnoreCase("non-smoker")) {
         totalNonSmokers += 1;
      }

      //Add object to ArrayList
      listOfPolicies.add(newPolicy);
   }

   inputFile.close();

   //Display info
   for (int i = 0; i < listOfPolicies.size(); i++) {
      System.out.println("Policy Number: " + listOfPolicies.get(i).getPolicyNumber());
      System.out.println("Policy Name: " + listOfPolicies.get(i).getProviderName());
      System.out.println("Holder First Name: " + listOfPolicies.get(i).getHolderFirstName());
      System.out.println("Holder Last Name: " + listOfPolicies.get(i).getHolderLastName());
      System.out.println("Holder Age: " + listOfPolicies.get(i).getHolderAge());
      System.out.println("Holder Smoker Status: " + listOfPolicies.get(i).getHolderSmokingStatus());
      System.out.println("Holder Height: " + listOfPolicies.get(i).getHolderHeight());
      System.out.println("Holder Weight : " + listOfPolicies.get(i).getHolderWeight());
      System.out.printf("Holder BMI: %.2f \n", listOfPolicies.get(i).bmi(listOfPolicies.get(i).getHolderWeight(), listOfPolicies.get(i).getHolderHeight()));
      System.out.printf("Policy Price: $%.2f \n", listOfPolicies.get(i).calcPrice());
      System.out.println();

   }

      System.out.println("Number of Smokers: " + totalSmokers);
      System.out.println("Number of Non-Smokers: " + totalNonSmokers);

    }
    
}
