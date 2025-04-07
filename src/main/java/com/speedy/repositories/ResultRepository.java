package com.speedy.repositories;

import com.speedy.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findByLink(String link);
}
