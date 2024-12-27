package cn.edu.sdu.orz.bug.entity;

import cn.edu.sdu.orz.bug.utils.Utils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * The type Bug record.
 */
@Entity
@Table(name = "bug_record")
@Getter
@Setter
@SuppressWarnings("unused")
public class BugRecord {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "bug", nullable = false)
    private Bug bug;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private BugRecordType type;

    @ManyToOne
    @JoinColumn(name = "previous", nullable = false)
    private BugStatus previous;

    @ManyToOne
    @JoinColumn(name = "after", nullable = false)
    private BugStatus after;

    @ManyToOne
    @JoinColumn(name = "solve_type")
    private BugSolveType solveType;

    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(name = "time", nullable = false)
    private Timestamp time;

    /**
     * Instantiates a new Bug record.
     */
    public BugRecord() {
        setId(Utils.newRandomID());
    }

    /**
     * Instantiates a new Bug record.
     *
     * @param id        the id
     * @param bug       the bug
     * @param type      the type
     * @param previous  the previous
     * @param after     the after
     * @param solveType the solve type
     * @param comment   the comment
     * @param user      the user
     * @param time      the time
     */
    public BugRecord(String id, Bug bug, BugRecordType type, BugStatus previous, BugStatus after,
                     BugSolveType solveType, String comment, User user, Timestamp time) {
        setId(id);
        setBug(bug);
        setType(type);
        setPrevious(previous);
        setAfter(after);
        setSolveType(solveType);
        setComment(comment);
        setUser(user);
        setTime(time);
    }
}
