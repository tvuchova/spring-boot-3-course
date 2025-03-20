import reactor.core.publisher.Flux;

import java.util.List;


public class Task
{
    // TODO: Implement this method to return a Flux<String>

    public Flux<String> getMessages(int len) {
        var namesList = List.of("alex", "ben", "chloe");
        return Flux.fromIterable(namesList)
                .map(String::toUpperCase)
                .filter(s -> s.length() > len)
                .flatMap(this::splitString); // Replace with actual implementation

    }
    private Flux<String> splitString(String name) {
        return Flux.fromArray(name.split("")); // Converts "ALEX" -> ["A", "L", "E", "X"]
    }
}
