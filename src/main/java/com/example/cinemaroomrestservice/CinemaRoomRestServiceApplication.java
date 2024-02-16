package com.example.cinemaroomrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class CinemaRoomRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaRoomRestServiceApplication.class, args);
    }

    @GetMapping("/seats")
    public Map<String, Object> getSeatsInfo() {
        int rows = 9;
        int columns = 9;
        List<Map<String, Integer>> seats = new ArrayList<>();

        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                Map<String, Integer> seat = new HashMap<>();
                seat.put("row", row);
                seat.put("column", column);
                seats.add(seat);
            }
        }

        Map<String, Object> cinemaInfo = new HashMap<>();
        cinemaInfo.put("rows", rows);
        cinemaInfo.put("columns", columns);
        cinemaInfo.put("seats", seats);

        // Log to console to verify the endpoint call
        System.out.println("Endpoint /seats called");

        return cinemaInfo;
    }


}
