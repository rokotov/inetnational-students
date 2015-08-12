package kotov.interstudents.common.model;

import kotov.interstudents.common.IdHolder;

import java.io.Serializable;

/**
 * Created by vkotov on 18.12.2014.
 */
public abstract class AbstractEntity implements Serializable, IdHolder {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractEntity that = (AbstractEntity) o;

        return !(getId() == null || !getId().equals(that.getId()));

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : super.hashCode();
    }
}
