package root.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.NoPersistentProperty;
import org.seasar.dao.annotation.tiger.S2Dao;

import root.entity.Account;

@S2Dao(bean = Account.class)
public interface AccountDao {
    public List<Account> select();

    @NoPersistentProperty("registered")
    public int insert(Account account);

    @NoPersistentProperty("registered")
    public int update(Account account);

    @NoPersistentProperty("registered")
    public int delete(Account account);
}
