package com.epam.finalkafka.service;


import com.epam.finalkafka.dto.FlatBeaconPositionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<String, FlatBeaconPositionDto> kafkaBeaconPositionTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, FlatBeaconPositionDto> kafkaBeaconPositionTemplate,
                             ObjectMapper objectMapper) {
        this.kafkaBeaconPositionTemplate = kafkaBeaconPositionTemplate;
        this.objectMapper = objectMapper;
    }


    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    @Override
    public void send() {
        FlatBeaconPositionDto dto = createDto();
        log.info("<= sending {}", writeValueAsString(dto));
        kafkaBeaconPositionTemplate.send("position_data.test1", dto);
    }

    private FlatBeaconPositionDto createDto() {
        return new FlatBeaconPositionDto(Instant.now());
    }

    private String writeValueAsString(FlatBeaconPositionDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
