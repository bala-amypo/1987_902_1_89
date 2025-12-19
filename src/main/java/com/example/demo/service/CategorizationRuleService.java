package com.example.backendproject.service;
import com.example.backendproject.model.CategorizationRule;

import java.util.List;

public interface CategorizationRuleService {
    CategorizationRule createRule(Long categoryId, CategorizationRule rule);
    List<CategorizationRule> getRulesByCategory(Long categoryId);
    void deleteRule(Long ruleId);
}


