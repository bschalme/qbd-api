package ca.airspeed.qbdapi.adapter.out.persistence;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.ChequePort;
import ca.airspeed.qbdapi.domain.DividendSummary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@RequiredArgsConstructor
@Slf4j
public class ChequePersistenceAdapter implements ChequePort {

    private final ChequeJpaRepository repo;

    @Override
    public DividendSummary retrieveHistoricalDividendSummary() {
        ZonedDateTime today = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("America/Winnipeg"));
        log.debug("today is {}.", today.toString());
        log.debug("Retrieving dividends for month {}, day {}", today.getMonthValue(), today.getDayOfMonth());
        return new DividendSummary(repo.getHistoricalDividendSummary(today.getMonthValue(), today.getDayOfMonth()));
    }

}
