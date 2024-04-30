package com.room.bokking.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBookingDTO { // lesss goooo
    private String room; // you can do this
    private Integer roomID; // go get room id now
    private Integer bookingID; //goooooooo
    private LocalDate dateOfBooking; // but i cant do this all day

    private String timeFrom; // wow this  is funny
    private String timeTo; // cause it tring
    private String purpose; // yes you

}
