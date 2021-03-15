package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.util.List;

import ca.airspeed.qbdapi.domain.DividendYear;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Introspected
@Data
@EqualsAndHashCode(callSuper = false)
public class DividendSummaryResponseResource extends AbstractResource<DividendSummaryResponseResource> {

    private List<DividendYear> dividendHistory;

    public DividendSummaryResponseResource() {

    }

    public DividendSummaryResponseResource(List<DividendYear> dividendHistory) {
        this.dividendHistory = dividendHistory;
    }
}
