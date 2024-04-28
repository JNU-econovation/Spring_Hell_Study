package com.econovation.hellstudy.domains.user.dto.request;

import java.util.List;

public record BlockUserRequest(String blockerId, List<String> blockeeIds) {
}
