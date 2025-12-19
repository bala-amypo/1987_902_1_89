package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Categorization Rules Endpoints")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;

    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Operation(summary = "Create rule for category")
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<CategorizationRule> createRule(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {

        return new ResponseEntity<>(
                ruleService.createRule(categoryId, rule),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get rules by category")
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CategorizationRule>> getRulesByCategory(
            @PathVariable Long categoryId) {

        return ResponseEntity.ok(ruleService.getRulesByCategory(categoryId));
    }

    @Operation(summary = "Delete rule")
    @DeleteMapping("/{ruleId}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long ruleId) {
        ruleService.deleteRule(ruleId);
        return ResponseEntity.noContent().build();
    }
}
