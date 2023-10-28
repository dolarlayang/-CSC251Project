import java.util.Scanner;
import java.util.ArrayList;

public class EventDemo {
    public static void main(String[] args) {
        //Vars
        String name = "";
        String ticketType = "";
        String userChoice = "";
        int liveEventsCount = 0;

        //Hold the totals 
        int totalLiveEvents = 0;
        double revenue = 0;

        final String LUXSEATING = "Luxury Seating";
        final String PREMSEATING = "Premium Seating";
        final String STANSEATING = "Standard Seating";

        char repeatAgain; //Loop Control Var

        //Create ArrayList to store objects
        ArrayList<EventSeasonTicketHolder> ticketHolders = new ArrayList<>();
        
        //Read usr input
        Scanner usrInput = new Scanner(System.in);

        do {
        //Inquire usr name
        System.out.print("\nEnter the customer's name: ");
        name = usrInput.nextLine();

        //Display Menu
        System.out.println("Choose from one of the following Live Event Ticket Plans:");
        System.out.println("A. Standard Seating - $22.99 / per event");
        System.out.println("B. Premium Seating - $117.99 / per event");
        System.out.println("C. Luxury Seating - $235.99 / per event");

        //Inquire to choose from menu
        do {
            System.out.print("\nEnter your choice (A, B, or C): ");
            userChoice = usrInput.nextLine();
        } while (!userChoice.equalsIgnoreCase("A") && !userChoice.equalsIgnoreCase("B") && !userChoice.equalsIgnoreCase("C"));
        
        //Set ticketType based on user choice
        if(userChoice.equalsIgnoreCase("A")) {
            ticketType = STANSEATING;
        } else if (userChoice.equalsIgnoreCase("B")) {
            ticketType = PREMSEATING;
        } else if (userChoice.equalsIgnoreCase("C")) {
            ticketType = LUXSEATING;
        }
        
        do {
            System.out.print("\nHow many live events are being purchased? (Min: 1, Max: 20 events) ");
            liveEventsCount = usrInput.nextInt();
        } while (liveEventsCount < 1 || liveEventsCount > 20); //Validatio check
        

        //Create object
        EventSeasonTicketHolder newTicketHolder = new EventSeasonTicketHolder(name, ticketType, liveEventsCount);

        //Store object into ArrayList
        ticketHolders.add(newTicketHolder);

        System.out.print("\nDo you wish to enter information for another ticket holder (Y/N)? ");
        repeatAgain = usrInput.next().charAt(0);

        //Clear Buffer 
        usrInput.nextLine();

    } while (repeatAgain == 'Y');

    usrInput.close();

    //Loop through Array to display each customer info
    System.out.println(); //Empty Line
    System.out.println("Ticket Holder List");
    System.out.println("---------------------------");
    for(int i = 0; i < ticketHolders.size();i++) {
        System.out.println("Customer Name: " + ticketHolders.get(i).getName());
        System.out.println("Live Event Ticket Plan: " + ticketHolders.get(i).getTicketType());
        System.out.println("Number of Live Events: " + ticketHolders.get(i).getNumOfLiveEvents());
        System.out.printf("Cost Per Live Event: $%.2f\n", ticketHolders.get(i).calculateLiveEventCost());
        System.out.printf("Live Event Ticket Reservation Subtotal: $%,.2f\n", (ticketHolders.get(i).getNumOfLiveEvents() * ticketHolders.get(i).calculateLiveEventCost()));
        System.out.printf("Live Event Ticket Reservation Fee: $%,.2f\n" , ticketHolders.get(i).calculateLiveEventReservationFee());
        System.out.printf("Ticket Plan Price: $%,.2f\n", ticketHolders.get(i).calculateLiveEventTicketPlanPrice());
        System.out.println(); //Empty new line

        //Calc num of events from each instance and adds up 
        totalLiveEvents += ticketHolders.get(i).getNumOfLiveEvents();;
        //Calc total revenue
        revenue += ticketHolders.get(i).calculateLiveEventTicketPlanPrice();
    }

    //Display Info
    System.out.println("Totals:");
    System.out.println("---------------------------");
    System.out.println("Total Ticket Holders: " + ticketHolders.size());
    System.out.println("Total Events Purchased: " + totalLiveEvents);
    System.out.printf("Total Ticket Revenue: $%,.2f\n", revenue) ;
    }
}
