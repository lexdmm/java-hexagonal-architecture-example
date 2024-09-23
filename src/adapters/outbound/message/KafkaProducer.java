package outbound.message;

import org.springframework.kafka.core.KafkaTemplate;

import domain.User;

public class KafkaProducer {
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(User user) {

    kafkaTemplate.send("user-topic", user.toString());
    System.out.println("Mensagem enviada para Kafka: " + user.getName());
  }
}
