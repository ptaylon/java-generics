package examples;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BoxExample<E> {

    E content;

    public BoxExample(final E content) {
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    public void setContent(final E content) {
        this.content = content;
    }

    public static void main(String[] args) {

        BoxExample<List<String>> boxExample = new BoxExample<>(List.of("test", "test2", "test3"));
        List<String> dynamicContent = boxExample.getContent();

        dynamicContent.forEach(System.out::println);

        double[] arr = {2.0, 6.0, 8.9};
        BoxExample<Set<Double>> boxExample1 = new BoxExample<>(Arrays.stream(arr).boxed().collect(Collectors.toSet()));
        Set<Double> dynamicContent1 = boxExample1.getContent();

        dynamicContent1.forEach(System.out::println);

    }

}
