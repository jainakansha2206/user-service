package com.thephoenixcollective.user_service.mapper;

import com.thephoenixcollective.user_service.dto.HRContactsReq;
import com.thephoenixcollective.user_service.dto.HRContactsResp;
import com.thephoenixcollective.user_service.entity.HRContactsEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-02T23:31:52+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class HRContactsMapStructImpl implements HRContactsMapStruct {

    @Override
    public HRContactsEntity toEntity(HRContactsReq dto) {
        if ( dto == null ) {
            return null;
        }

        HRContactsEntity hRContactsEntity = new HRContactsEntity();

        hRContactsEntity.setName( dto.getName() );
        hRContactsEntity.setTitle( dto.getTitle() );
        hRContactsEntity.setCompany( dto.getCompany() );
        hRContactsEntity.setEmail( dto.getEmail() );
        hRContactsEntity.setStatus( dto.getStatus() );

        return hRContactsEntity;
    }

    @Override
    public HRContactsResp toResponse(HRContactsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HRContactsResp.HRContactsRespBuilder hRContactsResp = HRContactsResp.builder();

        if ( entity.getId() != null ) {
            hRContactsResp.id( entity.getId().intValue() );
        }
        hRContactsResp.name( entity.getName() );
        hRContactsResp.title( entity.getTitle() );
        hRContactsResp.email( entity.getEmail() );
        hRContactsResp.company( entity.getCompany() );
        hRContactsResp.status( entity.getStatus() );

        return hRContactsResp.build();
    }
}
