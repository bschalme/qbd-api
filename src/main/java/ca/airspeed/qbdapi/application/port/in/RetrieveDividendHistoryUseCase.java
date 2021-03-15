package ca.airspeed.qbdapi.application.port.in;

import ca.airspeed.qbdapi.domain.DividendSummary;

public interface RetrieveDividendHistoryUseCase {
    DividendSummary retrieveDividendHistory();
}
