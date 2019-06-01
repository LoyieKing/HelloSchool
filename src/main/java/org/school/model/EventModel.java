package org.school.model;

import javax.naming.Name;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Event", schema = "myschool", catalog = "")
public class EventModel {
    private String eventId;
    private String eventName;
    private EventTypeModel eventType;
    private Timestamp eventDate;
    private String eventDescription;
    private List<UserModel> hosts;

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
    public EventTypeModel getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeModel eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "eventDate")
    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
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

        EventModel that = (EventModel) o;


        return eventId.equals(that.eventId);
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
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
}
