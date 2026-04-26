package tn.portfolio.portofolio.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class VisitorStat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String page;
    Long counter = 0L;
    LocalDateTime lastVisit;

    @ManyToOne
    Project project;
}
