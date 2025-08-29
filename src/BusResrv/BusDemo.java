package BusResrv;
import java.sql.SQLException;
import java.util.*;
public class BusDemo {
    public static void main(String[] args) throws SQLException {
        BusDAO busdao=new BusDAO();

        try {
            Scanner sc = new Scanner(System.in);
            int userOpt = 1;
            System.out.println("Marvelous Bus Booking");
            while (userOpt != 4) {
                System.out.println("Enter 1 to Book the Raid");
                System.out.println("Enter 2 to Display Bus Details");
                System.out.println("Enter 3 to Cancel the Booking");
                System.out.println("Enter 4 to Exit");

                userOpt = sc.nextInt();
                if (userOpt == 1) {
                    Booking booking = new Booking();
                    if (booking.isAvailable()) {
                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.addBooking(booking);
                        System.out.println("Your Booking is Confirmed");
                    } else {
                        System.out.println("Sorry. Bus is full,Try another Bus or Date");
                    }
                }
                if(userOpt==2){
                    busdao.displayBusInfo();
                }
                if(userOpt==3){
                    BookingDAO bookingdao=new BookingDAO();
                    System.out.println("Enter your BusId to cancel the Booking");
                    int id=sc.nextInt();
                    bookingdao.cancelBooking(id);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
