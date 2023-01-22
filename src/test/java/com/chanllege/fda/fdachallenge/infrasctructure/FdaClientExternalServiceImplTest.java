package com.chanllege.fda.fdachallenge.infrasctructure;

import com.chanllege.fda.fdachallenge.infrasctructure.dtos.OpenFDADrugRecordApplicationResponse;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.Openfda;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.Product;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.Result;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FdaClientExternalServiceImplTest {


    @Mock
    private RestTemplate restTemplate;

	@InjectMocks
	private FdaClientExternalServiceImpl fdaClientExternalService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchWhenDrugIsFoundFromFdaApiThenReturnPageOfResults()  {

        Result resultExpected = new Result();
        resultExpected.setApplicationNumber("applicationNumber");
        OpenFDADrugRecordApplicationResponse openFDADrugRecordApplicationResponse =
                OpenFDADrugRecordApplicationResponse.builder()
                        .results(
                                Collections.singletonList(
                                        resultExpected))
                        .build();

        ResponseEntity<OpenFDADrugRecordApplicationResponse> responseEntity =
                new ResponseEntity<>(openFDADrugRecordApplicationResponse, HttpStatus.OK);


        when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.eq(OpenFDADrugRecordApplicationResponse.class)
        )).thenReturn(responseEntity);


        fdaClientExternalService.setFdaEndpoint("https://api.fda.gov/drug/drugsfda.json?search=openfda.manufacturer_name:");

        OpenFDADrugRecordApplicationResponse result = fdaClientExternalService.search("manufacturerName", "brandName", PageRequest.of(1, 1));

        assertEquals(openFDADrugRecordApplicationResponse, result);

    }
}