package com.chanllege.fda.fdachallenge.domain.drug.services;

import com.chanllege.fda.fdachallenge.infrasctructure.dtos.OpenFDADrugRecordApplicationResponse;
import org.springframework.data.domain.Pageable;

/**
 * The interface Fda client external service.
 */
public interface FdaClientExternalService {

    /**
     * Search optional.
     *
     * @param manufacturerName the manufacturer name
     * @param brandName        the brand name
     * @param pageable         the pageable
     * @return the optional
     */
   OpenFDADrugRecordApplicationResponse search(final String manufacturerName, final String brandName,
                                                         final Pageable pageable);

}
