package software.ulpgc.katas.architecture.usecases;

import software.ulpgc.katas.architecture.UseCase;
import software.ulpgc.katas.architecture.domain.FibonacciSeriesCalculator;
import software.ulpgc.katas.architecture.model.Series;
import software.ulpgc.katas.architecture.ports.SeriesSerializer;

public class CalculateFibonacciSeriesUseCase implements UseCase {
    private final SeriesSerializer serializer;

    public CalculateFibonacciSeriesUseCase(SeriesSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public String execute(String input) {
        Series series = new FibonacciSeriesCalculator().calculate(Integer.parseInt(input));
        return serializer.serialize(series);
    }
}