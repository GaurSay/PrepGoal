package Java_advanced;

public class TicketBook {
       public int totalTickets;
       public volatile int count;

       public TicketBook(int totalTickets){
           this.totalTickets = totalTickets;
           this.count = 0;
       }

       public synchronized void bookTicket() {
        if(this.count < this.totalTickets){
            System.out.println("ticket booked " + this.count);
            this.count = this.count+1;
        }
        else{
            System.out.println("oops booking full  " + this.count);
        }
    }
}
