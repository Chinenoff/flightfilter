package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilters {

    public FlightFilters() {
    }

    public static List<Flight> filtrededFlights(List<Flight> flightsBeforeSorting, FlightFilter... listFlightFilters) {
        List<Flight> tempListFlights = flightsBeforeSorting;

        for (FlightFilter flightFilter : listFlightFilters) {
            tempListFlights = tempListFlights.stream().filter(flightFilter::check)
                    .collect(Collectors.toList());
        }
        return tempListFlights;
    }
}
