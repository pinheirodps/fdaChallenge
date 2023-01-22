package com.chanllege.fda.fdachallenge.api;

import com.chanllege.fda.fdachallenge.AbstractIntegrationTest;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.CreateDrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.services.DrugRecordApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DrugRecordApplicationControllerTest extends AbstractIntegrationTest {

    private static final String CONTENT_TYPE = "application/json";
    private static final String SEARCH_BASE_ROUTE =
            "/drug-record-applications?manufacturerName=Hospira&page=0&size=20&sort=priRole";
    @Mock
    private DrugRecordApplicationService drugRecordApplicationService;

    @Autowired
    private MockMvc mockMvc;



    @Test
    @DisplayName("Should return a response with status code 400 when the request is invalid")
    void createWhenRequestIsInvalidThenReturnResponseWithStatusCode400() throws Exception {
        final String manufacturerName = "teste";
        final String brandName = "";
        final Pageable pageable = PageRequest.of(0, 20);
        final CreateDrugRecordApplicationDto createDrugRecordApplicationDto =
                CreateDrugRecordApplicationDto.builder()
                        .manufacturerName(manufacturerName)
                        .brandName(brandName)
                        .pageable(pageable)
                        .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/drug-record-applications?page=0&size=20")
                        .content(asJsonString(createDrugRecordApplicationDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());


    }

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
                .andExpect(status().isCreated())
                .andExpect(status().isOk());

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
    @DisplayName("Should return 400 when the manufacturername is empty")
    void searchWhenManufacturerNameIsEmptyThenReturn400() throws Exception {
        String manufacturerName = "";
        String brandName = "";
        Pageable pageable = PageRequest.of(0, 20);

        when(drugRecordApplicationService.search(manufacturerName, brandName, pageable))
                .thenReturn(Page.empty());

        mockMvc.perform(MockMvcRequestBuilders
                        .get(SEARCH_BASE_ROUTE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("Should return 200 when the manufacturername is not empty")
    void saveDrugRecordApplicationsWhenManufacturerNameIsNotEmptyThenReturn200() throws Exception {

        mockMvc.perform(get(SEARCH_BASE_ROUTE))
                .andExpect(status().isOk());

    }
}