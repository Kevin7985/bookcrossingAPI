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
            "WHERE (u.id = :uid) AND (u.isActive = true)"
    )
    Optional<User> findByIdActive(@Param("uid") UUID userId);
}
