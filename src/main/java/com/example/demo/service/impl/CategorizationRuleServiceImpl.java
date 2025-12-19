package com.example.backendproject.service.impl;
import com.example.backendproject.model.Category;
import com.example.backendproject.model.CategorizationRule;
import com.example.backendproject.repository.CategoryRepository;
import com.example.backendproject.repository.CategorizationRuleRepository;
import com.example.backendproject.service.CategorizationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository,
                                         CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        rule.setCategory(category);
        return ruleRepository.save(rule);
    }

    @Override
    public List<CategorizationRule> getRulesByCategory(Long categoryId) {
        return ruleRepository.findByCategoryId(categoryId);
    }

    @Override
    public void deleteRule(Long ruleId) {
        ruleRepository.deleteById(ruleId);
    }
}

