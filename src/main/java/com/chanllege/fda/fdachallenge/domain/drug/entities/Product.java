package com.chanllege.fda.fdachallenge.domain.drug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * The type Product.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private String productNumber;
}
