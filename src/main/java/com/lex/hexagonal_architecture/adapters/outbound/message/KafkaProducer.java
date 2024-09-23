package com.lex.hexagonal_architecture.adapters.outbound.message;

import org.springframework.kafka.core.KafkaTemplate;
import com.lex.hexagonal_architecture.core.domain.User;

public class KafkaProducer {
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String topic, String message) {
    kafkaTemplate.send(topic, message);
  }

  public void sendMessageTest(User user) {

    kafkaTemplate.send("user-topic", user.toString());
    System.out.println("Mensagem enviada para Kafka: " + user.getName());
  }
}
