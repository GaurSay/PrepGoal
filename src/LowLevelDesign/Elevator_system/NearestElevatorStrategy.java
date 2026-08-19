package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;
import LowLevelDesign.Elevator_system.Enums.ElevatorState;

import java.util.List;

public class NearestElevatorStrategy
        implements ElevatorSelectionStrategy {

    @Override
    public Elevator selectElevator(List<Elevator> elevators, int requestedFloor, Direction direction) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {

            if (elevator.getState()
                    == ElevatorState.OUT_OF_SERVICE) {
                continue;
            }

            int distance = Math.abs(
                    elevator.getCurrentFloor()
                            - requestedFloor);

            if (distance < minDistance) {
                minDistance = distance;
                best = elevator;
            }
        }

        return best;
    }
}
