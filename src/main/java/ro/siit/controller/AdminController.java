package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.siit.payload.AirportPayload;
import ro.siit.service.AirportService;

@RestController
public class AdminController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/api/v1/airports")
    public ResponseEntity<String> createAirport(@RequestBody final AirportPayload airportPayload) {
        airportService.createAirport(airportPayload.getName());
        return ResponseEntity.ok("Totul a fost bine");
    }

    @PutMapping("/api/v1/airports")
    public ResponseEntity<String> updateAirport(@RequestBody final AirportPayload airportPayload) {
        airportService.updateAirport(airportPayload);
        return ResponseEntity.ok("Am actualizat cu succes");
    }
}
