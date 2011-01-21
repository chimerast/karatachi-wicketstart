package root.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.request.IRequestCycleProcessor;
import org.karatachi.wicket.auth.AuthenticatedWebApplication;
import org.karatachi.wicket.auth.AuthenticatedWebSession;
import org.karatachi.wicket.locator.WebRootFileLocator;
import org.karatachi.wicket.locator.WebRootServletWebRequest;
import org.karatachi.wicket.ssl.RequiredSSLWebRequestCycleProcessor;

import root.auth.Authenticate;
import root.entity.Account;
import root.web.auth.SignInPage;

public class WicketApplication extends
        AuthenticatedWebApplication<Account, Authenticate> {
    @Override
    protected void init() {
        getResourceSettings().addResourceFolder("");
        getResourceSettings().setResourceStreamLocator(
                new WebRootFileLocator("root/web"));
    }

    @Override
    protected WebRequest newWebRequest(HttpServletRequest servletRequest) {
        return new WebRootServletWebRequest(servletRequest);
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return IndexPage.class;
    }

    @Override
    protected Class<? extends AuthenticatedWebSession<Account>> getWebSessionClass() {
        return WicketSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SignInPage.class;
    }

    @Override
    protected Class<Authenticate> getAnnotationClass() {
        return Authenticate.class;
    }

    @Override
    protected boolean authorize(Account role, Authenticate annotation) {
        return true;
        /*
        long code = annotation.value().getCode();
        if (annotation.value() == Role.ANONYMOUSE) {
            return true;
        } else if (role != null && (role.role & code) == code) {
            return true;
        } else {
            return false;
        }
        */
    }

    @Override
    protected IRequestCycleProcessor newRequestCycleProcessor() {
        return new RequiredSSLWebRequestCycleProcessor();
    }
}
