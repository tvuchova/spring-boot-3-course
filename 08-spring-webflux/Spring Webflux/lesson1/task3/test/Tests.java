import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


public class Tests {
  @Test
  void testNamesFlux_map() {
    Task ts=new Task();
    Flux<String> resultFlux = ts.getMessages(3);

    StepVerifier.create(resultFlux)
            .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
            .verifyComplete();
  }
}
