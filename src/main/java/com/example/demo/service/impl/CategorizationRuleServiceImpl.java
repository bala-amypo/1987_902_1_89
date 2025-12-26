package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {
    
    private final CategorizationRuleRepository categorizationRuleRepository;
    private final CategoryRepository categoryRepository;
    
    public CategorizationRuleServiceImpl(CategorizationRuleRepository categorizationRuleRepository,
                                       CategoryRepository categoryRepository) {
        this.categorizationRuleRepository = categorizationRuleRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        
        rule.setCategory(category);
        return categorizationRuleRepository.save(rule);
    }
    
    @Override
    public List<CategorizationRule> getRulesByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        
        return categorizationRuleRepository.findAll().stream()
                .filter(rule -> rule.getCategory().getId().equals(categoryId))
                .toList();
    }
    
    @Override
    public void deleteRule(Long ruleId) {
        if (!categorizationRuleRepository.existsById(ruleId)) {
            throw new ResourceNotFoundException("Rule not found");
        }
        categorizationRuleRepository.deleteById(ruleId);
    }
}