package com.epam.finalkafka;


import com.epam.finalkafka.dto.FlatBeaconPositionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.util.HashMap;
import java.util.Map;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 12.02.19
 * Time: 22:06
 * e-mail: 2262288@gmail.com
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

   /* @Value("${kafka.producer.id}")
    private String kafkaProducerId;*/

    @Value("kafka.group.id")
    private String groupId;

    @Autowired
    private ObjectMapper objectMapper;


    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        //props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerId);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, groupId);
        return props;
    }

    @Bean
    public ProducerFactory<String, FlatBeaconPositionDto> producerFlatBeaconFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs(), new StringSerializer(), new JsonSerializer<FlatBeaconPositionDto>(objectMapper));
    }

    @Bean
    public KafkaTemplate<String, FlatBeaconPositionDto> kafkaTemplate() {
        KafkaTemplate<String, FlatBeaconPositionDto> template = new KafkaTemplate<>(producerFlatBeaconFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }
}
