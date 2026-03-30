package projectUp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Booking {

    public String empName;
    public String empId;
    public NotificationStrategy notificationStrategy;
    public SlotMeetingRoom slotMeetingRoom;

}
