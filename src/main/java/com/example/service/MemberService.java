package com.example.service;

import com.example.entity.Member;
import java.util.List; 
import java.util.Optional;

public interface MemberService {
    Member createMember(Member member);
    List<Member> getAllMember();
    Optional<Member> getMemberById(String id);
    Member updateMember(String id, Member memberDetails);
    void deleteMember(String id);
    // Additional methods
    void deleteMemberById(String id);
    Optional<Member> findMemberByEmail(String email);
    void addMember(Member member);
    void saveMember(Member member);
    void extendMembership(String id);
}


