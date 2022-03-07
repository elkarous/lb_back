package lb.spring.services;

import lb.spring.entities.Camping;
import lb.spring.repositories.CampingRepository;
import lb.spring.repositories.FileDBRepository;
import lb.spring.responses.CampingResponse;
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
public Camping getCampingById(int id){
        return this.campingRepository.findById(id).get();
}
public List<CampingResponse> getName(){
        return  campingRepository.getNames();
}
}
