package nk.gk.wyl.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Description: 根据查询条件生成
 * @Author: zhangshuailing
 * @CreateDate: 2020/8/29 0:09
 * @UpdateUser: zhangshuailing
 * @UpdateDate: 2020/8/29 0:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class QueryUtil {
    /**
     * 查询条件中抽取出来 模糊查询 精确查找 排序
     *
     * @param map          查询条件
     * @param search       模糊查询
     * @param exact_search 精确查找
     * @param in_search    in 查询
     * @param order        排序
     */
    public static void searchMap(Map<String, Object> map,
                                 Map<String, String> search,
                                 Map<String, String> exact_search,
                                 Map<String, String> order,
                                 Map<String, List<String>> in_search) throws Exception {
        // 模糊查询
        search = getMap(map, "search");
        // 精确查找
        exact_search = getMap(map, "exact_search");
        // 排序
        order = getMap(map, "order");
        // in 字句
        in_search = getList(map, "in_search");
    }

    /**
     * 转map
     *
     * @param map   参数
     * @param field 参数中的key
     * @return
     * @throws Exception
     */
    public static Map<String, String> getMap(Map<String, Object> map, String field) throws Exception {
        Map<String, String> query = null;
        if (map.containsKey(field)) {
            try {
                query = (Map<String, String>) JSON.toJSON(map.get(field));
            } catch (Exception e) {
                throw new Exception("参数 " + field + " 类型错误");
            }
        }
        return query;
    }

    /**
     * 获取参数中的数组
     *
     * @param map
     * @param field
     * @return
     */
    public static String[] getMapArray(Map<String, Object> map, String field) throws Exception {
        String[] array = null;
        if (!StringUtils.isEmpty(map.get(field))) {
            try {
                array = (String[]) JSON.toJSON(map.get(field));
            } catch (Exception e) {
                throw new Exception(field + " 参数类型错误！");
            }
        }
        return array;
    }

    /**
     * 获取参数中的数组
     *
     * @param map
     * @param field
     * @return
     */
    public static List<String> getMapList(Map<String, Object> map, String field) throws Exception {
        List<String> array = null;
        if (!StringUtils.isEmpty(map.get(field))) {
            try {
                array = (List<String>) JSON.toJSON(map.get(field));
            } catch (Exception e) {
                throw new Exception(field + " 参数类型错误！");
            }
        }
        return array;
    }

    /**
     * 转map
     *
     * @param map   参数
     * @param field 参数中的key
     * @return
     * @throws Exception
     */
    public static Map<String, List<String>> getList(Map<String, Object> map, String field) throws Exception {
        Map<String, List<String>> query = null;
        if (map.containsKey(field)) {
            try {
                query = (Map<String, List<String>>) JSON.toJSON(map.get(field));
            } catch (Exception e) {
                throw new Exception("参数 " + field + " 类型错误");
            }
        }
        return query;
    }

    /**
     * 校验map 参数
     *
     * @param map
     * @param name
     * @return
     * @throws Exception
     */
    public static Map<String, Object> checkMap(Map<String, Object> map, String name) throws Exception {
        if (StringUtils.isEmpty(map.get(name))) {
            throw new Exception("缺少 " + name + " 参数");
        }
        Map<String, Object> result = (Map<String, Object>) JSON.toJSON(map.get(name));
        return result;
    }

    /**
     * 获取参数值
     *
     * @param map
     * @param name
     * @return
     * @throws Exception
     */
    public static String getValue(Map<String, Object> map, String name) {
        if (StringUtils.isEmpty(map.get(name))) {
            return "";
        }
        return map.get(name).toString();
    }

    /**
     * 获取用户的uid
     *
     * @param map
     * @return
     */
    public static String getUid(Map<String, Object> map) {
        return getValue(map, "uid");
    }
}
