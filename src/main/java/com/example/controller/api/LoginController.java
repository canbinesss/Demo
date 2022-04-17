package com.example.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.utils.Constant;
import com.example.utils.JwtHelper;
import com.example.utils.ServiceH5Result;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@ApiOperation(value = "3.1.登陆", notes = "登陆")
    @RequestMapping(value = "/loginByMobile", method = RequestMethod.POST)
    @ResponseBody
    public ServiceH5Result loginByMobile(HttpServletRequest request, HttpServletResponse respons,@RequestBody Map<String,String> obj) throws Exception {
		respons.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("3.1.登陆 begin");
		ServiceH5Result sr = new ServiceH5Result();
		String userName = obj.get("userName");
		String password = obj.get("password");
		System.out.println(userName);
		System.out.println(password);
//		Object o = JSON.parse(obj);
//		
//		password = o.get("password");
		
		
		//验证用户名和密码是否为空
		if(userName == null || "".equals(userName)){
			sr.setResult("0");
			sr.setMsg("用户名不能为空！");
			return sr;
		}
		if(password == null || "".equals(password)){
			sr.setResult("0");
			sr.setMsg("密码不能为空！");
			return sr;
		}
		//密码先用md5加密后在判断
//		password = MD5Util.getMD5(password);
		//根据用户名和密码查询是否存在，如果存在，则验证成功，如果不存在，则验证失败
		//验证用户名密码
//		BasUser user = loginService.getUser(userName, password);
//		if(user!=null){
		if(userName.equals("admin") && password.equals("123456")){
			//验证成功，生成token
			JwtHelper jwtHelper = new JwtHelper();
            Map<String, Object> map = new HashMap<String, Object>();
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("user", userName);
            map2.put("password", password);
            map.put("user", map2);
//            Map<String,Object> userInfo = loginService.getUserInfor(user.getUserId());
//            map.put("userInfo", userInfo);
            //这里将用户信息存入token中
            // 用户Id
            //map.put("userId", user.getUserId());
            // 用户名
            //map.put("userName", user.getUserName());
                        
            // -----------------------------------------------
            String token = jwtHelper.createJWT(map, 24 * 60 * 60 * 1000);
            sr.setToken(token);
            sr.setData(map);
            sr.setMsg("成功");
            sr.setResult("1");
            sr.setErrorType(Constant.SUCCESS);
		} else {
			//验证失败
			sr.setResult("0");
			sr.setErrorType(Constant.LOGIN_FAIL);
			sr.setMsg("登录失败！");
		}
		
		return sr;		
	}
	
	
