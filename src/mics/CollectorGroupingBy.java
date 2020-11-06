package mics;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CollectorGroupingBy {
    private int PARALLELIZATION = 4;

    private Collection<List<Integer>> getInvestmentsByChunks(Set<Integer> ids) {
        final AtomicInteger counter = new AtomicInteger();
        return ids.stream().collect(
                Collectors.groupingBy( x -> {
                        int foo = counter.getAndIncrement();
                        int bar =  foo / PARALLELIZATION;
                        return bar;
                    }
                )
        ).values();
    }

    public static void main(String[] args) {
        CollectorGroupingBy collectorGroupingBy = new CollectorGroupingBy();
        Set<Integer> bar = new HashSet();

        bar.add(0);
        bar.add(1);
        bar.add(2);
        bar.add(3);
        bar.add(4);
        bar.add(5);
        bar.add(6);
        bar.add(7);
        bar.add(8);

        System.out.println(collectorGroupingBy.getInvestmentsByChunks(bar));
    }
}
