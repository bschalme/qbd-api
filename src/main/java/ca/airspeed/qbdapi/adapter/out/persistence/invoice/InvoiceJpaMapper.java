package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaMapper;
import ca.airspeed.qbdapi.domain.Invoice;
import ca.airspeed.qbdapi.domain.InvoiceLineDetail;

@Mapper(uses = CustomerJpaMapper.class)
public interface InvoiceJpaMapper {

    public static final InvoiceJpaMapper INSTANCE = Mappers.getMapper(InvoiceJpaMapper.class);

    @Mapping(source = "txnID", target = "id")
    @Mapping(source = "refNumber", target = "invoiceNumber")
    @Mapping(source = "txnDate", target = "invoiceDate")
    @Mapping(source = "currency.currencyCode", target = "currency")
    @Mapping(source = "customerMsgRefFullName", target = "notesForCustomer")
    Invoice jpaEntityToInvoice(InvoiceJpaEntity entity);

    @Mapping(source = "txnLineID", target = "id")
    @Mapping(source = "itemRefListID", target = "item.id")
    @Mapping(source = "itemRefFullName", target = "item.fullName")
    InvoiceLineDetail jpaEntityToInvoiceLineDetail(InvoiceLineDetailJpaEntity entity);

    List<Invoice> jpaEntitiesToInvoices(List<InvoiceJpaEntity> entities);
}
