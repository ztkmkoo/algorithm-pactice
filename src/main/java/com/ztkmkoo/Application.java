package com.ztkmkoo;

import com.ztkmkoo.hackerrank.ClassLoadUtils;
import com.ztkmkoo.practice.KebronPractice;
import com.ztkmkoo.practice.Practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        runPracticeByAnnotation();
    }

    private static void runPracticeByAnnotation() {

        Date lastDate = null;
        Class<? extends Practice> lastPracticeClassType = null;

        try {
            final List<Class> practices = ClassLoadUtils.getClassListImplements("com.ztkmkoo", Practice.class);

            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            for (final Class cls : practices) {
                final KebronPractice kebronPractice = KebronPractice.class.cast(cls.getAnnotation(KebronPractice.class));
                if (kebronPractice == null)
                    continue;

                final String regDateString = kebronPractice.regDate();
                final Date date = simpleDateFormat.parse(regDateString);

                if (lastDate == null) {
                    lastDate = date;
                    lastPracticeClassType = cls;
                } else {
                    if (date.after(lastDate)) {
                        lastDate = date;
                        lastPracticeClassType = cls;
                    }
                }
            }

            if (lastPracticeClassType != null) {
                final Practice lastPractice = lastPracticeClassType.newInstance();
                lastPractice.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
