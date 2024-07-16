package co.edu.escuelaing.interactiveblackboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.interactiveblackboard.repositories.TicketRepository;

@RestController
public class DrawingServiceController {

    @Autowired
    TicketRepository ticketRepository;

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

    @GetMapping("/getticket")
    public String getTicket() {
        return "{\"ticket\":\"" + ticketRepository.getTicket() + "\"}";
    }

}