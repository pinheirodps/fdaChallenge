package com.chanllege.fda.fdachallenge.api;

import com.chanllege.fda.fdachallenge.AbstractIntegrationTest;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.CreateDrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.entities.DrugRecordApplication;
import com.chanllege.fda.fdachallenge.domain.drug.repositories.DrugRecordApplicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DrugRecordApplicationControllerTest extends AbstractIntegrationTest {

    private static final String CONTENT_TYPE = "application/json";
    private static final String SEARCH_BASE_ROUTE =
            "/drug-record-applications?manufacturerName=Hospira&page=0&size=20";
    private static final String LIST_ALL_BASE_ROUTE =
            "/drug-record-applications";
    private static final String SEARCH_BASE_ROUTE_NOT_FOUND =
            "/drug-record-applications/search?manufacturerName=test";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DrugRecordApplicationRepository drugRecordApplicationRepository;


    @Test
    @DisplayName("Should return a response with status code 200 when the request is valid")
    void createWhenRequestIsValidThenReturnResponseWithStatusCode200() throws Exception {
        final String manufacturerName = "Hospira";
        final String brandName = "";
        final Pageable pageable = PageRequest.of(0, 20);
        final CreateDrugRecordApplicationDto createDrugRecordApplicationDto =
                CreateDrugRecordApplicationDto.builder()
                        .manufacturerName(manufacturerName)
                        .brandName(brandName)
                        .pageable(pageable)
                        .build();


        mockMvc.perform( MockMvcRequestBuilders
                        .post("/drug-record-applications?page=0&size=20")
                        .content(asJsonString(createDrugRecordApplicationDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    public String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Should return 200 when the manufacturername is present")
    void searchWhenManufacturerNameIsPresentThenReturn200() throws Exception {

        mockMvc.perform(get(SEARCH_BASE_ROUTE))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return 404 when the manufacturername is not found")
    void searchWhenManufacturerNameIsEmptyThenReturn404() throws Exception {

        mockMvc.perform(get(SEARCH_BASE_ROUTE_NOT_FOUND))
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("Should return 200 when the manufacturername is not empty")
    void saveDrugRecordApplicationsWhenManufacturerNameIsNotEmptyThenReturn200() throws Exception {

        DrugRecordApplication drugRecordApplication1 = new DrugRecordApplication("123456",
                Collections.singletonList("Test Manufacturer"), Collections.singletonList("Test Substance"), Arrays.asList("123", "456"));
        DrugRecordApplication drugRecordApplication2 = new DrugRecordApplication("789012",
                Collections.singletonList("Test Manufacturer 2"), Collections.singletonList("Test Substance 2"), Arrays.asList("789", "012"));
        drugRecordApplicationRepository.deleteAll();
        drugRecordApplicationRepository.save(drugRecordApplication1);
        drugRecordApplicationRepository.save(drugRecordApplication2);

        MvcResult mvcResult = mockMvc.perform(get(LIST_ALL_BASE_ROUTE))

                .andExpect(status().isOk())
                .andReturn();
        String actualJson = mvcResult.getResponse().getContentAsString();
        assertTrue(actualJson.contains("123456"));
        assertTrue(actualJson.contains("789012"));
        assertTrue(actualJson.contains("Test Substance"));
        assertTrue(actualJson.contains("Test Substance 2"));
    }
}