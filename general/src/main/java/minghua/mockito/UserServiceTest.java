package minghua.mockito;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserDao mockDao;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(UserDao.class);
        when(mockDao.getUser(1)).thenReturn(new User(1, "User1"));
        when(mockDao.update(isA(User.class))).thenReturn(true);

        userService = new UserService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = userService.update(1, "new name");
        assertTrue("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getUser(eq(1));
        //验证是否执行过一次update
        verify(mockDao, times(1)).update(isA(User.class));
    }


    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = userService.update(2, "new name");
        assertFalse("must true", result);
        //验证是否执行过一次getUser(1)
        verify(mockDao, times(1)).getUser(eq(2));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(User.class));
    }


    @Test(expected = RuntimeException.class)
    public void doThrow_when(){
        List list = mock(List.class);
        doThrow(new RuntimeException()).when(list).add(1);
        list.add(1);
    }
}
