package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;

import java.util.List;

public class ElevatorController {

    private final List<Elevator> elevators;

    private final ElevatorSelectionStrategy strategy;

    public ElevatorController(
            List<Elevator> elevators,
            ElevatorSelectionStrategy strategy) {

        this.elevators = elevators;
        this.strategy = strategy;
    }

    public void requestElevator(
            int floor,
            Direction direction) {

        Elevator elevator =
                strategy.selectElevator(
                        elevators,
                        floor,
                        direction);

        if (elevator == null) {
            throw new IllegalStateException(
                    "No elevator available");
        }

        elevator.addRequest(floor);
    }
}
