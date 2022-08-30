package ru.shornikov.сondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionDev implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String ActiveProfile = context.getEnvironment().getActiveProfiles()[0];
        return "dev".equals(ActiveProfile);
    }
}