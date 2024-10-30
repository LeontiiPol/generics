package ru.polovinko.generics.examples.pecs;

import ru.polovinko.generics.examples.pecs.domain.Children;
import ru.polovinko.generics.examples.pecs.domain.GrandParent;
import ru.polovinko.generics.examples.pecs.domain.Parent;

import java.util.List;

public class Pecs {

    public static void pecsExample() {
        List<Children> source = List.of(new Children(), new Children());
        List<GrandParent> target = List.of(new GrandParent(), new Parent());

        copy(source, target);
    }
    public static void copy(List<? extends GrandParent> src, List<? super GrandParent> trg) {
        for(GrandParent item : src) {
            trg.add(item);
        }
    }

    public static void whyWeCannotAddToProducer() {
        List<Children> childs = List.of(new Children(), new Children());
        addToProducer(childs);
        Children child = childs.get(0); // тут прилетает Parent и прокидывается исключение
    }

    public static void addToProducer(List<? extends GrandParent> producer) {
        producer.add(new Parent());
//        capture(producer, new Children());
    }

    private static <T> void capture(List<T> list, Object value) {
        list.add((T) value);
    }

    public static void whyWeCannotReadNothingExceptObjectFromConsumer() {
        List<GrandParent> grandParents = List.of(new GrandParent(), new GrandParent());
        readFromConcumer(grandParents);
    }

    public static void readFromConcumer(List<? super Parent> consumer) {
        Parent parent = consumer.get(0); // тут вернется GrandParent и прокинется исключение
    }

}
