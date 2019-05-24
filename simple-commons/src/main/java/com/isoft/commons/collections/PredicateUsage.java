package com.isoft.commons.collections;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.lang3.BooleanUtils;
//import org.apache.commons.lang.BooleanUtils;
//import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;

public class PredicateUsage {
	public static void main(String[] args){
		demoPredicates();
	}

	public static void demoPredicates() {
		System.out.println(StringUtils.center(" demoPredicates ", 40, "="));
		Predicate p1 = new InstanceofPredicate(String.class); // key line1
		Predicate p2 = NotNullPredicate.getInstance(); // key line2
		Predicate p3 = new Predicate() { // key line3
			public boolean evaluate(Object obj) {
				String str = (String) obj;
				return StringUtils.isAlphanumeric(str) && str.length() >= 6 && str.length() <= 10;
			}
		};
		Predicate p4 = PredicateUtils.allPredicate(new Predicate[] { p1, p2, p3 }); // key
																					// line4
		String input = "ABCD1234";
		Object[] raw = new Object[] { "Is '", input, "' a valid input? ",
				BooleanUtils.toStringYesNo(p4.evaluate(input)), "." };
		System.out.println(StringUtils.join(raw));
		System.out.println(StringUtils.repeat("=", 40));
	}
}