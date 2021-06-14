package forum.statistics;

public class StatisticsCalculator {
    private Statistics statistics;
    private int posts;
    private int comments;
    private int users;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getPosts() {
        return posts;
    }

    public int getComments() {
        return comments;
    }

    public int getUsers() {
        return users;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        posts = statistics.postsCount();
        comments = statistics.commentsCount();
        users = statistics.usersNames().size();
        if (users > 0) {
            postsPerUser = statistics.postsCount() / statistics.usersNames().size();
            commentsPerUser = statistics.commentsCount() / statistics.usersNames().size();
        }
        if (posts > 0) {
            commentsPerPost = statistics.commentsCount() / statistics.postsCount();
        }
    }
}
