package com.firstspring.demo.data;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {
    
}
