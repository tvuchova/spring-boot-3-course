package solution;

import reactor.core.publisher.Flux;

public class Task {
  //put your task here
  public Flux<String> explore_concat() {
      var abcFlux = Flux.just("a", "b", "c");
      var defFlux = Flux.just("d", "e", "f");
      return Flux.concat(abcFlux.map(String::toUpperCase), defFlux.map(String::toUpperCase));
  }
}
