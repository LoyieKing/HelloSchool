package org.school.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Event", schema = "myschool", catalog = "")
public class Event {
    private String eventId;
    private String eventName;
    private EventType eventType;
    private String eventTime;
    private String eventDescription;
    private List<UserModel> hosts;
    private List<Group> groups;

    @Id
    @Column(name = "eventID")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "eventName")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @ManyToOne
    @JoinColumn(name = "eventTypeID")
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "eventTime")
    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Basic
    @Column(name = "eventDescription")
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;


        return eventId.equals(that.eventId);
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(name = "EventHost",
    joinColumns = {@JoinColumn(name = "eventID")},
    inverseJoinColumns = {@JoinColumn(name = "userID")})
    public List<UserModel> getHosts() {
        return hosts;
    }

    public void setHosts(List<UserModel> hosts) {
        this.hosts = hosts;
    }

    @ManyToMany
    @JoinTable(name = "GroupEvent",
    joinColumns = {@JoinColumn(name = "eventID")},
    inverseJoinColumns = {@JoinColumn(name = "groupID")})
    public List<Group> getGroups(){return groups;}

    public void setGroups(List<Group> groups){this.groups = groups;}
}
