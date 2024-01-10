package ca.airspeed.qbdapi.adapter.in.web.resource;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.adapter.in.web.model.WebCreditCardCharge;
import ca.airspeed.qbdapi.domain.Account;
import ca.airspeed.qbdapi.domain.CreditCardCharge;

@Mapper
public interface WebCreditCardChargeMapper {

    WebCreditCardChargeMapper INSTANCE = Mappers.getMapper(WebCreditCardChargeMapper.class);

    CreditCardChargeResponseResource domainObjectToCreditCardChargeResponseResource(
            CreditCardCharge creditCardCharge);

    CreditCardCharge webCreditCardChargeToDomainObject(WebCreditCardCharge webCreditCardCharge);

    AccountResponse domainAccountToAccountResponse(Account account);
}
