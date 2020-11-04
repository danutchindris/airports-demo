package ro.siit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/*
- tabela flights
      - id long PK
      - flightno string
      - departure datetime
      - arrival datetime
      - departure_airport FK (foreign key; legatura la id-ul tabelei airports)
      - arrival_airport FK (foreign key; legatura la id-ul tabelei airports)
      - airline FK (foreign key catre tabela airlines)
 */
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "flight_no")
    private String flightNo;

    @Column(name = "departure_time")
    private LocalDateTime departure;

    @Column(name = "arrival_time")
    private LocalDateTime arrival;

    @ManyToOne(targetEntity = Airport.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne(targetEntity = Airport.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @ManyToOne(targetEntity = Airline.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
