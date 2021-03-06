package com.tripin.application.entity;

import com.tripin.application.enums.ParticipantAuthorizationType;

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

    private ParticipantAuthorizationType participantAuthorizationType;

    private boolean isDelete = false;

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Participants() {
    }

    public Participants(int planID){
        this.planID=planID;
    }

    public Participants(int planID, int participantID){
        this.planID=planID;
        this.participantID=participantID;
    }

    public Participants(int planID, int participantID, ParticipantAuthorizationType participantAuthorizationType) {
        this.planID = planID;
        this.participantID = participantID;
        this.participantAuthorizationType = participantAuthorizationType;
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

    public ParticipantAuthorizationType getParticipantAuthorizationType() {
        return participantAuthorizationType;
    }

    public void setParticipantAuthorizationType(ParticipantAuthorizationType participantAuthorizationType) {
        this.participantAuthorizationType = participantAuthorizationType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return getPlanID() == that.getPlanID() &&
                getParticipantID() == that.getParticipantID() &&
                isDelete() == that.isDelete() &&
                getParticipantAuthorizationType() == that.getParticipantAuthorizationType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlanID(), getParticipantID(), getParticipantAuthorizationType(), isDelete());
    }

    @Override
    public String toString() {
        return "Participants{" +
                "planID=" + planID +
                ", participantID=" + participantID +
                ", participantAuthorizationType=" + participantAuthorizationType +
                ", isDelete=" + isDelete +
                '}';
    }
}
