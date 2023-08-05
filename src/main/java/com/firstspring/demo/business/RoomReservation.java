package com.firstspring.demo.business;
import java.sql.Date;

public class RoomReservation {
    private String roomNumber;
    private int guestId;
    private int roomId;
    private String roomType;
    private Date checkInDate;
    private Date checkOutDate;
    

    public String getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
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

    public String getRoomType(){
        return roomType;
    }
    public void setRoomType(String roomType){
        this.roomType = roomType;
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
            "room_number=" + roomNumber +
            ", guest_id="+ guestId +
            ", room_id="+ roomId +
            ", room_type="+ roomType +
            ", check_in_date="+ checkInDate+
            ", check_out_date=" + checkOutDate +
        "}" ;
    }
}
