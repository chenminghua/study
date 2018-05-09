package minghua.mockito;

public interface UserDao {
    User getUser(int id);

    boolean update(User user);
}
