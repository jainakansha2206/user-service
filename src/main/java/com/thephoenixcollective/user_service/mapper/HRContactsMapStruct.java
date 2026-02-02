package com.thephoenixcollective.user_service.mapper;

import com.thephoenixcollective.user_service.dto.HRContactsReq;
import com.thephoenixcollective.user_service.dto.HRContactsResp;
import com.thephoenixcollective.user_service.entity.HRContactsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HRContactsMapStruct {
    @Mapping(target = "id", ignore = true)
    HRContactsEntity toEntity(HRContactsReq dto);

    HRContactsResp toResponse(HRContactsEntity entity);
}
