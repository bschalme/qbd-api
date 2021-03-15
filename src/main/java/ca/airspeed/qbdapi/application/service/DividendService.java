package ca.airspeed.qbdapi.application.service;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.RetrieveDividendHistoryUseCase;
import ca.airspeed.qbdapi.application.port.out.ChequePort;
import ca.airspeed.qbdapi.domain.DividendSummary;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class DividendService implements RetrieveDividendHistoryUseCase {

    private final ChequePort chequePort;

    @Override
    public DividendSummary retrieveDividendHistory() {
        return chequePort.retrieveHistoricalDividendSummary();
    }

}
