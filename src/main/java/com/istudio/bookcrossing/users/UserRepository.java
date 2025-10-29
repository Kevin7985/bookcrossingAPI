package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(
            "SELECT u FROM User u " +
            "WHERE (u.isActive = true) AND (u.id = :uid)"
    )
    Optional<User> findActiveById(@Param("uid") UUID userId);

    @Query(
            "SELECT u FROM User u " +
            "WHERE (u.email = :email) AND (u.password = :pass)"
    )
    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("pass") String password);
}
