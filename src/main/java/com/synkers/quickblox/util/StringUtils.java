package com.synkers.quickblox.util;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

public class StringUtils {
    public StringUtils() {
    }

    public static String[] splitString(String var0, String var1) {
        StringTokenizer var2 = new StringTokenizer(var0, var1);
        String[] var3 = new String[var2.countTokens()];

        for (int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4] = var2.nextToken();
        }

        return var3;
    }

    public static String trimWhitespace(String var0) {
        if (var0 == null) {
            return var0;
        } else {
            StringBuffer var1 = new StringBuffer();

            for (int var2 = 0; var2 < var0.length(); ++var2) {
                char var3 = var0.charAt(var2);
                if (var3 != 10 && var3 != 12 && var3 != 13 && var3 != 9) {
                    var1.append(var3);
                }
            }

            return var1.toString().trim();
        }
    }

    public static String join(Collection var0, String var1) {
        StringBuffer var2 = new StringBuffer();

        for (Iterator var3 = var0.iterator(); var3.hasNext(); var2.append((String) var3.next())) {
            if (var2.length() != 0) {
                var2.append(var1);
            }
        }

        return var2.toString();
    }

    public static String replaceSeparators(String var0) {
        return var0.replace('/', '.').replace(File.separatorChar, '.');
    }
}
