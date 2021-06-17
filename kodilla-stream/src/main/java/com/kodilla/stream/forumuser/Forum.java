package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Forum() {
        forumUsers.add(new ForumUser(1, "Adam", 'M', 1990, 3, 12, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(2, "Jolee", 'F', 1992, 6, 8, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(3, "Clark", 'M', 1994, 1, 25, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(4, "Asia", 'F', 1989, 7, 29, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(5, "Joe", 'M', 1985, 8, 6, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(6, "Mark", 'M', 2010, 12, 12, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(7, "Suzie", 'F', 2011, 1, 25, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(8, "Ewa", 'F', 1986, 7, 3, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(9, "Adam", 'M', 2008, 6, 19, RANDOM.nextInt(70)));
        forumUsers.add(new ForumUser(10, "Edd", 'M', 2009, 8, 17, RANDOM.nextInt(70)));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<ForumUser>(forumUsers);
    }
}
