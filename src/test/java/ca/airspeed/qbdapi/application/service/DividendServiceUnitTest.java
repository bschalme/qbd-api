package ca.airspeed.qbdapi.application.service;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.ChequePort;
import ca.airspeed.qbdapi.domain.DividendSummary;
import ca.airspeed.qbdapi.domain.DividendYear;

@ExtendWith(MockitoExtension.class)
class DividendServiceUnitTest {

    @InjectMocks
    private DividendService service;

    @Mock
    private ChequePort mockChequePort;

    @Test
    void retrieveDividendHistory() throws Exception {
        // Given:
        when(mockChequePort.retrieveHistoricalDividendSummary())
                .thenReturn(new DividendSummary(asList(new DividendYear(2020, BigDecimal.valueOf(1234.56D)))));

        // When:
        DividendSummary result = service.retrieveDividendHistory();

        // Then:
        assertThat(result, notNullValue());
        List<DividendYear> dividends = result.getDividendYears();
        assertThat(dividends, hasSize(1));
        DividendYear year1 = dividends.get(0);
        assertThat(year1.getYear(), is(2020));
        assertThat(year1.getDividends(), is(BigDecimal.valueOf(1234.56D)));
    }
}
