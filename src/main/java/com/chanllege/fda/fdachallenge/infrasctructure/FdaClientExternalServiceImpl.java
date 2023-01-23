package com.chanllege.fda.fdachallenge.infrasctructure;

import com.chanllege.fda.fdachallenge.domain.drug.exceptions.DrugNotFoundException;
import com.chanllege.fda.fdachallenge.domain.drug.services.FdaClientExternalService;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.OpenFDADrugRecordApplicationResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.chanllege.fda.fdachallenge.domain.util.Parameters.BRAND_NAME;
import static com.chanllege.fda.fdachallenge.domain.util.Parameters.LIMIT;
import static com.chanllege.fda.fdachallenge.domain.util.Parameters.SKIP;

/**
 * The type Fda client external service.
 */
@Slf4j
@Service
public class FdaClientExternalServiceImpl implements FdaClientExternalService {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${fda.endpoint}")
    @Setter
    private String fdaEndpoint;

    @Override
    public OpenFDADrugRecordApplicationResponse search(final String manufacturerName, final String brandName,
                                                       final Pageable pageable) {
        ResponseEntity<OpenFDADrugRecordApplicationResponse> response;
        try {
            String url = fdaEndpoint + manufacturerName;
            if (StringUtils.isNotEmpty(brandName)) {
                url += BRAND_NAME + brandName;
            }
            url += LIMIT + pageable.getPageSize() + SKIP + pageable.getOffset();

            response = restTemplate.exchange(url, HttpMethod.GET,
                    null, OpenFDADrugRecordApplicationResponse.class);

        } catch (HttpClientErrorException e) {
            log.error(e.getMessage(), e);
            throw new DrugNotFoundException(manufacturerName, brandName, pageable);
        }

        return response.getBody();

    }

}
