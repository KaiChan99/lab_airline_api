package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(long id){ return flightRepository.findById(id).get();}

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public Flight addPassengerToFlight(long FlightId, long PassengerId){
        Flight flight = flightRepository.findById(FlightId).get();
        Passenger passenger = passengerRepository.findById(PassengerId).get();
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        flightRepository.save(flight);
        return flight;
    }

    public void deleteFlight(long id){
        flightRepository.deleteById(id);

    }
}
