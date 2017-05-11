/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.utils.dbUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author macako
 */
public interface NewInterface {

    /**
     * 执行批量sql语句
     *
     * @param sql    sql语句
     * @param params 二维参数数组
     * @return 受影响的行数的数组
     */
    int[] batchUpdate(String sql, Object[][] params) throws SQLException;

    void fillStatement(PreparedStatement stmt, Object... params) throws SQLException;

    /**
     * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
     *
     * @param sql sql语句
     * @return 查询结果
     */
    List<Map<String, Object>> find(String sql);

    /**
     * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 查询结果
     */
    List<Map<String, Object>> find(String sql, Object param);

    /**
     * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 查询结果
     */
    List<Map<String, Object>> find(String sql, Object[] params);

    /**
     * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @return 查询结果
     */
    <T> List<T> find(Class<T> entityClass, String sql);

    /**
     * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param param       参数
     * @return 查询结果
     */
    <T> List<T> find(Class<T> entityClass, String sql, Object param);

    /**
     * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param params      参数数组
     * @return 查询结果
     */
    @SuppressWarnings(value = "unchecked")
    <T> List<T> find(Class<T> entityClass, String sql, Object[] params);

    /**
     * 执行分页查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param page        页号
     * @param pageSize    每页记录条数
     * @return 查询结果
     */
    <T> List<T> find(Class<T> entityClass, String sql, int page, int pageSize);

    /**
     * 执行分页查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param param       参数
     * @param page        页号
     * @param pageSize    每页记录条数
     * @return 查询结果
     */
    <T> List<T> find(Class<T> entityClass, String sql, Object param, int page, int pageSize);

    /**
     * 执行分页查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param params      参数数组
     * @param page        页号
     * @param pageSize    每页记录条数
     * @return 查询结果
     */
    @SuppressWarnings(value = "unchecked")
    <T> List<T> find(Class<T> entityClass, String sql, Object[] params, int page, int pageSize);

    /**
     * 查询某一条记录，并将指定列的数据转换为Object
     *
     * @param sql        sql语句
     * @param columnName 列名
     * @return 结果对象
     */
    Object findBy(String sql, String columnName);

    /**
     * 查询某一条记录，并将指定列的数据转换为Object
     *
     * @param sql        sql语句
     * @param columnName 列名
     * @param param      参数
     * @return 结果对象
     */
    Object findBy(String sql, String columnName, Object param);

    /**
     * 查询某一条记录，并将指定列的数据转换为Object
     *
     * @param sql        sql语句
     * @param columnName 列名
     * @param params     参数数组
     * @return 结果对象
     */
    Object findBy(String sql, String columnName, Object[] params);

    /**
     * 查询某一条记录，并将指定列的数据转换为Object
     *
     * @param sql         sql语句
     * @param columnIndex 列索引
     * @return 结果对象
     */
    Object findBy(String sql, int columnIndex);

    /**
     * 查询某一条记录，并将指定列的数据转换为Object
     *
     * @param sql         sql语句
     * @param columnIndex 列索引
     * @param param       参数
     * @return 结果对象
     */
    Object findBy(String sql, int columnIndex, Object param);

    /**
     * 查询某一条记录，并将指定列的数据转换为Object
     *
     * @param sql         sql语句
     * @param columnIndex 列索引
     * @param params      参数数组
     * @return 结果对象
     */
    Object findBy(String sql, int columnIndex, Object[] params);

    /**
     * 查询出结果集中的第一条记录，并封装成对象
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @return 对象
     */
    <T> T findFirst(Class<T> entityClass, String sql);

    /**
     * 查询出结果集中的第一条记录，并封装成对象
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param param       参数
     * @return 对象
     */
    <T> T findFirst(Class<T> entityClass, String sql, Object param);

    /**
     * 查询出结果集中的第一条记录，并封装成对象
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param params      参数数组
     * @return 对象
     */
    @SuppressWarnings(value = "unchecked")
    <T> T findFirst(Class<T> entityClass, String sql, Object[] params);

    /**
     * 查询出结果集中的第一条记录，并封装成Map对象
     *
     * @param sql sql语句
     * @return 封装为Map的对象
     */
    Map<String, Object> findFirst(String sql);

    /**
     * 查询出结果集中的第一条记录，并封装成Map对象
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 封装为Map的对象
     */
    Map<String, Object> findFirst(String sql, Object param);

    /**
     * 查询出结果集中的第一条记录，并封装成Map对象
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 封装为Map的对象
     */
    @SuppressWarnings(value = "unchecked")
    Map<String, Object> findFirst(String sql, Object[] params);

    /**
     * 执行分页查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中,然后装List封装成PageResult对象
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param page        页号
     * @param pageSize    每页记录条数
     * @return PageResult对象
     */
    <T> PageResult findPageResult(Class<T> entityClass, String sql, int page, int pageSize);

    /**
     * 执行分页查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中,然后装List封装成PageResult对象
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param param       参数
     * @param page        页号
     * @param pageSize    每页记录条数
     * @return PageResult对象
     */
    <T> PageResult findPageResult(Class<T> entityClass, String sql, Object param, int page, int pageSize);

    /**
     * 执行分页查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中,然后装List封装成PageResult对象
     *
     * @param entityClass 类名
     * @param sql         sql语句
     * @param params      参数数组
     * @param page        页号
     * @param pageSize    每页记录条数
     * @return PageResult对象
     */
    @SuppressWarnings(value = "unchecked")
    <T> PageResult findPageResult(Class<T> entityClass, String sql, Object[] params, int page, int pageSize);

    /**
     * 查询记录总条数
     *
     * @param sql sql语句
     * @return 记录总数
     */
    int getCount(String sql);

    /**
     * 查询记录总条数
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 记录总数
     */
    int getCount(String sql, Object param);

    /**
     * 查询记录总条数
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 记录总数
     */
    int getCount(String sql, Object[] params);

    /**
     * 执行sql语句
     *
     * @param sql sql语句
     * @return 受影响的行数
     */
    long insert(String sql) throws SQLException;

    /**
     * 执行sql语句
     * <code>
     * executeUpdate("insert user(name, age) values(?,?));
     * </code>
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 受影响的行数
     */
    long insert(String sql, Object param) throws SQLException;

    /**
     * 插入一条记录，并返回自增主键
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 自增主键(如果没有更新成功, 返回-1或跑出异常)
     * @throws java.sql.SQLException
     */
    long insert(String sql, Object[] params) throws SQLException;

    void setDataSource(DataSource dataSource);

    void setPmdKnownBroken(boolean pmdKnownBroken);

    /**
     * 执行sql语句
     *
     * @param sql sql语句
     * @return 受影响的行数
     */
    int update(String sql) throws SQLException;

    /**
     * 执行sql语句
     * <code>
     * executeUpdate("update user set username = 'kitty' where username = ?", "hello kitty");
     * </code>
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 受影响的行数
     */
    int update(String sql, Object param) throws SQLException;

    /**
     * 执行sql语句,无法保证事务不推荐使用
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 受影响的行数
     */
    int update(String sql, Object[] params) throws SQLException;
    
}
