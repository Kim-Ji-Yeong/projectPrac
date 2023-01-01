package com.example.projectprac.controller;

import com.example.projectprac.domain.dto.Response;
import com.example.projectprac.domain.dto.User.UserJoinRequest;
import com.example.projectprac.domain.dto.User.UserJoinResponse;
import com.example.projectprac.domain.dto.User.UserLoginRequest;
import com.example.projectprac.domain.dto.User.UserLoginResponse;
import com.example.projectprac.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest){
    UserJoinResponse userJoinResponse = userService.join(userJoinRequest.getUserName(), userJoinRequest.getPassword());
    return Response.success(userJoinResponse);
    }



//    @PostMapping("/login")
//    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest){
//        UserLoginResponse userLoginResponse = userService.login(userLoginRequest.getUserName(),userLoginRequest.getPassword());
//        return Response.success(userLoginResponse);
//    }

}










