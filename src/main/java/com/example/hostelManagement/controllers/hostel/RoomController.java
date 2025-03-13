package com.example.hostelManagement.controllers.hostel;


import com.example.hostelManagement.dto.RoomFixedDto;
import com.example.hostelManagement.dto.RoomVariableDto;
import com.example.hostelManagement.dto.StdToRoomDto;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.hostel.Room;
import com.example.hostelManagement.models.user.Student;
import com.example.hostelManagement.models.user.User;
import com.example.hostelManagement.service.hostel.HostelService;
import com.example.hostelManagement.service.hostel.RoomService;
import com.example.hostelManagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private HostelService hostelService;

    @Autowired
    private UserService userService;

    @PostMapping("/create/fixedSize")
    public ResponseEntity<?> createRoomsForFixedSize(@RequestBody RoomFixedDto roomFixedDto) {
        Hostel hostel = hostelService.getHostelById(roomFixedDto.getHostel_id());

        if (hostel == null) {
            return ResponseEntity.ok("hostel not found");
        }
        roomService.createRoomsForFixedSize(roomFixedDto.getFloorNo(), roomFixedDto.getTotalRooms(), roomFixedDto.getStartRoomNo(), hostel, roomFixedDto.getTotalSeatsInEachRoom());
        return ResponseEntity.ok("rooms created successfully");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody RoomVariableDto roomVariableDto) {
        Hostel hostel = hostelService.getHostelById(roomVariableDto.getHostel_id());

        if (hostel == null) {
            return ResponseEntity.ok("hostel not found");
        }
        roomService.createRoom(roomVariableDto.getFloorNo(), roomVariableDto.getRoomNo(), hostel, roomVariableDto.getTotalSeatsInRoom());
        return ResponseEntity.ok("rooms created successfully");
    }

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudentToRoom(@RequestBody StdToRoomDto stdToRoomDto) {
        Optional<Room> room = roomService.getRoom(stdToRoomDto.getRoom_id());
        User user = userService.findById(stdToRoomDto.getStd_id());
        room.ifPresent(value -> roomService.addStudentToRoom(value.getRoom_id(), (Student) user));
        return ResponseEntity.ok("added successfully");
    }

    @DeleteMapping("/removeStudent")
    public ResponseEntity<?> removeStudentToRoom(@RequestBody StdToRoomDto stdToRoomDto) {
        User user = userService.findById(stdToRoomDto.getStd_id());
        roomService.removeStudentFromRoom(user.getId());
        return ResponseEntity.ok("added successfully");
    }

}