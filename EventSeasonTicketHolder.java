
//20 live events for 1 year.
//Program that will help track ticket plan purchases and calc ticket plan prices 
//and calc revenue
    
public class EventSeasonTicketHolder {
    //Fields
    private String name;
    private String ticketType;
    private int numOfLiveEvents;
    
//Constructors
/**
 * Default constructor that creates an object with default values
 */
public EventSeasonTicketHolder() {
    name = "";
    ticketType = "";
    numOfLiveEvents = 0;
}

/**
 * Sets the object with values passed into the argument
 * @param custName name of customer
 * @param tickType type of ticket
 * @param liveEvents number of events
 */
public EventSeasonTicketHolder(String custName, String tickType, int liveEvents) {
    name = custName;
    ticketType = tickType;
    numOfLiveEvents = liveEvents;
}

//Getters
public String getName() {
    return this.name;
}

public String getTicketType() {
    return this.ticketType;
}

public int getNumOfLiveEvents() {
    return this.numOfLiveEvents;
}

//Setters
public void setTicketType(String ticketType) {
    this.ticketType = ticketType;
}

public void setNumOfLiveEvents(int numOfLiveEvents) {
    this.numOfLiveEvents = numOfLiveEvents;
}

//Calcs and returns the cost per live event on the season ticket plan
public double calculateLiveEventCost() {
    final String LUXSEATING = "Luxury Seating";
    final String PREMSEATING = "Premium Seating";
    final String STANSEATING = "Standard Seating";
    double costPerEvent = 0.00;

    //Grab ticket type from instance
    String ticketType = getTicketType();

    if(ticketType.equalsIgnoreCase(LUXSEATING)) {
        costPerEvent = 235.99;
    } else if(ticketType.equalsIgnoreCase(PREMSEATING)) {
        costPerEvent = 117.99;
    } else if(ticketType.equalsIgnoreCase(STANSEATING)) {
        costPerEvent = 22.99;
    }

    return costPerEvent;
}

/**
 * Calculates the reservation fee
 * @return returns reservation fee
 */
public double calculateLiveEventReservationFee() {
    int liveEvent = getNumOfLiveEvents();
    double reservationFee = 0.00;

    if (liveEvent > 0 && liveEvent <= 7) {
        reservationFee = 214.00;
    } else if (liveEvent > 7 && liveEvent <= 14 ) {
        reservationFee = 323.59;
    } else if (liveEvent > 14 && liveEvent <= 20 ) {
        reservationFee = 413.50;
    }

    return reservationFee;
} 

/**
 * Calculates price of ticket plans
 * @return the live event cost, times the number of live event then adding the sum of cost of ticket
 */
public double calculateLiveEventTicketPlanPrice() {
    return (calculateLiveEventCost() * getNumOfLiveEvents())+ calculateLiveEventReservationFee();
} 

}
