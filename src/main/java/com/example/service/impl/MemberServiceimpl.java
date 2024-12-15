package com.example.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Member;
import com.example.repo.MemberRepo;
import com.example.service.AuthorService;
import com.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public Member saveMember(Member member) {
        // Ensure member's ID is null before saving to prevent overwriting existing members.
        if (member.getId() != null) {
            throw new IllegalArgumentException("A new member cannot have an ID.");
        }
        return memberRepo.save(member);
    }

    @Override
    public java.lang.reflect.Member addMember(java.lang.reflect.Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMember'");
    }

    @Override
    public Member updateMember(String id, Member member) {
        // Check if the member exists
        if (!memberRepo.existsById(id)) {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist.");
        }

        // Ensure the ID matches the one being updated
        member.setId(id);

        // Save the updated member
        return memberRepo.save(member);
    }

    @Override
    public java.lang.reflect.Member extendMembership(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extendMembership'");
    }

// Delete a member by ID
    @Override
    public void deleteMemberById(String id) {
        // Check if member exists before attempting deletion
        Optional<Member> existingMember = memberRepo.findById(id);
        if (existingMember.isPresent()) {
            memberRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist.");
        }
    }
}



