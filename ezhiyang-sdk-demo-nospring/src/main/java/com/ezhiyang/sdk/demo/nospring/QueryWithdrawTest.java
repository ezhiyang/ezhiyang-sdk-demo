package com.ezhiyang.sdk.demo.nospring;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.QueryWithdrawExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryWithdrawExcutor.QueryWithdrawParam;
import com.ezhiyang.sdk.core.excutor.ret.QueryWithdrawVo;
/**
 * 查询提现DEMO
 * @author Theo Zhou
 *
 */
public class QueryWithdrawTest {

  public static void main(String[] args) {
    SdkContext context = ContextBuilder.buildContext();
    QueryWithdrawExcutor excutor = new QueryWithdrawExcutor();
    
    QueryWithdrawParam param1 = new QueryWithdrawParam();
    param1.setBizId("1234444444444-423539257");
    excutor.addQueryWithdrawParam(param1);
    QueryWithdrawParam param2 = new QueryWithdrawParam();
    param2.setBizId("1234444444444-1964257359");
    excutor.addQueryWithdrawParam(param2);

    QueryWithdrawVo vo = excutor.excute(context);
    System.out.println(vo);
  }
  
}
