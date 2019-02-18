package cn.lwthad.Common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/*
    自定义响应类
 */
public class CommonResult {

    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //状态
    private Integer status;

    //消息
    private String msg;

    //数据
    private Object data;

    /*默认无参构造器*/
    public CommonResult() {
    }

    public CommonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public CommonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /*自定义相应类*/
    public static CommonResult build(Integer status, String msg){
        return new CommonResult(status, msg, null);
    }

    /*方法重载*/
    public static CommonResult build(Integer status, String msg, Object data){
        return new CommonResult(status, msg, data);
    }

    public static CommonResult ok(){
        return new CommonResult(null);
    }

    /*方法重载*/
    public static CommonResult ok(Object data){
        return new CommonResult(data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json数据转成java对象
     * @param jsonData
     * @param clazz
     * @return
     */
    public static CommonResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, CommonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object object = null;
            if(clazz != null){
                if (data.isObject()){
                    object = MAPPER.readValue(data.traverse(), clazz);
                }else  if (data.isTextual()){
                    object = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(),object);
        } catch (Exception e) {
            return null;
        }
    }
}
