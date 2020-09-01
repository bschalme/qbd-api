package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.Customer;

class CustomerMapperUnitTest {

    private CustomerMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = new CustomerMapper();
    }

    @Test
    void mapToJpaEntity() throws Exception {
        // Given:
        Customer customer = Customer.builder()
                .id("123")
                .name("Consulting")
                .fullName("MegaCorp Inc.:Consulting")
                .build();

        // When:
        CustomerJpaEntity jpa = mapper.mapToJpaEntity(customer);

        // Then:
        assertThat(jpa, notNullValue());
        assertThat(jpa.getListID(), is("123"));
        assertThat(jpa.getName(), is("Consulting"));
        assertThat(jpa.getFullName(), is("MegaCorp Inc.:Consulting"));
    }

    @Test
    void mapToDomainEntity_HappyPath() throws Exception {
        // Given:
        CustomerJpaEntity jpa = new CustomerJpaEntity();
        jpa.setListID("123");
        jpa.setName("Consulting");
        jpa.setFullName("MegaCorp Inc.:Consulting");
        Optional<CustomerJpaEntity> optional = Optional.of(jpa);

        // When:
        Customer customer = mapper.mapToDomainEntity(optional);

        // Then:
        assertThat(customer, notNullValue());
        assertThat(customer.getId(), is("123"));
        assertThat(customer.getName(), is("Consulting"));
        assertThat(customer.getFullName(), is("MegaCorp Inc.:Consulting"));
    }

    @Test
    void mapDomainToEntity_NothingToConvert() throws Exception {
        // Given:
        Optional<CustomerJpaEntity> optional = Optional.empty();

        // When:
        Customer customer = mapper.mapToDomainEntity(optional);

        // Then:
        assertThat(customer, nullValue());
    }

    @Test
    void mapToDomainList() throws Exception {
        // Given:
        CustomerJpaEntity megaCorp = new CustomerJpaEntity();
        megaCorp.setListID("123");
        megaCorp.setFullName("MegaCorp Inc.:Consulting");
        CustomerJpaEntity littleBiz = new CustomerJpaEntity();
        littleBiz.setListID("456");
        littleBiz.setFullName("LittleBiz:Application Support");

        // When:
        List<Customer> customerList = mapper.mapToDomainList(asList(megaCorp, littleBiz));

        // Then:
        assertThat(customerList, hasSize(2));
    }

    @Test
    void mapToDomainList_FromNullResultSet() throws Exception {
        // When:
        List<Customer> customerList = mapper.mapToDomainList(null);

        // Then:
        assertThat(customerList, empty());
    }
}
