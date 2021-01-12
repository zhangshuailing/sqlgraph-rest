package nk.gk.wyl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtil {

    /**
     * 获取数据类型
     * @param object 对象
     * @return 返回字符串
     */
    public static String getType(Object object){
        String typeName=object.getClass().getName();
        int length= typeName.lastIndexOf(".");
        String type =typeName.substring(length+1);
        return type;
    }

    /**
     * 将 list 按照 field 转成 List<String>
     * @param list 集合
     * @param field 字段
     * @return 返回集合
     */
    public static List<String> getList(List<Map> list, String field){
        List<String> result = new ArrayList<>();
        if(list == null || list.isEmpty()){
            return result;
        }
        for (Map map:list){
            result.add(map.get(field)==null?"":map.get(field).toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String index = "";
        String[] str = new String[12];

        System.out.println(getType(map));
        System.out.println(getType(list));
        System.out.println(getType(index));
        System.out.println(getType(str));
    }
}
