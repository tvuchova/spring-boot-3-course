import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;

public class Tests {
  Task task = new Task();
  @Test
  public void testSolution() {
    task.namesFlux_map(3)
        .as(StepVerifier::create)
            .expectNext("4-ALEX", "5-CHLOE")
            .verifyComplete();
  }
}
