package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldReturnSeveralTasksWhenManyMatch() {
        SimpleTask simple = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Позвонить", "Купить хлеб"});
        Meeting meeting = new Meeting(3, "Позвонить по проекту", "Проект А", "Завтра");

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple, epic, meeting};
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnOneTaskWhenOnlyOneMatches() {
        SimpleTask simple = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Помыть машину"});
        Meeting meeting = new Meeting(3, "Обсуждение релиза", "Проект Б", "Сегодня");

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple};
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoTasksMatch() {
        SimpleTask simple = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Помыть машину"});
        Meeting meeting = new Meeting(3, "Обсуждение релиза", "Проект Б", "Сегодня");

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Футбол");

        Assertions.assertArrayEquals(expected, actual);
    }
}
