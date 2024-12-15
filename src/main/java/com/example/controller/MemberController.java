package com.example.controller;

import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Add a new member
    @PostMapping("/add")
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    // Update an existing member
    @PutMapping("/update/{id}")
    public Member updateMember(@PathVariable String id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    // Extend a member's membership by 4 years
    @PostMapping("/extend/{id}")
    public Member extendMembership(@PathVariable String id) {
        return memberService.extendMembership(id);
    }

    // Find a member by email
    @GetMapping("/find/{email}")
    public Optional<Member> findMemberByEmail(@PathVariable String email) {
        return memberService.findMemberByEmail(email);
    }
}