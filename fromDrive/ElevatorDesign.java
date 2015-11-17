package Misc;
import java.util.*;

public class ElevatorDesign {
   
   static class Elevator {
      
      enum Direction {
         IDLE,
         DOWN,
         UP
      }
      
      int currentFloor;
      Direction direction;
      List<Integer> requestQueue;
      Door door;
      Boolean stop;
      
      void addRequest(int floor) {
         requestQueue.add(floor); // add requests in ascending order
      }
      
      boolean stopElevator() {
         this.stop = true;
      }
      
      boolean stopOperation() {
         return stop;
      }
      
      void serveRequest() {
      }
   }
   
   class ElevatorBank {
      List<Elevator> elevators;
      
      public ElevatorBank() {
         elevators = new ArrayList<Elevator>();
      }
      
      Elevator getAnElevator(int targetFloor) {
         // Can be a simple round-robin based algo
         // Or something that checks each elevator's current floor,
         // direction and returns optimal one.
      }
      
      public void addRequest(int floorNum) {
         Elevator ele = getAnElevator(floorNum);
         ele.addRequest(floorNum);
      }
   }
   
   static class Door {
      
      enum DoorState {
         OPEN,
         CLOSE
      }
      
      DoorState state;
      
      boolean tryOpen() {
         if (state != DoorState.OPEN)
            state = DoorState.OPEN;
         
         return true;
      }
      
      boolean tryClose() {
         
         if (state == DoorState.CLOSE)
            return true;
         
         if (IsInterrupted()) {
            return false;
         }
         
        state = DoorState.CLOSE;
        return true;
      }
   }
   
   class Switch {
      ElevatorBank elevBank;
      int floorInstalled;
      
      public Switch(ElevatorBank bank, int floorNum) {
         this.elevBank = bank;
         this.floorInstalled = floorNum;
      }
      
      public void onPress() {
         elevBank.addRequest(floorInstalled);
      }
   }
}
