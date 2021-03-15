package ca.airspeed.qbdapi.domain;

import java.util.List;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Introspected
@Data
public class DividendSummary {
    private List<DividendYear> dividendYears;

    public DividendSummary() {
    }

    public DividendSummary(List<DividendYear> dividendYears) {
        this.dividendYears = dividendYears;
    }
}
