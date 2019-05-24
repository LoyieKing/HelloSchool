package org.school.dao;

import java.util.List;

public interface IBaseDao {

    List<?> list(Class clazz);

    List<?> listAll(Class clazz);

    void saveOrUpdate(Object entity);

    void delete(Object entity);

    Object getById(Integer id, Class clazz);

}
