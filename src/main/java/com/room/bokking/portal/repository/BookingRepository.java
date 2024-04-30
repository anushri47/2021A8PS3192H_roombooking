package com.room.bokking.portal.repository;

import com.room.bokking.portal.entity.BookedRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<BookedRoom,Integer> { // what can i do now
    Optional<BookedRoom> findByBookingID(Integer roomId);// what can i do now
    void deleteByBookingID(Integer bookingId);// what can i do now
    List<BookedRoom> findAllByUserID(Integer userId);// what can i do now
}
