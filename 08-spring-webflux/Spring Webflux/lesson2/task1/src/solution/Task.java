package solution;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Task {
  //put your task here
  public Flux<Integer> limitRateExample(Flux<Integer> largeFlux) {
      //Flux<Integer> largeFlux = Flux.range(1, 1000);

      return largeFlux.limitRate(10)
              .doOnNext(System.out::println)
              .delayElements(Duration.ofMillis(1));
  }
}
