package by.sichnenko.committee.tag;

import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * The EmptyListTag class.
 * If list is empty then include body, else skip body.
 */
public class EmptyListTag extends TagSupport {
    private int items;

    public void setItems(List<Object> itemsList) {
        this.items = itemsList.size();
    }

    @Override
    public int doStartTag() {
        return items == 0 ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }
}