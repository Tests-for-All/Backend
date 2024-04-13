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
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
    @SequenceGenerator(name = "tag_sequence", sequenceName = "tags_id_seq", allocationSize = 1)
    private Long id;
    private String name;
}
