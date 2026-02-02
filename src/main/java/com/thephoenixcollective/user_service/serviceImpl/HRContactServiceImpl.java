package com.thephoenixcollective.user_service.serviceImpl;

import com.thephoenixcollective.user_service.dto.HRContactsReq;
import com.thephoenixcollective.user_service.dto.HRContactsResp;
import com.thephoenixcollective.user_service.entity.HRContactsEntity;
import com.thephoenixcollective.user_service.mapper.HRContactsMapStruct;
import com.thephoenixcollective.user_service.repository.HRContactsRepository;
import com.thephoenixcollective.user_service.service.HRContactService;
import com.thephoenixcollective.user_service.utility.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class HRContactServiceImpl implements HRContactService {

    @Autowired
    private HRContactsRepository repository;

    @Autowired
    private HRContactService service;

    @Autowired
    private HRContactsMapStruct contactsMapStruct;

    @Override
    public void createHRContacts(MultipartFile file) {
        log.info("event=HRContactServiceImpl.createHRContacts creating contacts where file size={}", file.getSize());

        if (file.getSize() <= 0) {
            throw new IllegalArgumentException("Provided File is Empty");
        }

        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".csv")) {
            throw new IllegalArgumentException("Only CSV files are supported");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            List<HRContactsEntity> entities = reader.lines().skip(1).map(this::parseLine).filter(dto -> !repository.existsByEmail(dto.getEmail())).map(contactsMapStruct::toEntity).toList();

            repository.saveAll(entities);
            log.info("Records has not been saved into the table");

        } catch (IOException e) {
            throw new RuntimeException("Failed to process file", e);
        }


    }

    private HRContactsReq parseLine(String line) {
        String[] values = line.split(",");

        return HRContactsReq.builder().name(values[0].trim()).email(values[1].trim()).title(values[2].trim()).company(values[3].trim()).status(values[4].trim()).build();
    }


}
