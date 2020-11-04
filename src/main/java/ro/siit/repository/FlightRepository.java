package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.domain.Flight;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFlightNo(String flightNo);
}
