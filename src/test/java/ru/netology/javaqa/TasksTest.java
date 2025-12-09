package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить маме");
        Assertions.assertTrue(task.matches("Позвонить"));
    }

    @Test
    public void shouldNotMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить маме");
        Assertions.assertFalse(task.matches("купить"));
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = { "Молоко", "Хлеб", "Яйца" };
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("Хлеб"));
    }

    @Test
    public void shouldNotMatchEpic() {
        String[] subtasks = { "Молоко", "Хлеб", "Яйца" };
        Epic epic = new Epic(2, subtasks);
        Assertions.assertFalse(epic.matches("Сметана"));
    }

    @Test
    public void shouldMatchMeetingByTopic() {
        Meeting meeting = new Meeting(3,
                "Релиз версии",
                "Приложение Банка",
                "В 10 утра");

        Assertions.assertTrue(meeting.matches("Релиз"));
    }

    @Test
    public void shouldMatchMeetingByProject() {
        Meeting meeting = new Meeting(3,
                "Релиз версии",
                "Приложение Банка",
                "В 10 утра");

        Assertions.assertTrue(meeting.matches("Банка"));
    }

    @Test
    public void shouldNotMatchMeeting() {
        Meeting meeting = new Meeting(3,
                "Релиз версии",
                "Приложение Банка",
                "В 10 утра");

        Assertions.assertFalse(meeting.matches("ужин"));
    }
}
