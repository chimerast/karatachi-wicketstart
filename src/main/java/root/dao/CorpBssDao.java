package root.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.dao.annotation.tiger.Sql;
import org.seasar.dao.pager.PagerCondition;

import root.entity.CorpBss;

@S2Dao(bean = CorpBss.class)
public interface CorpBssDao {

    public List<CorpBss> selectPage(PagerCondition condition);

    public List<CorpBss> selectAll();

    @Sql("SELECT count(*) FROM corp_bss")
    public int count();
}