//	@ApiOperation(value = "3.2.修改密码", notes = "修改密码")
//    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
//    @ResponseBody
//    public ServiceH5Result changePasswordMobile(HttpServletRequest request, HttpServletResponse respons,@RequestBody Map<String,String> obj) throws Exception {
//		logger.info("3.2.修改密码 begin");
//		ServiceH5Result sr = new ServiceH5Result();
//		String token = obj.get("token");
//		String userName = obj.get("userName");
//		String password = obj.get("password");
//		if(token == null || "".equals(token)){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_IS_NOT_NULL);
//			sr.setResult("token不能为空！");
//			return sr;
//		}
//		//解析token
//		JwtHelper helper = new JwtHelper();
//		Claims claims = helper.parseJWT(token);
//		if (claims == null){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_PARSE_FAIL);
//			sr.setMsg("token解析失败，请重新登陆获取token!");
//			return sr;
//		}else{
//			//解析成功，进行正常流程
//			Map m = (Map) claims.get("user");
//			String userid = (String) m.get("userId");
//			try {
//
//				password = MD5Util.getMD5(password);
//				Integer num =loginService.updatePwd(userid,password);
//				Map<String,String> map = new HashMap<String,String>();
//				sr.setResult(num+"");
//				sr.setMsg("成功");
//				sr.setErrorType(Constant.SUCCESS);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				sr.setResult("0");
//				sr.setErrorType(Constant.CHANGE_PASSWORD_FAIL);
//				sr.setMsg("修改密码失败!");
//			}finally {
//				sr.setToken(token);
//			}
//		}
//		return sr;
//	}
//
//
//
//	@ApiOperation(value = "3.3.获取个人信息", notes = "获取个人信息")
//    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
//    @ResponseBody
//    public ServiceH5Result getUserInfo(HttpServletRequest request, HttpServletResponse respons,@RequestBody Map<String,String> obj) throws Exception {
//		logger.info("3.3.获取个人信息 begin");
//		ServiceH5Result sr = new ServiceH5Result();
//		String token = obj.get("token");
//		String userName = obj.get("userName");
//		if(token == null || "".equals(token)){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_IS_NOT_NULL);
//			sr.setResult("token不能为空！");
//			return sr;
//		}
//		//解析token
//		JwtHelper helper = new JwtHelper();
//		Claims claims = helper.parseJWT(token);
//		if (claims == null){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_PARSE_FAIL);
//			sr.setMsg("token解析失败，请重新登陆获取token!");
//			return sr;
//		}else{
//			//解析成功，进行正常流程
//			try {
//				Map m = (Map) claims.get("user");
//				String userid = (String) m.get("userId");
//				Map<String,Object> list1 = loginService.getUserInfor(userid);
//				List<Map<String,Object>> list2 = loginService.getBasDictFamilyRelation();
//				Map<String,Object> map = new HashMap();
//				map.put("userInfo", list1);
//				map.put("familyRelation", list2);
//				sr.setData(map);
//				sr.setResult("1");
//				sr.setMsg("成功");
//				sr.setErrorType(Constant.SUCCESS);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				sr.setResult("0");
//				sr.setMsg("获取个人信息失败！");
//				sr.setErrorType(Constant.GET_USER_INFO_FAIL);
//			}finally {
//				sr.setToken(token);
//			}
//
//		}
//		return sr;
//	}
//	@ApiOperation(value = "3.4.修改个人信息", notes = "修改个人信息")
//    @RequestMapping(value = "/changeUserInfo", method = RequestMethod.POST)
//    @ResponseBody
//    public ServiceH5Result changeUserInfo(HttpServletRequest request, HttpServletResponse respons,@RequestBody Map<String,Object> obj) throws Exception {
//		logger.info("3.4.修改个人信息 begin");
//		respons.setHeader("Access-Control-Allow-Origin", "*");
//		ServiceH5Result sr = new ServiceH5Result();
//		String token = obj.get("token").toString();
//		String userName = obj.get("userName").toString();
//		Map<String,String> map = (Map<String, String>) obj.get("temperatureInfo");
//		String familyMobile = map.get("familyMobile");
//		String phone = map.get("phone");
//		String nativePlace = map.get("nativePlace");
//		String currentAddress = map.get("currentAddress");
//		String familyName = map.get("familyName");
//		String familyRelation = map.get("familyRelation");
//
//		if(token == null || "".equals(token)){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_IS_NOT_NULL);
//			sr.setResult("token不能为空！");
//			return sr;
//		}
//		//解析token
//		JwtHelper helper = new JwtHelper();
//		Claims claims = helper.parseJWT(token);
//		if (claims == null){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_PARSE_FAIL);
//			sr.setMsg("token解析失败，请重新登陆获取token!");
//			return sr;
//		}else{
//			//解析成功，进行正常流程
//			try {
//				Map m = (Map) claims.get("user");
//				String employeeId = (String) m.get("relationId");
//				Integer num =loginService.updateUserInfor(phone,nativePlace,currentAddress,familyName,familyRelation,familyMobile,employeeId);
//				if(num != 0) {
//					sr.setResult(num+"");
//					sr.setMsg("成功");
//					sr.setErrorType(Constant.SUCCESS);
//				}else {
//					sr.setResult(num+"");
//					sr.setMsg("修改个人信息失败！");
//					sr.setErrorType(Constant.CHANGE_USER_FAIL);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				sr.setResult("0");
//				sr.setMsg("修改个人信息失败！");
//				sr.setErrorType(Constant.CHANGE_USER_FAIL);
//			}finally {
//				sr.setToken(token);
//			}
//		}
//		return sr;
//	}
//
//
//	@ApiOperation(value = "3.4.退出登陆账号", notes = "退出登陆账号")
//    @RequestMapping(value = "/logoutByMobile", method = RequestMethod.POST)
//    @ResponseBody
//    public ServiceH5Result logoutByMobile(HttpServletRequest request, HttpServletResponse respons,@RequestBody Map<String,Object> obj) throws Exception {
//		logger.info("3.4.退出登陆账号 begin");
//		ServiceH5Result sr = new ServiceH5Result();
//		String token = obj.get("token").toString();
//		if(token == null || "".equals(token)){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_IS_NOT_NULL);
//			sr.setResult("token不能为空！");
//			return sr;
//		}
//		//解析token
//		JwtHelper helper = new JwtHelper();
//		Claims claims = helper.parseJWT(token);
//		if (claims == null){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_PARSE_FAIL);
//			sr.setMsg("token解析失败，请重新登陆获取token!");
//			return sr;
//		}else{
//			//解析成功，进行正常流程
//
//			sr.setResult("1");
//			sr.setErrorType(Constant.SUCCESS);
//			sr.setMsg("退出成功");
//		}
//		return sr;
//	}
//
//
//	@ApiOperation(value = "3.5.首页初始化", notes = "首页初始化")
//	@RequestMapping(value = "/indexByMobile", method = RequestMethod.POST)
//	@ResponseBody
//	public ServiceH5Result indexByMobile(HttpServletRequest request, HttpServletResponse respons,@RequestBody Map<String,String> obj) throws Exception {
//		logger.info("3.5.首页初始化 begin");
//		ServiceH5Result sr = new ServiceH5Result();
//		String token = obj.get("token");
//		String userName = obj.get("userName");
//		if(token == null || "".equals(token)){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_IS_NOT_NULL);
//			sr.setResult("token不能为空！");
//			return sr;
//		}
//		//解析token
//		JwtHelper helper = new JwtHelper();
//		Claims claims = helper.parseJWT(token);
//		if (claims == null){
//			sr.setResult("0");
//			sr.setErrorType(Constant.TOKEN_PARSE_FAIL);
//			sr.setMsg("token解析失败，请重新登陆获取token!");
//			return sr;
//		}else{
//			//解析成功，进行正常流程
//			try {
//
//				Map user = (Map) claims.get("user");
//				String employeeId = (String) user.get("relationId");
//				Map userInfo = (Map) claims.get("userInfo");
//				String name  = (String) userInfo.get("name");
//				String idCard = (String) userInfo.get("IdCard");
//				String phone = (String) userInfo.get("phone");
//				String enterprise = (String) userInfo.get("enterprise");
//				String enterpriseAddress = (String) userInfo.get("enterpriseAddress");
//				String department = (String) userInfo.get("department");
//				Map infectiousList = (Map) claims.get("infectiousList");
//				String infectious_id  = (String) userInfo.get("infectious_id");
//				String infectious_name  = (String) userInfo.get("infectious_name");
//				String pictureUrl = (String) userInfo.get("pictureUrl");
//
//				Map<String,String> map1 = new HashMap<>();
//				map1.put("name", name);
//				map1.put("idCard", idCard);
//				map1.put("phone", phone);
//				map1.put("enterprise", enterprise);
//				map1.put("enterpriseAddress", enterpriseAddress);
//				map1.put("department", department);
//				map1.put("pictureUrl", pictureUrl);
//				Map<String,Object> map2 = new HashMap<>();
//				map2.put("userInfo", map1);
//
//				//TODO 查询今日提报条数
//				Map<String,Object> todayTemperatureNum = temperatureService.getTodayTemperatureNum(employeeId);
//				String num = todayTemperatureNum.get("COUNT(*)").toString();
//				//TODO 查询出当天最后一次填写时间的体温
//				Map<String,Object> lastTemperatureRo = temperatureService.getLastTemperatureByToday(employeeId);
//				Double lastTemperature = null;
//				if(lastTemperatureRo != null) {
//
//					lastTemperature =(Double) lastTemperatureRo.get("temperature");
//					map2.put("yqfkRecord", "今日已经填报"+num+"次 "+lastTemperature+"°");
//					//TODO 查询该体温的范围  （未检测  体温正常  ）
////					String state = temperatureService.getState(lastTemperature);
//					//TODO 判断体温状态
////					if(state!=null) {
//						if(lastTemperature>36.2 &&lastTemperature<37.3) {
//							//TODO 放入到返回前端的字串当中
//							map2.put("temperatureState", "体温正常");
//						}else{
//							//TODO 放入到返回前端的字串当中
//							map2.put("temperatureState", "体温异常");
//						}
////					}else {
////						map2.put("temperatureState", "体温异常");
////					}
//				}else {
//					map2.put("temperatureState", "未检测");
//					map2.put("yqfkRecord", "");
//				}
//				//TODO 查询填报体温最后一天日期
//				Map<String,Object> lastDayTemperature = temperatureService.getLastDayTemperature(employeeId);
//				//TODO 查询体温不正常的最后一天日期
//				Map<String,Object> lastDayTemperatureNo = temperatureService.getLastDayTemperatureNo(employeeId);
//				System.err.println(lastDayTemperature);
//				System.err.println(lastDayTemperatureNo);
//				if(lastDayTemperature!=null && lastDayTemperatureNo!=null) {
//					//TODO 日期进行格式化
//					String gTime = lastDayTemperature.get("fillTime").toString();
//					String nTime = lastDayTemperatureNo.get("fillTime").toString();
//					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//					 Date gDate = sdf.parse(gTime);
//					 Date nDate = sdf.parse(nTime);
//					 if(gDate.compareTo(nDate) < 0) {
//						// "gDate 时间在 nDate 之前
//						//TODO 计算天数
//						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					    long startDateTime = dateFormat.parse(dateFormat.format(nDate)).getTime();
//					    long endDateTime = dateFormat.parse(dateFormat.format(new Date())).getTime();
//					    Integer days= (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
//					    if(days < 1) {
//					    	map2.put("exceptionInfo", "");
//					    }else {
//					    	map2.put("exceptionInfo", "你已连续"+days+"天异常，请注意安全！");
//					    }
//					 }else if(gDate.compareTo(nDate) > 0){
//						// "gDate 时间在 nDate 之后
//						 map2.put("exceptionInfo", "");
//					 }else if(gDate.compareTo(nDate) == 0) {
//						// "gDate 时间在 nDate 相等
//
//						//TODO 获取天最后一个填报信息
//						 Map<String,Object> lastTemperatureByTime = temperatureService.getLastTemperatureByTime(employeeId,nTime);
//						 Double tiwen = (Double) lastTemperatureByTime.get("temperature");
//						//TODO 判断体温是否正常
//						 if(36.2<=tiwen && tiwen<=37.2) {
//							 //TODO 正常
//							map2.put("exceptionInfo", "");
//						 }else {
//							 //TODO 不正常 进行计算到现在还有多少天。
//							 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//						     long startDateTime = dateFormat.parse(dateFormat.format(nDate)).getTime();
//						     long endDateTime = dateFormat.parse(dateFormat.format(new Date())).getTime();
//						     Integer days= (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
//						     if(days < 1) {
//							    	map2.put("exceptionInfo", "");
//							    }else {
//							    	map2.put("exceptionInfo", "你已连续"+days+"天异常，请注意安全！");
//							    }
//						 }
//					 }else if(lastDayTemperature != null && lastDayTemperatureNo == null) {
//						 map2.put("exceptionInfo", "");
//					 }
//				}
//
//
//
//				 Calendar calendar = Calendar.getInstance();
//					calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 7);
//					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//					Map m = (Map) claims.get("user");
//					String statDate= obj.get("statDate");
//					if(statDate=="" || statDate==null){
//						statDate = date.format(new Date());
//					}
//
//					List<Map<String,Object>> list = temperatureService.getDayToSeven(statDate);
//					List<Map<String,Object>> temperatureRecordList = new ArrayList<Map<String,Object>>();
//					for(int i=0 ;i<list.size();i++) {
//						Map mapday = new HashMap();
//						String fillTime = (String) list.get(i).get("fillTime");
//						String day = fillTime.substring(8, 10);
//						String month = fillTime.substring(5, 7);
//						mapday.put("day", month+"/"+day);
//						List<Map<String,Object>> daytemperatureList = temperatureService.getTemperatureByDay(fillTime,employeeId);
//						mapday.put("daytemperatureList", daytemperatureList);
//						temperatureRecordList.add(mapday);
//					}
//
//					List<String> columns =new ArrayList();
//					columns.add("day");
//					List twjlList = new ArrayList();
//					for(int i = 0;i<temperatureRecordList.size();i++) {
//						Map twjlMap = new HashMap<>();
//						Map dayMap = temperatureRecordList.get(i);
//						String dates = (String) dayMap.get("day");
//						twjlMap.put("day", dates);
//						List tList = (List) dayMap.get("daytemperatureList");
//						for(int j = 0;j<tList.size();j++) {
//							Map tMap = (Map) tList.get(j);
//							String hour = (String) tMap.get("hour");
//							if(!columns.contains(hour)) {
//								columns.add(hour);
//							}
//							Double temperature = (Double) tMap.get("temperature");
//							twjlMap.put(hour, temperature);
//						}
//						twjlList.add(twjlMap);
//					}
//
//
//
//					Map map  = new HashMap();
//					map2.put("temperatureRecordList",twjlList);
//					map2.put("columns",columns);
//
////				 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
////				 String statDate = date.format(new Date());
////				 List<Map<String,Object>> list = temperatureService.getDayToSeven(statDate);
////				 List<Map<String,Object>> temperatureRecordList = new ArrayList<Map<String,Object>>();
////					for(int i=0 ;i<list.size();i++) {
////						Map mapday = new HashMap();
////						String fillTime = (String) list.get(i).get("fillTime");
////						String day = fillTime.substring(8, 10);
////						mapday.put("day ", day);
////						List<Map<String,Object>> daytemperatureList = temperatureService.getTemperatureByDay(fillTime,employeeId);
////						mapday.put("daytemperatureList", daytemperatureList);
////						temperatureRecordList.add(mapday);
////					}
////				map2.put("temperatureRecord",temperatureRecordList);
//				sr.setData(map2);
//				sr.setResult("1");
//				sr.setMsg("成功");
//				sr.setErrorType(Constant.SUCCESS);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				sr.setResult("0");
//				sr.setMsg("初始化主页信息失败！");
//				sr.setErrorType(Constant.INIT_INDEX_FAIL);
//			}finally {
//				sr.setToken(token);
//			}
//
//		}
//
//		return sr;
//	}
	
	
}
