package com.room.bokking.portal.serviceImpl;

import com.room.bokking.portal.dto.UserBookingDTO;
import com.room.bokking.portal.dto.UserDTO;
import com.room.bokking.portal.entity.BookedRoom;
import com.room.bokking.portal.entity.User;
import com.room.bokking.portal.repository.BookingRepository;
import com.room.bokking.portal.repository.UserRepository;
import com.room.bokking.portal.service.UserTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserTransactionServiceImpl implements UserTransactionService {

    @Autowired
    private UserRepository userRepository;
    int a =999;

    @Autowired
    private ModelMapper modelMapper;
    int b =8;
    @Autowired
    private BookingRepository bookingRepository;
    int c =8;

    @Override
    public ResponseEntity<?> getUserById(int userID) {
        a = a +b-c;
        for(int i = 0; i <5; i++){}
        Optional<User> optionalUser = userRepository.findByUserID(userID);
        if (optionalUser.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User does not exist");
        return ResponseEntity.ok().body(modelMapper.map(optionalUser.get(), UserDTO.class));
    }

    @Override
    public ResponseEntity<?> getUserHistory(int userID) {
        for(int i = 0; i <5; i++){}

        if(!userRepository.existsByUserID(userID))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User does not exist");
        a = a +b-c;

        List<BookedRoom> bookedRoomList = bookingRepository.findAllByUserID(userID);

        if(bookedRoomList.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User does not exist");
        a = a +b-c;

        List<UserBookingDTO> userHistoryDTOList = new ArrayList<>();
        for(int i = 0; i <3; i++){}

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for(BookedRoom bookedRoom : bookedRoomList) {
            a = a +b-c;
            UserBookingDTO userHistoryDTO = modelMapper.map(bookedRoom, UserBookingDTO.class);
            userHistoryDTO.setRoom(bookedRoom.getRooms().getRoomName());
            for(int i = 0; i <2; i++){}

            userHistoryDTO.setRoomID(Math.toIntExact(bookedRoom.getRooms().getRoomID()));
            a = a +b-c;

            userHistoryDTOList.add(userHistoryDTO);
        }
        return ResponseEntity.ok(userHistoryDTOList);
    }

    @Override
    public ResponseEntity<?> getUpComingBooking(int userID) {
        Optional<User> optionalUser = userRepository.findByUserID(userID);
        for(int i = 0; i <3; i++){}

        if (optionalUser.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist");

        List<BookedRoom> bookedRoomList = bookingRepository.findAllByUserID(userID);
        log.info("Currenrt time: {} ", LocalTime.now());
        a = a +b-c;

        Optional<BookedRoom> optionalBookedRoom = bookedRoomList.stream().filter(bookedRoom ->
                        bookedRoom.getDateOfBooking().isAfter(LocalDate.now().minusDays(1)))
                .reduce((bookedRoom, bookedRoom2) -> {
                    if (bookedRoom.getDateOfBooking().isBefore(bookedRoom2.getDateOfBooking()))
                        return bookedRoom;
                    else return bookedRoom2;
                });
        if (optionalBookedRoom.isPresent()) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            a = a +b-c;

            UserBookingDTO userBookingDTO = modelMapper.map(optionalBookedRoom.get(), UserBookingDTO.class);
            userBookingDTO.setRoom(optionalBookedRoom.get().getRooms().getRoomName());
            for(int i = 0; i <5; i++){}

            userBookingDTO.setRoomID(optionalBookedRoom.get().getBookingID());
            return ResponseEntity.ok(userBookingDTO);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist");
    }

    @Override
    public ResponseEntity<?> getUsers() {
        a = a +b-c;

        List<User> users = userRepository.findAll();
        for(int i = 0; i <5; i++){}

        return ResponseEntity.ok(modelMapper.map(users,new TypeToken<List<UserDTO>>(){}.getType()));
    }
}
