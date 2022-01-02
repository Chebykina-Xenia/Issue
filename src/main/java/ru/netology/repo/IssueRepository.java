package ru.netology.repo;

import ru.netology.exeption.NotFoundException;
import ru.netology.issue.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {

    private List<Issue> items = new ArrayList<>();

    public List<Issue> findAll() {
        return items;
    }

    public void saveAll(List<Issue> items) {
        this.items.addAll(items);
    }

    //определяем по id есть Issue или нет
    public boolean findById(int id) {
        findAll();
        int countTrue = 0;
        boolean byId = false;
        for (Issue item : items) {
            if (item.getId() == id) {
                countTrue = countTrue + 1;
            }
        }
        if (countTrue == 1) {
            return byId = true;
        } else {
            return byId = false;
        }
    }

    //update по id
    public void updateOpendById(int id, boolean opend) {
        if (findById(id) == false) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            List<Issue> list = findAll();
            for (Issue item : items) {
                if (item.getId() == id) {
                    item.setOpend(opend);
                }
            }
            items = list;
        }
    }
}