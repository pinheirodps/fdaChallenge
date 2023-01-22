package com.chanllege.fda.fdachallenge.domain.drug.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Drug record stored application dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrugRecordStoredApplicationDto {
    private String applicationNumber;
    private  List<String>  manufacturerName;
    private List<String> substanceName;
    private List<String> productNumbers;
}
