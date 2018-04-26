package com.user;

import java.sql.Timestamp;

public class Note {
    private int noteId;
    private String noteType ;
    private String noteTitle;
    private int noteNumberOfPages;
    private int noteDownloadTimes;
    private byte[] noteFile;
    private String noteSubmitter;
    private Timestamp noteSubmittingTime;
    private int noteDownloadPeanuts;
    private String noteDescription;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public int getNoteNumberOfPages() {
        return noteNumberOfPages;
    }

    public void setNoteNumberOfPages(int noteNumberOfPages) {
        this.noteNumberOfPages = noteNumberOfPages;
    }

    public int getNoteDownloadTimes() {
        return noteDownloadTimes;
    }

    public void setNoteDownloadTimes(int noteDownloadTimes) {
        this.noteDownloadTimes = noteDownloadTimes;
    }

    public byte[] getNoteFile() {
        return noteFile;
    }

    public void setNoteFile(byte[] noteFile) {
        this.noteFile = noteFile;
    }

    public String getNoteSubmitter() {
        return noteSubmitter;
    }

    public void setNoteSubmitter(String noteSubmitter) {
        this.noteSubmitter = noteSubmitter;
    }

    public Timestamp getNoteSubmittingTime() {
        return noteSubmittingTime;
    }

    public void setNoteSubmittingTime(Timestamp noteSubmittingTime) {
        this.noteSubmittingTime = noteSubmittingTime;
    }

    public int getNoteDownloadPeanuts() {
        return noteDownloadPeanuts;
    }

    public void setNoteDownloadPeanuts(int noteDownloadPeanuts) {
        this.noteDownloadPeanuts = noteDownloadPeanuts;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }
}
