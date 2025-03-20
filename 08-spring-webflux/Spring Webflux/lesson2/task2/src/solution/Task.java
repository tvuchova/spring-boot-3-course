package solution;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class Task {
    //put your task here
    public Flux<List<Integer>> bufferAndRequestExample() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofMillis(1))
                .buffer(5);
    }
}
