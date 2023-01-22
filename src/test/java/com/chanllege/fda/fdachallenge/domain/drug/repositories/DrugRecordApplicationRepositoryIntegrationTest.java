package com.chanllege.fda.fdachallenge.domain.drug.repositories;

import com.chanllege.fda.fdachallenge.AbstractIntegrationTest;
import com.chanllege.fda.fdachallenge.domain.drug.entities.DrugRecordApplication;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;




@DataJpaTest
@ActiveProfiles("test")
public class DrugRecordApplicationRepositoryIntegrationTest extends AbstractIntegrationTest {



    @Autowired
    private DrugRecordApplicationRepository drugRecordApplicationRepository;

    @BeforeEach
    public void setUp() {
        // insert test data into the database
        DrugRecordApplication drugRecordApplication1 = new DrugRecordApplication("123456",
                Collections.singletonList("Test Manufacturer"), Collections.singletonList("Test Substance"), Arrays.asList("123", "456"));
        DrugRecordApplication drugRecordApplication2 = new DrugRecordApplication("789012",
                Collections.singletonList("Test Manufacturer 2"), Collections.singletonList("Test Substance 2"), Arrays.asList("789", "012"));
        drugRecordApplicationRepository.save(drugRecordApplication1);
        drugRecordApplicationRepository.save(drugRecordApplication2);
    }

    @Test
    public void testFindAll() {
        Page<DrugRecordApplication> drugRecordApplications = drugRecordApplicationRepository.findAll(PageRequest.of(0, 10));
        assertThat(drugRecordApplications.getTotalElements()).isEqualTo(2);
        assertThat(drugRecordApplications.getContent().get(0).getApplicationNumber()).isEqualTo("123456");
        assertThat(drugRecordApplications.getContent().get(1).getApplicationNumber()).isEqualTo("789012");
    }
}
