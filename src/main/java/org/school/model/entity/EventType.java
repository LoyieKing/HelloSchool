package org.school.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "EventType", schema = "myschool", catalog = "")
public class EventType {
    private short eventTypeId;
    private String eventName;
    private Short priority;

    @Id
    @Column(name = "eventTypeID")
    public short getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(short eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    @Basic
    @Column(name = "eventName")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "priority")
    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventType that = (EventType) o;

        if (eventTypeId != that.eventTypeId) return false;
        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        return priority != null ? priority.equals(that.priority) : that.priority == null;

    }

    @Override
    public int hashCode() {
        int result = (int) eventTypeId;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }
}
