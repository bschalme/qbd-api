package ca.airspeed.qbdapi.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.domain.Invoice;
import ca.airspeed.qbdapi.domain.InvoiceLineDetail;

@Mapper
public interface InvoiceJpaMapper {

    public static final InvoiceJpaMapper INSTANCE = Mappers.getMapper(InvoiceJpaMapper.class);

    @Mapping(source = "txnID", target = "id")
    Invoice jpaEntityToInvoice(InvoiceJpaEntity entity);

    @Mapping(source = "txnLineID", target = "id")
    InvoiceLineDetail jpaEntityToInvoiceLineDetail(InvoiceLineDetailJpaEntity entity);
}
