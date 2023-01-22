package com.chanllege.fda.fdachallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

/**
 * The type Problem config.
 */
@Configuration
public class ProblemConfig {

    /**
     * Problem module problem module.
     *
     * @return the problem module
     */
    @Bean
    ProblemModule problemModule() {
        final ProblemModule module = new ProblemModule();

        // do not show stacktraces
        module.withStackTraces(false);
        return module;
    }

    /**
     * Constraint violation problem module constraint violation problem module.
     *
     * @return the constraint violation problem module
     */
    @Bean
    ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }
}
