package com.zac.security.sha;

import java.security.MessageDigest;
import java.util.UUID;

public class SHAUtil {
	/*** 
     * SHA加密 生成40位SHA码
     * @param 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) { 
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    
	/**	
	 * 		获取 随机四位数
	 * @return
	 */
	public static String randomFour(){
		String randoms= (int) (Math.random()*9000+1000)+"";
		return randoms.trim();
	}
	/**
	 *  根据 token 和  密码   进行加密处理
	 * @param token
	 * @param pwd
	 * @return  返回  加密后的密码插入数据
	 * @throws Exception 
	 */
	public  static String encryptionAndToken(String token,String pwd) throws Exception{
		//   初始密码 +token +base64（token倒叙）
			//1倒叙的 token
		   	String cutbackToken=""; 
		    char[] charArray = token.toCharArray(); 
		    for (int i=charArray.length-1; i>=0; i--){ 
		    	cutbackToken += charArray[i]; 
		    }
		    //2 base64token
		    String token64 = Base64Util.encryptBASE64(cutbackToken.getBytes());
		   // System.out.println("("+token64+")");
		    // 3加密 三个参数 
		    String vlaue = pwd+token+token64;
		    //System.out.println("("+vlaue+")");
		    String resultPwd = shaEncode(vlaue).toUpperCase();
		    return resultPwd;
	}

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
    	String account = "admin";
		String token = "2370";
		String pwd = account+"aaAA1111";
		token="2053";
		pwd="zac111111";
		//token = UUID.randomUUID().toString();
		//String s = Base64Util.encryptBASE64(token.getBytes());
        System.out.println("SHA后：" + encryptionAndToken(token , pwd));
       // System.out.println("SHA后2：" + shaEncode(username + token + pwd+s));
        
    }
}
