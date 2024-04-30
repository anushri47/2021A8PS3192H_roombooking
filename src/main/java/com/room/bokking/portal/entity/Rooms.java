package com.room.bokking.portal.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "rooms") // name em room
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID; // go get id
    private Long roomCapacity; // arre room id
    private String roomName; // i need to study ml

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingID") //ids and passes
    private BookedRoom bookedRoom ; //rooms and passes
}
