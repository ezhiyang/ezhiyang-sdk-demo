package com.ezhiyang.sdk.demo.spring;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.PersonAuthExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryAccountDetailExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryAvailableAmountExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryAvailableAmountExcutor.QueryAvailableAmountParam;
import com.ezhiyang.sdk.core.excutor.impl.QueryBalanceExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryWithdrawExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryWithdrawExcutor.QueryWithdrawParam;
import com.ezhiyang.sdk.core.excutor.impl.SubmitWithdrawExcutor;
import com.ezhiyang.sdk.core.excutor.impl.SubmitWithdrawExcutor.SubmitWithdrawParam;
import com.ezhiyang.sdk.core.excutor.ret.PersonAuthVo;
import com.ezhiyang.sdk.core.excutor.ret.QueryAccountDetailVo;
import com.ezhiyang.sdk.core.excutor.ret.QueryAvailableAmountVo;
import com.ezhiyang.sdk.core.excutor.ret.QueryBalanceVo;
import com.ezhiyang.sdk.core.excutor.ret.QueryWithdrawVo;
import com.ezhiyang.sdk.core.excutor.ret.SubmitWithdrawVo;
/**
 * 多主体的sdk测试类
 * @author Theo Zhou
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class MultipleEntityExcutorTest {

  @Autowired
  private Map<String,SdkContext> sdkContextMap;
  /**
   * 1号客户端
   */
  private static final String CLIENT_1 = "hoketest3";
  /**
   * 2号客户端
   */
  private static final String CLIENT_2 = "hoketest1";
  
  /**
   * 根据client id 获取 sdkContext
   * @param clientId
   * @return
   */
  private SdkContext getSdkContext(String clientId) {
    return sdkContextMap.get(clientId);
  }
  
  
  @Test
  public void testPersonAuthExcutor() {
    SdkContext client1 = getSdkContext(CLIENT_1);
    PersonAuthExcutor excutor = new PersonAuthExcutor();
    PersonAuthVo vo = excutor.setName("李明")
           .setCertNo("3101010101010")
           .setMobile("13028977101")
           .setAccountType(1)
           .setAccountNo("622581810909221")
           .excute(client1);
    System.out.println(vo);
    
    SdkContext client2 = getSdkContext(CLIENT_2);
    excutor = new PersonAuthExcutor();
    vo = excutor.setName("李明")
           .setCertNo("3101010101010")
           .setMobile("13028977101")
           .setAccountType(1)
           .setAccountNo("622581810909221")
           .excute(client2);
    System.out.println(vo);
  }
  
  @Test
  public void testSubmitWithdrawExcutor() {
    SdkContext client1 = getSdkContext(CLIENT_1);
    SubmitWithdrawExcutor excutor = new SubmitWithdrawExcutor();
    for(int i=0;i<=2;i++) {
      SubmitWithdrawParam param = new SubmitWithdrawParam();
      param.setBizId("1234444444444"+new Random().nextInt())
           .setName("测试一")
           .setCertNo("888999888888")
           .setMobile("mobile")
           .setAccountType(2)
           .setAccountNo("45671899876543212")
           .setAmount(new BigDecimal(0.01).setScale(2,RoundingMode.HALF_UP));
      excutor.addWithdrawParam(param);
    }
    
    SubmitWithdrawVo vo = excutor.excute(client1);
    System.out.println(vo);
  }
  
  @Test
  public void testQueryWithdrawExcutor() {
    SdkContext client1 = getSdkContext(CLIENT_1);

    QueryWithdrawExcutor excutor = new QueryWithdrawExcutor();
    
    QueryWithdrawParam param1 = new QueryWithdrawParam();
    param1.setBizId("1234444444444-423539257");
    excutor.addQueryWithdrawParam(param1);
    QueryWithdrawParam param2 = new QueryWithdrawParam();
    param2.setBizId("1234444444444-1964257359");
    excutor.addQueryWithdrawParam(param2);

    QueryWithdrawVo vo = excutor.excute(client1);
    System.out.println(vo);
  }
  
  @Test
  public void testQueryBalanceExcutor() {
    SdkContext client1 = getSdkContext(CLIENT_1);

    QueryBalanceExcutor excutor = new QueryBalanceExcutor();
    QueryBalanceVo vo = excutor.setCompanyCode("b7adaff5-cf62-461e-8ac8-0cb8daa3d7e0")
           .setTaxAreaId(21L).excute(client1);
    System.out.println(vo);
  }
  
  @Test
  public void testQueryAccountDetailExcutor() {
    SdkContext client1 = getSdkContext(CLIENT_1);
    QueryAccountDetailExcutor excutor = new QueryAccountDetailExcutor();
    QueryAccountDetailVo vo =excutor.setCompanyCode("b7adaff5-cf62-461e-8ac8-0cb8daa3d7e0")
           .setTaxAreaId(21L)
           .setQueryStartDate(parseDate("2020-05-01 00:00:01"))
           .setQueryEndDate(parseDate("2020-07-01 00:00:01"))
           .setPageSize(10)
           .setPageNo(1)
           .excute(client1);
    System.out.println(vo);
  }
  
  @Test
  public void testQueryAvailableAmountExcutor() {
    SdkContext client1 = getSdkContext(CLIENT_1);
    QueryAvailableAmountExcutor excutor = new QueryAvailableAmountExcutor();
    QueryAvailableAmountParam param = new QueryAvailableAmountParam();
    param.setCertNo("888999888888").setName("测试一");
    QueryAvailableAmountVo vo = excutor.addQueryAvailableAmountParam(param).excute(client1);
    System.out.println(vo);
  }
  
  
  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static Date parseDate(String str) {
    try {
      return sdf.parse(str);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
  
}
