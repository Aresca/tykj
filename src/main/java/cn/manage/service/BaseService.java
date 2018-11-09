package cn.manage.service;
import java.util.List;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseService<T> {

    public abstract Mapper<T> getMapper();

    /**
     * 根据id查询
     * 
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return this.getMapper().selectByPrimaryKey(id);
    }

    /**
     * 查询所有的数据
     * 
     * @return
     */
    public List<T> queryAll() {
        return this.getMapper().select(null);
    }

    /**
     * 根据条件查询一条数据
     * 
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return this.getMapper().selectOne(record);
    }

    /**
     * 根据条件查询数据
     * 
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return this.getMapper().select(record);
    }

    /**
     * 分页查询数据
     * 
     * @param record
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhere(record);
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据
     * 
     * @param t
     * @return
     */
    public Integer save(T t) {
        return this.getMapper().insert(t);
    }

    /**
     * 新增数据，使用不为null的字段
     * 
     * @param t
     * @return
     */
    public Integer saveSelective(T t) {
        return this.getMapper().insertSelective(t);
    }

    /**
     * 修改数据
     * 
     * @param t
     * @return
     */
    public Integer update(T t) {
        return this.getMapper().updateByPrimaryKey(t);
    }

    /**
     * 修改数据，使用不为null的字段
     * 
     * @param t
     * @return
     */
    public Integer updateSelective(T t) {
        return this.getMapper().updateByPrimaryKeySelective(t);
    }

    /**
     * 根据主键删除
     * 
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.getMapper().deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * 
     * @param ids
     * @param property
     * @param clazz
     * @return
     */
    public Integer deleteByIds(List<Object> ids, String property, Class<T> clazz) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, ids);
        return this.getMapper().deleteByExample(example);
    }
}

