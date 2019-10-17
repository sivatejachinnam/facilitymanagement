package com.dcrewit.facilitymanagement.models;

public class TicketListItem {
    private int ticketId;
    private String ticketDes;
    private String assignedTo;
    private String ticketStatus;
    private String createdDate;

    public TicketListItem(int ticketId, String ticketDes, String assignedTo, String ticketStatus, String createdDate) {
        this.ticketId = ticketId;
        this.ticketDes = ticketDes;
        this.assignedTo = assignedTo;
        this.ticketStatus = ticketStatus;
        this.createdDate = createdDate;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketDes() {
        return ticketDes;
    }

    public void setTicketDes(String ticketDes) {
        this.ticketDes = ticketDes;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
