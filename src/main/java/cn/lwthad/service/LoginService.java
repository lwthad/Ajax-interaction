package cn.lwthad.service;

import cn.lwthad.Common.CommonResult;
import cn.lwthad.mapper.UserMapper;
import cn.lwthad.pojo.User;
import cn.lwthad.pojo.UserExample;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  返回自定义消息类
     * @param username
     * @param password
     * @return
     */
    public CommonResult login(String username, String password){
        //构造 userExample 查询条件
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<User> users = userMapper.selectByExample(userExample);
        System.out.println("查询用户 = {");
        for (User u : users){
            System.out.println("    "+ u );
        }
        System.out.println("}");
        if(!users.isEmpty()){
            return CommonResult.ok(users);
        }
        return CommonResult.build(500,"校验失败");
    }

    /**
     *  验证登陆逻辑
     *      手动构建json数据返回
     * @param username
     * @param password
     * @return
     */
    public String login1(String username,String password){

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();

        if("tom".equals(username) && "123123".equals(password)){
            jsonObject.put("name",username);
            jsonObject.put("pwd",password);
            jsonObject2.put("status","200");
            jsonObject2.put("user",jsonObject);

            return jsonObject2.toString();
        }else{
            jsonObject2.put("status","500");
            jsonObject2.put("user",null);
            return jsonObject2.toString();
        }
    }
}
