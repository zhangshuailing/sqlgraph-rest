package nk.gk.wyl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nk.gk.wyl.api.SqlGraphService;
import nk.gk.wyl.util.QueryUtil;
import nk.gk.wyl.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
* @Description:    控制层
* @Author:         zhangshuailing
* @CreateDate:     2020/10/12 10:56
* @UpdateUser:     zhangshuailing
* @UpdateDate:     2020/10/12 10:56
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@RestController
@RequestMapping("rest/v1/sql-graph")
@Api(tags = "sqlGraph-rest接口")
public class SqlGraphController {
    @GetMapping("")
    public String index(){
        return "SQL-GRAPH";
    }

    @Autowired
    private SqlGraphService sqlService;


    /**
     * 添加或更新
     *
     * @param table 表名
     * @param map_body 参数
     * @return 返回数据
     * @throws Exception 异常信息
     */
    @PostMapping("{table}/saveOrUpdate")
    @ApiOperation(value = "添加或更新")
    public String saveOrUpdate(@PathVariable("table") String table,
                               @RequestBody Map<String, Object> map_body) throws Exception {
        // 复制map
        String uid = QueryUtil.getUid(map_body);
        return sqlService.saveOrUpdate(map_body, table, uid);
    }

    /**
     * 分页语句
     *
     * @param table    表名
     * @param map_body json 参数
     * @return 返回map 对象
     * @throws Exception 异常信息
     */
    @PostMapping("{table}/page")
    @ApiOperation(value = "分页语句,暂时不能用")
    public Map<String, Object> page(@PathVariable("table") String table,
                                    @RequestBody Map<String, Object> map_body) throws Exception {
        // 复制map
        return sqlService.page(table, map_body);
    }


    /**
     * 列表
     *
     * @param table
     * @param map_body
     * @return
     * @throws Exception 异常信息
     */

    @PostMapping("{table}/list")
    @ApiOperation(value = "列表查询")
    public List<Map<String, Object>> findList(@PathVariable("table") String table,
                                              @RequestBody Map<String, Object> map_body) throws Exception {
        return sqlService.findList(table, map_body);
    }

    /**
     * 获取单条数据
     *
     * @param table
     * @return
     * @throws Exception 异常信息
     */
    @GetMapping("{table}/{id}")
    @ApiOperation(value = "获取单条数据")
    public Map<String, Object> get(@PathVariable("table") String table, @PathVariable("id") String id) throws Exception {
        return sqlService.get(table, id, null);
    }

    /**
     * 单个删除
     *
     * @param table 表名
     * @param id    数据编号
     * @return 返回true false
     * @throws Exception 异常信息
     */
    @DeleteMapping("{table}/{id}")
    @ApiOperation(value = "单个删除")
    public boolean delete(@PathVariable("table") String table, @PathVariable("id") String id) throws Exception {
        return sqlService.deleteLogic(table, id, "");
    }

    /**
     * pl删除
     *
     * @param table 表名
     * @param map_body   参数
     * @return 返回true false
     * @throws Exception 异常信息
     */
    @PostMapping("{table}")
    @ApiOperation(value = "批量删除")
    public boolean deleteBatch(@PathVariable("table") String table, @RequestBody Map<String, Object> map_body) throws Exception {
        // 复制map
        List<String> ids = QueryUtil.getMapList(map_body, "ids");
        return sqlService.deleteLogicBatch(table, "id", ids, QueryUtil.getUid(map_body));
    }

}
