package com.zac.util;


import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Tools
 * @author ZacTang
 *
 */
public final class StringUtil {
	
	/**
	 * <p>Escapes the characters in a <code>String</code> to be suitable to pass to
     * an SQL query.</p>
	 * @author ZacTang 
	 * @param str  the string to escape, may be null
	 * @return a new String, escaped for SQL, <code>null</code> if null string input
	 */
	public static String injection(String str){
		
		 if (str == null) {
	            return null;
	        }
		 return str.replace( "'", "''");
	}
	
	/**
	 * <p>remover trim String(about String.trimm())</p>
	 * @param content
	 * @return
	 */
	public static String trim(String content) {
		return content.replaceAll("[\\s\\p{Zs}]+", "");
	}
	
	/**
	 * get random number
	 * @param count
	 * @return
	 */
	public static String getRandomString(int count) {
		if (count > 0) {
			StringBuilder buf = new StringBuilder();
			SecureRandom rd = new SecureRandom();
			for (int i = 0; i < count; i++) {
				buf.append(rd.nextInt(10));
			}
			return buf.toString();
		} else {
			return "";
		}

	}
	
	/**
	 * Hidden to ** about the tagString  of content 
	 * @param tg tagString(**)
	 * @param content 
	 * @return
	 */
	public static String hidepartChar(String tg,String content) {
		return content.replaceAll(tg, "**");
	}
	
	 /**
     * Returns <tt>true</tt> if, and only if,{@link #length()} is <tt>0</tt> ,or  value is <tt>null<tt>.
     *
     * @return <tt>true</tt> if {@link #length()} is <tt>0</tt> or null, otherwise
     * <tt>false</tt>
     */
	public static boolean isEmpty(String value){
		if(null==value){
			return true;
		}
		return value.length() == 0;
	}
	
	public static String xssEncode(String s) {
	    if (s == null || s.isEmpty()) {
	      return s;
	    }
	    //s.replaceAll(regex, replacement);
	    
	    StringBuilder sb = new StringBuilder(s.length() + 16);
	    for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);
	      switch (c) {
	      case '>':
	        sb.append("＞");// 转义大于号
	        break;
	      case '<':
	        sb.append("＜");// 转义小于号
	        break;
	      case '\'':
	        sb.append("＇");// 转义单引号
	        break;
	      case '\"':
	        sb.append("＂");// 转义双引号
	        break;
	      case '&':
	        sb.append("＆");// 转义&
	        break;
	      default:
	        sb.append(c);
	        break;
	      }
	    }
	    return sb.toString();
	  }
	
	/**
     * Validate E-mail
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
}
