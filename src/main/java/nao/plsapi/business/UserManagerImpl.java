package nao.plsapi.business;

import nao.plsapi.data.modal.User;
import nao.plsapi.data.repository.UserRepository;
import nao.plsapi.view.UserView;
import nao.plsapi.view.factory.UserViewFactory;
import nao.plsapi.view.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserRepository userRepository;

    public List<UserView> findAll() {
        return UserViewFactory.fromList(userRepository.findAll());
    }

    @Override
    public UserView find(final String studentId) {
        return UserViewFactory.from(userRepository.findOne(studentId));
    }

    @Override
    public UserView save(UserInfo userInfo) {
        User user = new User();
        user.setId(userInfo.getId());
        user.setFirstName(userInfo.getFirstName());
        user.setLastName(userInfo.getLastName());
        user.setUserName(userInfo.getUserName());
        user.setPassword(userInfo.getPassword());

        if (userInfo.getId() != null && userInfo.getId().isEmpty()) {
            user.setId(null);
        }

        return UserViewFactory.from(userRepository.save(user));
    }

    @Override
    public void delete(String studentId) {
        userRepository.delete(studentId);
    }
}
