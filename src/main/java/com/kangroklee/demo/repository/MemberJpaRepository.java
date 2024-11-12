package com.kangroklee.demo.repository;

import com.kangroklee.demo.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    //JpaRepository 상속 받았으므로 findById등은 있지만 아래같은건 직접 정의해줘야.
    //이렇게만 하면 Spring Boot JPA가 자동으로 쿼리를 생성한다!
    Member findByUsername(String username);
    Optional<Member> findByEmail(String email);
    Page<Member> findByAgeGreaterThan(int age, Pageable pageable);
    Page<Member> findByUsernameStartingWith(String prefix, Pageable pageable);

    boolean existsByUsername(String username);
}
