package ca.airspeed.qbdapi.application.port.out;

import ca.airspeed.qbdapi.domain.CreditCardCharge;

public interface CreditCardChargePort {
    CreditCardCharge addCreditCardCharge(CreditCardCharge creditCardCharge);
}
