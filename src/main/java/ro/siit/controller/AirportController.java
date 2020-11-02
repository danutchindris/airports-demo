package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.domain.Airport;
import ro.siit.model.Search;
import ro.siit.repository.AirportRepository;
import ro.siit.service.AirportService;

import java.util.List;

/*

Clasa de tip controller, in care punem mapari de cai HTTP pe care le accesam in browser
e.g. /airports

Controller-ul mapeaza o cale (path) HTTP la o metoda Java, folosind o adnotatie ("annotation")
(e.g. GetMapping - creeaza o mapare cu metoda HTTP GET la metoda Java ce urmeaza dupa adnotatie)

 */
@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/airports") // mapping-ul de e tip GET (metoda HTTP) pentru ca accesam
    // calea /airports in browser cu scopul de a obtine date si a le afisa in pagina
    public String retrieveAirports(final Model model) {
        final List<Airport> airports = airportRepository.findAll();
        model.addAttribute("myAirports", airports);

        return "airports-page"; // String-ul "airports-page" este un nume de "View"
        // care are ca scop sa agrege datele obtinute cu un "template"
        // agregarea e facuta de catre un "template engine", cum ar fi Thymeleaf
        // in final rezulta un document HTML, care e trimis catre browser ca "response"
    }

    @GetMapping("/search")
    public ModelAndView displaySearchPage() {
        final ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("search", new Search());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView displaySearchResults(final Search search) {
        final ModelAndView modelAndView = new ModelAndView("airports-page");
        final List<Airport> list = airportService.findFilteredAirports(search);
        modelAndView.addObject("myAirports", list);
        return modelAndView;
    }
}

// Spring Framework e un ecosistem cu multe proiecte, printre care Spring MVC, Spring Data JPA

// proiectul de Spring pe care il folosim pentru a construi aplicatii web cu interfata grafica
// se numeste Spring MVC
// MVC vine de la Model-View-Controller (design pattern care organizeaza un proiect pe layer-e)
// separa componentele proiectului in cele trei parti:
// Model - transporta date intre Controller si View (in ambele sensuri)
// Controller - mapeaza path-uri la metode Java
// View - agrega datele primite de la Controller cu un template - lucru facut de un template engine