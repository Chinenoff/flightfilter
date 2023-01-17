package com.gridnine.testing;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.FlightFilters;
import com.gridnine.testing.filter.collection.DepartingInPast;
import com.gridnine.testing.filter.collection.DepartsBeforeArrives;
import com.gridnine.testing.filter.collection.MoreTwoHoursGroundTime;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights);

        System.out.println("****ORIGINAL****");
        flights.stream()
                .forEach(System.out::println);

        System.out.println("**** FILTER DepartingInPast ****");
        FlightFilters.filtrededFlights(flights, Filter.DEPARTINGINPAST.getTypeFilter())
                .stream()
                .forEach(System.out::println);

        System.out.println("**** FILTER DepartsBeforeArrives ****");
        FlightFilters.filtrededFlights(flights, new DepartsBeforeArrives())
                .stream()
                .forEach(System.out::println);

        System.out.println("**** FILTER MoreTwoHoursGroundTime ****");
        FlightFilters.filtrededFlights(flights, new MoreTwoHoursGroundTime())
                .stream()
                .forEach(System.out::println);

        System.out.println("**** RESULT MULTI FILTER ****");
        FlightFilters.filtrededFlights(flights, new DepartingInPast(), new DepartsBeforeArrives(), new MoreTwoHoursGroundTime())
                .stream()
                .forEach(System.out::println);
    }
}
