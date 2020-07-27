package com.ezhiyang.sdk.demo.nospring;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.QueryBalanceExcutor;
import com.ezhiyang.sdk.core.excutor.ret.QueryBalanceVo;
/**
 * 查询余额DEMO
 * @author Theo Zhou
 *
 */
public class QueryBalanceTest {

  public static void main(String[] args) {
    SdkContext context = ContextBuilder.buildContext();
    QueryBalanceExcutor excutor = new QueryBalanceExcutor();
    QueryBalanceVo vo = excutor.setCompanyCode("b7adaff5-cf62-461e-8ac8-0cb8daa3d7e0")
           .setTaxAreaId(21L).excute(context);
    System.out.println(vo);
  }
  
}
