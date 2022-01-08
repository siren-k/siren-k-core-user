package com.sirenk.core.user.interfaces.user.session;

import com.sirenk.core.user.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserSessionInterceptor implements HandlerInterceptor {

    private final HttpSession httpSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // handler 종류 확인 => HandlerMethod 타입인지 체크
        // HandlerMethod가 아니면 그대로 진행
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        // @RoleGuard 받아오기
        RoleGuard roleGuard = handlerMethod.getMethodAnnotation(RoleGuard.class);

        // method에 @MySequred가 없는 경우, 즉 인증이 필요 없는 요청
        if (roleGuard == null) {
            return true;
        }

        // @RoleGuard가 있는 경우이므로, 세션이 있는지 체크
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("/my-error");
            return false;
        }

        // 세션이 존재하면 유효한 유저인지 확인
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/my-error");
            return false;
        }

        // admin일 경우
        String role = roleGuard.role().toString();
        if (role != null) {
            if ("ADMIN".equals(role)) {
                if (user.getRole() != Role.ADMIN) {
                    response.sendRedirect("/my-error");
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {
    }

}
