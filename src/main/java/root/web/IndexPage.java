package root.web;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.seasar.framework.container.annotation.tiger.Binding;

import root.dao.CorpBssDao;
import root.entity.CorpBss;
import root.web.base.WebBasePage;

public class IndexPage extends WebBasePage {
    private static final long serialVersionUID = 1L;

    @Binding
    private CorpBssDao corpBssDao;

    public IndexPage(PageParameters parameters) {
        super(parameters);

        // retrieve query parameter
        String globalId = parameters.getString("global_id", "JP3205800000");

        // search a company from db
        CorpBss corpBss = corpBssDao.select(globalId);

        add(new Label("globalId", corpBss.globalId));
        add(new Label("corpFrmlNameVch", corpBss.corpFrmlNameVch));
        add(new Label("adrsVch", corpBss.adrsVch));
    }
}
