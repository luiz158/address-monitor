package com.address.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: jules
 * Date: 7/6/14
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = Address.FIND_BY_ID, query = "select a from Address a where a.id=:id"),
        @NamedQuery(name = Address.FIND_BY_URL, query = "select a from Address a where a.url = :url"),
})
public class Address extends BaseEntity {

    public static final String FIND_BY_ID = "findById";
    public static final String FIND_BY_URL = "findByUrl";

    @NotEmpty
    @Column(unique = true)
    private String url;

    @NotEmpty
    @Column(unique = true)
    private String company;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "address")
    private Set<ChangeLog> logEntries = new HashSet<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<ChangeLog> getLogEntries() {
        return logEntries;
    }

    protected void setLogEntries(Set<ChangeLog> logEntries) {
        this.logEntries = logEntries;
    }

    public boolean addChangeLog(ChangeLog changeLog) {
        changeLog.setAddress(this);
        return this.logEntries.add(changeLog);
    }
}
