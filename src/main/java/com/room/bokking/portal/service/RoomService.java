package com.room.bokking.portal.service;

import com.room.bokking.portal.dto.RoomDto;
import com.room.bokking.portal.dto.RoomFilterDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService { // ssupp hows you doin all good?
    ResponseEntity<?> addNewRoom(RoomDto roomDto); // ssupp hows you doin all good?

    ResponseEntity<?> updateRoom(RoomDto roomDto); // ssupp hows you doin all good?

    ResponseEntity<?> deleteRoom(RoomDto roomDto); // ssupp hows you doin all good?

    List<RoomFilterDto> getRooms(Long capacity); // ssupp hows you doin all good?

}
