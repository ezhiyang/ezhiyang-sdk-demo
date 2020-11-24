package com.ezhiyang.sdk.demo.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezhiyang.sdk.core.decript.DecriptService;
/**
 * 解密回调报文测试
 * @author Theo Zhou
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class DecriptTest {

  @Autowired
  DecriptService decriptService;
  
  @Test
  public void test() {
    decriptService.decript("");
//    DecriptCallbackUtil.decript(body, zyPublicKeyContent, myPrivateKeyContent);
  }
  
  
}
