package minghua.mockito;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean update(int id, String name){
        User user = userDao.getUser(id);
        if (null == user) {
            return false;
        }
        User updatedUser = new User(user.getId(), name);
        return userDao.update(updatedUser);
    }
}
