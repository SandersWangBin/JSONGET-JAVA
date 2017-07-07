package com.sanderswangbin.testsuites;

import com.sanderswangbin.pull.PullObj;

public class TestSuiteMain {
	public static void check(String pullReg, String... texts) {
		try {
			PullObj pobj = new PullObj(pullReg);
			for (String text : texts) {
				pobj.check(text);
				for (String v : pobj.vars().get(0).values()) System.out.println(v);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String... argv) {
		String pullReg = "r\'\"message\"\\s*:\\s*[\"]*([a-zA-Z0-9\\s\'\\._-]+)[\"]*\\s*\'.PULL({0}==[])";
		String[] texts = {"{\"message\": \"Created example object \'ExampleObj01\'\"}",
				"{\"message\": 2017-07-04}",
				"{\"message\": 2516}",
				"{\"message\": true}",
				"{\"message\": \"It is message\", \"id\": 2015}",
				"{\"message\": 4312, \"id\": 2015}",
				"{\"message\": 2017-07-05, \"id\": 2015}",};
		check(pullReg, texts);
	}
}
