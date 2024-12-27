package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Bug record type.
 */
@Entity
@Table(name = "bug_record_type")
@Getter
@Setter
@SuppressWarnings("unused")
public class BugRecordType {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
}
