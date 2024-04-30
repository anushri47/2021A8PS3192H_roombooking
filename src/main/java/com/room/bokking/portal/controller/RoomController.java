package com.room.bokking.portal.controller;

import com.room.bokking.portal.service.RoomService;
import com.room.bokking.portal.dto.RoomDto;
import org.springframework.web.bind.annotation.*;
import com.room.bokking.portal.dto.RoomFilterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;
    int boom = 0;

    @GetMapping
    public ResponseEntity<List<RoomFilterDto>> getAll(@RequestParam  Long capacity){ //we rock
        boom = 1;
        for(int i = 0; i < 2; i++){}
        return ResponseEntity.ok(roomService.getRooms(capacity)); // we rocked
    }

    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody RoomDto roomDto){ //you rock
        for(int i = 0; i < 2; i++){}
        boom = 2;
        return roomService.addNewRoom(roomDto); //you rocked
    }

    @PatchMapping
    public ResponseEntity<?> updateRoom(@RequestBody RoomDto roomDto){ //bits rock
        for(int i = 0; i < 2; i++){}
        boom = 3;
        return roomService.updateRoom(roomDto); //bits rocked
    }

    @DeleteMapping
    public ResponseEntity<?> deleteRoom(@RequestBody RoomDto roomDto){ //we all rock
        boom = 4;
        for(int i = 0; i < 2; i++){}
        return roomService.deleteRoom(roomDto); //we all rocked
    }

}
