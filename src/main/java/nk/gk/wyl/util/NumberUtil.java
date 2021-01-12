package nk.gk.wyl.util;
/**
* @Description:    数字工具类
* @Author:         zhangshuailing
* @CreateDate:     2020/10/6 20:59
* @UpdateUser:     zhangshuailing
* @UpdateDate:     2020/10/6 20:59
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class NumberUtil {
    /**
     * 校验字符串是否是数字.
     * @param str 字符串
     * @return
     */
    public static boolean checkNumber(String str){
        if(str != null && !"".equals(str.trim())){
            return str.matches("^[0-9]*$");
        }
        return false;
    }

    /**
     * 获取字符串转int
     * @param field 字段
     * @param str 字符串
     * @return 返回int
     * @throws Exception 异常信息
     */
    public static int getNumber(String field,String str) throws Exception{
        boolean bl = checkNumber(str);
        if(bl){
            return Integer.parseInt(str);
        }else{
            throw new Exception("参数 "+ field + " 格式错误");
        }
    }
}
