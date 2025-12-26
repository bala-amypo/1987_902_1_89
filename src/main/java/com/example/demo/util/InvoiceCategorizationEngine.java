package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {
    
    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {
        if (invoice == null || invoice.getDescription() == null || rules == null) {
            return null;
        }
        
        String description = invoice.getDescription();
        
        for (CategorizationRule rule : rules) {
            if (matchesRule(description, rule)) {
                return rule.getCategory();
            }
        }
        
        return null;
    }
    
    private boolean matchesRule(String description, CategorizationRule rule) {
        if (rule.getKeyword() == null || rule.getKeyword().isEmpty()) {
            return false;
        }
        
        switch (rule.getMatchType()) {
            case EXACT:
                return description.equals(rule.getKeyword());
            case CONTAINS:
                return description.toLowerCase().contains(rule.getKeyword().toLowerCase());
            case REGEX:
                try {
                    Pattern pattern = Pattern.compile(rule.getKeyword());
                    return pattern.matcher(description).find();
                } catch (Exception e) {
                    return false;
                }
            default:
                return false;
        }
    }
}