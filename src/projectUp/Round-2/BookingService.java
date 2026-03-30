//package projectUp;
//
//public class BookingService {
//
//        public void validateRequest(projectUp.TimeSlot timeSlot) throws Exception {
//            // pre processing validation
//            // 1. time slot is not 1-2
//            if(timeSlot.endTime - timeSlot.startTime > 6){
//                throw new Exception("the time slot duration is > 6");
//            }
//            //2. duration of time
//        }
//
//        public Booking createBooking(int meetingRoomId,TimeSlot timeSlot){
//
//            validateRequest(timeSlot);
//            //1. fetch meeting is present respository
//            projectUp.MeetingRoom meetingRoom = getMeetingRoomdetails(meetingRoomId);
//
//
//
//
//            //2.SlotMeetingRoom -  (meetingRoomId,timeSlot)
//            SlotMeetingRoom slotMeetingRoom = new SlotMeetingRoom();
//            // checking if slotMeetingRoom.meetingSlotStatus.equals(MeetingSlotStatus.AVAILABLE){
//
//            if( slotMeetingRoom.meetingSlotStatus.equals(MeetingSlotStatus.AVAILABLE){
//
//                synchronized (meetingRoom){
//                    Booking booking = new Booking("shubham","124", new EmailNotication(),slotMeetingRoom);
//                }
//            }
////            else{
////                // return "this is already occupied;
////            }
//
//            return booking;
//
//        }
//
//
//        public MeetingRoom getMeetingRoomdetails(int meetingRoomId)
//        {
//            return new MeetingRoom();
//        }
//}
