package ru.netology.issue;

import java.util.Collection;
import java.util.HashSet;

public class Issue implements Comparable<Issue> {
   private int id;                              //идентификатор Issue
   private boolean opend;                       //true-открытое, false-закрытое
   private String autor;                        //автор
   private String title;                        //название
   private String write;                        //описание
   Collection labelTag;
   //private int labelTag;                      //отметка по которой профодим фильтрацию
   private String assignee;                     //ответственный за работу
   private int workingHours;                      //сколько часов в работе (для сортировки новая-старая)

    public Issue() {
    }

    public Issue(int id, boolean opend, String autor, String title, String write, Collection labelTag, String assignee, int workingHours) {
        this.id = id;
        this.opend = opend;
        this.autor = autor;
        this.title = title;
        this.write = write;
        this.labelTag = labelTag;
        this.assignee = assignee;
        this.workingHours = workingHours;
    }

    @Override
    public int compareTo(Issue o) {
        return id - o.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpend() {
        return opend;
    }

    public void setOpend(boolean opend) {
        this.opend = opend;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public Collection getLabelTag() {
        return labelTag;
    }

    public void setLabelTag(Collection labelTag) {
        this.labelTag = labelTag;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
