package root.web;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.seasar.framework.container.annotation.tiger.Binding;

import root.dao.CorpBssDao;
import root.entity.CorpBss;
import root.web.base.WebBasePage;

public class SearchPage extends WebBasePage {
    private static final long serialVersionUID = 1L;

    @Binding
    private CorpBssDao corpBssDao;

    private String keyword;

    public SearchPage(PageParameters parameters) {
        super(parameters);

        add(new SearchForm("form", new PropertyModel<String>(this, "keyword")));

        IModel<List<CorpBss>> resultsModel =
                new LoadableDetachableModel<List<CorpBss>>() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    protected List<CorpBss> load() {
                        System.out.println(keyword);
                        List<CorpBss> ret = corpBssDao.selectByName(keyword);
                        System.out.println(ret);
                        return ret;
                    }
                };

        add(new PropertyListView<CorpBss>("results", resultsModel) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<CorpBss> item) {
                item.add(new Label("globalId"));
                item.add(new Label("corpFrmlNameVch"));

                CorpBss corpBss = item.getModelObject();
                PageParameters parameters = new PageParameters();
                parameters.add("global_id", corpBss.globalId);
                item.add(new BookmarkablePageLink<Void>("link",
                        IndexPage.class, parameters));
            }
        });
    }

    public class SearchForm extends Form<String> {
        private static final long serialVersionUID = 1L;

        public SearchForm(String id, IModel<String> model) {
            super(id, model);

            add(new TextField<String>("keyword", model));
        }
    }
}
