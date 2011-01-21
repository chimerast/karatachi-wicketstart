package root.web;

import org.apache.wicket.Request;
import org.karatachi.wicket.auth.AuthenticatedWebSession;
import org.seasar.framework.container.SingletonS2Container;

import root.entity.Account;
import root.logic.AccountLogic;

public class WicketSession extends AuthenticatedWebSession<Account> {
    private static final long serialVersionUID = 1L;

    private Account account;

    public WicketSession(Request request) {
        super(request);
    }

    @Override
    public Account getRole() {
        return account;
    }

    @Override
    public void signOut() {
        super.signOut();
        account = null;
    }

    @Override
    protected boolean authenticate(String username, String password) {
        AccountLogic accountLogic =
                SingletonS2Container.getComponent(AccountLogic.class);
        return (account = accountLogic.authenticate(username, password)) != null;
    }
}
