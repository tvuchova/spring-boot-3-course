import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import java.time.Duration;
import java.util.List;

public class Tests {
  Task task = new Task();
  @Test
  public void testSolution() {

    StepVerifier.create(task.bufferAndRequestExample())
            .expectNext(List.of(1, 2, 3, 4, 5))
            .expectNext(List.of(6, 7, 8, 9, 10))
            .expectNext(List.of(11, 12, 13, 14, 15))
            .expectNext(List.of(16, 17, 18, 19, 20))
            .expectNext(List.of(21, 22, 23, 24, 25))
            .expectNext(List.of(26, 27, 28, 29, 30))
            .expectNext(List.of(31, 32, 33, 34, 35))
            .expectNext(List.of(36, 37, 38, 39, 40))
            .expectNext(List.of(41, 42, 43, 44, 45))
            .expectNext(List.of(46, 47, 48, 49, 50))
            .verifyComplete();
  }
  }

