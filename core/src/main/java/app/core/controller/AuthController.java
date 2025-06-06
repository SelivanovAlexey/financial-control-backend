package app.core.controller;

import app.core.JsonHelper;
import app.core.model.AuthRequest;
import app.core.service.AuthServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    private final AuthServiceImpl authService;
    private final JsonHelper jsonHelper;

    //TODO: сделать нормальную обработку валидаций (exception handler)
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest authRequest, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        boolean isAuthSuccessful = authService.authenticate(authRequest, request, response);
        return isAuthSuccessful ? ResponseEntity.ok().build() : ResponseEntity.badRequest().body(jsonHelper.createJson(Map.of("message","Неправильные имя пользователя или пароль")));
    }

    //TODO: убрать нахер отсюда
    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testAuth() throws JsonProcessingException {
        return ResponseEntity.ok().body(jsonHelper.createJson(Map.of("message","Тестовый эндпоинт")));
    }

    //TODO: добавить рест для регистрации (удаления??) пользователя




}
