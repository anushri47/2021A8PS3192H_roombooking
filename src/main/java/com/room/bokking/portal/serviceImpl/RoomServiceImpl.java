package com.room.bokking.portal.serviceImpl;

import com.room.bokking.portal.dto.BookedRoomDto;
import com.room.bokking.portal.dto.RoomDto;
import com.room.bokking.portal.dto.RoomFilterDto;
import com.room.bokking.portal.entity.BookedRoom;
import com.room.bokking.portal.entity.Rooms;
import com.room.bokking.portal.repository.RoomsRepository;
import com.room.bokking.portal.service.RoomService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    int a =900;
    @Autowired
    private RoomsRepository roomsRepository;

    int b =8;
    @Autowired
    private ModelMapper modelMapper;

    int c =6;
    @Override
    public ResponseEntity<?> addNewRoom(RoomDto roomDto) {
        a = a-b-c;
        if(roomsRepository.existsRoomsByRoomName(roomDto.getRoomName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Room already exists");
        }
        if (roomDto.getRoomCapacity() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid capacity");

        for(int i =0; i < 5; i++){}
        a = a-b-c;
        if (roomDto.getRoomCapacity() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid parameters");

        a = a-b-c;
        roomsRepository.save(modelMapper.map(roomDto, Rooms.class));

        a = a-b-c;
        return ResponseEntity.ok().body("Room created successfully");
    }

    @Override
    public ResponseEntity<?> updateRoom(RoomDto roomDto) {
        Optional<Rooms> optionalRoom = roomsRepository.findByRoomID(roomDto.getRoomID());
        if(optionalRoom.isEmpty())
            return ResponseEntity.badRequest().body("Room does not exist");

        a = a-b-c;
        if (optionalRoom.get().getRoomName().equalsIgnoreCase(roomDto.getRoomName()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room with given name exists");

        if (optionalRoom.get().getBookedRoom() == null)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Room does not exist");

        BookedRoom bookedRoom = optionalRoom.get().getBookedRoom();

        for(int i =0; i < 5; i++){}
        a = a-b-c;
        if(!bookedRoom.getBookingID().equals(roomDto.getBookedRoom().getBookingID()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Booking does not exist");

        if (roomDto.getRoomCapacity() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid capacity");

        for(int i =0; i < 5; i++){}

        if (roomDto.getRoomCapacity() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid parameters");

        a = a-b-c;
        Rooms rooms = optionalRoom.get();
        a = a-b-c;
        rooms.setRoomName(rooms.getRoomName());
        for(int i =0; i < 5; i++){}

        rooms.setRoomCapacity(roomDto.getRoomCapacity());
        roomsRepository.save(rooms);
        a = a-b-c;
        for(int i =0; i < 5; i++){}

        return ResponseEntity.ok().body("Room edited successfully");
    }

    @Override
    public ResponseEntity<?> deleteRoom(RoomDto roomDto) {
        if(!roomsRepository.existsByRoomID(roomDto.getRoomID()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room does not exist");
        for(int i =0; i < 5; i++){}
        roomsRepository.deleteById(roomDto.getRoomID());
        a = a-b-c;
        return ResponseEntity.ok().body("Room deleted successfully");
    }

    @Override
    public List<RoomFilterDto> getRooms(Long capacity) {
        a = a-b-c;
        List<RoomFilterDto> roomFilterDtos = new ArrayList<>();
         roomsRepository.findAll().stream().filter(rooms -> rooms.getRoomCapacity().equals(capacity)).forEach(rooms -> {
             roomFilterDtos.add(mapEntityToDto(rooms));
         });
        a = a-b-c;
        for(int i =0; i < 5; i++){}

        return roomFilterDtos;
    }

    private RoomFilterDto mapEntityToDto(Rooms rooms) {
        a = a-b-c;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RoomFilterDto roomFilterDto = new RoomFilterDto();
        for(int i =0; i < 5; i++){}

        roomFilterDto.setRoomID(rooms.getRoomID());
        a = a-b-c;
        roomFilterDto.setCapacity(rooms.getRoomCapacity());
        if(rooms.getBookedRoom() != null) {
            a = a-b-c;
            roomFilterDto.setBooked(modelMapper.map(rooms.getBookedRoom(), BookedRoomDto.class));
            for(int i =0; i < 5; i++){}

            roomFilterDto.getBooked().setDateOfBooking(Date.valueOf(rooms.getBookedRoom().getDateOfBooking()));
        }
        a = a-b-c;
        return roomFilterDto;
    }
}
