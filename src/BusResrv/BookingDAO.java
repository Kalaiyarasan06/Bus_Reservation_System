package BusResrv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class BookingDAO {
    public int getBookedCount(int Busno,Date date) throws SQLException {
        String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
        Connection con=DbConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1,Busno);
        pst.setDate(2,sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addBooking(Booking booking)throws SQLException{
        String query="insert into booking values(?,?,?,?)";
        Connection con=DbConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        pst.setString(1, booking.Passenger);
        pst.setInt(2,booking.Busno);
        pst.setDate(3,sqldate);
        pst.setInt(4,booking.id);
        pst.executeUpdate();
    }
    public void cancelBooking(int id) throws SQLException {
        String query="delete from booking where id=?";
        Connection con=DbConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,id);
        int rows=pst.executeUpdate();
        if(rows>0) {
            System.out.println("Your Booking is Successfully Cancelled!!");
        }
        else{
            System.out.println("No Booking Found with the given ID.");
        }
    }
}
