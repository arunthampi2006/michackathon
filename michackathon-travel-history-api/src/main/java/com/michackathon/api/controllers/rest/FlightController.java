package com.michackathon.api.controllers.rest;

import com.michackathon.api.dao.FlightDAO;
import com.michackathon.api.domain.Flight;
import com.michackathon.api.domain.TravelHistory;
import com.michackathon.api.model.FlightSearch;
import com.michackathon.couchbase.CouchbaseClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankajmisra on 10/22/16.
 */

@RestController
@RequestMapping("/flight")
public class FlightController {

    @RequestMapping(value = "/search",method = RequestMethod.POST,
        consumes = "application/json",produces = "application/json")
    public List<Flight> flightSearch(FlightSearch search) throws IOException {
        List<Flight> flights= new ArrayList<Flight>();
        CouchbaseClient client = CouchbaseClient.getConnection("couchbase://localhost:8091", "default");
        if (client != null) {
            FlightDAO dao = new FlightDAO(client, Flight.class);
            flights  = dao.searchFlights(search.getOrigin(), search.getDestination(), search.getDepDate());
        }
        return flights;
    }

}
