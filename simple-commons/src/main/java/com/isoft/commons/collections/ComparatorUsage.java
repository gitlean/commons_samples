package com.isoft.commons.collections;

import java.util.Arrays;
import java.util.Comparator;
 
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang.StringUtils;
 
/**
 * Comparator
 * @author john
 * @date 2018年10月3日
 * @time 上午8:19:02
 * @describe:
 */
public class ComparatorUsage {
    public static void main(String[] args) {
        demoComparator();
    }
    public static void demoComparator() {
        System.out.println(StringUtils.center(" demoComparator ", 40, "="));
        // data setup
        Issue[] issues = new Issue[] {
                new Issue(15102, "Major", "John"),
                new Issue(15103, "Minor", "Agnes"),
                new Issue(15104, "Critical", "Bill"),
                new Issue(15105, "Major", "John"),
                new Issue(15106, "Major", "John"),
                new Issue(15107, "Critical", "John"),
                new Issue(15108, "Major", "Agnes"),
                new Issue(15109, "Minor", "Julie"),
                new Issue(15110, "Major", "Mary"),
                new Issue(15111, "Enhancement", "Bill"),
                new Issue(15112, "Minor", "Julie"),
                new Issue(15113, "Major", "Julie")
        };
        // comparators setup
        String[] severityOrder = {"Critical", "Major", "Minor", "Enhancement"};
        Comparator severityComparator = new FixedOrderComparator(severityOrder);//key line1
        ComparatorChain compChain = new ComparatorChain();//key line2
        compChain.addComparator(new BeanComparator("owner"));
        compChain.addComparator(new BeanComparator("severity", severityComparator));
        compChain.addComparator(new BeanComparator("id"));
        // sort and display
        Arrays.sort(issues, compChain);//key line3
        for (int i = 0; i < issues.length; i++) {
            System.out.println(issues[i]);
        }
        System.out.println(StringUtils.repeat("=", 40));
    }
}
