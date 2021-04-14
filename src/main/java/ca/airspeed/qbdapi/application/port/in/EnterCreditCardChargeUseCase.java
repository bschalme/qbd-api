package ca.airspeed.qbdapi.application.port.in;

import ca.airspeed.qbdapi.domain.CreditCardCharge;

public interface EnterCreditCardChargeUseCase {

    public CreditCardCharge enterCreditCardCharge(CreditCardCharge creditCardCharge);
}
