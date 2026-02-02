package com.thephoenixcollective.user_service.repository;

import com.thephoenixcollective.user_service.entity.HRContactsEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRContactsRepository extends JpaRepository<HRContactsEntity, Long> {
    boolean existsByEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email);
}
