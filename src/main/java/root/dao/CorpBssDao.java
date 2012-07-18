package root.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.Arguments;
import org.seasar.dao.annotation.tiger.Query;
import org.seasar.dao.annotation.tiger.S2Dao;

import root.entity.CorpBss;

@S2Dao(bean = CorpBss.class)
public interface CorpBssDao {

    @Arguments("global_id")
    public CorpBss select(String globalId);

    @Query("corp_frml_name_vch LIKE CONCAT('%', ? , '%') LIMIT 10")
    public List<CorpBss> selectByName(String name);
}
