package com.room.bokking.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // we goooo
public class RoomDto {
    private Long roomID;
    private String roomName;
    private Long roomCapacity;
    private BookedRoomDto bookedRoom;
}
