package root.web.base;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public abstract class WebBasePage extends WebPage implements IHeaderContributor {
    private static final long serialVersionUID = 1L;

    public static final ResourceReference BOOTSTRAP_CSS =
            new ResourceReference(WebBasePage.class, "bootstrap.css");
    public static final ResourceReference BOOTSTRAP_RESPONSIVE_CSS =
            new ResourceReference(WebBasePage.class, "bootstrap-responsive.css");
    public static final ResourceReference JQUERY_JS = new ResourceReference(
            WebBasePage.class, "jquery.js");
    public static final ResourceReference BOOTSTRAP_JS = new ResourceReference(
            WebBasePage.class, "bootstrap.js");

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
        response.renderCSSReference(BOOTSTRAP_CSS);
        response.renderString("<style type=\"text/css\"> body { padding-top: 60px; padding-bottom: 40px; } .sidebar-nav { padding: 9px 0; } </style>");
        response.renderCSSReference(BOOTSTRAP_RESPONSIVE_CSS);

        response.renderJavascriptReference(JQUERY_JS);
        response.renderJavascriptReference(BOOTSTRAP_JS);
    }
}
