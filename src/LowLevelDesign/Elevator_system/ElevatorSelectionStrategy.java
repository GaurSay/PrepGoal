package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;

import java.util.List;

public interface ElevatorSelectionStrategy {

    Elevator selectElevator(
            List<Elevator> elevators,
            int requestedFloor,
            Direction direction);
}
