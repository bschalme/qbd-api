package ca.airspeed.qbdapi.application.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.InvoicePort;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceUnitTest {

    @InjectMocks
    private InvoiceService service;

    @Mock
    private InvoicePort mockInvoicePort;
    
}
