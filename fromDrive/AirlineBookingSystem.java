package Misc;
import java.util.*;

enum PassClass {
   BUSINESS,
   FIRST
}

class Airport {
   private String id;
   
   public Airport(String id) {
      this.id = id;
   }
   
   public String id() {
      return id;
   }
}

class Airline {
   private String id;
   Map<String, Flight> flightIdToFlight = new HashMap<String, Flight>();
   
   public Airline(String id) {
      this.id = id;
   }
   
   public boolean addFlight(Flight flight) {
      if (isValidFlight(flight.id())) {
         System.out.println("Flight with given id already exists in the airline.");
         return false;
      }
      
      flightIdToFlight.put(flight.id(), flight);
      return true;
   }
   
   public boolean bookSeat(String flightId, PassClass passClass, int row, char col) {
      if (isValidFlight(flightId)) {
         return getFlight(flightId).bookSeat(passClass, row, col);
      }
      
      System.out.println("Invalid flight id");
      return false;
   }
   
   private boolean isValidFlight(String flightId) {
      return flightIdToFlight.containsKey(flightId);
   }
   
   private Flight getFlight(String flightId) {
      return flightIdToFlight.get(flightId);
   }
   
   public String id() {
      return id;
   }
}

class Flight {
   private String id;
   Section[] sections = new Section[PassClass.values().length];
   
   public Flight(String id) {
      this.id = id;
      
      for (int i=0; i<sections.length; i++) {
         sections[i] = null;
      }
   }
   
   public boolean addSection(Section sec) {
      if (isValidSection(sec.passClass()))
         return false;
      
      sections[sec.passClass().ordinal()] = sec;
      return true;
   }
   
   public boolean bookSeat(PassClass passClass, int row, char col) {
      if (isValidSection(passClass)) {
         return sections[passClass.ordinal()].bookSeat(row, col);
      }
      
      System.out.println("Invalid passenger class for the given flight.");
      return false;
   }
   
   private boolean isValidSection(PassClass passClass) {
      return sections[passClass.ordinal()] != null;
   }
   
   public String id() {
      return id;
   }
}

class Section {
   private PassClass passClass;
   boolean[][] seatMap;
   int rows;
   int cols;
   
   public Section(PassClass passClass, int rows, int cols) {
      this.rows = rows;
      this.cols = cols;
      this.passClass = passClass;
      seatMap = new boolean[rows][cols];
   }
   
   public boolean bookSeat(int row, char col) {
      if (row < 0 || row >= rows || col < 0 || col >= cols) {
         System.out.println("Invalid seat number.");
         return false;
      }
      
      if (seatMap[row][col]) {
         System.out.println("Requested seat not available anymore.");
         return false;
      }
      
      seatMap[row][col] = true;
      return false;
   }
   
   public PassClass passClass() {
      return passClass;
   }
}

class SystemManager {
   boolean createAirport(String id) {
   }
   
   boolean createAirline(String id) {
   }
   
   boolean createFlight(String id, String airlineId, String fromAirportId, String toAirportId, Date date) {
   }
   
   boolean addSection(String airlineId, String flightId, PassClass passClass, int rows, int cols) {
   }
   
   void printAvailability(String fromAirportId, String toAirportId, Date date, PassClass passClass) {
   }
   
   boolean makeABooking(String airlineId, String flightId, PassClass passClass, int row, char col) {
   }
   
   void printSystemInfo() {
   }
}

public class AirlineBookingSystem {

}
