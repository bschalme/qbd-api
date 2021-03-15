package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.domain.DividendSummary;
import ca.airspeed.qbdapi.domain.DividendYear;

@ExtendWith(MockitoExtension.class)
public class ChequePersistenceAdapterUnitTest {

    @InjectMocks
    private ChequePersistenceAdapter adapter;

    @Mock
    private ChequeJpaRepository mockRepo;

    @Test
    void retrieveHistoricalDividendSummary() throws Exception {
        // Given:
        when(mockRepo.getHistoricalDividendSummary(isA(Integer.class), isA(Integer.class)))
                .thenReturn(asList(new DividendYear(2020, BigDecimal.valueOf(1234.56D))));

        // When:
        DividendSummary results = adapter.retrieveHistoricalDividendSummary();

        // Then:
        assertThat(results, notNullValue());
        List<DividendYear> dividends = results.getDividendYears();
        assertThat(dividends, hasSize(1));
    }
}
