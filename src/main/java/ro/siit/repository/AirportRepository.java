package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.domain.Airport;

import java.util.List;

/*

Interfata de lucru cu baza de date
Mai concret, e o interfata care abstractizeaza lucrul cu tabela "airports" din DB
De fapt, interfata AirportRepository nu lucreaza direct cu tabela, ci cu maparea ei la clasa Airport,
care e o clasa de tip Entity. Un obiect al clasei de tip entity reprezinta o inregistrare a tabelei
pe care o mapeaza.

 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCountryAndCity(String country, String city);

    List<Airport> findByCountry(String country);

    List<Airport> findByCity(String city);
}
