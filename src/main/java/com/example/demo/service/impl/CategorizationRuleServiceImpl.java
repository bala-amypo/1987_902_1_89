package com.example.backendproject.service.impl;

import com.example.backendproject.exception.ResourceNotFoundException;
import com.example.backendproject.model.CategorizationRule;
import com.example.backendproject.model.Category;
import com.example.backendproject.repository.*;
import com.example.backendproject.service.CategorizationRuleService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl
        implements CategorizationRuleService {

    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository ruleRepo,
            CategoryRepository categoryRepo
    ) {
        this.ruleRepository = ruleRepo;
        this.categoryRepository = categoryRepo;
    }

    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        rule.setCategory(category);
        return ruleRepository.save(rule);
    }

    @Override
    public List<CategorizationRule> getRulesByCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        return ruleRepository.findAll().stream()
                .filter(r -> r.getCategory().equals(category))
                .toList();
    }

    @Override
    public void deleteRule(Long ruleId) {
        ruleRepository.deleteById(ruleId);
    }
}
