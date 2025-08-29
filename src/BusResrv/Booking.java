package BusResrv;
import java.awt.print.Book;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    int id;
    String Passenger;
    int Busno;
    Date date;
    Booking(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the Passenger: ");
        Passenger=sc.next();
        System.out.print("Enter the Bus No: ");
        Busno=sc.nextInt();
        System.out.print("Enter the Date(dd-mm-yyyy): ");
        String dateInput=sc.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Enter BusId: ");
        id=sc.nextInt();

    }
    public boolean isAvailable() throws SQLException {
        BusDAO busdao=new BusDAO();
        BookingDAO bookingdao=new BookingDAO();
        int capacity=busdao.getCapacity(Busno);

        int booked=bookingdao.getBookedCount(Busno,date);
        return booked<capacity;
    }
}
