package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;
import LowLevelDesign.Elevator_system.Enums.ElevatorState;

public class Main {

    public static void main(String[] args) {

        Elevator elevator = new Elevator(1);

        System.out.println(
                "Initial Floor: " +
                        elevator.getCurrentFloor()
        );

        // Passenger requests
        elevator.addRequest(5);
        elevator.addRequest(10);
        elevator.addRequest(2);

        System.out.println("\n--- Starting Elevator ---");

        // Each move() represents moving to the next requested floor
        while (elevator.getDirection() != Direction.IDLE
                || elevator.getState() == ElevatorState.IDLE) {

            elevator.move();

            // Stop once there are no more requests
            if (elevator.getDirection() == Direction.IDLE) {
                break;
            }
        }

        System.out.println("\n--- Final State ---");

        System.out.println(
                "Current Floor: " +
                        elevator.getCurrentFloor()
        );

        System.out.println(
                "Direction: " +
                        elevator.getDirection()
        );

        System.out.println(
                "State: " +
                        elevator.getState()
        );
    }
}
