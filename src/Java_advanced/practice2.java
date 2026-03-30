package Java_advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class practice2  {

    public static void main(String[] args) {

        TicketBook ticketBook = new TicketBook(5);

        ExecutorService executor = Executors.newFixedThreadPool(10);

            for(int i=0;i<10;i++){
                new Thread(()-> {
                    ticketBook.bookTicket();
                }).start();
            }
    }




}
