package ro.siit.service;

import ro.siit.domain.Airport;
import ro.siit.model.Search;
import ro.siit.payload.AirportPayload;

import java.util.List;

public interface AirportService {

    List<Airport> findFilteredAirports(Search search);

    Airport createAirport(String name);

    Airport updateAirport(AirportPayload payload);
}
