package com.kodilla.testing.forum.statistics;

import forum.statistics.Statistics;
import forum.statistics.StatisticsCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalcTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Mock
    private Statistics statisticsMock;

    private static List createUsers(int n) {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add("User" + i);
        }
        return users;
    }

    @Test
    void testCalculateAdvStatisticsPostsZero() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List users = createUsers(3);
        int postsCount1 = 0;
        int comments1 = 10;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(3, statisticsCalculator.getUsers());
        Assertions.assertEquals(0, statisticsCalculator.getPosts());
        Assertions.assertEquals(10, statisticsCalculator.getComments());
        Assertions.assertEquals(0, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(3, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsPosts1000() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List users = createUsers(3);
        int postsCount1 = 1000;
        int comments1 = 10;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(3, statisticsCalculator.getUsers());
        Assertions.assertEquals(1000, statisticsCalculator.getPosts());
        Assertions.assertEquals(10, statisticsCalculator.getComments());
        Assertions.assertEquals(333, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(3, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsCommentsZero() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List users = createUsers(3);
        int postsCount1 = 50;
        int comments1 = 0;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(3, statisticsCalculator.getUsers());
        Assertions.assertEquals(50, statisticsCalculator.getPosts());
        Assertions.assertEquals(0, statisticsCalculator.getComments());
        Assertions.assertEquals(16, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsCommentsLessThanPosts() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List users = createUsers(3);
        int postsCount1 = 100;
        int comments1 = 50;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(3, statisticsCalculator.getUsers());
        Assertions.assertEquals(100, statisticsCalculator.getPosts());
        Assertions.assertEquals(50, statisticsCalculator.getComments());
        Assertions.assertEquals(33, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(16, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsCommentsMoreThanPosts() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List users = createUsers(3);
        int postsCount1 = 50;
        int comments1 = 100;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(3, statisticsCalculator.getUsers());
        Assertions.assertEquals(50, statisticsCalculator.getPosts());
        Assertions.assertEquals(100, statisticsCalculator.getComments());
        Assertions.assertEquals(16, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(33, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(2, statisticsCalculator.getCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsUsersNull() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List<String> users = new ArrayList<>();
        int postsCount1 = 100;
        int comments1 = 100;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0, statisticsCalculator.getUsers());
        Assertions.assertEquals(100, statisticsCalculator.getPosts());
        Assertions.assertEquals(100, statisticsCalculator.getComments());
        Assertions.assertEquals(0, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(0, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(1, statisticsCalculator.getCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsUsers100() {
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        List users = createUsers(100);
        int postsCount1 = 100;
        int comments1 = 100;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postsCount1);
        when(statisticsMock.commentsCount()).thenReturn(comments1);
        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(100, statisticsCalculator.getUsers());
        Assertions.assertEquals(100, statisticsCalculator.getPosts());
        Assertions.assertEquals(100, statisticsCalculator.getComments());
        Assertions.assertEquals(1, statisticsCalculator.getPostsPerUser());
        Assertions.assertEquals(1, statisticsCalculator.getCommentsPerUser());
        Assertions.assertEquals(1, statisticsCalculator.getCommentsPerPost());
    }
}
