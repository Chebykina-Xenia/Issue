package ru.netology.repo;

import org.junit.jupiter.api.Test;
import ru.netology.issue.Issue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repo = new IssueRepository();

//ДОБАВЛЕНИЕ
    @Test
    void saveTest(){
        List<Issue> list = new ArrayList<>();

        HashSet<Integer> labelTag1 = new HashSet<Integer>();
        HashSet<Integer> labelTag2 = new HashSet<Integer>();
        HashSet<Integer> labelTag3 = new HashSet<Integer>();

        labelTag1.add(1);
        labelTag1.add(5);
        labelTag1.add(3);
        labelTag2.add(2);
        labelTag3.add(1);
        labelTag3.add(4);

        list.add(new Issue(1, true, "Ivan", "Test1", "Comment", labelTag1, "Petya", 240));
        list.add(new Issue(2, false, "Roma", "Test2", "Comment", labelTag2, "Elena", 60));

        repo.saveAll(list);
      //  repo.findAll();
        List<Issue> listActual = new ArrayList<>();

        listActual = (List<Issue>) repo.findAll();

        Issue first = new Issue(1, true, "Ivan", "Test1", "Comment", labelTag1, "Petya", 240);
        Issue second = new Issue(2, false, "Roma", "Test2", "Comment", labelTag2, "Elena", 60);

        List<Issue> listExpected = Arrays.asList(first, second);


     //   repo.save(new Issue(1, true, "Ivan", "Test1", "Comment", labelTag1, "Petya", 240 ));
      //  repo.save(new Issue(2, false, "Roma", "Test2", "Comment", labelTag2, "Elena", 60 ));
      //  repo.save(new Issue(3, true, "Xenia", "Test3", "Comment", labelTag3, "Artem", 180 ));

        //проверка ожидаемого и фактического результата
       assertTrue(listActual.equals(listExpected));
//assertEquals(listExpected, listActual);

    }
}