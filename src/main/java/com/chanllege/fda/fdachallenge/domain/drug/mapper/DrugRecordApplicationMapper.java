package com.chanllege.fda.fdachallenge.domain.drug.mapper;

import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordStoredApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.ResponseCreateDrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.entities.DrugRecordApplication;
import com.chanllege.fda.fdachallenge.infrasctructure.dtos.OpenFDADrugRecordApplicationResponse;
import org.mapstruct.Mapper;

/**
 * The interface Drug record application mapper.
 */
@Mapper(componentModel = "spring")
public interface DrugRecordApplicationMapper {

    /**
     * To dto drug record application dto.
     *
     * @param source the source
     * @return the drug record application dto
     */
    DrugRecordApplicationDto toDto (OpenFDADrugRecordApplicationResponse source);

    /**
     * To create drug record application dto response create drug record application dto.
     *
     * @param source the source
     * @return the response create drug record application dto
     */
    ResponseCreateDrugRecordApplicationDto toCreateDrugRecordApplicationDto (DrugRecordApplication source );

    /**
     * To drug record stored ap drug record stored application dto.
     *
     * @param drugRecordApplication the drug record application
     * @return the drug record stored application dto
     */
    DrugRecordStoredApplicationDto toDrugRecordStoredAp (DrugRecordApplication drugRecordApplication);
}
