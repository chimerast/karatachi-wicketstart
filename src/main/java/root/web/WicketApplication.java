package root.web;

import org.apache.wicket.Page;
import org.seasar.wicket.S2WebApplication;

public class WicketApplication extends S2WebApplication {
    @Override
    protected void init() {
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return IndexPage.class;
    }
}
