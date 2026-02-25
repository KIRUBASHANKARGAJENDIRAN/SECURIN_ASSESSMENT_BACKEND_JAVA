package com.training.demoApp.serviceimplementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.training.demoApp.dto.TemperatureStatsDTO;
import com.training.demoApp.dto.WeatherResponseDTO;
import com.training.demoApp.model.Weather;
import com.training.demoApp.repository.WeatherRepository;
import com.training.demoApp.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WeatherResponseDTO> getByDate(LocalDate date) {

        return repository.findByDate(date)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public List<WeatherResponseDTO> getByMonth(int month) {

        return repository.findByMonth(month)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public TemperatureStatsDTO getStats(int year, int month) {

        List<Weather> data =
                repository.findByYearAndMonth(year, month);

        List<Double> temps = data.stream()
                .map(Weather::getTemperature)
                .filter(Objects::nonNull)
                .sorted()
                .toList();

        if (temps.isEmpty())
            return new TemperatureStatsDTO(0.0, 0.0, 0.0);

        double max = temps.get(temps.size() - 1);
        double min = temps.get(0);

        double median;
        int size = temps.size();

        if (size % 2 == 0)
            median = (temps.get(size/2 - 1) + temps.get(size/2)) / 2;
        else
            median = temps.get(size/2);

        return new TemperatureStatsDTO(max, median, min);
    }

    private WeatherResponseDTO convertToDTO(Weather w) {

        return new WeatherResponseDTO(
                w.getDateTime(),
                w.getCondition(),
                w.getTemperature(),
                w.getHumidity(),
                w.getPressure()
        );
    }
}
