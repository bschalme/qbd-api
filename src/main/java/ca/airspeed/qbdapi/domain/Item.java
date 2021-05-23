package ca.airspeed.qbdapi.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class Item {
    private String id;
    private String fullName;
    private String tableName;

}
