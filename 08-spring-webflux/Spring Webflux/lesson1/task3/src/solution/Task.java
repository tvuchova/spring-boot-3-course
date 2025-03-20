package solution;

import reactor.core.publisher.Flux;

import java.util.List;


public class Task
{
    // TODO: Implement this method to return a Flux<String>

    public Flux<String> getMessages(int len) {
         // Replace with actual implementation
        return null;
    }
    private Flux<String> splitString(String name) {
        return Flux.fromArray(name.split("")); // Converts "ALEX" -> ["A", "L", "E", "X"]
    }
}
