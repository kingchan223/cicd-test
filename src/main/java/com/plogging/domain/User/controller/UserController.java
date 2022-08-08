package com.plogging.domain.User.controller;

import com.plogging.domain.User.dto.UserDeleteReq;
import com.plogging.domain.User.dto.UserJoinReq;
import com.plogging.domain.User.entity.User;
import com.plogging.domain.User.service.UserService;
import com.plogging.global.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ApplicationResponse<User> join(@Valid @RequestBody UserJoinReq userJoinReq){
        return ApplicationResponse.create(
                "가입완료",
                userService.join(userJoinReq)
        );
    }

    @PostMapping("/delete")
    public ResponseEntity<User> delete(@Valid @RequestBody UserDeleteReq userDeleteReq){
        return ResponseEntity.ok(
                userService.delete(userDeleteReq)
        );
    }
    //주석 추가
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/bye")
    public String bye(){
        return "bye world";
    }
}
