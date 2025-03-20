package solution;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class Task {
  //put your task here
  public Flux<String> namesFlux_map(int stringLength) {
      var namesList = List.of("alex", "ben", "chloe");
      return Flux.fromIterable(namesList)
              .map(String::toUpperCase)
              .delayElements(Duration.ofMillis(500))
              .filter(s -> s.length() > stringLength)
              .map(s -> s.length() + "-" + s)
              .doOnNext(name -> System.out.println("name is : " + name))
              .doOnSubscribe(s -> System.out.println("Subscription is : " + s))
              .doOnComplete(() -> System.out.println("Completed sending all the items."))
              .doFinally(signalType -> System.out.println("value is : " + signalType))
              .defaultIfEmpty("default");
  }
}
