package com.laioffer.homehub.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "policies")
public class PoliciesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime updateTime;
    private Long publisherId;

//    @ManyToOne
//    @OnDelete(action= OnDeleteAction.CASCADE)
//    @JoinColumn(name = "listing_id", foreignKey = @ForeignKey(name = "fk_booking_listing"), insertable = false, updatable = false)
//    private ListingEntity listing;


//    @ManyToOne
//    @OnDelete(action=OnDeleteAction.CASCADE)
//    @JoinColumn(name = "guest_id", foreignKey = @ForeignKey(name = "fk_booking_guest"), insertable = false, updatable = false)
//    private UserEntity guest;


    public PoliciesEntity() {
    }

    public PoliciesEntity(Long id, String title, String content, LocalDateTime updateTime, Long publisherId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.updateTime = updateTime;
        this.publisherId = publisherId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() { return title; }

    public String getContent() { return content; }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Long getPublisherId() { return publisherId; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliciesEntity that = (PoliciesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(updateTime, that.updateTime) && Objects.equals(publisherId, that.publisherId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, updateTime, publisherId);
    }


    @Override
    public String toString() {
        return "PoliciesEntity{" +
                "id=" + id +
                ", title=" + title +
                ", content=" + content +
                ", updateTime=" + updateTime +
                ", publisherId=" + publisherId +
                '}';
    }
}
