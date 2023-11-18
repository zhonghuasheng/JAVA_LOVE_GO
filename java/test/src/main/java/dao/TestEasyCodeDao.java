package testeasycode.dao;

import testeasycode.entity.TestEasyCode;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TestEasyCode)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-17 11:14:03
 */
public interface TestEasyCodeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    TestEasyCode queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TestEasyCode> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param testEasyCode 实例对象
     * @return 对象列表
     */
    List<TestEasyCode> queryAll(TestEasyCode testEasyCode);

    /**
     * 新增数据
     *
     * @param testEasyCode 实例对象
     * @return 影响行数
     */
    int insert(TestEasyCode testEasyCode);

    /**
     * 修改数据
     *
     * @param testEasyCode 实例对象
     * @return 影响行数
     */
    int update(TestEasyCode testEasyCode);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}