package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Introspected
@RequiredArgsConstructor
@Getter
public class DividendYear {
    private final Integer year;
    private final BigDecimal dividends;
}
