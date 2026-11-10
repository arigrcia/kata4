package software.ulpgc.katas;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import software.ulpgc.katas.architecture.UseCase;
import software.ulpgc.katas.architecture.usecases.CalculateFibonacciSeriesUseCase;
import software.ulpgc.katas.infrastructure.adapters.JsonSeriesSerializer;

public class Main {
    static void main() {
        Javalin.create(c -> init(c))
                .start(8080);
    }

    private static void init(JavalinConfig config) {
        config.routes.get("/fibonacci", c-> executeFibonacci(c));
    }

    private static void executeFibonacci(Context context) {
        UseCase useCase = new CalculateFibonacciSeriesUseCase(new JsonSeriesSerializer());
        context.result(useCase.execute(context.queryParam("n")));
    }

}