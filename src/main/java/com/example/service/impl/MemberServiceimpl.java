package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Member;
import com.example.repo.MemberRepo;
import com.example.service.AuthorService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    // Save a new member
    @Override
    public Member savemMember(Member member) {
        // Ensure member's ID is null before saving to prevent overwriting existing members.
        if (member.getId() != null) {
            throw new IllegalArgumentException("A new member cannot have an ID.");
        }
        return memberRepo.save(member);
    }

    // Get a member by ID
    @Override
    public Optional<Member> getMemberById(String id) {
        // Optional will return null if the member doesn't exist
        return memberRepo.findById(id);
    }

    // Get all members
    @Override
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    // Delete a member by ID
    @Override
    public void deleteMember(String id) {
        // Check if member exists before attempting deletion
        Optional<Member> existingMember = memberRepo.findById(id);
        if (existingMember.isPresent()) {
            memberRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist.");
        }
    }

    // Update member information
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
}



