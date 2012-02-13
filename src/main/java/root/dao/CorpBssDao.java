package root.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.Query;
import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.dao.annotation.tiger.Sql;
import org.seasar.dao.pager.PagerCondition;

import root.entity.CorpBss;

@S2Dao(bean = CorpBss.class)
public interface CorpBssDao {

    @Query("ORDER BY global_id")
    public List<CorpBss> selectPage(PagerCondition condition);

    @Sql("SELECT count(*) FROM corp_bss")
    public int count();
}
