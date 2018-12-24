package com.coderbd;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author User
 */
public class SayHellosTag extends SimpleTagSupport {

    List<String> list = new ArrayList();

    public SayHellosTag() {
        init();
    }

    private void init() {
        list.add("Bangladesh");
        list.add("Australia");
        list.add("Germany");
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            // connect to database

            String output = "<select>";

            for (String s : list) {
                System.out.println(": " + s);
                output += "<option value='" + s + "'>" + s + "</option>";
            }
            output += "</select>";
            out.println(output);

        } catch (Exception ex) {
            throw new JspException("Error in  tag", ex);
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
