package tn.portfolio.portofolio.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProject;
    String title;
    @Column(length = 1000)
    String description;
    @Column(length = 1000)
    String technologies;
    String githubLink;
    String demoLink;
    @Lob
    String image;
    int ordre;
    LocalDate creationDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("project") 
    List<Message> messages;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    List<VisitorStat> stats;
}
