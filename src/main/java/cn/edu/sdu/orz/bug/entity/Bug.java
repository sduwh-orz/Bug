package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Bug.
 */
@Entity
@Table(name = "bug")
@Getter
@Setter
@SuppressWarnings("unused")
public class Bug {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "grade", nullable = false)
    private BugGrade grade;

    @ManyToOne
    @JoinColumn(name = "reporter", nullable = false)
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private BugStatus status;

    @ManyToOne
    @JoinColumn(name = "solve_type", nullable = false)
    private BugSolveType solveType;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature", nullable = false)
    private Feature feature;

    @OneToMany(mappedBy = "bug", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @OrderBy("time DESC")
    private List<BugRecord> records;
}
