package root.web.base;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import root.auth.Authenticate;
import root.auth.Role;

@Authenticate(Role.CUSTOMER)
public abstract class WebBasePage extends WebPage implements IHeaderContributor {
    private static final long serialVersionUID = 1L;

    public static final ResourceReference DEFAULT_CSS = new ResourceReference(
            WebBasePage.class, "default.css");

    public WebBasePage() {
        super();
        commonInit();
    }

    public WebBasePage(IModel<?> model) {
        super(model);
        commonInit();
    }

    public WebBasePage(IPageMap pageMap, IModel<?> model) {
        super(pageMap, model);
        commonInit();
    }

    public WebBasePage(IPageMap pageMap, PageParameters parameters) {
        super(pageMap, parameters);
        commonInit();
    }

    public WebBasePage(IPageMap pageMap) {
        super(pageMap);
        commonInit();
    }

    public WebBasePage(PageParameters parameters) {
        super(parameters);
        commonInit();
    }

    private void commonInit() {
        add(new Label("title", getPageTitle()));
    }

    protected String getPageTitle() {
        return getClass().getSimpleName();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.renderCSSReference(DEFAULT_CSS);
    }
}
