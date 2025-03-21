package solution;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public class Task {
  //put your task here
  public Flux<Tuple2<String, String>> explore_zip() {
    var abcFlux = Flux.just("a", "b", "c");
    var numbersFlux = Flux.just("1", "2", "3");
    return Flux.zip(abcFlux.map(String::toUpperCase), numbersFlux);
  }
}
