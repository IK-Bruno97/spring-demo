package com.firstspring.demo.business;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import com.firstspring.demo.data.Guest;
import com.firstspring.demo.data.GuestRepository;
import com.firstspring.demo.data.Reservation;
import com.firstspring.demo.data.ReservationRepository;
import com.firstspring.demo.data.Room;
import com.firstspring.demo.data.RoomRepository;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository){
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservations(){
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Integer, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room ->{
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomType(room.getRoomType());
            roomReservationMap.put(room.getId(), roomReservation);
        }); 
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByCheckInDate(new Date(2023-07-01));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setCheckInDate(new Date(2023-07-01));
            roomReservation.setCheckOutDate(new Date(2023-07-01));
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(guest.getId());
        });

        List<RoomReservation> roomReservation = new ArrayList<>();
        for (Integer id : roomReservationMap.keySet()){
            roomReservation.add(roomReservationMap.get(id));
        }
        roomReservation.sort(new Comparator<RoomReservation>(){
            @Override
            public int compare(RoomReservation o1, RoomReservation o2){
                if (o1.getRoomType().equals(o2.getRoomType())){
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomType().compareTo(o2.getRoomType());
            }
        });
        return roomReservation;

    }

    public List<Guest> getHotelGuests(){
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guests.forEach(guest ->{guestList.add(guest);});
        guestList.sort(new Comparator<Guest>(){
            @Override
            public int compare(Guest o1, Guest o2){
                if (o1.getLastName().equals(o2.getLastName())){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName()); 
            }
        });
        return guestList;
    }
    public void addGuest(Guest guest){
        if (null == guest){
            throw new RuntimeException("Guest cannot be null");
        }
        this.guestRepository.save(guest);
    }


    public List<Room> getRooms(){
        Iterable<Room> rooms = this.roomRepository.findAll();
        List<Room> roomList = new ArrayList<>();
        rooms.forEach(room ->{roomList.add(room);});
        roomList.sort(new Comparator<Room>(){
            @Override
            public int compare(Room o1, Room o2){
                return o1.getRoomNumber().compareTo(o2.getRoomNumber());
            }
        });
        return roomList;
    }
}
