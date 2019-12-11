package spring.utils;


import spring.dto.BaseCommonResult;

import java.util.HashMap;
import java.util.Map;

/**
 * BaseCommonResult生成器
 */
public class ResultBuilder {

    private ResultBuilder(){

    }


    /**
     * 返回成功
     * @return
     */
    public static BaseCommonResult success(){
        BaseCommonResult result = new BaseCommonResult();
        result.setCode(BaseApiCode.SUCCESS);
        result.setMsg(BaseApiCode.getZhMsg(BaseApiCode.SUCCESS));
        return result;
    }

    /**
     * 返回成功
     * @return
     */
    public static <T>BaseCommonResult success(String msg){
        BaseCommonResult result = new BaseCommonResult();
        result.setCode(BaseApiCode.SUCCESS);
        result.setMsg(msg);
        return result;
    }


    /**
     * 返回成功
     * @return
     */
    public static <T> BaseCommonResult<T> success(T data){
        BaseCommonResult<T> result = new BaseCommonResult();
        result.setCode(BaseApiCode.SUCCESS);
        result.setMsg(BaseApiCode.getZhMsg(BaseApiCode.SUCCESS));
        result.setData(data);
        return result;
    }

    /**
     * 返回成功
     * @return
     */
    public static  BaseCommonResult<Map<String,Object>> success(String key,Object value){
        BaseCommonResult<Map<String,Object>> result = new BaseCommonResult();
        result.setCode(BaseApiCode.SUCCESS);
        result.setMsg(BaseApiCode.getZhMsg(BaseApiCode.SUCCESS));
        Map<String,Object> resMap = new HashMap();
        resMap.put(key,value);
        result.setData(resMap);
        return result;
    }

    /**
     * 返回成功
     * @return
     */
    public static <T> BaseCommonResult<T> success(T data, String msg){
        BaseCommonResult<T> result = new BaseCommonResult();
        result.setCode(BaseApiCode.SUCCESS);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    /**
     * 返回失败
     * @return
     */
    public static BaseCommonResult fail(){
        BaseCommonResult result = new BaseCommonResult();
        result.setCode(BaseApiCode.FAIL);
        result.setMsg(BaseApiCode.getZhMsg(BaseApiCode.FAIL));
        return result;
    }

    /**
     * 返回失败
     * @return
     */
    public static BaseCommonResult fail(String msg){
        BaseCommonResult result = new BaseCommonResult();
        result.setCode(BaseApiCode.FAIL);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回失败
     * @return
     */
    public static BaseCommonResult fail(Integer code, String msg){
        BaseCommonResult result = new BaseCommonResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回失败
     * @return
     */
    public static <T> BaseCommonResult<T> fail(Integer code, String msg, T data){
        BaseCommonResult<T> result = new BaseCommonResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
