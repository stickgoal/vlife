package com.woniuxy.vlife.movie.controller;

import com.woniuxy.vlife.movie.entity.Movie;
import com.woniuxy.vlife.movie.entity.Review;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("movie")
@CrossOrigin("*")
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    {
        Movie m1 = new Movie(1, "https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp", "肖申克的救赎", "　　20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是对自由的渴望仍促使他朝着心中的希望和目标前进。而关于其罪行的真相，似乎更使这一切朝前推进了一步……");
        m1.setReviews(Arrays.asList(new Review[]{
                new Review(1,"很好看",1,"张三",new Date()),
                new Review(2,"男人必看，实在太赞了",1,"李四",new Date())
        }));
        movies.add(m1);
        movies.add(new Movie(2,"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2561716440.webp","霸王别姬","段小楼（张丰毅）与程蝶衣（张国荣）是一对打小一起长大的师兄弟，两人一个演生，一个饰旦，一向配合天衣无缝，尤其一出《霸王别姬》，更是誉满京城，为此，两人约定合演一辈子《霸王别姬》。但两人对戏剧与人生关系的理解有本质不同，段小楼深知戏非人生，程蝶衣则是人戏不分。\n" +
                "　　段小楼在认为该成家立业之时迎娶了名妓菊仙（巩俐），致使程蝶衣认定菊仙是可耻的第三者，使段小楼做了叛徒，自此，三人围绕一出《霸王别姬》生出的爱恨情仇战开始随着时代风云的变迁不断升级，终酿成悲剧。"));
        movies.add(new Movie(3,"https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1484728154.webp","阿甘正传 Forrest Gump (1994)","阿甘（汤姆·汉克斯 饰）于二战结束后不久出生在美国南方阿拉巴马州一个闭塞的小镇，他先天弱智，智商只有75，然而他的妈妈是一个性格坚强的女性，她常常鼓励阿甘“傻人有傻福”，要他自强不息。\n" +
                "　　阿甘像普通孩子一样上学，并且认识了一生的朋友和至爱珍妮（罗宾·莱特·潘 饰），在珍妮和妈妈的爱护下，阿甘凭着上帝赐予的“飞毛腿”开始了一生不停的奔跑。\n" +
                "　　阿甘成为橄榄球巨星、越战英雄、乒乓球外交使者、亿万富翁，但是，他始终忘不了珍妮，几次匆匆的相聚和离别，更是加深了阿甘的思念。\n" +
                "　　有一天，阿甘收到珍妮的信，他们终于又要见面……"));
    }

    @RequestMapping("movies")
    public List<Movie> getAllMovies(){
        return movies;
    }

    @RequestMapping("detail")
    public Movie getDetail(int movieId){
        return movies.get(movieId-1);
    }


}
