import java.util.*;
import java.io.*;

/*Part 1: Demonstrates the Policy.java file in use */
/*Part 2: Read input from a file*/

public class Project_Dola_Y {

    public static void main(String[] args) throws IOException {

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

      //Create object holding holder info
      PolicyHolder newHolder = new PolicyHolder(firstName, lastName, age, smokerStatus, height, weight); 
      
      //Create object holding on policy info
      Policy newPolicy = new Policy(polNum, provName, newHolder);

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
      System.out.println(listOfPolicies.get(i));
   }

   System.out.println();
   System.out.println("There were " + listOfPolicies.get(0).getTotalPolicies() + " policies created");
   System.out.println("Number of Smokers: " + totalSmokers);
   System.out.println("Number of Non-Smokers: " + totalNonSmokers);

    }
    
}
