package root.web.base;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.model.IModel;

import root.auth.Authenticate;
import root.auth.Role;

@Authenticate(Role.ANONYMOUSE)
public abstract class AnonymousWebBasePage extends WebBasePage {
    private static final long serialVersionUID = 1L;

    public AnonymousWebBasePage() {
        super();
        commonInit();
    }

    public AnonymousWebBasePage(IModel<?> model) {
        super(model);
        commonInit();
    }

    public AnonymousWebBasePage(IPageMap pageMap, IModel<?> model) {
        super(pageMap, model);
        commonInit();
    }

    public AnonymousWebBasePage(IPageMap pageMap, PageParameters parameters) {
        super(pageMap, parameters);
        commonInit();
    }

    public AnonymousWebBasePage(IPageMap pageMap) {
        super(pageMap);
        commonInit();
    }

    public AnonymousWebBasePage(PageParameters parameters) {
        super(parameters);
        commonInit();
    }

    private void commonInit() {

    }
}
