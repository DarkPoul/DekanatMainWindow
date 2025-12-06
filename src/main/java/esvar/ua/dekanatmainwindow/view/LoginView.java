package esvar.ua.dekanatmainwindow.view;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@CssImport("./styles/minimal-login.css")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm loginForm;

    public LoginView() {
        setSizeFull();
        addClassName("login-view");
        setPadding(false);
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        loginForm = new LoginForm();
        loginForm.setAction("login");
        loginForm.setForgotPasswordButtonVisible(false);
        loginForm.setError(false);
        loginForm.setI18n(createMinimalI18n());

        add(loginForm);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        loginForm.setError(false);
    }

    private LoginI18n createMinimalI18n() {
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form form = i18n.getForm();
        form.setTitle("");
        form.setUsername("");
        form.setPassword("");
        form.setSubmit("Вхід");
        form.setForgotPassword("");
        i18n.setForm(form);

        LoginI18n.ErrorMessage errorMessage = i18n.getErrorMessage();
        errorMessage.setTitle("");
        errorMessage.setMessage("");
        i18n.setErrorMessage(errorMessage);

        i18n.setHeader(new LoginI18n.Header());
        i18n.setAdditionalInformation("");

        return i18n;
    }
}
