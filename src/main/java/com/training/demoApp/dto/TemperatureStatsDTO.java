package com.training.demoApp.dto;

public class TemperatureStatsDTO {

    public Double getMax() {
		return max;
	}

	public Double getMedian() {
		return median;
	}

	public Double getMin() {
		return min;
	}

	private Double max;
    private Double median;
    private Double min;

    public TemperatureStatsDTO(Double max, Double median, Double min) {
        this.max = max;
        this.median = median;
        this.min = min;
    }

	
}