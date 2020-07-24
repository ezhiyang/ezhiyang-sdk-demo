package com.ezhiyang.sdk.demo.nospring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.QueryAccountDetailExcutor;
import com.ezhiyang.sdk.core.excutor.ret.QueryAccountDetailVo;
/**
 * 查询账户明细DEMO
 * @author Theo Zhou
 *
 */
public class QueryAccountDetailTest {

  public static void main(String[] args) {
    SdkContext context = ContextBuilder.buildContext();
    QueryAccountDetailExcutor excutor = new QueryAccountDetailExcutor();
    QueryAccountDetailVo vo =excutor.setCompanyCode("b7adaff5-cf62-461e-8ac8-0cb8daa3d7e0")
           .setTaxAreaId(21L)
           .setQueryStartDate(parseDate("2020-05-01 00:00:01"))
           .setQueryEndDate(parseDate("2020-07-01 00:00:01"))
           .setPageSize(10)
           .setPageNo(1)
           .excute(context);
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
