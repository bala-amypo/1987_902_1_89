package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription();

        for (CategorizationRule rule : rules) {
            switch (rule.getMatchType()) {
                case "EXACT":
                    if (description.equalsIgnoreCase(rule.getKeyword())) {
                        return rule.getCategory();
                    }
                    break;

                case "CONTAINS":
                    if (description.toLowerCase()
                            .contains(rule.getKeyword().toLowerCase())) {
                        return rule.getCategory();
                    }
                    break;

                case "REGEX":
                    if (Pattern.compile(rule.getKeyword(),
                            Pattern.CASE_INSENSITIVE)
                            .matcher(description).find()) {
                        return rule.getCategory();
                    }
                    break;
            }
        }
        return null;
    }
}
