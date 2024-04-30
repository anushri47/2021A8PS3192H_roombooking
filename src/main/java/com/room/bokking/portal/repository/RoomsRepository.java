package com.room.bokking.portal.repository;

import com.room.bokking.portal.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RoomsRepository extends JpaRepository<Rooms,Long>, JpaSpecificationExecutor<Rooms> {

   boolean existsRoomsByRoomName(String roomName);

   Optional<Rooms> findByRoomID(Long roomId);

   boolean existsByRoomID(Long roomId);

   void deleteByRoomID(Long roomId);

}
