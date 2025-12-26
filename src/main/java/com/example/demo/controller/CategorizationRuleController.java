package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {
    
    private final CategorizationRuleService categorizationRuleService;
    
    public CategorizationRuleController(CategorizationRuleService categorizationRuleService) {
        this.categorizationRuleService = categorizationRuleService;
    }
    
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<CategorizationRule> createRule(@PathVariable Long categoryId,
                                                        @RequestBody CategorizationRule rule) {
        CategorizationRule createdRule = categorizationRuleService.createRule(categoryId, rule);
        return ResponseEntity.ok(createdRule);
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CategorizationRule>> getRulesByCategory(@PathVariable Long categoryId) {
        List<CategorizationRule> rules = categorizationRuleService.getRulesByCategory(categoryId);
        return ResponseEntity.ok(rules);
    }
    
    @DeleteMapping("/{ruleId}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long ruleId) {
        categorizationRuleService.deleteRule(ruleId);
        return ResponseEntity.ok().build();
    }
}