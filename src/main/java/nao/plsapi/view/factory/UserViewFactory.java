package nao.plsapi.view.factory;

import nao.plsapi.data.modal.User;
import nao.plsapi.view.UserView;

import java.util.ArrayList;
import java.util.List;

public class UserViewFactory {

    public static UserView from(User user){
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setFirstName(user.getFirstName());
        userView.setLastName(user.getLastName());
        userView.setUserName(user.getUserName());

        return userView;
    }

    public static List<UserView> fromList(List<User> users){
        List<UserView> usersView = new ArrayList<>();

        for (User user : users){
            usersView.add(from(user));
        }
        return usersView;
    }

}
