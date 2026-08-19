package LowLevelDesign.Elevator_system;

import LowLevelDesign.Elevator_system.Enums.Direction;
import LowLevelDesign.Elevator_system.Enums.ElevatorState;
import lombok.Data;

import java.util.TreeSet;

@Data

public class Elevator {

    private final int id;

    private int currentFloor;

    private Direction direction;

    private ElevatorState state;

    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    public Elevator(int id) {

        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;

        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>();
    }

    public void addRequest(int floor) {

        if (floor == currentFloor) {
            return;
        }

        if (floor > currentFloor) {
            upRequests.add(floor);
        } else {
            downRequests.add(floor);
        }
    }

    public void move() {

        if (state == ElevatorState.OUT_OF_SERVICE) {
            return;
        }

        if (direction == Direction.IDLE) {
            chooseDirection();
        }

        if (direction == Direction.UP) {
            moveUp();
        } else if (direction == Direction.DOWN) {
            moveDown();
        }
    }

    private void chooseDirection() {

        if (!upRequests.isEmpty()) {
            direction = Direction.UP;
        } else if (!downRequests.isEmpty()) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.IDLE;
            state = ElevatorState.IDLE;
        }
    }

    private void moveUp() {

        state = ElevatorState.MOVING;

        Integer nextFloor =
                upRequests.ceiling(currentFloor);

        if (nextFloor == null) {
            direction = Direction.DOWN;
            return;
        }

        currentFloor = nextFloor;

        upRequests.remove(currentFloor);

        openDoor();
    }

    private void moveDown() {

        state = ElevatorState.MOVING;

        Integer nextFloor =
                downRequests.floor(currentFloor);

        if (nextFloor == null) {
            direction = Direction.UP;
            return;
        }

        currentFloor = nextFloor;

        downRequests.remove(currentFloor);

        openDoor();
    }

    private void openDoor() {

        state = ElevatorState.DOOR_OPEN;

        System.out.println(
                "Elevator " + id +
                        " reached floor " + currentFloor);

        closeDoor();
    }

    private void closeDoor() {

        if (direction == Direction.UP
                && upRequests.isEmpty()
                && !downRequests.isEmpty()) {

            direction = Direction.DOWN;

        } else if (direction == Direction.DOWN
                && downRequests.isEmpty()
                && !upRequests.isEmpty()) {

            direction = Direction.UP;

        } else if (upRequests.isEmpty()
                && downRequests.isEmpty()) {

            direction = Direction.IDLE;
            state = ElevatorState.IDLE;

            return;
        }

        state = ElevatorState.IDLE;
    }
}