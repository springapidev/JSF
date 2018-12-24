package com.project.web.util;

import java.text.NumberFormat;

public class ParamUtil {

    static public Long longValue(String strValue) {
        Long reValue = null;
        if ((strValue == null) || (strValue.trim().equals(""))) {
            strValue = null;
        }

        NumberFormat nf = NumberFormat.getInstance();
        try {
            reValue = (Long) nf.parse(strValue).longValue();
        } catch (Exception ex) {
        }
        return reValue;
    }

}
