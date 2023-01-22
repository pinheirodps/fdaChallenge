package com.chanllege.fda.fdachallenge.domain.drug.services;

import com.chanllege.fda.fdachallenge.domain.drug.dtos.CreateDrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordStoredApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.ProductDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.ResultDto;
import com.chanllege.fda.fdachallenge.domain.drug.entities.DrugRecordApplication;
import com.chanllege.fda.fdachallenge.domain.drug.mapper.DrugRecordApplicationMapper;
import com.chanllege.fda.fdachallenge.domain.drug.repositories.DrugRecordApplicationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Drug record application service.
 */
@Slf4j
@Service
@AllArgsConstructor
public class DrugRecordApplicationService {

    private FdaClientExternalService fdaClientExternalService;

    private DrugRecordApplicationRepository repository;
    private DrugRecordApplicationMapper mapper;

    /**
     * Search page.
     *
     * @param manufacturerName the manufacturer name
     * @param brandName        the brand name
     * @param pageable         the pageable
     * @return the page
     */
    @Transactional(readOnly = true)
    public Page<ResultDto> search(final String manufacturerName, final String brandName,
                                  final Pageable pageable) {


        DrugRecordApplicationDto drugRecordApplicationDto = mapper
                .toDto(fdaClientExternalService.search(manufacturerName, brandName, pageable));
        final Page<ResultDto> page = new PageImpl<>(drugRecordApplicationDto.getResults());
        return new PageImpl<>(page.getContent(), pageable, page.getTotalElements());
    }


    /**
     * Create.
     *
     * @param createDrugRecordApplicationDto the create drug record application dto
     */
    @Transactional
    public void create(final CreateDrugRecordApplicationDto createDrugRecordApplicationDto) {

        DrugRecordApplicationDto drugRecordApplicationDto = mapper
                .toDto(fdaClientExternalService.search(createDrugRecordApplicationDto.getManufacturerName(),
                        createDrugRecordApplicationDto.getBrandName(),
                        createDrugRecordApplicationDto.getPageable()));

        DrugRecordApplication.DrugRecordApplicationBuilder builder = DrugRecordApplication.builder();
        drugRecordApplicationDto.getResults().stream().forEach(resultDto ->
                repository.save(builder.applicationNumber(resultDto.getApplicationNumber()
                        ).manufacturerName(resultDto.getOpenfda().getManufacturerName())
                        .substanceName(resultDto.getOpenfda().getSubstanceName())
                        .productNumbers(resultDto.getProducts()
                                .stream().map(ProductDto::getProductNumber)
                                .collect(Collectors.toList())).build()));

    }

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    @Transactional(readOnly = true)
    public Page<DrugRecordStoredApplicationDto> findAll(Pageable pageable) {
        Page<DrugRecordApplication> drugRecordApplications = repository.findAll(pageable);
        List<DrugRecordStoredApplicationDto> drugRecordApplicationDTOS = drugRecordApplications.getContent().stream()
                .map(mapper::toDrugRecordStoredAp)
                .collect(Collectors.toList());
        return new PageImpl<>(drugRecordApplicationDTOS, pageable, drugRecordApplications.getTotalElements());
    }
}
