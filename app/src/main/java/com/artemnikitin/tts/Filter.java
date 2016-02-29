package com.artemnikitin.tts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class Filter {

    private final Locale[] locales;

    public Filter(Locale[] locales) {
       this.locales = locales;
    }

    public List<String> getListOfLocales() {
        List<String> res = processLocales(filter(locales));
        Collections.sort(res);
        return res;
    }

    private Locale[] filter(Locale[] locales) {
        List<Locale> result = new ArrayList<>();
        for (Locale locale : locales) {
            if (locale.toString().contains("_") && locale.toString().length() == 5) {
                result.add(locale);
            }
        }
        Locale[] array = new Locale[result.size()];
        return result.toArray(array);
    }

    private List<String> processLocales(Locale[] locales) {
        List<String> result = new ArrayList<>(locales.length);
        for (Locale loc : locales) {
            result.add(loc.getDisplayName() + " (" + loc.toString() + ")");
        }
        return result;
    }

}
