package ca.airspeed.qbdapi.application.service;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.EnterCreditCardChargeUseCase;
import ca.airspeed.qbdapi.application.port.out.CreditCardChargePort;
import ca.airspeed.qbdapi.domain.CreditCardCharge;
import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class CreditCardChargeService implements EnterCreditCardChargeUseCase {

    private final CreditCardChargePort port;

    @Override
    @Counted("credit-card-charges.create")
    public CreditCardCharge enterCreditCardCharge(CreditCardCharge creditCardCharge) {
        return port.addCreditCardCharge(creditCardCharge);
    }

}
