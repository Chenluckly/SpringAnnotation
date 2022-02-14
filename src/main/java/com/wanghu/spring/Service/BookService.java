package com.wanghu.spring.Service;

import com.wanghu.spring.Dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author wanghu
 * @create 2021-11-15 21:52
 * @file com.wanghu.spring.Service-Administrator
 */
@Service
public class BookService {



//    @Qualifier("bookDao")
//    @Autowired(required = false)
//    @Resource
      @Inject
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
