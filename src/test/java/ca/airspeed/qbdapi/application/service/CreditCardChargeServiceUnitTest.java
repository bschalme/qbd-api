package ca.airspeed.qbdapi.application.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.CreditCardChargePort;
import ca.airspeed.qbdapi.domain.CreditCardCharge;

@ExtendWith(MockitoExtension.class)
class CreditCardChargeServiceUnitTest {

    @InjectMocks
    private CreditCardChargeService service;

    @Mock
    private CreditCardChargePort mockCreditCardChargePort;

    @Test
    void testEnterCreditCardCharge() throws Exception {
        // Given:
        CreditCardCharge charge = CreditCardCharge.builder()
                .build();
        when(service.enterCreditCardCharge(isA(CreditCardCharge.class))).thenReturn(charge);

        // When:
        CreditCardCharge result = service.enterCreditCardCharge(charge);

        // Then:
        assertThat(result, notNullValue());
        verify(mockCreditCardChargePort).addCreditCardCharge(isA(CreditCardCharge.class));
    }

}
