package com.example.springassignmentlv3.security.jwt;
import com.example.springassignmentlv3.exception.CustomException;
import com.example.springassignmentlv3.exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;



@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final HandlerExceptionResolver handlerExceptionResolver;
    public JwtAuthenticationEntryPoint(HandlerExceptionResolver handlerExceptionResolver) {
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)  {
        // 권한이 없는 경우 커스텀 예외 메시지 설정
//        if (authException instanceof AccessDeniedException) {
//            request.setAttribute("exception", new CustomException(ErrorCode.ACCESS_DENIED));
//        }

        // 권한이 없는 경우가 아니며 예외가 설정되어 있지 않다면 기본 예외 설정
        if (request.getAttribute("exception") == null) {
            request.setAttribute("exception", new CustomException(ErrorCode.UNEXPECTED_ERROR));
        }

        handlerExceptionResolver.resolveException(request, response, null, (Exception) request.getAttribute("exception"));
    }
}