package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;
import LowLevelDesign.Elevator_system.Enums.ElevatorState;

import java.util.List;

public class NearestElevatorStrategy
        implements ElevatorSelectionStrategy {

    @Override
    public Elevator selectElevator(
            List<Elevator> elevators,
            ElevatorRequest request) {
        Elevator best = null;
        int bestScore = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {

            if (elevator.getState()
                    == ElevatorState.OUT_OF_SERVICE) {
                continue;
            }

            int score = calculateScore(
                    elevator,
                    request);

            if (score < bestScore) {
                bestScore = score;
                best = elevator;
            }
        }

        return best;
    }

    private int calculateScore(
            Elevator elevator,
            ElevatorRequest request) {

        int distance = Math.abs(
                elevator.getCurrentFloor()
                        - request.getFloor());

        // Best case:
        // Elevator is already moving in requested direction
        // and request is ahead of it.

        if (elevator.getDirection()
                == request.getDirection()) {

            if (request.getDirection() == Direction.UP
                    && elevator.getCurrentFloor()
                    <= request.getFloor()) {

                return distance;
            }

            if (request.getDirection() == Direction.DOWN
                    && elevator.getCurrentFloor()
                    >= request.getFloor()) {

                return distance;
            }
        }

        // Idle elevator is the next best option
        if (elevator.getDirection()
                == Direction.IDLE) {

            return distance + 100;
        }

        // Elevator moving in opposite direction
        return distance + 1000;
    }
}
