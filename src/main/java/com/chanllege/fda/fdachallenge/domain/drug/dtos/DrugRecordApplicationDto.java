package com.chanllege.fda.fdachallenge.domain.drug.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Drug record application dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrugRecordApplicationDto {
    private List<ResultDto> results;
}
