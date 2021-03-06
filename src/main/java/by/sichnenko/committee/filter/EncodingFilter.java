package by.sichnenko.committee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param"),
                @WebInitParam(name = "contentType", value = "text/html", description = "Content type Param")})

public class EncodingFilter implements Filter {
    private String code;
    private String contentType;

    public void init(FilterConfig fConfig) throws ServletException {
        code = fConfig.getInitParameter("encoding");
        contentType = fConfig.getInitParameter("contentType");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();
        String codeResponse = response.getCharacterEncoding();
        String contentTypeRequest = request.getContentType();

        if (contentType != null && !contentType.equalsIgnoreCase(contentTypeRequest)) {
            response.setContentType(contentType);
        }

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
        }
        if (code != null && !code.equalsIgnoreCase(codeResponse)) {
            response.setCharacterEncoding(code);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        code = null;
        contentType = null;
    }
}

