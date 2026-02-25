package com.training.demoApp.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.training.demoApp.model.Weather;
import com.training.demoApp.repository.WeatherRepository;

import jakarta.annotation.PostConstruct;

@Component
public class CsvLoader {

	private final WeatherRepository repository;

    public CsvLoader(WeatherRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings({ })
    @PostConstruct
    public void load() throws Exception {

        InputStream inputStream =
                getClass().getClassLoader().getResourceAsStream("testset.csv");

        BufferedReader br =
                new BufferedReader(new InputStreamReader(inputStream));

        br.readLine(); // skip header

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            Weather weather = new Weather();

            weather.setDateTime(
                    LocalDateTime.parse(data[0].trim(), formatter)
            );

            weather.setCondition(data[1]);
            weather.setHeatIndex(CsvUtil.parseDouble(data[5]));
            weather.setHumidity(CsvUtil.parseDouble(data[6]));
            weather.setPressure(CsvUtil.parseDouble(data[8]));
            weather.setTemperature(CsvUtil.parseDouble(data[11]));

            repository.save(weather);
        }

        br.close();
    }
}
