package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String userNick;
    private final char sex;
    private final LocalDate birthDate;
    private final int quantityPosts;

    public ForumUser(final int userId, final String userNick, final char sex, final int yearOfBirth,
                     final int monthOfBirth, final int dayOfBirth, final int quantityPosts) {
        this.userId = userId;
        this.userNick = userNick;
        this.sex = sex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.quantityPosts = quantityPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getQuantityPosts() {
        return quantityPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", quantityPosts=" + quantityPosts +
                '}';
    }
}
