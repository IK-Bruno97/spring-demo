package com.firstspring.demo.data;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private int reservationId;
    @Column(name = "GUEST_ID")
    private int guestId;
    @Column(name = "ROOM_ID")
    private int roomId;
    @Column(name = "CHECK_IN_DATE")
    private Date checkInDate;
    @Column(name = "CHECK_OUT_DATE")
    private Date checkOutDate;


    public int getReservationId(){
        return reservationId;
    }
    public void setReservationId(int reservationId){
        this.reservationId = reservationId;
    }

    public int getGuestId(){
        return guestId;
    }
    public void setGuestId(int guestId){
        this.guestId = guestId;
    }

    public int getRoomId(){
        return roomId;
    }
    public void setRoomId(int roomId){
        this.roomId = roomId;
    }

    public Date getCheckInDate(){
        return checkInDate;
    }
    public void setCheckInDate(Date checkInDate){
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate(){
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate){
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString(){
        return "Reservation{ " +
            "reservation_id=" + reservationId +
            ", guest_id="+ guestId +
            ", room_id="+ roomId +
            ", check_in_date="+ checkInDate+
            ", check_out_date=" + checkOutDate +
        "}" ;
    }

}
