package com.room.bokking.portal.service;

import com.room.bokking.portal.dto.BookedRoomDto;
import org.springframework.http.ResponseEntity;

public interface BookingService { // ssupp hows you doin all good?
    ResponseEntity<?> bookRoom(BookedRoomDto bookedRoomDto); // ssupp hows you doin all good?

    ResponseEntity<?> updateRoom(BookedRoomDto bookedRoomDto); // ssupp hows you doin all good?

    ResponseEntity<?> deleteBooking(Long bookingID); // ssupp hows you doin all good?
}
