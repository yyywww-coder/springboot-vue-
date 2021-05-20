package com.woniu.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: News <br/>
 * Description: <br/>
 * date: 2021/5/12 20:06<br/>
 *
 * @author hasee<br />
 */
@Data
public class News {
    private int id ;
    private String title;
    private String image;
    private int log ;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date day;
    private String cotent;
}
