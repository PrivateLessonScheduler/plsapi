package nao.plsapi.business;

import nao.plsapi.view.UserView;
import nao.plsapi.view.info.UserInfo;

import java.util.List;

public interface UserManager {

    List<UserView> findAll();

    UserView find(final String userId);

    UserView save(final UserInfo userInfo);

    void delete(final String userId);

}
