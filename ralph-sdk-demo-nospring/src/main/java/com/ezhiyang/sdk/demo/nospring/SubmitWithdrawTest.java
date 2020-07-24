package com.ezhiyang.sdk.demo.nospring;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.SubmitWithdrawExcutor;
import com.ezhiyang.sdk.core.excutor.impl.SubmitWithdrawExcutor.SubmitWithdrawParam;
import com.ezhiyang.sdk.core.excutor.ret.SubmitWithdrawVo;
/**
 * 提现DEMO
 * @author Theo Zhou
 *
 */
public class SubmitWithdrawTest {

  public static void main(String[] args) {
    SdkContext context = ContextBuilder.buildContext();
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
    
    SubmitWithdrawVo vo = excutor.excute(context);
    System.out.println(vo);
  }
  
}
