package esvar.ua.dekanatmainwindow.view;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@PageTitle("Login")
@AnonymousAllowed
public class LoginView extends LoginOverlay {

    public LoginView() {
        setTitle("Dekanat Portal");
        setDescription("Увійдіть для продовження");
        setAction("login");
        setOpened(true);
        setForgotPasswordButtonVisible(false);
    }
}
