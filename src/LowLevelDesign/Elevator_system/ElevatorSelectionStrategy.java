package LowLevelDesign.Elevator_system;

import java.util.List;

public interface ElevatorSelectionStrategy {

    Elevator selectElevator(
            List<Elevator> elevators,
            ElevatorRequest request);
}
