package com.room.bokking.portal.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;


@Entity
@Table(name = "booked_room") // lets book
@Data
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalTime timeTo; // time time
    private LocalDate dateOfBooking; //date date
    private String purpose; // purpose purpose
    private Integer userID; // id user id
    private Integer bookingID; // booking bookig go
    private LocalTime timeFrom; //winnie the pooh

    @OneToOne(mappedBy = "bookedRoom") //we booked
    private Rooms rooms; // meeee shoeeesss
}
