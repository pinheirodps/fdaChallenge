package com.chanllege.fda.fdachallenge.domain.drug.entities;

import io.quarkiverse.hibernate.types.json.JsonBinaryType;
import io.quarkiverse.hibernate.types.json.JsonTypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * The type Drug record application.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TypeDef(name = JsonTypes.JSON_BIN, typeClass = JsonBinaryType.class)
public class DrugRecordApplication implements Serializable {

    @NotNull
    @Id
    private String applicationNumber;

    @Column(columnDefinition = "jsonb", nullable = false, updatable = true, name = "manufacturerName")
    @Type(type = JsonTypes.JSON_BIN)
    @Basic(fetch = FetchType.LAZY)
    private  List<String>  manufacturerName;

    @Column(columnDefinition = "jsonb", nullable = false, updatable = true, name = "substanceName")
    @Type(type = JsonTypes.JSON_BIN)
    @Basic(fetch = FetchType.LAZY)
    private List<String> substanceName;

    @Column(columnDefinition = "jsonb", nullable = false, updatable = true, name = "productNumbers")
    @Type(type = JsonTypes.JSON_BIN)
    @Basic(fetch = FetchType.LAZY)
    private List<String> productNumbers;
}
