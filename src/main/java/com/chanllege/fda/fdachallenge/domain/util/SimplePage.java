package com.chanllege.fda.fdachallenge.domain.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Simple page.
 *
 * @param <T> the type parameter
 */
@JsonIgnoreProperties({
        "pageable",
        "number",
        "numberOfElements",
        "first",
        "last",
        "empty"
})
public class SimplePage<T> extends PageImpl<T> {


    /**
     * Instantiates a new Simple page.
     *
     * @param content       the content
     * @param totalElements the total elements
     * @param totalPages    the total pages
     * @param page          the page
     * @param size          the size
     * @param sort          the sort
     */
    @JsonCreator
    public SimplePage(@JsonProperty("content") final List<T> content,
                      @JsonProperty("totalElements") final long totalElements,
                      @JsonProperty("totalPages") final int totalPages,
                      @JsonProperty("page") final int page,
                      @JsonProperty("size") final int size,
                      @JsonProperty("sort") final List<String> sort) {
        super(content, PageRequest.of(page, size, Sort.by(sort.stream()
                .map(el -> el.split(","))
                .map(ar -> new Sort.Order(Sort.Direction.fromString(ar[1]), ar[0]))
                .collect(Collectors.toList()))), totalElements);
    }

    /**
     * Instantiates a new Simple page.
     *
     * @param content       the content
     * @param totalElements the total elements
     * @param pageable      the pageable
     */
    public SimplePage(final List<T> content, final long totalElements, final Pageable pageable) {
        super(content, pageable, totalElements);
    }


    /**
     * Gets page.
     *
     * @return the page
     */
    public int getPage() {
        return getNumber();
    }

    /**
     * Gets sort list.
     *
     * @return the sort list
     */
    @JsonProperty("sort")
    public List<String> getSortList() {
        return getSort().stream()
                .map(order -> order.getProperty() + "," + order.getDirection().name())
                .collect(Collectors.toList());
    }


}

