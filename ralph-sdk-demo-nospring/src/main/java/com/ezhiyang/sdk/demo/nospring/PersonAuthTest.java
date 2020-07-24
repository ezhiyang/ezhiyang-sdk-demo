package com.ezhiyang.sdk.demo.nospring;

import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.excutor.impl.PersonAuthExcutor;
import com.ezhiyang.sdk.core.excutor.ret.PersonAuthVo;
/**
 * 身份认证DEMO
 * @author Theo Zhou
 *
 */
public class PersonAuthTest {

  public static void main(String[] args) {
    SdkContext context = ContextBuilder.buildContext();
    PersonAuthExcutor excutor = new PersonAuthExcutor();
    PersonAuthVo vo = excutor.setName("李明")
           .setCertNo("3101010101010")
           .setMobile("13028977101")
           .setAccountType(1)
           .setAccountNo("622581810909221")
           .excute(context);
    System.out.println(vo);
  }
  
}
