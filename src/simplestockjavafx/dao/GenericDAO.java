package simplestockjavafx.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author cecilio alvarez caules contacto@arquitecturajava.com
 * @version 1.0
 */
public interface GenericDAO<T, Id extends Serializable> {

    T findById(Id id);

    List<T> findAll();
    
    List<T> findByParameter(Object param);
    
    List<T> findByParameters(Object[] params);
    
    void save(T objeto);

    void delete(T objeto);

    void insert(T objeto);    
    

}
