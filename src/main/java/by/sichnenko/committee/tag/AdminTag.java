package by.sichnenko.committee.tag;

import by.sichnenko.committee.model.RoleType;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AdminTag extends TagSupport {
    private RoleType role;

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        return role == RoleType.ADMIN ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }
}