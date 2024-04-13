package com.api.TestHub.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_sequence")
    @SequenceGenerator(name = "answer_sequence", sequenceName = "answers_id_seq", allocationSize = 1)
    private Long id;

    private String text;

    private Boolean isTrue;
}
