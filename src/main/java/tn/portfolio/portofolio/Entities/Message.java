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
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMessage;
    String name;
    String email;
    String subject;
    String content;
    LocalDateTime dispatchDate;
    boolean read;

    @ManyToOne(optional = true)
    @JoinColumn(name = "project_id_project", nullable = true)
    Project project;
}
