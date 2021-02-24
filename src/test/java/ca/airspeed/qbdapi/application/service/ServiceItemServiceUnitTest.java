package ca.airspeed.qbdapi.application.service;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.ServiceItemPort;
import ca.airspeed.qbdapi.domain.ServiceItem;

@ExtendWith(MockitoExtension.class)
class ServiceItemServiceUnitTest {

    @InjectMocks
    private ServiceItemService service;

    @Mock
    private ServiceItemPort mockPort;

    @Test
    void retrieveServiceItem_found() throws Exception {
        // Given:
        String id = "ABC-123";
        lenient().when(mockPort.findByServiceItemId(eq(id)))
                .thenReturn(ServiceItem.builder()
                        .id("ABC-123")
                        .name("SD100")
                        .price(BigDecimal.valueOf(10000, 2))
                        .build());

        // When:
        ServiceItem result = service.retrieveServiceItem(id);

        // Then:
        assertNotNull(result);
        assertEquals("ABC-123", result.getId(), "ServiceItem id;");
    }

    @Test
    void findByFullName_found() throws Exception {
        // Given:
        String fullName = "SD100";
        lenient().when(mockPort.findByFullName(eq(fullName)))
                .thenReturn(asList(ServiceItem.builder()
                        .id("ABC-123")
                        .name("SD100")
                        .price(BigDecimal.valueOf(10000, 2))
                        .build()));

        // When:
        List<ServiceItem> results = service.findByFullName(fullName);

        // Then:
        assertNotNull(results);
        assertEquals(1, results.size(), "Number of ServiceItems returned;");
        ServiceItem item = results.get(0);
        assertEquals("SD100", item.getName(), "Name;");
    }
}
