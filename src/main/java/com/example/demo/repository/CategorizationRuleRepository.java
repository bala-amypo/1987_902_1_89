package com.example.backendproject.repository;
import com.example.backendproject.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {
    List<CategorizationRule> findByCategoryId(Long categoryId);
}
