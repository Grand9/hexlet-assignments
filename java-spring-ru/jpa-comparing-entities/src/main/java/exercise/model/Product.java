package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.*;

// BEGIN
@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "price"})
public class Product {
    @GeneratedValue
    @Id
    private long id;

    private String title;
    private int price;
}
// END
