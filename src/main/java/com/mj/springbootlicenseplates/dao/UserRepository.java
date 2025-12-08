package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (name) VALUES (:name)", nativeQuery = true)
    void insertUserNative(@Param("name") String name);

    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    User getUserNative(@Param("name") String name);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM users WHERE name = :name)", nativeQuery = true)
    boolean existsByNameNative(@Param("name") String name);

}
