package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;

public class ElevatorRequest {

    private final int floor;
    private final Direction direction;

    public ElevatorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}