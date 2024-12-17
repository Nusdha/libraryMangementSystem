package com.example.service.impl;

import com.example.entity.Member;
import com.example.service.MemberService;
import com.example.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public Member createMember(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return memberRepo.findById(id);
    }

    @Override
    public Member updateMember(String id, Member memberDetails) {
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setName(memberDetails.getName());
        member.setId(memberDetails.getId());
        member.setPhoneNumber(memberDetails.getPhoneNumber());
        member.setEmail(memberDetails.getEmail());

        return memberRepo.save(member);
    }

    @Override
    public void deleteMember(String id) {
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        memberRepo.delete(member);
    }

    @Override
    public void deleteMemberById(String id) {
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        memberRepo.delete(member);
    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepo.findByEmail(email);
    }

    @Override
    public void addMember(Member member) {
        memberRepo.save(member);
    }

    @Override
    public void saveMember(Member member) {
        memberRepo.save(member);
    }

    @Override
    public void extendMembership(String id) {
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        // Example logic to extend membership
        member.setMembershipEndDate(member.getMembershipEndDate().plusYears(1));
        memberRepo.save(member);
    }
}
