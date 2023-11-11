package testeasycode.service.impl;

import testeasycode.entity.TestEasyCode;
import testeasycode.dao.TestEasyCodeDao;
import testeasycode.service.TestEasyCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestEasyCode)表服务实现类
 *
 * @author makejava
 * @since 2020-02-17 11:14:05
 */
@Service("testEasyCodeService")
public class TestEasyCodeServiceImpl implements TestEasyCodeService {
    @Resource
    private TestEasyCodeDao testEasyCodeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public TestEasyCode queryById( ) {
        return this.testEasyCodeDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TestEasyCode> queryAllByLimit(int offset, int limit) {
        return this.testEasyCodeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param testEasyCode 实例对象
     * @return 实例对象
     */
    @Override
    public TestEasyCode insert(TestEasyCode testEasyCode) {
        this.testEasyCodeDao.insert(testEasyCode);
        return testEasyCode;
    }

    /**
     * 修改数据
     *
     * @param testEasyCode 实例对象
     * @return 实例对象
     */
    @Override
    public TestEasyCode update(TestEasyCode testEasyCode) {
        this.testEasyCodeDao.update(testEasyCode);
        return this.queryById(testEasyCode.get());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.testEasyCodeDao.deleteById() > 0;
    }
}