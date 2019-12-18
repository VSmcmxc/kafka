package com.epam.finalkafka;

import com.epam.finalkafka.dto.FlatBeaconPositionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.Instant;

public class ExampleMain {
    public static void main(String[] args) throws IOException {
        FlatBeaconPositionDto v = new FlatBeaconPositionDto(Instant.now());


        System.out.println("-- serializing --");
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String s = om.writeValueAsString(v);
        System.out.println(s);

        System.out.println("-- deserializing --");
        FlatBeaconPositionDto view = om.readValue(s, FlatBeaconPositionDto.class);
        System.out.println(view);
    }
}
