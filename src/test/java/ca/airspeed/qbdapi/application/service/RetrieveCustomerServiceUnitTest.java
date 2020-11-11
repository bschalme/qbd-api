package ca.airspeed.qbdapi.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.RetrieveCustomerPort;
import ca.airspeed.qbdapi.domain.Customer;

@ExtendWith(MockitoExtension.class)
class RetrieveCustomerServiceUnitTest {

    @InjectMocks
    private RetrieveCustomerService service;

    @Mock
    private RetrieveCustomerPort mockCustomerPort;

    @Test
    void retrieveCustomerHappyPath() throws Exception {
        // Given:
        lenient().when(mockCustomerPort.findByCustomerId(eq("ABC-123"))).thenReturn(Customer.builder()
                .name("MegaCorp")
                .id("ABC-123")
                .build());

        // When:
        Customer customer = service.retrieveCustomer("ABC-123");

        // Then:
        assertNotNull(customer);
        assertEquals("ABC-123", customer.getId(), "Customer Id;");
        assertEquals("MegaCorp", customer.getName(), "Customer Name;");
    }
}
