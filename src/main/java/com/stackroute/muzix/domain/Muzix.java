package com.stackroute.muzix.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Muzix {
    @Id
    long trackId;
    String trackName;
    String trackComments;
    int yearOfRelease;

    public Muzix() {
    }

    public Muzix(long trackId, String trackName, String trackComments, int yearOfRelease) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackComments = trackComments;
        this.yearOfRelease = yearOfRelease;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComments() {
        return trackComments;
    }

    public void setTrackComments(String trackComments) {
        this.trackComments = trackComments;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Muzix{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackComments='" + trackComments + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
