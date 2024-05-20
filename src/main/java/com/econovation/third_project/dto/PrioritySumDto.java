package com.econovation.third_project.dto;

import java.util.Map;

public record PrioritySumDto(Map<String,Long> firstPrioritySum,
                             Map<String,Long> secondPrioritySum) {
}
