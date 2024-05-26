package com.econovation.fourth_project.policy.servicce;

import com.econovation.fourth_project.policy.database.Database;
import com.econovation.fourth_project.policy.domain.Effect;
import com.econovation.fourth_project.policy.domain.Policy;
import com.econovation.fourth_project.policy.dto.request.CheckResourceRequest;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
@RequiredArgsConstructor
public class CheckResourceUseCase {
    private final Database database;

    public Boolean execute(CheckResourceRequest request, String resource) {
        Either<Policy,Policy> policy = findByResource(resource);
        policy.fold(

        )
    }

    /**
     * Either<Deny,Allow>
     */
    private Either<Policy,Policy> findByResource(String resource) {
        List<Policy> policies = database.findByResource(resource);
        Map<Effect,List<Policy>> groupByEffect = policies.stream().collect(groupingBy(policy -> policy.getStatement().getEffect()));
        if(groupByEffect.containsKey(Effect.Deny))
            // stream.findFirst나 findAny보다 그냥 0번째 인덱스 가져 오는게 더 성능상 좋을 것 같다.
            return Either.left(groupByEffect.get(Effect.Deny).get(0));
        else
            return Either.right(groupByEffect.get(Effect.Allow).get(0));
    }
    // Effect가 Deny인 경우
    private boolean checkAction()


}
