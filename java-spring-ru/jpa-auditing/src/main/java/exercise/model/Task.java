package exercise.model;

import com.sun.source.util.TaskListener;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

// BEGIN
@Entity
@Table(name = "tasks")
@EntityListeners(TaskListener.class)
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDate.from(LocalDateTime.now());
        updatedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDate.from(LocalDateTime.now());
    }
}
// END
