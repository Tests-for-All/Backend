package com.api.TestHub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
    @SequenceGenerator(name = "question_sequence", sequenceName = "questions_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String details;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;
}
