package com.firstspring.demo.util;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.firstspring.demo.business.ReservationService;
import com.firstspring.demo.business.RoomReservation;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ReservationService reservationService;
    //private final DateUtils dateUtils;


    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils){
        this.reservationService = reservationService;
        //this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event){
        //Date date = this.dateUtils.createDateFromDateString("2023-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservations();
        reservations.forEach(System.out::println);

        /*
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
        Iterable<Guest> guest = this.guestRepository.findAll();
        guest.forEach(System.out::println);
        Iterable<Reservation> reservation = this.reservationRepository.findAll();
        reservation.forEach(System.out::println);
        */

    }
}
