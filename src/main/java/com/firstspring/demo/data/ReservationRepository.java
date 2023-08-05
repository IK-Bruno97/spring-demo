package com.firstspring.demo.data;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Iterable<Reservation> findReservationByCheckInDate(Date date);
    
}
