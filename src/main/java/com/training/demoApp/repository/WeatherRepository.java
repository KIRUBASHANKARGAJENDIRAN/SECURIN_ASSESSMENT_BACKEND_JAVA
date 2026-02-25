package com.training.demoApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.demoApp.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query("SELECT w FROM Weather w WHERE DATE(w.dateTime) = :date")
    List<Weather> findByDate(LocalDate date);

    @Query("SELECT w FROM Weather w WHERE MONTH(w.dateTime) = :month")
    List<Weather> findByMonth(int month);

    @Query("""
        SELECT w FROM Weather w
        WHERE YEAR(w.dateTime) = :year
        AND MONTH(w.dateTime) = :month
    """)
    List<Weather> findByYearAndMonth(int year, int month);
}
