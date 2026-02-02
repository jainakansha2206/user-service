package com.thephoenixcollective.user_service.mapper;

import com.thephoenixcollective.user_service.dto.UserRequestDto;
import com.thephoenixcollective.user_service.dto.UserResponseDto;
import com.thephoenixcollective.user_service.entity.User;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-02T23:31:52+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( dto.getEmail() );
        user.setName( dto.getName() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setUserName( dto.getUserName() );
        user.setPassword( dto.getPassword() );
        user.setRole( dto.getRole() );

        return user;
    }

    @Override
    public UserResponseDto toResponseDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.id( entity.getId() );
        userResponseDto.name( entity.getName() );
        userResponseDto.phoneNumber( entity.getPhoneNumber() );
        userResponseDto.email( entity.getEmail() );
        userResponseDto.role( entity.getRole() );
        if ( entity.getCreatedBy() != null ) {
            userResponseDto.createdBy( Long.parseLong( entity.getCreatedBy() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            userResponseDto.createdDate( LocalDateTime.ofInstant( entity.getCreatedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        if ( entity.getUpdatedBy() != null ) {
            userResponseDto.updatedBy( Long.parseLong( entity.getUpdatedBy() ) );
        }
        if ( entity.getUpdatedDate() != null ) {
            userResponseDto.updatedDate( LocalDateTime.ofInstant( entity.getUpdatedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return userResponseDto.build();
    }

    @Override
    public List<UserResponseDto> toResponseDtos(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( entities.size() );
        for ( User user : entities ) {
            list.add( toResponseDto( user ) );
        }

        return list;
    }
}
