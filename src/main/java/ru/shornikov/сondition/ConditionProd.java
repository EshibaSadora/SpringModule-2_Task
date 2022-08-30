package ru.shornikov.сondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionProd implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String ActiveProfile = context.getEnvironment().getActiveProfiles()[0];
        return "prod".equals(ActiveProfile);
    }
}