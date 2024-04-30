package com.room.bokking.portal.service;

import org.springframework.http.ResponseEntity; // ssupp hows you doin all good?

public interface UserTransactionService { // ssupp hows you doin all good?
    ResponseEntity<?> getUserById(int userID); // ssupp hows you doin all good?

    ResponseEntity<?> getUserHistory(int userID); // ssupp hows you doin all good?

    ResponseEntity<?> getUpComingBooking(int userID); // ssupp hows you doin all good?

    ResponseEntity<?> getUsers(); // ssupp hows you doin all good?
}


