package com.econovation.third_project.agrregate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

//TODO: 제네릭?
@Component
public class AdminPageQueryAggregator {
    private final Map<String, AdminPageQuery> queries;
    public AdminPageQueryAggregator(List<AdminPageQuery> queries) {
        this.queries = queries.stream()
                .collect(Collectors.toMap(AdminPageQuery::getType, Function.identity()));
    }

    public Map<String, List<?>> aggregate(Set<String> requests){
        List<AdminPageQuery> queriesToExecute = getQueriesToExecute(requests);
        Map<String, CompletableFuture<List<?>>> executedQueries = executeQueriesAsync(queriesToExecute);
        return aggregateResults(executedQueries);
    }

    private List<AdminPageQuery> getQueriesToExecute(Set<String> requests){
        return requests.stream()
                .map(request -> Optional.ofNullable(queries.get(request))
                        .orElseThrow(IllegalArgumentException::new)
                )
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
