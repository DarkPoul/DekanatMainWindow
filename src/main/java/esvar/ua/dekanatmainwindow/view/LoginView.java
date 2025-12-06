package esvar.ua.dekanatmainwindow.view;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@CssImport("./styles/tohell-login.css")
@AnonymousAllowed
public class LoginView extends LoginOverlay implements BeforeEnterObserver {

    public LoginView() {
        setI18n(createSilentI18n());
        setAction("login");
        setError(false);
        setForgotPasswordButtonVisible(false);
        setOpened(true);
        getLoginForm().getSubmitButton().setText("ToHell");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        setError(false);
    }

    private LoginI18n createSilentI18n() {
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Header header = new LoginI18n.Header();
        header.setTitle("");
        header.setDescription("");
        i18n.setHeader(header);

        LoginI18n.Form form = i18n.getForm();
        form.setTitle("");
        form.setUsername("");
        form.setPassword("");
        form.setSubmit("ToHell");
        form.setForgotPassword("");
        form.setRememberMe("");
        form.setUsernamePlaceholder("");
        form.setPasswordPlaceholder("");
        i18n.setForm(form);

        LoginI18n.ErrorMessage errorMessage = i18n.getErrorMessage();
        errorMessage.setTitle("");
        errorMessage.setMessage("");
        i18n.setErrorMessage(errorMessage);

        i18n.setAdditionalInformation("");

        return i18n;
    }
}
