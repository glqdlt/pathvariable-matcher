package com.glqdlt.example;

import org.junit.Assert;
import org.junit.Test;

public class PathVariableMatcherTest {

    @Test
    public void good() {
        String s1 = "/api/${context}/user/${name}/detail";
        String s2 = "/api/a/user/jhun/detail";
        PathVariableMatcher pathVariableMatcher = new PathVariableMatcher();
        Assert.assertTrue(pathVariableMatcher.match(s1, s2));
    }

    @Test
    public void wrong1() {
        String s1 = "/api/${context}/user/${name}/detail2";
        String s2 = "/api/a/user/jhun/detail";
        PathVariableMatcher pathVariableMatcher = new PathVariableMatcher();
        Assert.assertFalse(pathVariableMatcher.match(s1, s2));
    }

    @Test
    public void wrong2() {
        String s1 = "/api/${context}/user/${name}/detail";
        String s2 = "/api/a/user/jh/un/detail";
        PathVariableMatcher pathVariableMatcher = new PathVariableMatcher();
        Assert.assertFalse(pathVariableMatcher.match(s1, s2));
    }

    @Test
    public void wrong3() {
        String s1 = "/api/${context}/user/${name}/detail";
        String s2 = "/api/a/user//detail";
        PathVariableMatcher pathVariableMatcher = new PathVariableMatcher();
        Assert.assertFalse(pathVariableMatcher.match(s1, s2));
    }

    @Test
    public void wrong4() {
        String s1 = "/api/${context}/user/${name}/detail";
        String s2 = "/";
        PathVariableMatcher pathVariableMatcher = new PathVariableMatcher();
        Assert.assertFalse(pathVariableMatcher.match(s1, s2));
    }

    @Test
    public void wrong5() {
        String s1 = "/api/${context}/user/${name}/detail/";
        String s2 = "/api/a/user/jhun/detail";
        PathVariableMatcher pathVariableMatcher = new PathVariableMatcher();
        Assert.assertTrue(pathVariableMatcher.match(s1, s2));
    }
}