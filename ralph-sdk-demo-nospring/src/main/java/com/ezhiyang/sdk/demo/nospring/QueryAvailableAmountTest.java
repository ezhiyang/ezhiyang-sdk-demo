package com.ezhiyang.sdk.demo.nospring;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.QueryAvailableAmountExcutor;
import com.ezhiyang.sdk.core.excutor.impl.QueryAvailableAmountExcutor.QueryAvailableAmountParam;
import com.ezhiyang.sdk.core.excutor.ret.QueryAvailableAmountVo;
/**
 * 查询可用余额DEMO
 * @author Theo Zhou
 *
 */
public class QueryAvailableAmountTest {

  public static void main(String[] args) {
    SdkContext context = ContextBuilder.buildContext();
    QueryAvailableAmountExcutor excutor = new QueryAvailableAmountExcutor();
    QueryAvailableAmountParam param = new QueryAvailableAmountParam();
    param.setCertNo("888999888888").setName("测试一");
    QueryAvailableAmountVo vo = excutor.addQueryAvailableAmountParam(param)
        .addQueryAvailableAmountParam(param).excute(context);
    System.out.println(vo);
  }
  
}
