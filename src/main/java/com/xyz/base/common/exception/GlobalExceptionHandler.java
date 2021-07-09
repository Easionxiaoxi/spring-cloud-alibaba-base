package com.xyz.base.common.exception;

import com.xyz.base.common.enums.StateCode;
import com.xyz.base.common.model.Result;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局统一异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 404无对应的控制器
     */
    @ExceptionHandler({NoHandlerFoundException.class})
    public Result<Object> noHandlerFound(NoHandlerFoundException e) {
        return Result.fail(StateCode.METHOD_NOT_FOUND);
    }

    /**
     * 405控制器中找不到该方法
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result<Object> methodNotSupported(HttpRequestMethodNotSupportedException e) {
        return Result.fail(StateCode.METHOD_NOT_SUPPORTED);
    }

    /**
     * 415请求头中content-type类型失配
     */
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result<Object> mediaTypeNotSupported(HttpMediaTypeNotSupportedException e) {
        return Result.fail(StateCode.MEDIA_TYPE_NOT_SUPPORTED);
    }

    /**
     * 缺少路径参数
     */
    @ExceptionHandler({MissingPathVariableException.class})
    public Result<Object> missingPathVariable(MissingPathVariableException e) {
        return Result.fail(StateCode.PATH_PARAM_MISS_ERROR);
    }

    /**
     * 缺少请求参数
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result<Object> missingRequestPara(MissingServletRequestParameterException e) {
        return Result.fail(StateCode.REQUEST_PARAM_MISS_ERROR);
    }

    /**
     * 参数类型失配
     */
    @ExceptionHandler({TypeMismatchException.class})
    public Result<Object> paramTypeMissMatch(TypeMismatchException e) {
        return Result.fail(StateCode.PARAM_TYPE_MISS_MATCH_ERROR);
    }

    /**
     * 参数json反序列化pojo失败
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result<Object> messageNotReadable(HttpMessageNotReadableException e) {
        return Result.fail(StateCode.PARAM_DESERIALIZATION_ERROR);
    }

    /**
     * pojo序列化json失败
     */
    @ExceptionHandler({HttpMessageNotWritableException.class})
    public Result<Object> messageNotWritable(HttpMessageNotWritableException e) {
        return Result.fail(StateCode.PARAM_SERIALIZATION_ERROR);
    }

    /**
     * 参数方式校验指定异常处理方法
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public Result<Object> constraint(ConstraintViolationException e) {
        List<String> collect = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        return Result.fail(StateCode.PARAM_VALID_ERROR.getCode(), String.join(",", collect));
    }

    /**
     * Bean方式校验指定异常处理方法
     */
    @ExceptionHandler({BindException.class})
    public Result<Object> bind(BindException e) {
        List<ObjectError> allErrors = e.getAllErrors();
        List<String> collect = new ArrayList<>();
        allErrors.forEach(error -> {
            FieldError fieldError = (FieldError) error;
            collect.add(fieldError.getDefaultMessage());
        });
        return Result.fail(StateCode.PARAM_VALID_ERROR.getCode(), String.join(",", collect));
    }

    /**
     * 注解方式的参数校验
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<Object> valid(MethodArgumentNotValidException e) {
        List<String> collect = e.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        return Result.fail(StateCode.PARAM_VALID_ERROR.getCode(), String.join(",", collect));
    }

    /**
     * 文件上传超出最大限制
     */
    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public Result<Object> maxUploadSize(MaxUploadSizeExceededException e) {
        return Result.fail(StateCode.MAX_UPLOAD_SIZE_ERROR);
    }

    /**
     * 统一异常处理方法，未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> unknownError(Exception e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }

    /**
     * 自定义异常处理方法
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Object> customerError(BusinessException e) {
        e.printStackTrace();
        return Result.fail(e.getCode(), e.getMessage());
    }
}
