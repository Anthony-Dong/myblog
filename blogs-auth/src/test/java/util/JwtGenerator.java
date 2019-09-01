package util;


import com.blogs.auth.util.JwtUtils;
import com.blogs.auth.util.RsaUtils;

import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtGenerator {

    private static final String pubKeyPath = "D:\\代码库\\个人博客\\keys\\rsa.pub";

    private static final String priKeyPath = "D:\\代码库\\个人博客\\keys\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    /**
     *
     * 生成前  先把  @before的 那个 方法 注释掉  或者注解注释掉
     * @throws Exception
     */
    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "fanhaodong-auth@Login(Auth}*^36)&blogs%");
    }


//
//    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        System.out.println(this.publicKey);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        System.out.println(this.privateKey);
    }

/*    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo("1", "jack","123"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6ImphY2siLCJpcGFkZHJlc3MiOiIxMjMiLCJleHAiOjE1NjY2MjUyNDl9.i_pZQctJYpkKcw92WTASqThLstM6s0o1Nd5wOVf97NuSY8m96Js62tFh_XpfhZ8sV8T12dt2wW_I_iQje0XWBR5kt8cWDKV-6VdtN7ENDBNVB8CwCGX8YLTgu0nYjcfSmtWPOVLEOU0QjnpczPnKuOozT3fIlDKXbErmpYAsFpE";
//        解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
        System.out.println("ip:"+user.getIp());
    }*/
}