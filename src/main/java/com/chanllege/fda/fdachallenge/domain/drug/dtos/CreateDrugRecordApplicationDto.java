package com.chanllege.fda.fdachallenge.domain.drug.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * The type Create drug record application dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({
        "pageable",

})
public class CreateDrugRecordApplicationDto  implements Serializable {
    @NotEmpty(message = "The manufacturerName is required.")
    private String manufacturerName;
    private String brandName;
    private Pageable pageable;
}
