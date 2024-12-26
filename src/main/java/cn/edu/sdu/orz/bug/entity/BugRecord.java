package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * The type Bug record.
 */
@Entity
@Table(name = "bug_record")
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
        super();
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
    public BugRecord(String id, Bug bug, BugRecordType type, BugStatus previous, BugStatus after, BugSolveType solveType,
                     String comment, User user, Timestamp time) {
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

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets bug.
     *
     * @param bug the bug
     */
    public void setBug(Bug bug) {
        this.bug = bug;
    }

    /**
     * Gets bug.
     *
     * @return the bug
     */
    public Bug getBug() {
        return bug;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public BugRecordType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(BugRecordType type) {
        this.type = type;
    }

    /**
     * Gets previous.
     *
     * @return the previous
     */
    public BugStatus getPrevious() {
        return previous;
    }

    /**
     * Sets previous.
     *
     * @param previous the previous
     */
    public void setPrevious(BugStatus previous) {
        this.previous = previous;
    }

    /**
     * Gets after.
     *
     * @return the after
     */
    public BugStatus getAfter() {
        return after;
    }

    /**
     * Sets after.
     *
     * @param after the after
     */
    public void setAfter(BugStatus after) {
        this.after = after;
    }

    /**
     * Gets solve type.
     *
     * @return the solve type
     */
    public BugSolveType getSolveType() {
        return solveType;
    }

    /**
     * Sets solve type.
     *
     * @param solveType the solve type
     */
    public void setSolveType(BugSolveType solveType) {
        this.solveType = solveType;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public Timestamp getTime() {
        return time;
    }
}
