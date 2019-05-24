package com.isoft.commons.codec;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang3.StringUtils;

public class CodecTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AbcDef";
		String base64Str = encodeTest(str);
		decodeTest(base64Str);
		String hexStr = encodeHexTest(str);
		decodeHexTest(hexStr);
		MD5Test(str);
		ShaTest(str);
		testMetaphone();
		uRLCodecTest("联合国");
	}

	// 1、 Base64编解码
	private static String encodeTest(String str) {
		System.out.println(StringUtils.center(" encodeTest ", 40, "=")); // data
		Base64 base64 = new Base64();
		try {
			str = base64.encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Base64 编码后：" + str);
		return str;
	}

	private static void decodeTest(String str) {
		System.out.println(StringUtils.center(" decodeTest ", 40, "=")); // data
		Base64 base64 = new Base64();
		// str = Arrays.toString(Base64.decodeBase64(str));
		str = new String(Base64.decodeBase64(str));
		System.out.println("Base64 解码后：" + str);
	}

	// 2、 Hex编解码
	private static String encodeHexTest(String str) {
		System.out.println(StringUtils.center(" encodeHexTest ", 40, "=")); // data
		try {
			str = Hex.encodeHexString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Hex 编码后：" + str);
		return str;
	}

	private static String decodeHexTest(String str) {
		System.out.println(StringUtils.center(" decodeHexTest ", 40, "=")); // data
		Hex hex = new Hex();
		try {
			str = new String((byte[]) hex.decode(str));
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		System.out.println("Hex 编码后：" + str);
		return str;
	}

	// 3、 MD5加密
	private static String MD5Test(String str) {
		System.out.println(StringUtils.center(" MD5Test ", 40, "=")); // data
		try {
			System.out.println("MD5 编码后：" + new String(DigestUtils.md5Hex(str.getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	// 4、 SHA编码    SHA1
	private static String ShaTest(String str) {
		System.out.println(StringUtils.center(" ShaTest ", 40, "=")); // data
		try {
			//System.out.println("SHA 编码后：" + new String(DigestUtils.shaHex(str.getBytes("UTF-8"))));
			System.out.println("SHA1 编码后：" + new String(DigestUtils.sha1Hex(str.getBytes("UTF-8"))));
			
			
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	// 5、 Metaphone和Soundex
	// Metaphone 建立出相同的key给发音相似的单字, 比 Soundex 还要准确, 但是 Metaphone 没有固定长度, Soundex
	// 则是固定第一个英文字加上3个数字. 这通常是用在类似音比对, 也可以用在 MP3 的软件开发.
	private static void testMetaphone() {
		System.out.println(StringUtils.center(" testMetaphone ", 40, "=")); // data

		Metaphone metaphone = new Metaphone();
		RefinedSoundex refinedSoundex = new RefinedSoundex();
		Soundex soundex = new Soundex();
		for (int i = 0; i < 2; i++) {
			String str = (i == 0) ? "resume" : "resin";
			String mString = null;
			String rString = null;
			String sString = null;
			try {
				mString = metaphone.encode(str);
				rString = refinedSoundex.encode(str);
				sString = soundex.encode(str);
			} catch (Exception ex) {
				;
			}
			System.out.println("Original:" + str);
			System.out.println("Metaphone:" + mString);
			System.out.println("RefinedSoundex:" + rString);
			System.out.println("Soundex:" + sString + "\\n");
		}
	}

	// URLCodec
	private static void uRLCodecTest(String str) {
		System.out.println(StringUtils.center(" uRLCodecTest ", 40, "=")); // data

		URLCodec codec = new URLCodec();
		String s = null;
		try {
			s = codec.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);

		String s1 = null;
		try {
			s1 = codec.decode(s, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s1);

	}

}
