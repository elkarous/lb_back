package lb.spring.services;

import lb.spring.entities.Camping;
import lb.spring.entities.FileDB;
import lb.spring.repositories.CampingRepository;
import lb.spring.repositories.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampingServiceImpl {
    @Autowired
    CampingRepository campingRepository;
    @Autowired
    FileDBRepository fileDBRepository;

    @Transactional
    public  List<Camping> getAllCamping(){
     return    campingRepository.findAll();
    }
    public Camping getImageByCampingId(int id ){
        return campingRepository.getImage(id);
    }

}
