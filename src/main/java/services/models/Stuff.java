package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "stuff")
public final class Stuff {

  @Id private String stuff_id;

  private String type;

  private int price;

  public Stuff(String type, int price) {

    this.type = type;

    this.price = price;

    this.stuff_id = UUID.randomUUID().toString();
  }

  public Stuff() {}

  public String getStuff_id() {

    return stuff_id;
  }

  public String getType() {

    return type;
  }

  public int getPrice() {

    return price;
  }
}
