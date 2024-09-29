package com.kangroklee.demo.service;

import com.kangroklee.demo.domain.Member;
import com.kangroklee.demo.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    public Page<Member> getMembersByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("username").ascending());
        return memberJpaRepository.findAll(pageable);
    }

    public void printMembersByPage(int page, int size) {
        Page<Member> memberPage = getMembersByPage(page, size);
        List<Member> members = memberPage.getContent();

        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Username: " + member.getUsername());
        }
    }

    public Page<Member> getMembersByAgeGreaterThan(int page, int size, int age) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("username").ascending());
        return memberJpaRepository.findByAgeGreaterThan(age, pageable);
    }

    public void printMembersByAgeGreaterThan(int page, int size, int age) {
        Page<Member> memberPage = getMembersByAgeGreaterThan(page, size, age);
        List<Member> members = memberPage.getContent();

        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Username: " + member.getUsername() + ", Age: " + member.getAge());
        }
    }

    public Page<Member> getMembersByUsernameStartingWith(int page, int size, String prefix) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("username").ascending());
        return memberJpaRepository.findByUsernameStartingWith(prefix, pageable);
    }

    public void printMembersByUsernameStartingWith(int page, int size, String prefix) {
        Page<Member> memberPage = getMembersByUsernameStartingWith(page, size, prefix);
        List<Member> members = memberPage.getContent();

        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Username: " + member.getUsername());
        }
    }


}
