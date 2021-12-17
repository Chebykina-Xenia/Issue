package ru.netology.repo;

import ru.netology.issue.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {

    private Collection<Issue> items = new ArrayList<>();

    public boolean save(Issue item){
        return items.add(item);
    }

    public Collection<Issue> findAll(){
        return items;
     }

    public void saveAll (Collection<Issue> items){
        this.items.addAll(items);
    }

}
