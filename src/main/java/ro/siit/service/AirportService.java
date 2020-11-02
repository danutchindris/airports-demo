package ro.siit.service;

import ro.siit.domain.Airport;
import ro.siit.model.Search;

import java.util.List;

public interface AirportService {

    List<Airport> findFilteredAirports(Search search);
}
