package com.training.demoApp.service;

import java.time.LocalDate;
import java.util.List;

import com.training.demoApp.dto.TemperatureStatsDTO;
import com.training.demoApp.dto.WeatherResponseDTO;

public interface WeatherService {

    List<WeatherResponseDTO> getByDate(LocalDate date);

    List<WeatherResponseDTO> getByMonth(int month);

    TemperatureStatsDTO getStats(int year, int month);
}
