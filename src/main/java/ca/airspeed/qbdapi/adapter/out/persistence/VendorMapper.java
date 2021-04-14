package ca.airspeed.qbdapi.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ca.airspeed.qbdapi.domain.Vendor;

@Mapper
public interface VendorMapper {

    @Mapping(source = "listID", target = "id")
    Vendor vendorJpaEntityToVendor(VendorJpaEntity jpaEntity);

    @Mapping(source = "id", target = "listID")
    VendorJpaEntity vendorToVendorJpaEntity(Vendor vendor);
}
