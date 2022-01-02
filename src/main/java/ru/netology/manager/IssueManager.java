package ru.netology.manager;

import ru.netology.issue.Issue;
import ru.netology.repo.IssueRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IssueManager {
    private IssueRepository repo = new IssueRepository();
    private List<Issue> items = new ArrayList<>();

    public IssueManager(IssueRepository repository) {
        this.repo = repository;
    }

    //выводим открытые issue
    public List<Issue> getOpend() {
        List<Issue> issueOpend = new ArrayList<>();
        items = repo.findAll();
        for (Issue item : items) {
            if (item.getOpend() == true) {
                issueOpend.add(item);
            }
        }
        return items = issueOpend;
    }

    //выводим закрытые issue
    public List<Issue> getNotOpend() {
        List<Issue> issueOpend = new ArrayList<>();
        items = repo.findAll();
        for (Issue item : items) {
            if (item.getOpend() == false) {
                issueOpend.add(item);
            }
        }
        return items = issueOpend;
    }

    //фильтрация по автору — autor
    public List<Issue> filterByAutor(String textAutor) {
        List<Issue> newList = new ArrayList<>();
        items = repo.findAll();
        for (Issue item : items) {
            if (item.matchesString(textAutor)) {
                newList.add(item);
            }
        }
        return items = newList;
    }

    //фильтрация по ответсвенному — assignee
    public List<Issue> filterByAssignee(String textAssignee) {
        List<Issue> newList = new ArrayList<>();
        items = repo.findAll();
        for (Issue item : items) {
            if (item.matchesString(textAssignee)) {
                newList.add(item);
            }
        }
        return items = newList;
    }

    //фильтрация по labelTag
    public List<Issue> filterByLabelTag(HashSet<Integer> labelTag) {
        List<Issue> newList = new ArrayList<>();
        items = repo.findAll();
        for (Issue item : items) {
            if (item.matchesLable(labelTag)) {
                newList.add(item);
            }
        }
        return items = newList;
    }

}
