package lb.spring.services;

import lb.spring.requests.SearchRequest;
import lb.spring.responses.CampStatResponse;
import lb.spring.responses.Nationality;
import lb.spring.entities.Pickup;
import lb.spring.repositories.PickupRepository;
import lb.spring.repositories.ResCampRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class PickupService {
    @Autowired
    PickupRepository pickupRepository;
    @Autowired
    ResCampRepository resCampRepository;
    @PersistenceContext
    EntityManager entityManager;

    public List<Pickup> getAll() {
        Pageable paging = PageRequest.of(2, 10);
        return pickupRepository.findByLeadTime(paging);
    }

    public List<Nationality> count(String camping, Date startDate, Date endDate) {

        return resCampRepository.countReservation(camping, startDate, endDate);
    }

    public List<Integer> getHebergementByCamping(int campingId) {
        return pickupRepository.getHebergementByCamping(campingId);
    }

    public List<CampStatResponse> getAllCampStat() {
        return pickupRepository.getAllCampStat();
    }



    public List<CampStatResponse> getAllCampStatParam(SearchRequest searchRequest) {
        List<CampStatResponse> result = new ArrayList<>();
        if (searchRequest.getCamping_id() == 0 && searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null)
            result = pickupRepository.getAllCampStat();
            // axe camping
        else if (searchRequest.getCamping_id() == 0) {
            //000
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat10(searchRequest.getCamping_id());
            //001
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0) {

                result = pickupRepository.getAllCampStat11(getSeasonMonths(searchRequest.getSeasonType()));

            }
            //010
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() != null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat12(searchRequest.getBkg_date());

            //100
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat14(searchRequest.getHebergement());
            //101
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0) {

                result = pickupRepository.getAllCampStat15(searchRequest.getHebergement(), getSeasonMonths(searchRequest.getSeasonType()));
            }
            //110
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() != null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat16(searchRequest.getHebergement(), searchRequest.getBkg_date());


            //0 001
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat101(searchRequest.getYear());

            //0 010
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat102(searchRequest.getMonth());
            //0 011
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat103(searchRequest.getYear(), searchRequest.getMonth());

            //0 100
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat104(searchRequest.getDay());
            //0 101
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat105(searchRequest.getYear(), searchRequest.getDay());

            //0 110
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat106(searchRequest.getMonth(), searchRequest.getDay());
            //0 111
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat107(searchRequest.getYear(), searchRequest.getMonth(), searchRequest.getDay());
            //01 001
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat01101(searchRequest.getYear(),getSeasonMonths(searchRequest.getSeasonType()));

            //01 010
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat102(searchRequest.getMonth());
            //01 011
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat103(searchRequest.getYear(), searchRequest.getMonth());

            //01 100
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat104(searchRequest.getDay());
            //01 101
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat105(searchRequest.getYear(), searchRequest.getDay());

            //01 110
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat106(searchRequest.getMonth(), searchRequest.getDay());
            //01 111
            if (searchRequest.getHebergement() == 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat107(searchRequest.getYear(), searchRequest.getMonth(), searchRequest.getDay());
            //10 001
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat101(searchRequest.getYear());

            //10 010
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat102(searchRequest.getMonth());
            //10 011
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat103(searchRequest.getYear(), searchRequest.getMonth());

            //10 100
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat104(searchRequest.getDay());
            //10 101
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat105(searchRequest.getYear(), searchRequest.getDay());

            //10 110
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat106(searchRequest.getMonth(), searchRequest.getDay());
            //10 111
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() == null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat107(searchRequest.getYear(), searchRequest.getMonth(), searchRequest.getDay());
            //11 001
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat101(searchRequest.getYear());

            //11 010
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat102(searchRequest.getMonth());
            //11 011
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() == 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat103(searchRequest.getYear(), searchRequest.getMonth());

            //11 100
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() == 0)
                result = pickupRepository.getAllCampStat104(searchRequest.getDay());
            //11 101
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() == 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat105(searchRequest.getYear(), searchRequest.getDay());

            //11 110
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat106(searchRequest.getMonth(), searchRequest.getDay());
            //11 111
            if (searchRequest.getHebergement() != 0 && searchRequest.getBkg_date() == null && searchRequest.getSeasonType() != null && searchRequest.getDay() != 0 && searchRequest.getMonth() != 0 && searchRequest.getYear() != 0)
                result = pickupRepository.getAllCampStat107(searchRequest.getYear(), searchRequest.getMonth(), searchRequest.getDay());

        }
       return result;

    }
private List<Integer> getSeasonMonths(String season){

        if(season.equals("before season")){
            List<Integer> months= Arrays.asList(4,5,6);
            return months;
        }else if(season.equals("season")){
            List<Integer> months= Arrays.asList(7,8);
            return months;
        }
        else
        {
            List<Integer> months= Arrays.asList(9,10);
            return months;
        }
}
}