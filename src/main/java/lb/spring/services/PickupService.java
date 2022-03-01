package lb.spring.services;

import lb.spring.dto.Nationality;
import lb.spring.dto.UserDto;
import lb.spring.entities.Pickup;
import lb.spring.repositories.PickupRepository;
import lb.spring.repositories.ResCampRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PickupService {
    @Autowired
    PickupRepository pickupRepository;
    @Autowired
    ResCampRepository  resCampRepository;
    public List<Pickup> getAll(){
        Pageable paging = PageRequest.of(2, 10);
      return    pickupRepository.findByLeadTime(paging);
    }

    public List<Nationality> count (String camping){

    return resCampRepository.countReservation(camping) ;
    }
}
