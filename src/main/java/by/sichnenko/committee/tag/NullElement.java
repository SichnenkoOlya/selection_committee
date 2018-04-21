package by.sichnenko.committee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class NullElement  extends TagSupport {
    private Object element;

    public void setTest(Object element) {
        this.element = element;
    }

    @Override
    public int doStartTag() throws JspException {
        return element == null ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }
}