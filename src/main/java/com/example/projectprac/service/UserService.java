package com.example.projectprac.service;

import com.example.projectprac.domain.dto.User.UserJoinResponse;
import com.example.projectprac.domain.dto.entity.User;
import com.example.projectprac.exception.AppException;
import com.example.projectprac.exception.ErrorCode;
import com.example.projectprac.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserJoinResponse join(String userName, String password){

        //userName 중복 check
        userRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPLICATED, userName + "는 이미 있습니다.");
                });
        //저장
        User user = User.builder()
                .userName(userName)
                .password(password)
                .build();
        userRepository.save(user);

        UserJoinResponse userJoinResponse = UserJoinResponse
                .builder()
                .userName(user.getUserName())
                .id(user.getId())
                .build();
        return userJoinResponse;
    }
}
