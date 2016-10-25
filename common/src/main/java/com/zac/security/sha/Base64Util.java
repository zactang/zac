package com.zac.security.sha;

public class Base64Util {
	
 /**    
   * BASE64解密   
   * @param key          
   * @return          
   * @throws Exception          
   */              
  public static byte[] decryptBASE64(String key) throws Exception {    
  	return new Base64().decode(key);
  }               
                
  /**         
   * BASE64加密   
   * @param key          
   * @return          
   * @throws Exception          
   */              
  public static String encryptBASE64(byte[] key) throws Exception {    
  	return new Base64().encode(key);          
  }       

  public static void main(String[] args) throws Exception     
  {     
      String data = Base64Util.encryptBASE64("http://www.zaccn.com/".getBytes());     
      System.out.println("加密后：["+data+"]");     
           
      byte[] byteArray = Base64Util.decryptBASE64(data);     
      System.out.println("解密后："+new String(byteArray));     
  }     

}
