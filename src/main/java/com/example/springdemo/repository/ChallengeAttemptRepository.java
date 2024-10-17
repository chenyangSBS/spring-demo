package com.example.springdemo.repository;

import com.example.springdemo.entity.ChallengeAttempt;
import com.example.springdemo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeAttemptRepository extends CrudRepository<ChallengeAttempt, Long> {

    /**
     * @return the last 10 attempts for a given user, identified by their alias.
     */
    @EntityGraph(attributePaths = "user")
    List<ChallengeAttempt> findTop10ByUserAliasOrderByIdDesc(String userAlias);

    ChallengeAttempt findChallengeAttemptByUser(User user);

    @Query(value = "select * from challenge_attempt", nativeQuery = true)
    List<ChallengeAttempt> findAllNative();

    List<ChallengeAttempt> findAll();
}
