package lb.spring.controllers;

import lb.spring.entities.Camping;
import lb.spring.repositories.FileDBRepository;
import lb.spring.responses.CampingResponse;
import lb.spring.services.CampingServiceImpl;
import lb.spring.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/camping")
public class CampingController {
    @Autowired
    CampingServiceImpl campingService;
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    FileDBRepository fileDBRepository;
    @GetMapping
    List<Camping> getAllCamping(){
        return campingService.getAllCamping();
    }
    @GetMapping("/names")
    List<CampingResponse> getNames(){
        return campingService.getName();
    }
    @GetMapping("/{id}")
    Camping getCampingById(@PathVariable("id") int id ){
        return campingService.getCampingById(id);
    }
}
