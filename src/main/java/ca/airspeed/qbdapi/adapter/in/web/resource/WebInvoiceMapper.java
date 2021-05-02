package ca.airspeed.qbdapi.adapter.in.web.resource;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.domain.Invoice;

@Mapper
public interface WebInvoiceMapper {

    public static final WebInvoiceMapper INSTANCE = Mappers.getMapper(WebInvoiceMapper.class);

    public WebInvoiceResponseResource domainObjectToWebInvoiceResponseResource(Invoice domainInvoice);
}
