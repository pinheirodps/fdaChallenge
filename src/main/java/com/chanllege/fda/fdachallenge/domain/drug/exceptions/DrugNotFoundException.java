package com.chanllege.fda.fdachallenge.domain.drug.exceptions;

import com.chanllege.fda.fdachallenge.domain.common.exceptions.AbstractCustomThrowableProblem;
import org.springframework.data.domain.Pageable;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.Map;

/**
 * The type Drug not found exception.
 */
public class DrugNotFoundException extends AbstractCustomThrowableProblem {

    private static final URI TYPE = URI.create("urn:fda-service:problem-type:drug_not_found");


    /**
     * Instantiates a new Drug not found exception.
     *
     * @param manufacturerName the manufacturer name
     * @param brandName        the brand name
     * @param pageable         the pageable
     */
    public DrugNotFoundException(final String manufacturerName, final String brandName,
                                 final Pageable pageable) {
        super(TYPE, "Drug Not Found", Status.NOT_FOUND,
            String.format("Drug with manufacturerName %s brandName %s pageable %s not found",
                    manufacturerName, brandName, pageable), Map.of("manufacturerName", manufacturerName,
                        "brandName", brandName, "pageable", pageable)

                );
    }

    /**
     * Instantiates a new Drug not found exception.
     */
    public DrugNotFoundException() {
        super(TYPE, "Drugs Not Found", Status.NOT_FOUND, "Drugs Not Found", null);

    }

}
