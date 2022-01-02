package ru.netology.repo;

import org.junit.jupiter.api.Test;
import ru.netology.exeption.NotFoundException;
import ru.netology.issue.Issue;
import ru.netology.manager.IssueManager;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repo = new IssueRepository();
    private IssueManager manager = new IssueManager(repo);

    private HashSet<Integer> labelTag1 = new HashSet<Integer>();
    private HashSet<Integer> labelTag2 = new HashSet<Integer>();
    private HashSet<Integer> labelTag3 = new HashSet<Integer>();

    private List<Issue> listActual = new ArrayList<>();

    private Issue issue1 = new Issue(1, true, "Ivan", "Test1", "Comment", labelTag1, "Petya", 240);
    private Issue issue2 = new Issue(2, false, "Roma", "Test2", "Comment", labelTag2, "Elena", 60);
    private Issue issue3 = new Issue(3, true, "Xenia", "Test3", "Comment", labelTag3, "Elena", 90);
    private Issue issue4 = new Issue(4, true, "Elena", "Test4", "Comment", labelTag2, "Elena", 180);
    private Issue issue5 = new Issue(5, true, "Roma", "Test4", "Comment", labelTag2, "Xenia", 180);

    //ДОБАВЛЕНИЕ Issue
    @Test
    void saveTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);

        listActual.add(issue1);
        listActual.add(issue2);

        repo.saveAll(listActual);

        assertEquals(listActual, repo.findAll());
    }

    //ВЫВОДИМ ОТКРЫТЫЕ Issue
    @Test
    void findOpendIssueTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);

        repo.saveAll(listActual);
        manager.getOpend();

        assertEquals(3, manager.getOpend().size());
    }

    //ВЫВОДИМ ЗАКРЫТЫЕ Issue
    @Test
    void findNotOpendIssueTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);

        repo.saveAll(listActual);

        assertEquals(1, manager.getNotOpend().size());
    }

    //UPDATE 1 элемента
    @Test
    void updateOpendIssue1Test(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);

        listActual.add(issue1);
        listActual.add(issue2);

        repo.saveAll(listActual);
        repo.updateOpendById(2, true);

        assertEquals(listActual, repo.findAll());
    }

    //UPDATE 2 элементов
    @Test
    void updateOpendIssue2Test(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);

        repo.saveAll(listActual);
        repo.updateOpendById(2, true);
        repo.updateOpendById(4, false);

        assertEquals(listActual, repo.findAll());
    }

    //UPDATE если нет id
    @Test
    void updateOpendIssueNotIdTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);

        repo.saveAll(listActual);

        assertThrows(NotFoundException.class, () -> {
            repo.updateOpendById(6, true);
        }
        );
    }

    //фильтрация по автору
    @Test
    void filterByAutorTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);
        listActual.add(issue5);

        repo.saveAll(listActual);

        assertEquals(2, manager.filterByAutor("Roma").size());
    }
    //фильтрация по ответственному
    @Test
    void filterByAssigneeTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);
        listActual.add(issue5);

        repo.saveAll(listActual);

        assertEquals(3, manager.filterByAssignee("Elena").size());
    }
    //фильтрация по labelTag
    @Test
    void filterByLabelTagTest(){
        //добавляем тэги
        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        listActual.add(issue1);
        listActual.add(issue2);
        listActual.add(issue3);
        listActual.add(issue4);
        listActual.add(issue5);

        repo.saveAll(listActual);

        assertEquals(3, manager.filterByLabelTag(labelTag2).size());
    }

}