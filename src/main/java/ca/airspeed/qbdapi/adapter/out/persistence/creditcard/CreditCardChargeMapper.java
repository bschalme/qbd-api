package ca.airspeed.qbdapi.adapter.out.persistence.creditcard;

import static java.time.ZoneId.systemDefault;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.adapter.out.persistence.AccountJpaEntity;
import ca.airspeed.qbdapi.adapter.out.persistence.TxnExpenseLineDetailJpaEntity;
import ca.airspeed.qbdapi.adapter.out.persistence.VendorJpaEntity;
import ca.airspeed.qbdapi.domain.Account;
import ca.airspeed.qbdapi.domain.CreditCardCharge;
import ca.airspeed.qbdapi.domain.TxnExpenseLineDetail;
import ca.airspeed.qbdapi.domain.Vendor;

@Mapper
public interface CreditCardChargeMapper {

    public static final CreditCardChargeMapper INSTANCE = Mappers.getMapper(CreditCardChargeMapper.class);

    @Mapping(source = "txnID", target = "id")
    CreditCardCharge jpaEntityToCreditCardCharge(CreditCardChargeJpaEntity entity);

    @Mapping(source = "id", target = "txnID")
    @Mapping(target = "txnNumber", ignore = true)
    @Mapping(target = "accountRefFullName", ignore = true)
    @Mapping(target = "payeeEntityRefFullName", ignore = true)
    @Mapping(target = "status", ignore = true)
    CreditCardChargeJpaEntity creditCardChargeToJpaEntity(CreditCardCharge charge);

    @Mapping(source = "listID", target = "id")
    Account jpaEntityToAccount(AccountJpaEntity entity);

    @Mapping(source = "id", target = "listID")
    @Mapping(target = "status", ignore = true)
    AccountJpaEntity accountToJpaEntity(Account account);

    @Mapping(source = "listID", target = "id")
    Vendor vendorJpaEntityToVendor(VendorJpaEntity jpaEntity);

    @Mapping(source = "id", target = "listID")
    VendorJpaEntity vendorToVendorJpaEntity(Vendor vendor);

    @Mapping(source = "txnLineID", target = "id")
    TxnExpenseLineDetail jpaEntityToTxnExpenseLineDetail(TxnExpenseLineDetailJpaEntity entity);

    @Mapping(source = "id", target = "txnLineID")
    @Mapping(target = "accountRefFullName", ignore = true)
    @Mapping(target = "groupIDKEY", ignore = true)
    TxnExpenseLineDetailJpaEntity txnExpenseLineDetailToJpaEntity(TxnExpenseLineDetail detail);

    Set<TxnExpenseLineDetail> jpaEntitiesToTxnExpenseLineDetails(Set<TxnExpenseLineDetailJpaEntity> entities);

    Set<TxnExpenseLineDetailJpaEntity> txnExpenseLineDetailsToJpaEntityes(Set<TxnExpenseLineDetail> details);

    default Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(systemDefault()).toInstant());
    }
}
