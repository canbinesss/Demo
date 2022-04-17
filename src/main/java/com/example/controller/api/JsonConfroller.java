package com.example.controller.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.JsonAnswer;
import com.example.entity.JsonInfo;
import com.example.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Json")
public class JsonConfroller {

    @RequestMapping("/getData")
    @ResponseBody
    public String test() throws Exception {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL("https://m.examcoo.com/app/editor/getexercisecontent/v/9/leid/203686369/tokenleid/1799836662f56fba9eebf35ca0498ef6");
//            URL url = new URL("https://m.examcoo.com/app/editor/getexercisecontent/v/9/leid/202938294/tokenleid/760255f7001c7b9605ca35685ed58250");
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        JSONObject obj = JSONObject.parseObject(result);
        Map data = (Map) obj.get("data");
        Map map = (Map) data.get("result");
        List list = (List) map.get("b");
        list.remove(0);
        System.out.println(data);
        StringBuilder str = new StringBuilder();
        List<JsonInfo> cardVos = JSONArray.parseArray(list.toString(), JsonInfo.class);
        int i = 0;
        for (JsonInfo cardVo : cardVos) {
            i++;
            str.append(i+"、"+cardVo.getA().replace("<br>","")+"<br>");
            List<JsonAnswer> JsonAnswers = JSONArray.parseArray(cardVo.getB(), JsonAnswer.class);
            for(int j = 0;j<JsonAnswers.size();j++){
                str.append(getOption(j)+"、"+JsonAnswers.get(j).getO()+"<br>");
            }
//            str.append("1、对<br>");
//            str.append("2、错<br>");
            str.append("答案："+getAnswer(cardVo.getC())+"<br>");

        }
        return str.toString();
    }

    String getAnswer(String str){
        switch (str) {
            case "1" :
                //语句
                return "A";
            case "2" :
                //语句
                return "B";
            case "4" :
                //语句
                return "C";
            default : //可选
                //语句
                return "D";
        }

    }

    String getOption(int num){
        switch (num) {
            case 0 :
                //语句
                return "A";
            case 1 :
                //语句
                return "B";
            case 2 :
                //语句
                return "C";
            default : //可选
                //语句
                return "D";
        }
    }
}
