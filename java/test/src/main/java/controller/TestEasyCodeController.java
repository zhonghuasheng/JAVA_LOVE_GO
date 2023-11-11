package testeasycode.controller;

import testeasycode.entity.TestEasyCode;
import testeasycode.service.TestEasyCodeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TestEasyCode)表控制层
 *
 * @author makejava
 * @since 2020-02-17 11:14:05
 */
@RestController
@RequestMapping("testEasyCode")
public class TestEasyCodeController {
    /**
     * 服务对象
     */
    @Resource
    private TestEasyCodeService testEasyCodeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestEasyCode selectOne( id) {
        return this.testEasyCodeService.queryById(id);
    }

}