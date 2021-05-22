package com.zj.settings.web.handle;


import com.zj.settings.exception.IPException;
import com.zj.settings.exception.LockException;
import com.zj.settings.exception.MyException;
import com.zj.settings.exception.PriceException;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Object myException(Exception exception){
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }

    @ExceptionHandler(PriceException.class)
    @ResponseBody
    public Object priceDateException(Exception exception){
        return exception.getMessage();
    }

    @ExceptionHandler(IPException.class)
    @ResponseBody
    public Object ipException(Exception exception){
        return exception.getMessage();
    }

    @ExceptionHandler(LockException.class)
    @ResponseBody
    public Object lockException(Exception exception){
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }
}
