package ca.airspeed.qbdapi.adapter.out.persistence.creditcard;

import static java.util.UUID.randomUUID;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import ca.airspeed.qbdapi.adapter.out.persistence.TxnExpenseLineDetailJpaEntity;
import ca.airspeed.qbdapi.adapter.out.persistence.TxnExpenseLineDetailJpaRepository;
import ca.airspeed.qbdapi.application.port.out.CreditCardChargePort;
import ca.airspeed.qbdapi.domain.CreditCardCharge;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class CreditCardChargePersistenceAdapter implements CreditCardChargePort {

    private static final String ADD = "ADD";

    private final CreditCardChargeJpaRepository creditCardJpaRepo;
    private final TxnExpenseLineDetailJpaRepository txnExpenseLineDetailRepo;

    @Override
    @Transactional
    public CreditCardCharge addCreditCardCharge(CreditCardCharge creditCardCharge) {
        CreditCardChargeJpaEntity entity = CreditCardChargeMapper.INSTANCE
                .creditCardChargeToJpaEntity(creditCardCharge);
        entity.setTxnID(randomUUID().toString());
        entity.setStatus(ADD);
        for(TxnExpenseLineDetailJpaEntity expenseLine: entity.getExpenseLines()) {
            expenseLine.setTxnLineID(randomUUID().toString());
            expenseLine.setIdKey(entity.getTxnID());
        }
        CreditCardChargeJpaEntity result = creditCardJpaRepo.save(entity);
        txnExpenseLineDetailRepo.saveAll(entity.getExpenseLines());
        return CreditCardChargeMapper.INSTANCE.jpaEntityToCreditCardCharge(result);
    }

}
