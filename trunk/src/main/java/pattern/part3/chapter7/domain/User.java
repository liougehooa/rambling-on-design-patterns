package pattern.part3.chapter7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Date: 2009-11-30
 * Time: 23:36:12
 */
@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String name;
    //other fields...

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    //other getters and setters ...

    /**
     * @param object to compare
     * @return True if they have the same identity
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final User other = (User) object;
        if (id != null ? !id.equals(other.id) : other.id != null) return false;

        return true;
    }

    /**
     * @return Hash code of tracking id.
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
