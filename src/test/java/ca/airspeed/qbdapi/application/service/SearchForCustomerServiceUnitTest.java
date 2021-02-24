package ca.airspeed.qbdapi.application.service;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.SearchForCustomerPort;
import ca.airspeed.qbdapi.domain.Customer;

@ExtendWith(MockitoExtension.class)
class SearchForCustomerServiceUnitTest {

    @InjectMocks
    private SearchForCustomerService service;

    @Mock
    private SearchForCustomerPort mockCustomerPort;

    @Test
    void searchByFullName_Found() throws Exception {
        // Given:
        String arg = "Mega";
        lenient().when(mockCustomerPort.findByFullName(eq(arg)))
                .thenReturn(megaCorpList());

        // When:
        List<Customer> result = service.findByFullName(arg);

        // Then:
        assertThat(result, hasSize(1));
        assertThat(result.get(0).getFullName(), is("MegaCorp Inc."));
    }

    private List<Customer> megaCorpList() {
        Customer megaCorp = Customer.builder()
                .id("1")
                .fullName("MegaCorp Inc.")
                .build();
        return asList(megaCorp);
    }
}
