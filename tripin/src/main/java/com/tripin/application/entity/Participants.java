package com.tripin.application.entity;

import com.tripin.application.enums.ParticipantAuthorization;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: Participants
 * @Description: Participants旅游计划参与表的实例
 * @Author: Felix
 * @Date: 5/31/2018 18:07
 * @Version: 1.0
 **/

public class Participants implements Serializable {

    private static final long serialVersionUID = 1L;

    private int planID;

    private int participantID;

    private ParticipantAuthorization participantAuthorization;

    public Participants() {
    }

    public Participants(int planID, int participantID, ParticipantAuthorization participantAuthorization) {
        this.planID = planID;
        this.participantID = participantID;
        this.participantAuthorization = participantAuthorization;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public ParticipantAuthorization getParticipantAuthorization() {
        return participantAuthorization;
    }

    public void setParticipantAuthorization(ParticipantAuthorization participantAuthorization) {
        this.participantAuthorization = participantAuthorization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return getPlanID() == that.getPlanID() &&
                getParticipantID() == that.getParticipantID() &&
                getParticipantAuthorization() == that.getParticipantAuthorization();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlanID(), getParticipantID(), getParticipantAuthorization());
    }

    @Override
    public String toString() {
        return "Participants{" +
                "planID=" + planID +
                ", participantID=" + participantID +
                ", participantAuthorization=" + participantAuthorization +
                '}';
    }
}
