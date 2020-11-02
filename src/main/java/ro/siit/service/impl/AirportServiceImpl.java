package ro.siit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.domain.Airport;
import ro.siit.model.Search;
import ro.siit.repository.AirportRepository;
import ro.siit.service.AirportService;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> findFilteredAirports(final Search search) {
        List<Airport> list;
        if (search.hasCountry() && search.hasCity()) {
            list = airportRepository.findByCountryAndCity(search.getCountry(), search.getCity());
        } else if (search.hasCountry()) {
            list = airportRepository.findByCountry(search.getCountry());
        } else if (search.hasCity()) {
            list = airportRepository.findByCity(search.getCity());
        } else {
            list = airportRepository.findAll();
        }
        return list;
    }
}
