import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(14, 33, -24, 16, -1, 55, 0, 66, 28, 84, -55, 38, 73, -45));
        Stream<Integer> stream = list.stream();
        Comparator<Integer> integerComparator = Comparator.naturalOrder();
        BiConsumer<Integer, Integer> biConsumer = (e1, e2) -> System.out.println("Max: " + e1 + "\nMin: " + e2);

        findMinMax(stream, integerComparator, biConsumer);
        evenNumbers(list);
    }

    public static void findMinMax(Stream<Integer> stream, Comparator<Integer> comparator, BiConsumer<Integer, Integer> biConsumer) {
        List<Integer> collect = stream.collect(Collectors.toList());
        Integer max = collect.stream().max(comparator).orElse(null);
        Integer min = collect.stream().min(comparator).orElse(null);
        biConsumer.accept(max, min);
    }

    public static void evenNumbers(List<Integer> list) {
        List<Integer> collect = list.stream()
                .filter(e -> e != 0 && e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Количество чётных чисел: " + collect.size() + "\n" + collect);
    }

}