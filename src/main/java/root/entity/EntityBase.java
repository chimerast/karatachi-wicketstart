package root.entity;

import java.io.Serializable;
import java.util.Date;

public class EntityBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public Date registered;
    public Date updated;
}
