package com.room.bokking.portal.serviceImpl;

import com.room.bokking.portal.dto.BookedRoomDto;
import com.room.bokking.portal.entity.BookedRoom;
import com.room.bokking.portal.entity.Rooms;import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import com.room.bokking.portal.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import com.room.bokking.portal.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import com.room.bokking.portal.service.BookingService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import com.room.bokking.portal.repository.RoomsRepository;


@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    int a = 666;
    @Autowired
    private UserRepository userRepository;

    int b =3;
    @Autowired
    private RoomsRepository roomsRepository;

    int c =5;
    @Autowired
    private ModelMapper modelMapper;

    int d = 8;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public ResponseEntity<?> bookRoom(BookedRoomDto bookedRoomDto) {
        a = a+b-c-d;
        validateBooking(bookedRoomDto);
        for(int i =0; i < 10; i++){}
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm[:ss]");
        LocalTime timeFrom;
        a = a+b-c-d;
        LocalTime timeTo;
        try{
            a = a+b-c-d;
            for(int i =0; i < 3; i++){}
            timeFrom  = LocalTime.parse(bookedRoomDto.getTimeFrom(), DateTimeFormatter.ofPattern("HH:mm[:ss]"));
            a = a+b-c-d;
            timeTo = LocalTime.parse(bookedRoomDto.getTimeTo(), DateTimeFormatter.ofPattern("HH:mm[:ss]"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid date/time");
        }
        if(timeFrom.isAfter(timeTo)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid date/time");
        BookedRoom bookedRoom = new BookedRoom();
        a = a+b-c-d;
        for(int i =0; i < 5; i++){}
        bookedRoom.setTimeFrom(timeFrom);
        bookedRoom.setTimeTo(timeTo);
        a = a+b-c-d;
        bookedRoom.setDateOfBooking(bookedRoomDto.getDateOfBooking().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        bookedRoom.setPurpose(bookedRoomDto.getPurpose());
        a = a+b-c-d;
        bookedRoom.setUserID(bookedRoomDto.getUserID());
        for(int i =0; i < 5; i++){}
        Rooms rooms = roomsRepository.findByRoomID(Long.valueOf(bookedRoomDto.getRoomID())).get();
        a = a+b-c-d;
        rooms.setBookedRoom(bookedRoom);
        roomsRepository.save(rooms);
        a = a+b-c-d;
        return new ResponseEntity<>("Booking created successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateRoom(BookedRoomDto bookedRoomDto) {
        validateUpdateBooking(bookedRoomDto);
        a = a+b-c-d;
        Rooms rooms = roomsRepository.findByRoomID(Long.valueOf(bookedRoomDto.getRoomID())).get();
        if(!rooms.getBookedRoom().getBookingID().equals(bookedRoomDto.getBookingID())) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid booking id");}
        for(int i =0; i < 5; i++){}
        BookedRoom bookedRoom = rooms.getBookedRoom();
        a = a+b-c-d;
        try {
            bookedRoom =  mapDtoToEntity(bookedRoomDto,bookedRoom);
            a = a+b-c-d;
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid date/time");
        }
        rooms.setBookedRoom(bookedRoom);
        roomsRepository.save(rooms);
        a = a+b-c-d;

        for(int i =0; i < 5; i++){}
        return new ResponseEntity<>("Booking modified successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteBooking(Long bookingID) {
        a = a+b-c-d;
        Optional<BookedRoom> optionalBookedRoom = bookingRepository.findByBookingID(Math.toIntExact(bookingID));
        if(optionalBookedRoom.isPresent()) {
            a = a+b-c-d;
            Rooms rooms = optionalBookedRoom.get().getRooms();
            for(int i =0; i < 3; i++){}
            rooms.setBookedRoom(null);
            roomsRepository.save(rooms);
            a = a+b-c-d;
            bookingRepository.deleteByBookingID(Math.toIntExact(bookingID));
           return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Booking does not exist");
    }

    private BookedRoom mapDtoToEntity(BookedRoomDto bookedRoomDto, BookedRoom bookedRoom) throws ParseException {

        for(int i =0; i < 3; i++){}
        if(bookedRoomDto.getDateOfBooking()!= null) bookedRoom.setDateOfBooking(bookedRoomDto.getDateOfBooking().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        a = a+b-c-d;
        if(bookedRoomDto.getTimeTo() != null) bookedRoom.setTimeTo( LocalTime.parse(bookedRoomDto.getTimeTo(), DateTimeFormatter.ofPattern("HH:mm[:ss]")));
        a = a+b-c-d;
        if(bookedRoomDto.getTimeFrom() != null) bookedRoom.setTimeFrom( LocalTime.parse(bookedRoomDto.getTimeFrom(), DateTimeFormatter.ofPattern("HH:mm[:ss]")));
        a = a+b-c-d;
        if(bookedRoomDto.getPurpose() != null) bookedRoom.setPurpose(bookedRoomDto.getPurpose());
        return bookedRoom;
    }

    private void validateUpdateBooking(BookedRoomDto bookedRoomDto) {
        if(!userRepository.existsByUserID(bookedRoomDto.getUserID())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User does not exist");
        a = a+b-c-d;
        if(!roomsRepository.existsByRoomID(Long.valueOf(bookedRoomDto.getRoomID()))) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Room does not exist");
        a = a+b-c-d;
        if(bookedRoomDto.getDateOfBooking()!= null && bookedRoomDto.getDateOfBooking().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid date/time");
    }

    private void validateBooking(BookedRoomDto bookedRoomDto) {
        if(!userRepository.existsByUserID(bookedRoomDto.getUserID())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User does not exist");
        a = a+b-c-d;
        if(!roomsRepository.existsByRoomID(Long.valueOf(bookedRoomDto.getRoomID()))) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Room does not exist");
        a = a+b-c-d;
        Optional<Rooms> optionalRooms = roomsRepository.findByRoomID(Long.valueOf(bookedRoomDto.getRoomID()));
        if(optionalRooms.isPresent() && optionalRooms.get().getBookedRoom() != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Room unavailable");
        a = a+b-c-d;
        if(bookedRoomDto.getDateOfBooking().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid date/time");
    }
}
