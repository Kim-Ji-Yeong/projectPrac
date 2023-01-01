package com.example.projectprac.domain.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserJoinResponse {
    private Long id;
    private String userName;
}
