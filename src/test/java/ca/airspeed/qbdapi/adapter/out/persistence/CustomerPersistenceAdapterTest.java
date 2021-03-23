package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.domain.Customer;

@ExtendWith(MockitoExtension.class)
class CustomerPersistenceAdapterTest {
    @Mock
    private CustomerMapper mapper;

    @Mock
    private CustomerJpaRepository repo;

    @InjectMocks
    private CustomerPersistenceAdapter customerPersistenceAdapter;

    @SuppressWarnings("unchecked")
    @Test
    void testFindByCustomerId() throws Exception {
        // Given:
        when(repo.findById(isA(String.class))).thenReturn(Optional.of(new CustomerJpaEntity()));
        when(mapper.mapToDomainEntity(isA(Optional.class))).thenReturn(Customer.builder().build());

        // When:
        Customer result = customerPersistenceAdapter.findByCustomerId("123");

        // Then:
        assertThat(result, notNullValue());
    }

    @SuppressWarnings("unchecked")
    @Test
    void testFindByFullName() throws Exception {
        // Given:
        when(repo.findByFullNameStartsWith(isA(String.class))).thenReturn(asList(new CustomerJpaEntity()));
        when(mapper.mapToDomainList(isA(List.class))).thenReturn(asList(Customer.builder().build()));

        // When:
        List<Customer> results = customerPersistenceAdapter.findByFullName("Mega");

        // Then:
        assertThat(results, hasSize(1));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testCreate() throws Exception {
        // Given:
        when(repo.save(isA(CustomerJpaEntity.class))).thenReturn(new CustomerJpaEntity());
        when(mapper.mapToJpaEntity(isA(Customer.class))).thenReturn(new CustomerJpaEntity());
        when(mapper.mapToDomainEntity(isA(Optional.class))).thenReturn(Customer.builder()
                .build());

        // When:
        Customer result = customerPersistenceAdapter.create(Customer.builder()
                .build());

        // Then:
        assertThat(result, notNullValue());
    }
}
