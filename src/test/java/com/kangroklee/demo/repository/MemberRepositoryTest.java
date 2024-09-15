package com.kangroklee.demo.repository;

import com.kangroklee.demo.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback(value = false)
    void save1() {
        Member member = Member.builder()
                .username("memberA")
                .age(23)
                .email("abc@abc.com")
                .build();

        long saveId = memberRepository.save(member);
        Member findMember = memberRepository.findOne(saveId);
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    @Transactional
//    @Rollback
    void save2() {
        Member member = Member.builder()
                .username("memberA")
                .age(23)
                .email("abc@abc.com")
                .build();

        long saveId = memberRepository.save(member);

        em.flush();
        em.clear();

        Member findMember = memberRepository.findOne(saveId);
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByUsername() {
    }
}