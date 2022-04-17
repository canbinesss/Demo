package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.config.Result;
import com.example.dto.ChgDetailForUser;
import com.example.dto.Order;
import com.example.entity.*;
import com.example.service.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/ind")
public class IndController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private CoachService coachService;
    @Resource
    private CourseService courseService;
    @Resource
    private RecruitmentinfoService recruitmentinfoService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private ChgInvoiceService chgInvoiceService;
    @Resource
    private ChgDetailService chgDetailService;
    @Resource
    private SignInService signInService;
    @Resource
    private AccountService accountService;
    @Resource
    private AnnService annService;
    @Resource
    private AdService adService;
    @Resource
    private FofcsService fofcsService;
    @Resource
    private OrderService orderService;
    @Resource
    private RecordService recordService;
    @Resource
    private LMService lmService;

    @GetMapping("/getAdList")
    public Result<List<Ad>> getAdList() {
        List<Ad> list = adService.list();
        return Result.success(list);
    }

    @GetMapping("/getAnnList")
    public Result<List<Ann>> getAnnList() {
        List<Ann> list = annService.getlist();
        return Result.success(list);
    }

    @GetMapping("/getfofcsList")
    public Result<List<Fofcs>> getfofcsList() {
        List<Fofcs> list = fofcsService.getlist();
        return Result.success(list);
    }

    @GetMapping("/fourOfGoods")
    public Result<List<Goods>> fourOfGoods() {
        List<Goods> list = goodsService.getlist();
        return Result.success(list);
    }

    @GetMapping("/fourOfCoach")
    public Result<List<HashMap>> fourOfCoach() {
        List<HashMap> list = coachService.getlist();
        return Result.success(list);
    }

    @GetMapping("/fourOfCourse")
    public Result<List<Course>> fourOfCourse() {
        List<Course> list = courseService.getlist();
        return Result.success(list);
    }

    @GetMapping("/fourOfRecruitmentinfo")
    public Result<List<Recruitmentinfo>> fourOfRecruitmentinfo() {
        List<Recruitmentinfo> list = recruitmentinfoService.getlist();
        return Result.success(list);
    }
    /**
     * 获取课程信息
     * @author liuyang
     * @date 2021/5/5 14:47
     * @param id 
     * @return com.example.config.Result<com.example.entity.Course>
     */
    @GetMapping("/getvideo")
    public Result<Course> getvideo(@RequestParam(required = false, defaultValue = "") String id) {
        Course byId = courseService.getById(id);
        return Result.success(byId);
    }
    @GetMapping("/getAllGoods")
    public Result<List<Goods>> getAllGoods() {
        return Result.success(goodsService.getAlllist());
    }
    @GetMapping("/getAllCourse")
    public Result<List<Course>> getAllCourse() {
        return Result.success(courseService.getAlllist());
    }
    @GetMapping("/getAllCourseforuser")
    public Result<List<Course>> getAllCourseforuser(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        Long id = account.getId();

        List<Map<String,Object>> list = courseService.getCollectionbyUserId(id);
        List<Course> newlist = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : list) {
            Integer courseid = (Integer) stringObjectMap.get("courseid");
            Course byId = courseService.getById(courseid);
            newlist.add(byId);
        }
        return Result.success(newlist);
    }
    @GetMapping("/getAllCoach")
    public Result<List<HashMap>> getAllCoach() {
        return Result.success(coachService.getAlllist());
    }
    /**
     * 会员签到
     * @author liuyang
     * @date 2021/5/6 21:43
     * @param request
     * @return com.example.config.Result<java.lang.String>
     */
    @GetMapping("/vipSignin")
    public Result<String> vipSignin(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        SignIn signIn = new SignIn();
        Integer id = Integer.parseInt(account.getId().toString());
        signIn.setUserid(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(new Date());
        signIn.setIntime(time);
        signIn.setType("会员签到");
        signIn.setUsername(account.getUsername());

        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        String time2 = sdfs.format(new Date());

        if(signInService.getOne(Wrappers.<SignIn>lambdaQuery().eq(SignIn::getUserid,account.getId()).like(SignIn::getIntime, time2)) == null){
            signInService.save(signIn);
            return Result.success("签到成功！");
        }else{
            return Result.success("今日已签到，请勿重复签到！");
        }
    }
    /**
     * 获得用户的购买信息
     * @author liuyang
     * @date 2021/5/6 22:17
     * @param request
     * @return com.example.config.Result<java.lang.String>
     */
    @GetMapping("/chgdetails")
    public Result<List<ChgDetailForUser>> chgdetails(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        ArrayList<ChgDetailForUser> chgDetailForUsers = new ArrayList<>();
        Long id = account.getId();
        List<ChgInvoice> chgInvoices = chgInvoiceService.getByUserId(id);
        for (ChgInvoice chgInvoice : chgInvoices) {
            String invoiceCode = chgInvoice.getInvoiceCode();
            List<ChgDetail> chgDetails = chgDetailService.getByInvoiceCode(invoiceCode);
            for (ChgDetail chgDetail : chgDetails) {
                ChgDetailForUser chgDetailForUser = new ChgDetailForUser();
                chgDetailForUser.setInvCode(chgInvoice.getInvoiceCode());
                chgDetailForUser.setDate(chgInvoice.getChgdate());
                chgDetailForUser.setGoodsname(chgDetail.getGoodsname());
                chgDetailForUser.setNum(chgDetail.getNum());
                chgDetailForUser.setMoney(chgDetail.getAmt());
                String url = goodsService.getUrlByName(chgDetail.getGoodsname());
                chgDetailForUser.setImgurl(url);
                chgDetailForUsers.add(chgDetailForUser);
            }
        }
        return Result.success(chgDetailForUsers);
    }
    @GetMapping("/getAllCoachforuser")
    public Result<List<HashMap<String,Object>>> getAllCoachforuser(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        Long id = account.getId();
        List<Map<String,Object>> list =  coachService.getFollowbyUserId(id);
        List<HashMap<String,Object>> newlist = new ArrayList<HashMap<String,Object>>();
        for (Map<String, Object> stringObjectMap : list) {
            Integer coachid = (Integer) stringObjectMap.get("coachid");
            HashMap<String,Object> byId = coachService.getCoachbyId(coachid.toString());
            newlist.add(byId);
        }
        return Result.success(newlist);
    }
    /**
     *获取教练信息
     * @author liuyang
     * @date 2021/5/5 14:47
     * @param id
     * @return com.example.config.Result<java.util.HashMap<java.lang.String,java.lang.Object>>
     */
    @GetMapping("/getvideocoach")
    public Result<HashMap<String,Object>> getvideocoach(@RequestParam(required = false, defaultValue = "") String id) {
        Course byId = courseService.getById(id);
        String coachname = byId.getCoach();
        HashMap<String,Object> coach = coachService.getvideocoach(coachname);
        return Result.success(coach);
    }
    /**
     *获取教练信息
     * @author liuyang
     * @date 2021/5/5 14:47
     * @param id
     * @return com.example.config.Result<java.util.HashMap<java.lang.String,java.lang.Object>>
     */
    @GetMapping("/getCoach")
    public Result<HashMap<String,Object>> getCoachbyId(@RequestParam(required = false, defaultValue = "") String id) {
        HashMap<String,Object> coach = coachService.getCoachbyId(id);
        return Result.success(coach);
    }
    /**
     * 通过教练id获取视频信息
     * @author liuyang
     * @date 2021/5/5 14:47
     * @param id
     * @return com.example.config.Result<java.util.HashMap<java.lang.String,java.lang.Object>>
     */
    @GetMapping("/getCourseByCoachId")
    public Result<List<Course>> getCourseByCoachId(@RequestParam(required = false, defaultValue = "") String id) {
        HashMap<String,Object> coach = coachService.getCoachbyId(id);
        String coachname = (String) coach.get("coachname");
        List<Course> list = courseService.getlistByCoachName(coachname);
        return Result.success(list);
    }
    /**
     * 添加购物车
     * @author liuyang
     * @date 2021/5/5 14:47
     * @param request
     * @param id
     */
    @GetMapping("/addcart")
    public void addcart(HttpServletRequest request, @RequestParam(required = false, defaultValue = "") String id) {
        Goods goods = goodsService.getById(id);
        String url = goods.getUrl();
        BigDecimal price = new BigDecimal(0);
        Account account = (Account)request.getSession().getAttribute("account");
        if(account.getVipfilg()){
            Double dou = Double.parseDouble(goods.getDiscount());
            price = new BigDecimal(dou);
        }else{
            price = goods.getPrice();
        }
        String goodsname = goods.getGoodsname();
        Integer num = 1;
        BigDecimal xj = price;

        String username = account.getUsername();
        Long id1 = account.getId();
        String user = id1+username;

        Order order = new Order();
        order.setGoodsname(goodsname);
        order.setNum(num);
        order.setPrice(price);
        order.setUrl(url);
        order.setXj(xj);
        List<Order> list = new ArrayList<>();
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        Object o = redisTemplate.opsForValue().get(user);
        if (redisTemplate.opsForValue().get(user) != null) {
            list = (List<Order>) o;
            boolean have = false;
            Integer newnum = 0 ;
            for (Order order1 : list) {
                if (order1.getGoodsname().equals(order.getGoodsname())) {
                    have = true;
                    newnum = order1.getNum() + 1;
                    order1.setNum(newnum);
                }
            }
            if(have){
                redisTemplate.opsForValue().set(user, list);
            }else{
                list.add(order);
                redisTemplate.opsForValue().set(user, list);
            }
        }else{
            list.add(order);
            redisTemplate.opsForValue().set(user, list);
        }
    }

    /**
     * 查看购物车
     * @param request
     * @return
     */
    @GetMapping("/getCart")
    public Result<List<Order>> getCart(HttpServletRequest request) {
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        Account account = (Account)request.getSession().getAttribute("account");
        String username = account.getUsername();
        Long id1 = account.getId();
        String user = id1+username;
        Object o = redisTemplate.opsForValue().get(user);
        List<Order> list = (List<Order>) o;
        for (Order order : list) {
            order.setChecked("0");
        }
        return Result.success(list);
    }

    /**
     * 移出购物车
     * @param request
     * @return
     */
    @GetMapping("/removeOrder")
    public void removeOrder(HttpServletRequest request, @RequestParam(required = false, defaultValue = "") String goodsname) {
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        Account account = (Account)request.getSession().getAttribute("account");
        String username = account.getUsername();
        Long id1 = account.getId();
        String user = id1+username;
        Object o = redisTemplate.opsForValue().get(user);
        List<Order> list = (List<Order>) o;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGoodsname().equals(goodsname)) {
                list.remove(i);
            }
        }
        redisTemplate.opsForValue().set(user, list);
    }
    /**
     * 改变购物车
     * @param request
     * @return
     */
    @PostMapping("/changeOrder")
    public void changeOrder(HttpServletRequest request, @RequestBody List<Order> list) {
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        Account account = (Account)request.getSession().getAttribute("account");
        String username = account.getUsername();
        Long id1 = account.getId();
        String user = id1+username;
        redisTemplate.opsForValue().set(user, list);
    }

    /**
     * 结算信息
     * @author liuyang
     * @date 2021/5/5 15:57
     * @param request
     */
    @ResponseBody
    @GetMapping("/settlement")
    public String settlement(HttpServletRequest request) {
        String totalcost = request.getParameter("totalcost");
        String address1 = request.getParameter("address1");
        Object address2 = request.getParameter("address2");
        String address = address1 + "," + address2;
        //生成发票号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String invCode = sdf.format(new Date());
        //获得用户信息
        Account account = (Account) request.getSession().getAttribute("account");
        String username = account.getUsername();
        Integer userid = Integer.parseInt(account.getId().toString());

        ChgInvoice chgInvoice = new ChgInvoice();
        chgInvoice.setUserid(userid);
        chgInvoice.setUsername(username);
        chgInvoice.setChgdate(new Date());
        chgInvoice.setChgtype("微信");
        if(account.getVipfilg()){
            chgInvoice.setDiscount("会员价");
        }else{
            chgInvoice.setDiscount("正常价");
        }
        chgInvoice.setInvoiceCode(invCode);
        chgInvoice.setTotalcost(new BigDecimal(Double.parseDouble(totalcost)));
        chgInvoice.setAddress(address);

        chgInvoiceService.save(chgInvoice);

        return invCode;
    }

    /**
     * 保存明细并清除对应缓存
     * @author liuyang
     * @date 2021/5/5 17:05
     * @param request
     * @param list
     * @return com.example.config.Result<java.lang.String>
     */
    @PostMapping("/savedetail")
    public Result<String> savedetail(HttpServletRequest request,@RequestBody  List<Order> list) {
        //TODO 添加明细表
        String invCode = request.getParameter("invCode");
        ChgInvoice chgInvoice = chgInvoiceService.getOne(Wrappers.<ChgInvoice>lambdaQuery().eq(ChgInvoice::getInvoiceCode,invCode));
        for (Order order : list) {
            ChgDetail chgDetail = new ChgDetail();
            chgDetail.setGoodsname(order.getGoodsname());
            chgDetail.setAmt(order.getXj());
            chgDetail.setPrice(order.getPrice());
            chgDetail.setNum(order.getNum().toString());
            chgDetail.setInvoiceCode(invCode);
            chgDetail.setUnit("件");
            chgDetailService.save(chgDetail);
            com.example.entity.Order saveOrder = new com.example.entity.Order();
            saveOrder.setInvcode(invCode);
            saveOrder.setGoodsname(order.getGoodsname());
            saveOrder.setGoodsnum(order.getNum());
            saveOrder.setGoodsacc(chgInvoice.getAddress());
            saveOrder.setState("待发货");
            saveOrder.setOrderdate(new Date());
            orderService.save(saveOrder);
        }
        //TODO 清除对应的redis缓存
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        Account account = (Account)request.getSession().getAttribute("account");
        String username = account.getUsername();
        Long id1 = account.getId();
        String user = id1+username;
        Object o = redisTemplate.opsForValue().get(user);
        List<Order> listr = (List<Order>) o;
        List<Order> newlist = new ArrayList<>();
        List<String> arr1 = new ArrayList<>();
        for (Order order : list) {
             arr1.add(order.getGoodsname());
        }
        List<String> arr2 = new ArrayList<>();
        for (Order order : listr) {
             arr2.add(order.getGoodsname());
        }
        for (int i = 0; i < arr2.size(); i++) {
            if (!arr1.contains(arr2.get(i))) {
                newlist.add(listr.get(i));
            }
        }
        redisTemplate.opsForValue().set(user, newlist);
        return Result.success("感谢购买！");
    }


    /**
     * 收藏
     * @author liuyang
     * @date 2021/5/5 14:45
     * @param request
     * @param course
     * @return com.example.config.Result<java.lang.String>
     */
    @PostMapping("/collection")
    public Result<String> collection(HttpServletRequest request,@RequestBody Course course) {

        Map<String,Object> map = new HashMap<>();
        map.put("courseid",course.getId());
        Account account = (Account)request.getSession().getAttribute("account");
        map.put("userid",account.getId());
        map.put("collectiondate",new Date());

        Integer num = courseService.getCollection(map);
        String msg="";
        if(num==0){
            courseService.saveCollection(map);
            msg="收藏成功!";
        }else{
            courseService.removeCollection(map);
            msg="取消收藏成功";
        }
        return Result.success(msg);
    }
    /**
     * 关注
     * @author liuyang
     * @date 2021/5/5 14:46
     * @param request
     * @param coach
     * @return com.example.config.Result<java.lang.String>
     */
    @PostMapping("/follow")
    public Result<String> follow(HttpServletRequest request,@RequestBody Coach coach) {
        Map<String,Object> map = new HashMap<>();
        map.put("coachid",coach.getId());
        Account account = (Account)request.getSession().getAttribute("account");
        map.put("userid",account.getId());
        map.put("tocusdate",new Date());
        Integer num = coachService.getFollow(map);
        String msg="";
        if(num==0){
            coachService.saveFollow(map);
            msg="关注成功!";
        }else{
            coachService.removeFollow(map);
            msg="取消关注成功";
        }
        return Result.success(msg);
    }

    /**
     * 验证旧密码是否正确
     * @author liuyang
     * @date 2021/5/16 21:24
     * @param request
     * @param oldpass
     * @return com.example.config.Result<java.lang.String>
     */
    @GetMapping("/sureOldPass")
    public Result<Boolean> sureOldPass(HttpServletRequest request, @RequestParam(required = false, defaultValue = "") String oldpass) {
        boolean isok = false;
        Account account = (Account) request.getSession().getAttribute("account");
        if(oldpass.equals(account.getPassworld())){
            isok = true;
        }
        return Result.success(isok);
    }

    /**
     * 修改密码
     * @author liuyang
     * @date 2021/5/17 12:22
     * @param request
     * @param password
     * @return com.example.config.Result<java.lang.Boolean>
     */
    @GetMapping("/changePass")
    public Result<Boolean> changePass(HttpServletRequest request, @RequestParam(required = false, defaultValue = "") String password) {
        Account account = (Account) request.getSession().getAttribute("account");
        account.setPassworld(password);
        accountService.updateById(account);
        return Result.success(true);
    }

    @GetMapping("/getyear")
    public Result<List<HashMap>> getyear(HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("account");
        List<HashMap> yearinfo = new ArrayList<HashMap>();
        yearinfo = recordService.getyearinfo(account.getUsername());
        return new Result<>(yearinfo);
    }
    @GetMapping("/getday")
    public Result<HashMap<String,Object>> getday(HttpServletRequest request){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Account account = (Account) request.getSession().getAttribute("account");
        ArrayList<String> dates = pastDay(sdf.format(new Date()));
        ArrayList<String> times = new ArrayList<String>();
        HashMap<String,Object> map = new HashMap<>();
        map.put("username",account.getUsername());
        for (String date : dates) {
            map.put("date",date);
            Integer time = recordService.gettime(map);
            if(time != null){
                times.add(time.toString());
            }else{
                times.add("0");
            }
        }

        HashMap<String,Object> stringListHashMap = new HashMap<String,Object>();
        stringListHashMap.put("dates",dates);
        stringListHashMap.put("times",times);
        return new Result<HashMap<String,Object>>(stringListHashMap);
    }

    public static ArrayList<String> pastDay(String time) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        try {
            //我这里传来的时间是个string类型的，所以要先转为date类型的。
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(time);
            for (int i = 6; i >= 0; i--) {
                pastDaysList.add(getPastDate(i, date));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pastDaysList;
    }

    public static String getPastDate(int past,Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
        Date today = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(today);
        return result;
    }

    /**
     * 保存留言
     * @author liuyang
     * @date 2021/5/20 17:39
     * @param request
     * @param lm
     * @param coachid
     * @param coachname
     * @return com.example.config.Result<java.lang.Boolean>
     */
    @GetMapping("/savelm")
    public Result<Boolean> savelm(HttpServletRequest request,@RequestParam(required = false, defaultValue = "") String lm,@RequestParam(required = false, defaultValue = "") String coachid,@RequestParam(required = false, defaultValue = "") String coachname) throws ParseException {
        boolean isok = true;
        Account account = (Account) request.getSession().getAttribute("account");
        LM lm1 = new LM();
        lm1.setUserid(Integer.parseInt(account.getId().toString()));
        lm1.setUsername(account.getUsername());
        lm1.setCoachid(Integer.parseInt(coachid));
        lm1.setCoachname(coachname);
        lm1.setLmcontent(lm);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        Date parse = sdf.parse(format);
        lm1.setLmdate(parse);
        lmService.save(lm1);
        return new Result<>(isok);
    }

    @GetMapping("/loadlm")
    public Result<List<LM>> loadlm(HttpServletRequest request,@RequestParam(required = false, defaultValue = "") String id) throws ParseException {
        List<LM> lms = new ArrayList<>();
        lms = lmService.list(Wrappers.<LM>lambdaQuery().eq(LM::getCoachid,id));
        return new Result<>(lms);
    }

    @GetMapping("/loadlmforUser")
    public Result<List<LM>> loadlmforUser(HttpServletRequest request) throws ParseException {
        Account accoutn = (Account) request.getSession().getAttribute("account");
        List<LM> lms = new ArrayList<>();
        lms = lmService.list(Wrappers.<LM>lambdaQuery().eq(LM::getUserid,accoutn.getId()));
        return new Result<>(lms);
    }
}