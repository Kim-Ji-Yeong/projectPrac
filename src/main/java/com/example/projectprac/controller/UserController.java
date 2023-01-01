package com.example.projectprac.controller;

import com.example.projectprac.domain.dto.Response;
import com.example.projectprac.domain.dto.User.UserJoinRequeseet;
import com.example.projectprac.domain.dto.User.UserJoinResponse;
import com.example.projectprac.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    Response<UserJoinResponse> join(@RequestBody UserJoinRequeseet userJoinRequeseet){
    UserJoinResponse userJoinResponse = userService.join(userJoinRequeseet.getUserName(), userJoinRequeseet.getPassword());
    return Response.success(userJoinResponse);
    }
}
