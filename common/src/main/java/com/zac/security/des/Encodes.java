package com.zac.security.des;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 封装各种格式的编码解码工具类.
 * @author ZacTang
 * 1.Commons-Codec的 hex/base64 编码
 * 2.自制的base62 编码
 * 3.Commons-Lang的xml/html escape
 * 
 */
public class Encodes {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return Hex.encodeHexString(input);
	}

	/**
	 * Hex解码.
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			//throw Exceptions.unchecked(e);
			return null;
		}
	}

	/**
	 * Base64编码.
	 */
	public static String encodeBase64(byte[] input) {
		return Base64.encodeBase64String(input);
	}

	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
	 */
	public static String encodeUrlSafeBase64(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}

	/**
	 * Base64解码.
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * Base62编码。
	 */
	public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[(input[i] & 0xFF) % BASE62.length];
		}
		return new String(chars);
	}


	/**
	 * URL 编码, Encode默认为UTF-8.
	 */
	public static String urlEncode(String part) {
		try {
			return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * URL 解码, Encode默认为UTF-8.
	 */
	public static String urlDecode(String part) {

		try {
			return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	
	/**
	   * fixed encryption Key
	   * @return long
	   */
	  private static long getKey() {
		  
		  String ke="6WzIgLavQ0LezgmG/98D7IAopsqeedpW";
		 //ke="12345678";
		  byte [] bs=ke.getBytes();
		  long kenum=0;
		  for (int i = 0; i < bs.length; i++) {
			  kenum +=bs[i];
			
		}
		  return kenum;
	  }
	
	/**
	   *	en
	   */
	public static String decode(String s) {
	  String res = "";
	  DES des = new DES(getKey());
	  byte[] sBytes = s.getBytes();
	  for (int i = 0; i < (sBytes.length / 16); i++) {
	    byte[] theBytes = new byte[8];
	    for (int j = 0; j <= 7; j++) {
	      byte byte1 = (byte) (sBytes[16 * i + 2 * j] - 'a');
	      byte byte2 = (byte) (sBytes[16 * i + 2 * j + 1] - 'a');
	      theBytes[j] = (byte) (byte1 * 16 + byte2);
	    }
	    long x = des.bytes2long(theBytes);
	    byte[] result = new byte[8];
	    des.long2bytes(des.decrypt(x), result);
	    res = res + (new String(result));
	  }
	  return res.trim();
	}
	
	/**
	 *	encryption
	 */
	public static String encode(String s) {
	  String res = "";
	  DES des = new DES(getKey());
	  byte space = 0x20;
	  byte[] sBytes = s.getBytes();
	  int length = sBytes.length;
	  int newLength = length + (8 - length % 8) % 8;
	  byte[] newBytes = new byte[newLength];
	  for (int i = 0; i < newLength; i++) {
	    if (i <= length - 1) {
	      newBytes[i] = sBytes[i];
	    }
	    else {
	      newBytes[i] = space;
	    }
	  }
	  for (int i = 0; i < (newLength / 8); i++) {
	    byte[] theBytes = new byte[8];
	    for (int j = 0; j <= 7; j++) {
	      theBytes[j] = newBytes[8 * i + j];
	    }
	    long x = des.bytes2long(theBytes);
	    byte[] result = new byte[8];
	    des.long2bytes(des.encrypt(x), result);
	    byte[] doubleResult = new byte[16];
	    for (int j = 0; j < 8; j++) {
	      doubleResult[2 *
	          j] = (byte) ( ( ( ( (char) result[j]) & 0xF0) >> 4) + 'a');
	      doubleResult[2 * j + 1] = (byte) ( ( ( (char) result[j]) & 0x0F) + 'a');
	    }
	    res = res + new String(doubleResult);
	  }
	  return res;
	}






public static void main(String args[]){
System.out.println(getKey());
//	  System.out.println(decode("ggpbkfjaiidikfkl"));
	  /*System.out.println(encode("1").length());
	  System.out.println(encode("41150219860903001X"));
	  System.out.println(decode("oddmpnabebnogfbaaemefnigolicdhkinmbfhkepljihecfh"));
*/	  
//System.out.println(encode("220284198705077012"));
//System.out.println(encode("410883198703096537"));
//System.out.println(encode("360481198808284818"));
//System.out.println(encode("420111198907154032"));
//System.out.println(decode("4624299FF2461E032645BA6F49080C6C1967C60D"));

System.out.println(decode("nenicgamfmpmbfbjanalhcablnbhpdmmebpbhhopfclhlhnb"));
System.out.println(decode("fpjpbfggpgkolmhhjipnfdiabnachenehlkmlmgjgdjphbmf"));
System.out.println(decode("gapjakilbpcjbeobadmldjblgalhimcnnmcdjnhjhjceljkg"));
System.out.println(decode("kjebkmgomkoidgdfmggamnobllfmnldlopdjpoabijjeffbb"));
System.out.println(decode("alicpjhnpelijjidclfnfilpmoodmbcphefnalfaibbhleao"));
System.out.println(decode("gihniohbnnjneenflgdccocofkcoocginanjebjldapkaajo"));
System.out.println(decode("cgmaidpkpgpjngckdhdfflblahnppoapbenemhedlhhgello"));
System.out.println(decode("depggdofldndaenhbfcdpeflcfmbdapgplpfhjncbfcjlkkk"));
System.out.println(decode("mdifiedfjmeinpbacfcjpocljakcijbpnmcdjnhjhjceljkg"));

}
}
