package com.wanghu.spring.Controller;

import com.wanghu.spring.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author wanghu
 * @create 2021-11-15 21:51
 * @file com.wanghu.spring.Controller-Administrator
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
