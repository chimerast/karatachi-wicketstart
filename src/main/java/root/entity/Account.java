package root.entity;

import org.seasar.dao.annotation.tiger.Bean;
import org.seasar.dao.annotation.tiger.Id;
import org.seasar.dao.annotation.tiger.IdType;

@Bean(table = "account", timeStampProperty = "updated")
public class Account extends EntityBase {
    private static final long serialVersionUID = 1L;

    @Id(value = IdType.SEQUENCE, sequenceName = "account_id_seq")
    public long id;

    public String name;
    public String password;
    public boolean valid;
    public long role;
}
