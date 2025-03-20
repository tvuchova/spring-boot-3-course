import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;
public class Tests {
  Task task = new Task();
  @Test
  public void testSolution() {
    // put your test here
    task.explore_zip()
        .as(StepVerifier::create)
        .expectNextMatches(p -> p.getT1().equals("A") && p.getT2().equals("1"))
        .expectNextMatches(p -> p.getT1().equals("B") && p.getT2().equals("2"))
        .expectNextMatches(p -> p.getT1().equals("C") && p.getT2().equals("3"))
        .verifyComplete();
  }
}
