package repository;

import enumm.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private Map<String, List<Authorities>> userAuthoritiesMap = new HashMap<>();

    // Конструктор, в котором добавляем тестовых пользователей с разрешениями
    public UserRepository() {
        userAuthoritiesMap.put("user1", Arrays.asList(Authorities.READ, Authorities.WRITE));
        userAuthoritiesMap.put("user2", Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userAuthoritiesMap.containsKey(user)) {
            return userAuthoritiesMap.get(user);
        } else {
            return Collections.emptyList();
        }
    }
}