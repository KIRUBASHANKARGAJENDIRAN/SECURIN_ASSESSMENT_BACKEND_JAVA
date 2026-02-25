package com.training.demoApp.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.demoApp.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/date")
    public Object getByDate(@RequestParam String date) {
        return service.getByDate(LocalDate.parse(date));
    }

    @GetMapping("/month")
    public Object getByMonth(@RequestParam int month) {
        return service.getByMonth(month);
    }

    @GetMapping("/stats")
    public Object getStats(@RequestParam int year,
                           @RequestParam int month) {
        return service.getStats(year, month);
    }
}
