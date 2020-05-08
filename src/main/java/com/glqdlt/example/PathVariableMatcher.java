package com.glqdlt.example;

public class PathVariableMatcher {

    public Boolean match(String originUrl, String targetUrl) {

        final String[] originSplit = originUrl.split("/");
        final String[] targetSplit = targetUrl.split("/");

        if (originSplit.length != targetSplit.length) {
            return false;
        }

        for (int i = 0; i < originSplit.length; i++) {
            if (!matchItem(originSplit[i], targetSplit[i])) {
                return false;
            }
        }
        return true;
    }

    public Boolean isWildCard(String origin) {
        if (origin.equals("*") || origin.equals("**")) {
            return true;
        }
        boolean a = origin.startsWith("${");
        boolean b = origin.endsWith("}");
        return a && b;
    }

    public Boolean isPathVariable(String origin) {
        boolean a = origin.startsWith("${");
        boolean b = origin.endsWith("}");
        return a && b;
    }

    public Boolean matchItem(String origin, String target) {
        if (isWildCard(origin) || isPathVariable(origin)) {
            return target.length() > 0;
        }

        return origin.equals(target);
    }


}
