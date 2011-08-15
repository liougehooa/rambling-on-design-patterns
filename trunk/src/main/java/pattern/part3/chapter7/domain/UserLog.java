package pattern.part3.chapter7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Date: 2009-11-30
 * Time: 23:42:13
 */
@Entity
@Table(name = "user_log")
public class UserLog implements Loggable {
    private Long logId;
    private Long id;
    private String name;
    private Date logTime;
    //other fields...

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", columnDefinition = "varchar(250)")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "log_time")
    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    //other getters and setters ...

    /**
     * @param object to compare
     * @return True if they have the same identity
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final UserLog other = (UserLog) object;
        if (logId != null ? !logId.equals(other.logId) : other.logId != null) return false;

        return true;
    }

    /**
     * @return Hash code of logId.
     */
    @Override
    public int hashCode() {
        return logId.hashCode();
    }

    @Override
    public String toString() {
        return "UserLog{" + "logId=" + logId + ", id=" + id + ", name='" + name + '\'' + '}';
    }
}
