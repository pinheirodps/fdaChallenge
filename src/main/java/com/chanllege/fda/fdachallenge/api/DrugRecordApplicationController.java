package com.chanllege.fda.fdachallenge.api;

import com.chanllege.fda.fdachallenge.domain.drug.dtos.CreateDrugRecordApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.DrugRecordStoredApplicationDto;
import com.chanllege.fda.fdachallenge.domain.drug.dtos.ResultDto;
import com.chanllege.fda.fdachallenge.domain.drug.services.DrugRecordApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

import javax.validation.Valid;

/**
 * The type Drug record application controller.
 */
@RestController
@RequestMapping("/drug-record-applications")
@AllArgsConstructor
public class DrugRecordApplicationController {

    private DrugRecordApplicationService drugRecordApplicationService;

    /**
     * Search response entity.
     *
     * @param manufacturerName the manufacturer name
     * @param brandName        the brand name
     * @param pageable         the pageable
     * @return the response entity
     */
    @Operation(summary = "Search for drug record applications submitted to FDA for approval" +
            "        notes = Search by FDA Manufacturer name and Optional FDA brand name. Results are presented in pages.", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(mediaType =
                    "application/json", schema = @Schema(implementation = ResultDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema =
            @Schema(implementation = Problem.class))),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content(schema =
            @Schema(implementation = Problem.class))),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found",content = @Content(schema =
            @Schema(implementation = Problem.class)))
    })
    @GetMapping("/search")
    public ResponseEntity<Page<ResultDto>> search(
            @Parameter(description = "FDA Manufacturer name", required = true) @RequestParam(value = "manufacturerName") @Valid  String manufacturerName,
            @Parameter(description = "FDA brand name") @RequestParam(value = "brandName", required = false) String brandName,
            @Parameter(description = "PageableDefault equals 20 ", required = false) @PageableDefault(size = 20) final Pageable pageable) {
        return ResponseEntity.ok(drugRecordApplicationService.search(manufacturerName, brandName, pageable));
    }

    /**
     * Create response entity.
     *
     * @param pageable                       the pageable
     * @param createDrugRecordApplicationDto the create drug record application dto
     * @return the response entity
     */
    @Operation(summary = "Create a drug record application"
            + "Create and persist an entry for a given drug record application", responses = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(mediaType =
                    "application/json", schema = @Schema(implementation = Problem.class))),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to create is forbidden", content = @Content(mediaType =
                    "application/json", schema = @Schema(implementation = Problem.class))),
            @ApiResponse(responseCode = "409", description = "A conflict occurred. Please try again with different parameters", content = @Content(mediaType =
                    "application/json", schema = @Schema(implementation = Problem.class)))
    })
    @PostMapping()
    public ResponseEntity<Void> create(
            @Parameter(description = "PageableDefault equals 10 ", required = false) @PageableDefault(size = 10) final Pageable pageable,
            @Valid @RequestBody  final CreateDrugRecordApplicationDto createDrugRecordApplicationDto)
    {
        createDrugRecordApplicationDto.setPageable(pageable);
        drugRecordApplicationService.create(createDrugRecordApplicationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * Find all response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @Operation(summary = "View a list of stored drug record applications", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(mediaType =
                    "application/json", schema = @Schema(implementation = DrugRecordStoredApplicationDto.class))),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content(schema =
            @Schema(implementation = Problem.class)))
    })
    @GetMapping
    public ResponseEntity<Page<DrugRecordStoredApplicationDto>> findAll( @Parameter(description = "PageableDefault equals 10 ", required = false)
                                                                             @PageableDefault(size = 10)  final Pageable pageable) {
        Page<DrugRecordStoredApplicationDto> drugRecordApplications = drugRecordApplicationService.findAll(pageable);
        return ResponseEntity.ok(drugRecordApplications);
    }

}

