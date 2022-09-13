package br.com.baseapp.filters;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import br.com.baseapp.components.DateUtil;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
// @AllArgsConstructor
public class StateRequest implements Filter{

    @Override
    public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
 
        System.out.println("\n\n-FILTER----------------------\n\n");
        log.info(DateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        System.out.println("Request URI is: " + req.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("Response Status Code is: " + res.getStatus());
        System.out.println("\n\n-FILTER----------------------\n\n");
    }
    
}
