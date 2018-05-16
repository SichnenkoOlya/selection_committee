package by.sichnenko.committee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {
    private static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy";

    @Override
    public int doStartTag() throws JspException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        Date date=new Date();
        JspWriter out = pageContext.getOut();
        try {
            out.write(dateFormat.format(date));
        } catch (IOException e) {
            throw new JspException("Write output error", e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag(){
        return EVAL_PAGE;
    }
}
