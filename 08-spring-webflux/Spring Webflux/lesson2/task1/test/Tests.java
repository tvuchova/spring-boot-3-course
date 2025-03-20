import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Tests {
  Task task = new Task();
  @Test
  public void testSolution() {

    // put your test here
    //Flux<Integer> largeFlux = Flux.range(1, 1000).limitRate(10);
    ;
    Flux<Integer> range = Flux.range(1, 1000);
    StepVerifier.create(task.limitRateExample(range))
            .expectNextCount(1000) // Ensure all 1000 elements are processed
            .verifyComplete();
  }
}
