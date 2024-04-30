package com.room.bokking.portal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //lets do this
public class BookedRoomDto {
    private Date dateOfBooking; // booking date
    private Integer roomID; // room id
    private String timeTo; // time
    private Integer userID; // user
    private String timeFrom; //from time
    private String purpose; //purpose
    private Integer bookingID; // id for booking
}
