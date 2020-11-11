package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.siit.domain.Flight;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFlightNo(String flightNo);

    /*
    -- toate zborurile care pleaca de la un anumit aeroport, intr-o data anume
    -- SQL
    select * from flights f
    inner join airports a
    on a.id = f.departure_airport_id
    where f.departure_time::date = date '2020-11-07'
    and a.city = 'London'
    */

    /*
    acum scriem un query JPQL - Java Persistence API Query Language
    seamana, dar nu e SQL
     */
    @Query("select f from Flight f inner join f.departureAirport a " +
            "where f.departure >= :departureDate " +
            "and a.city = :departureCity")
    List<Flight> findFlightsByCustomRules(@Param("departureDate") LocalDateTime departureDate,
                                          @Param("departureCity") String departureCity);
}
