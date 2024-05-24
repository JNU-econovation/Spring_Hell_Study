package com.econovation.third_project.agrregate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminPageQueryAggregator {
    private final List<AdminPageQuery> queries;

    public Map<String, List<?>> aggregate(Set<String> requests){
        List<AdminPageQuery> queriesToExecute = getQueriesToExecute(requests);
        Map<String, CompletableFuture<List<?>>> executedQueries = executeQueriesAsync(queriesToExecute);
        return aggregateResults(executedQueries);
    }

    private List<AdminPageQuery> getQueriesToExecute(Set<String> requests){
        return this.queries.stream()
                .filter(query -> requests.contains(query.getType()))
                .toList();
    }

    private Map<String, CompletableFuture<List<?>>> executeQueriesAsync(List<AdminPageQuery> queriesToExecute){
        return queriesToExecute.stream()
                .collect(Collectors.toMap(
                        AdminPageQuery::getType,
                        query-> CompletableFuture.supplyAsync(query::execute)
                ));
    }

    private Map<String, List<?>> aggregateResults(Map<String, CompletableFuture<List<?>>> executedQueries) {
        return CompletableFuture.allOf(executedQueries.values().toArray(new CompletableFuture[0]))
                .<Map<String, List<?>>>thenApply(v ->
                        executedQueries.entrySet().stream()
                                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().join()))
                )
                .join();
    }

}
