package com.chanllege.fda.fdachallenge.infrasctructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * The type Open fda drug record application response.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenFDADrugRecordApplicationResponse {
    private List<Result> results;

}
