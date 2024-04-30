package com.room.bokking.portal.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomFilterDto { // filter
    private Long roomID; // i get mad
    private Long capacity; // but i am ok
    private BookedRoomDto booked; // i can look after myself
}
