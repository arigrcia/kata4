package software.ulpgc.katas.architecture.domain;

import software.ulpgc.katas.architecture.SeriesCalculator;
import software.ulpgc.katas.architecture.model.Series;

public class FibonacciSeriesCalculator implements SeriesCalculator {
    @Override
    public Series calculate(int n) {
        Series series = new Series();
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            series = series.put(a);
            a = b;
            b += series.get(i);
        }
        return series;
    }
}