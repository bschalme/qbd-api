package ca.airspeed.qbdapi.application.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.CustomerPort;
import ca.airspeed.qbdapi.domain.Customer;

@ExtendWith(MockitoExtension.class)
class CustomerServiceUnitTest {

    @InjectMocks
    private CustomerService service;

    @Mock
    private CustomerPort mockPort;

    @Test
    void createCustomer_success() throws Exception {
        // Given:
        Customer customer = Customer.builder()
                .name("MegaCorp")
                .build();
        when(mockPort.create(isA(Customer.class))).thenReturn(customer);

        // When:
        Customer result = service.createCustomer(customer);

        // Then:
        assertThat(result, notNullValue());
        assertThat(result.getId(), not(emptyOrNullString()));
        verify(mockPort).create(customer);
    }
}
