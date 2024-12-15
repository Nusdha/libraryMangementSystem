package com.example.service;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MemberService {
    Member saveMember(Member member);
    Member addMember(Member member);

    Member updateMember(String id, Member member);

    Member extendMembership(String id);
    Optional<Member> getMemberById(String id);

    Optional<Member> findMemberByEmail(String email);
    void deleteMemberById(String id);

}
