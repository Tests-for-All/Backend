package com.api.TestHub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinTable(name="tests_tags",
            joinColumns = @JoinColumn(name="test_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="tag_id", referencedColumnName="id") )
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;
}
