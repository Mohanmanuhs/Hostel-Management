package com.example.hostelManagement.controllers.hostel;


import com.example.hostelManagement.constants.Position;
import com.example.hostelManagement.dto.HostelDto;
import com.example.hostelManagement.dto.HostelWrapper;
import com.example.hostelManagement.dto.UserLoginRequest;
import com.example.hostelManagement.models.hostel.Food;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.Staff;
import com.example.hostelManagement.models.user.User;
import com.example.hostelManagement.repository.hostel.HostelRepo;
import com.example.hostelManagement.service.hostel.HostelService;
import com.example.hostelManagement.service.user.StaffService;
import com.example.hostelManagement.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hostel")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @Autowired
    private UserService userService;

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getHostelDetails(@PathVariable("id") Integer id) {

        Hostel hostel = hostelService.getHostelById(id);

        if (hostel == null) {
            return ResponseEntity.ok("hostel not found");
        }
        return ResponseEntity.ok(hostel);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createHostel(@RequestBody HostelWrapper hostelWrapper) {
        UserLoginRequest loginRequest = hostelWrapper.getLoginRequest();
        HostelDto hostelDto = hostelWrapper.getHostelDto();
        User user = userService.findByEmail(loginRequest.getEmail());
        Staff staff = (Staff) user;
        if(staff.getPosition()!= Position.WARDEN){
            return ResponseEntity.ok("you are not authorized");
        }else if(staff.getHostel()!=null){
            return ResponseEntity.ok("hostel already exists");
        }
        Hostel hostel = getHostelFromDto(hostelDto);
        List<Staff> staffs = hostel.getStaffs();
        staffs.add(staff);
        hostel.setStaffs(staffs);
        hostel = hostelService.createHostel(hostel);

        Food food = new Food();
        food.setHostel(hostel);
        food.setStd_count(0);
        hostel.setFood(food);

        return ResponseEntity.ok(getDtoFromHostel(hostelService.updateHostel(hostel)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateHostel(Staff staff, HostelDto hostelDto) {

        if(staff.getPosition()!= Position.WARDEN){
            return ResponseEntity.ok("you are not authorized");
        }else if(staff.getHostel()!=null){
            return ResponseEntity.ok("hostel already exists");
        }

        Hostel hostel = getHostelFromDto(hostelDto);
        hostel.setHostel_id(staff.getHostel().getHostel_id());
        hostel = hostelService.updateHostel(hostel);
        return ResponseEntity.ok(hostel);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteHostel(Staff staff) {

        if(staff.getPosition()!= Position.WARDEN){
            return ResponseEntity.ok("you are not authorized");
        }else if(staff.getHostel()==null){
            return ResponseEntity.ok("hostel no exists");
        }

        Hostel hostel = staff.getHostel();
        hostelService.deleteHostel(hostel.getHostel_id());
        return ResponseEntity.ok("deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchHostel(@RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchText", required = false) String searchText) {

        List<Hostel> searchResults;

        if (filterBy != null && searchText != null && !searchText.isEmpty()) {
            searchResults = hostelService.getHostelsByFilter(filterBy, searchText);
        } else {
            searchResults = hostelService.getAllHostels();
        }
        List<HostelDto> hostelDtos = searchResults.stream().map(this::getDtoFromHostel).toList();
        return ResponseEntity.ok(hostelDtos);
    }

    private Hostel getHostelFromDto(HostelDto hostelDto) {
        Hostel hostel = new Hostel();
        hostel.setFees(hostelDto.getFees());
        hostel.setCapacity(hostelDto.getCapacity());
        hostel.setEmpty_seats(hostelDto.getEmpty_seats());
        hostel.setName(hostelDto.getName());
        hostel.setPhone(hostelDto.getPhone());
        hostel.setLocation(hostelDto.getLocation());
        return hostel;
    }
    private HostelDto getDtoFromHostel(Hostel hostel) {
        HostelDto hostelDto = new HostelDto();
        hostelDto.setFees(hostel.getFees());
        hostelDto.setCapacity(hostel.getCapacity());
        hostelDto.setEmpty_seats(hostel.getEmpty_seats());
        hostelDto.setName(hostel.getName());
        hostelDto.setPhone(hostel.getPhone());
        hostelDto.setLocation(hostel.getLocation());
        return hostelDto;
    }


}