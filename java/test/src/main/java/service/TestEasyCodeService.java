package testeasycode.service;

import testeasycode.entity.TestEasyCode;
import java.util.List;

/**
 * (TestEasyCode)表服务接口
 *
 * @author makejava
 * @since 2020-02-17 11:14:04
 */
public interface TestEasyCodeService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    TestEasyCode queryById( );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TestEasyCode> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param testEasyCode 实例对象
     * @return 实例对象
     */
    TestEasyCode insert(TestEasyCode testEasyCode);

    /**
     * 修改数据
     *
     * @param testEasyCode 实例对象
     * @return 实例对象
     */
    TestEasyCode update(TestEasyCode testEasyCode);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}