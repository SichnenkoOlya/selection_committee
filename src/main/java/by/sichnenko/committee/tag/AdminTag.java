package by.sichnenko.committee.tag;

import by.sichnenko.committee.model.RoleType;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * The AdminTag class.
 * If user role is admin then include body, else skip body.
 */
public class AdminTag extends TagSupport {
    private RoleType role;

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public int doStartTag() {
        return role == RoleType.ADMIN ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }
}