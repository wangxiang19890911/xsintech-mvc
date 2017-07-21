package com.xsintech.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Encoder;

public class PasswordUtil {

	public static final String SECRETS = "0808fujiwara1129";

	private static final Set<String> LOWER_CASE_ALPHABETIC_CHARACTERS = new HashSet<String>();

	private static final Set<String> UPPER_CASE_ALPHABETIC_CHARACTERS = new HashSet<String>();

	private static final Set<String> NUMERIC_CHARACTERS = new HashSet<String>();

	private static final Set<String> PUNCTUATION_CHARACTERES = new HashSet<String>();

	static {
		// アルファベット（小文字）
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("a");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("b");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("c");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("d");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("e");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("f");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("g");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("h");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("i");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("j");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("k");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("l");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("m");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("n");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("o");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("p");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("q");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("r");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("s");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("t");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("u");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("v");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("w");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("x");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("y");
		LOWER_CASE_ALPHABETIC_CHARACTERS.add("z");

		// アルファベット（大文字）
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("A");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("B");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("C");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("D");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("E");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("F");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("G");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("H");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("I");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("J");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("K");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("L");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("M");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("N");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("O");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("P");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("Q");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("R");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("S");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("T");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("U");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("V");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("W");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("X");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("Y");
		UPPER_CASE_ALPHABETIC_CHARACTERS.add("Z");

		// 数字
		NUMERIC_CHARACTERS.add("0");
		NUMERIC_CHARACTERS.add("1");
		NUMERIC_CHARACTERS.add("2");
		NUMERIC_CHARACTERS.add("3");
		NUMERIC_CHARACTERS.add("4");
		NUMERIC_CHARACTERS.add("5");
		NUMERIC_CHARACTERS.add("6");
		NUMERIC_CHARACTERS.add("7");
		NUMERIC_CHARACTERS.add("8");
		NUMERIC_CHARACTERS.add("9");

		// 記号
		PUNCTUATION_CHARACTERES.add("`");
		PUNCTUATION_CHARACTERES.add("~");
		PUNCTUATION_CHARACTERES.add("!");
		PUNCTUATION_CHARACTERES.add("@");
		PUNCTUATION_CHARACTERES.add("#");
		PUNCTUATION_CHARACTERES.add("$");
		PUNCTUATION_CHARACTERES.add("%");
		PUNCTUATION_CHARACTERES.add("^");
		PUNCTUATION_CHARACTERES.add("&");
		PUNCTUATION_CHARACTERES.add("*");
		PUNCTUATION_CHARACTERES.add("(");
		PUNCTUATION_CHARACTERES.add(")");
		PUNCTUATION_CHARACTERES.add("_");
		PUNCTUATION_CHARACTERES.add("+");
		PUNCTUATION_CHARACTERES.add("-");
		PUNCTUATION_CHARACTERES.add("=");
		PUNCTUATION_CHARACTERES.add("{");
		PUNCTUATION_CHARACTERES.add("}");
		PUNCTUATION_CHARACTERES.add("|");
		PUNCTUATION_CHARACTERES.add("\\");
		PUNCTUATION_CHARACTERES.add(":");
		PUNCTUATION_CHARACTERES.add("\"");
		PUNCTUATION_CHARACTERES.add(";");
		PUNCTUATION_CHARACTERES.add("'");
		PUNCTUATION_CHARACTERES.add("<");
		PUNCTUATION_CHARACTERES.add(">");
		PUNCTUATION_CHARACTERES.add("?");
		PUNCTUATION_CHARACTERES.add(",");
		PUNCTUATION_CHARACTERES.add(".");
		PUNCTUATION_CHARACTERES.add("/");
	}

	private static ThreadLocal<MessageDigest> MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() {

		@Override
		protected MessageDigest initialValue() {
			try {
				return MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				throw new ExceptionInInitializerError(e);
			}
		}

	};

	private static ThreadLocal<BASE64Encoder> BASE64_ENCODER = new ThreadLocal<BASE64Encoder>() {

		@Override
		protected BASE64Encoder initialValue() {
			return new BASE64Encoder();
		}

	};

	public static String sha256hash(byte[] salt, String rawPassword, Integer numberOfDigest) {
		String hash = PasswordUtil.sha256hash(salt);
		hash = (rawPassword + hash);
		for (int i = 0; i < numberOfDigest; i++) {
			hash = PasswordUtil.sha256hash(hash.getBytes());
		}
		return hash;
	}

	public static String sha256hash(byte[] rawPassword) {
		MESSAGE_DIGEST.get().reset();
		MESSAGE_DIGEST.get().update(rawPassword);
		byte[] hash = MESSAGE_DIGEST.get().digest();

		//
		String encodedHash = BASE64_ENCODER.get().encodeBuffer(hash);
		return encodedHash.trim();
	}

	public static boolean isValid(String password) {

		if (StringUtils.isEmpty(password)) {
			return false;
		}

		// 誰か、いつか、正規表現で作り直してね。
		// 8桁以上～20桁以内
		if (!(8 <= password.trim().length() && password.trim().length() <= 20)) {
			return false;
		}

		// アルファベット大文字 && アルファベット小文字 && 数字 && 記号（）から3種類を利用する
		final boolean[] matches = new boolean[4];
		for (int i = 0; i < password.length(); i++) {
			final String s = Character.toString(password.charAt(i));
			if (LOWER_CASE_ALPHABETIC_CHARACTERS.contains(s)) {
				matches[0] = true;
				continue;
			} else if (UPPER_CASE_ALPHABETIC_CHARACTERS.contains(s)) {
				matches[1] = true;
				continue;
			} else if (NUMERIC_CHARACTERS.contains(s)) {
				matches[2] = true;
				continue;
			} else if (PUNCTUATION_CHARACTERES.contains(s)) {
				matches[3] = true;
				continue;
			}
			return false;
		}

		return ((matches[0] ? 1 : 0) + (matches[1] ? 1 : 0) + (matches[2] ? 1 : 0) + (matches[3] ? 1 : 0) >= 3);
	}
	
	public static boolean isValidAnswer(String password) {

		// アルファベット大文字 && アルファベット小文字 && 数字 から3種類を利用する
		final boolean[] matches = new boolean[3];
		for (int i = 0; i < password.length(); i++) {
			final String s = Character.toString(password.charAt(i));
			if (LOWER_CASE_ALPHABETIC_CHARACTERS.contains(s)) {
				matches[0] = true;
				continue;
			} else if (UPPER_CASE_ALPHABETIC_CHARACTERS.contains(s)) {
				matches[1] = true;
				continue;
			} else if (NUMERIC_CHARACTERS.contains(s)) {
				matches[2] = true;
				continue;
			}
			return false;
		}

		return ((matches[0] ? 1 : 0) + (matches[1] ? 1 : 0) + (matches[2] ? 1 : 0) >= 3);
	}

	public static void main(String[] args) {
		System.out.println(PasswordUtil.isValid("!QAZ2wsx"));
		System.out.println(PasswordUtil.isValid("1234567890-"));
		System.out.println(PasswordUtil.isValid("1234567890abc"));
		System.out.println(PasswordUtil.isValid("568tyiughjb#&'"));
		System.out.println(PasswordUtil.isValid("!A$%#&%$'&%90879"));
		System.out.println(PasswordUtil.isValid("568tyiughjb#&']"));
	}
}
