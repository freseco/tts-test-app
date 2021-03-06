package com.artemnikitin.tts;

import org.junit.Test;

import java.util.Locale;

import static junit.framework.Assert.assertEquals;

public class FilterTest {

    @Test
    public void checkLocaleTransformationToString() {
        Filter filter = new Filter(new Locale[]{Locale.US});
        assertEquals("Locale should be properly transformed to string",
                "English (United States) (en_US)", filter.getListOfLocales().get(0));
    }

    @Test
    public void checkFilterWithNull() {
        Filter filter = new Filter(null);
        assertEquals("With null as input resulting list should be 0 size", 0,
                filter.getListOfLocales().size());
    }

    @Test
    public void checkFilterWithNullInLocaleArray() {
        Filter filter = new Filter(new Locale[]{Locale.US, null});
        assertEquals("With null as a parameter input resulting list should be 1 size", 1,
                filter.getListOfLocales().size());
        assertEquals("Locale should be properly transformed to string",
                "English (United States) (en_US)", filter.getListOfLocales().get(0));
    }

    @Test
    public void checkOrderingForFilter() {
        Filter filter = new Filter(new Locale[]{Locale.US, Locale.CANADA});
        assertEquals("First locale should be properly ordered", "English (Canada) (en_CA)",
                filter.getListOfLocales().get(0));
        assertEquals("Second locale should be properly ordered", "English (United States) (en_US)",
                filter.getListOfLocales().get(1));
    }

}
