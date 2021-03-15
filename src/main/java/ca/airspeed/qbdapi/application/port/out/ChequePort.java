package ca.airspeed.qbdapi.application.port.out;

import ca.airspeed.qbdapi.domain.DividendSummary;

public interface ChequePort {
    DividendSummary retrieveHistoricalDividendSummary();
}
