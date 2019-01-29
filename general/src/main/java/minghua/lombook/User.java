package minghua.lombook;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class User {
    private int id;

    private String name;
    private String email;

    private int sex;
    private String address;
}
