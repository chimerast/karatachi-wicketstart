package root.web;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.seasar.dao.pager.DefaultPagerCondition;
import org.seasar.dao.pager.PagerCondition;
import org.seasar.framework.container.annotation.tiger.Binding;

import root.dao.CorpBssDao;
import root.entity.CorpBss;
import root.web.base.WebBasePage;

public class IndexPage extends WebBasePage {

    @Binding
    private CorpBssDao corpBssDao;

    public IndexPage() {
        final SortableDataProvider<CorpBss> provider =
                new SortableDataProvider<CorpBss>() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public int size() {
                        return corpBssDao.count();
                    }

                    @Override
                    public IModel<CorpBss> model(CorpBss object) {
                        return new CompoundPropertyModel<CorpBss>(object);
                    }

                    @Override
                    public Iterator<? extends CorpBss> iterator(int first,
                            int count) {
                        PagerCondition condition = new DefaultPagerCondition();;
                        condition.setOffset(first);
                        condition.setLimit(count);
                        return corpBssDao.selectPage(condition).iterator();
                    }
                };

        final DataView<CorpBss> companies;
        add(companies = new DataView<CorpBss>("companies", provider, 10) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(Item<CorpBss> item) {
                CorpBss corpBss = item.getModelObject();
                item.add(new Label("id", corpBss.globalId));
                item.add(new Label("name", corpBss.corpFrmlNameVch));
            }
        });
        add(new PagingNavigator("navigator", companies));
    }
}
