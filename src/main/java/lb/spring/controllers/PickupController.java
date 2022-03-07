package lb.spring.controllers;


import lb.spring.requests.SearchRequest;
import lb.spring.responses.CampStatResponse;
import lb.spring.responses.Nationality;
import lb.spring.requests.NationalityRequest;
import lb.spring.entities.Pickup;
import lb.spring.services.PickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pickup")
public class PickupController {
    @Autowired
    PickupService pickupService;
    private static final String DATE_PATTERN = "yyyy/MM/dd";
    @GetMapping
    List<Pickup> getAll()
    {
        return pickupService.getAll();
    }
    @PostMapping("/count")
    List<Nationality> count(@RequestBody NationalityRequest  nationalityRequest) {
        return pickupService.count(nationalityRequest.getCamping(),nationalityRequest.getStartDate(),nationalityRequest.getEndDate());
    }
    @GetMapping("{campingId}")
    List<Integer> getHebergementByCamping( @PathVariable("campingId") int campingId){
        return pickupService.getHebergementByCamping(campingId);
    }

    @PostMapping("/stat")
    public List<CampStatResponse> getAllCampStatParam(@RequestBody SearchRequest searchRequest){
        return pickupService.getAllCampStatParam(searchRequest);
    }

}
