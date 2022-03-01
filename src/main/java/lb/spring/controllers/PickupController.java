package lb.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lb.spring.dto.Nationality;
import lb.spring.entities.Pickup;
import lb.spring.services.PickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pickup")
public class PickupController {
    @Autowired
    PickupService pickupService;
    @GetMapping
    List<Pickup> getAll()
    {
        return pickupService.getAll();
    }
    @GetMapping("/count/{camping}")
    List<Nationality> count(@PathVariable("camping") String camping) throws JsonProcessingException {
        return pickupService.count(camping);
    }

}
