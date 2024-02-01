package ca.sheridancollege.lenguyen.diceapp.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLogFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(RequestLogFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String requestUri = ((HttpServletRequest)servletRequest).getRequestURI();

        log.info("received request for " + requestUri);
        log.info("Request type " + ((HttpServletRequest) servletRequest).getMethod());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("response send for requested " + requestUri);
        log.info("**************************************** ");
    }
}
