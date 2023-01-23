package com.chanllege.fda.fdachallenge.domain.drug.services;

import com.chanllege.fda.fdachallenge.domain.drug.dtos.CreateDrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordStoredApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.OpenfdaDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.ProductDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.ResultDto;
import com.chanllege.fda.fdachallenge.domain.drug.entities.DrugRecordApplication;
import com.chanllege.fda.fdachallenge.domain.drug.exceptions.DrugNotFoundException;
import com.chanllege.fda.fdachallenge.domain.drug.mapper.DrugRecordApplicationMapper;
import com.chanllege.fda.fdachallenge.domain.drug.repositories.DrugRecordApplicationRepository;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.OpenFDADrugRecordApplicationResponse;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DrugRecordApplicationServiceTest {

    @Mock
    private FdaClientExternalService fdaClientExternalService;

    @Mock
    private DrugRecordApplicationRepository repository;

    @Mock
    private DrugRecordApplicationMapper mapper;

    @InjectMocks
    private DrugRecordApplicationService service;

    @Test
    @DisplayName(
            "Should return a page of drugrecordstoredapplicationdto when the repository returns a page of drugrecordapplication")
    void
    findAllWhenRepositoryReturnsPageOfDrugRecordApplicationThenReturnPageOfDrugRecordStoredApplicationDto() {
        Pageable pageable = PageRequest.of(0, 10);
        DrugRecordApplication drugRecordApplication =
                DrugRecordApplication.builder()
                        .applicationNumber("123")
                        .manufacturerName(Collections.singletonList("manufacturer"))
                        .substanceName(Collections.singletonList("substance"))
                        .productNumbers(Collections.singletonList("product"))
                        .build();
        Page<DrugRecordApplication> drugRecordApplications =
                new PageImpl<>(Collections.singletonList(drugRecordApplication));
        when(repository.findAll(pageable)).thenReturn(drugRecordApplications);
        DrugRecordStoredApplicationDto drugRecordStoredApplicationDto =
                DrugRecordStoredApplicationDto.builder()
                        .applicationNumber("123")
                        .manufacturerName(Collections.singletonList("manufacturer"))
                        .substanceName(Collections.singletonList("substance"))
                        .productNumbers(Collections.singletonList("product"))
                        .build();
        when(mapper.toDrugRecordStoredAp(drugRecordApplication))
                .thenReturn(drugRecordStoredApplicationDto);

        Page<DrugRecordStoredApplicationDto> result = service.findAll(pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals(1, result.getContent().size());
        assertEquals("123", result.getContent().get(0).getApplicationNumber());
        assertEquals("manufacturer", result.getContent().get(0).getManufacturerName().get(0));
        assertEquals("substance", result.getContent().get(0).getSubstanceName().get(0));
        assertEquals("product", result.getContent().get(0).getProductNumbers().get(0));
    }



    @Test
    @DisplayName("Should save the drug record application when the drug is found")
    void createWhenDrugIsFoundThenSaveDrugRecordApplication() {
        String manufacturerName = "manufacturerName";
        String brandName = "brandName";
        Pageable pageable = PageRequest.of(0, 10);
        ResultDto resultDto = ResultDto.builder().applicationNumber("applicationNumber")

                .openfda(OpenfdaDto.builder()
                        .manufacturerName(List.of("manufacturerName"))
                        .substanceName(List.of("substanceName"))
                        .build())
                .products(List.of(ProductDto.builder()
                        .productNumber("productNumber")
                        .build()))
                .applicationNumber("applicationNumber")
                .build();

        DrugRecordApplicationDto drugRecordApplicationDto =
                DrugRecordApplicationDto.builder()
                        .results(Collections.singletonList(resultDto))
                        .build();
        Result resultExpected = new Result();
        resultExpected.setApplicationNumber("applicationNumber");
        OpenFDADrugRecordApplicationResponse openFDADrugRecordApplicationResponse =
                OpenFDADrugRecordApplicationResponse.builder()
                        .results(
                                Collections.singletonList(resultExpected))
                        .build();
        when(fdaClientExternalService.search(manufacturerName, brandName, pageable))
                .thenReturn(openFDADrugRecordApplicationResponse);
        when(mapper.toDto(openFDADrugRecordApplicationResponse))
                .thenReturn(drugRecordApplicationDto);
        service.create(
                CreateDrugRecordApplicationDto.builder()
                        .manufacturerName(manufacturerName)
                        .brandName(brandName)
                        .pageable(pageable)
                        .build());
        verify(repository, times(1)).save(any());
    }

    @Test
    @DisplayName("Should throw an exception when the drug is not found")
    void searchWhenDrugIsNotFoundThenThrowException() {
        String manufacturerName = "manufacturerName";
        String brandName = "brandName";
        Pageable pageable = PageRequest.of(0, 10);
        when(fdaClientExternalService.search(manufacturerName, brandName, pageable))
                .thenThrow(DrugNotFoundException.class);
        assertThrows(
                DrugNotFoundException.class,
                () -> service.search(manufacturerName, brandName, pageable));
    }

    @Test
    @DisplayName("Should return a page of results when the drug is found")
    void searchWhenDrugIsFoundThenReturnPageOfResults() {
        String manufacturerName = "manufacturerName";
        String brandName = "brandName";
        Pageable pageable = PageRequest.of(0, 10);
        ResultDto resultDto = ResultDto.builder().applicationNumber("applicationNumber").build();

        Result resultExpected = new Result();
        resultExpected.setApplicationNumber("applicationNumber");
        OpenFDADrugRecordApplicationResponse response = OpenFDADrugRecordApplicationResponse.builder()
                .results(List.of(resultExpected)).build();
        DrugRecordApplicationDto drugRecordApplicationDto =
                DrugRecordApplicationDto.builder()
                        .results(Collections.singletonList(resultDto))
                        .build();
        when(fdaClientExternalService.search(manufacturerName, brandName, pageable))
                .thenReturn(response);
        when(mapper.toDto(response)).thenReturn(drugRecordApplicationDto);
        Page<ResultDto> result = service.search(manufacturerName, brandName, pageable);
        assertNotNull(result);
        assertFalse(result.getContent().isEmpty());
        assertEquals(result.getContent().get(0).getApplicationNumber(), "applicationNumber");
    }
}