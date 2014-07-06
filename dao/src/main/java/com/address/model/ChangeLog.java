package com.address.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * User: jules
 * Date: 7/6/14
 */
@Entity
@Table(name = "change_log")
@NamedQueries({
        @NamedQuery(name = ChangeLog.FIND_BY_ADDRESS,
                query = "SELECT c FROM ChangeLog c " +
                        "WHERE c.address.id=:addressId " +
                        "ORDER BY c.createdAt")
})
public class ChangeLog extends BaseEntity {

    public static final String FIND_BY_ADDRESS = "findByAddress";

    @ManyToOne
    @JoinColumn(name = "address_fk", nullable = false)
    private Address address;

    /**
     * Property used for logging purposes
     */
    @Column
    protected String user;

    @NotEmpty
    @Column(unique = true)
    private String url;

    public static String getFindByAddress() {
        return FIND_BY_ADDRESS;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ChangeLog{" +
                ", user='" + user + '\'' +
                ", url='" + url + '\'' +
                ", createdAt" + createdAt + '\'' +
                "}\n";
    }
}
