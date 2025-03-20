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
    task.explore_concat().as(StepVerifier::create)
            .expectNext("A", "B", "C", "D", "E", "F")
            .verifyComplete();
  }
}
