package com.kangroklee.demo.controller;

import com.kangroklee.demo.dto.request.JoinRequest;
import com.kangroklee.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @PostMapping("/join")
    public void join(@RequestBody JoinRequest joinRequest) {
        memberService.join(joinRequest);
    }
}