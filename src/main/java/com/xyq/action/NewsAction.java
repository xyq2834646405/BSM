package com.xyq.action;

import com.xyq.service.INewsService;
import com.xyq.util.action.DefaultAction;
import com.xyq.vo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/pages/news/*")
public class NewsAction extends DefaultAction {
    @Autowired
    private INewsService newsService;

    @RequestMapping(value = "news_insert")
    public ModelAndView insert(News news){
        news.setPubdate(new Date());
        ModelAndView mav = new ModelAndView(getResource("forward.page"));
        try {
            if (newsService.insert(news)){
                setMsgAndPath(mav,"vo.insert.success","news.insert.page");
            }else{
                setMsgAndPath(mav,"vo.insert.failure","news.insert.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping(value = "news_checkTitle")
    public void checkTitle(HttpServletResponse response,String title){
        try {
            print(response,newsService.checkTitle(title));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "news_checkTitleForUpdate")
    public void checkTitleForUpdate(HttpServletResponse response,int nid,String title){
        try {
            print(response,newsService.checkTitleForUpdate(nid,title));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "news_update")
    public void update(HttpServletResponse response,News news){
        try {
            print(response,newsService.update(news));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "news_delete")
    public void delete(HttpServletResponse response,String ids){
        List<Integer> all = new ArrayList<Integer>();
        String[] result = ids.split("\\|");
        for (int i = 0; i < result.length; i++) {
            all.add(Integer.parseInt(result[i]));
        }
        try {
            print(response,newsService.delete(all));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "news_list")
    public void list(HttpServletRequest request,HttpServletResponse response){
        handSplit(request);//处理分页参数
        try {
            Map<String, Object> map = newsService.list(getCurrentPage(), getLineSize());
            List<News> all = (List<News>)map.get("allNewses");
            Integer allRecorders = (Integer)map.get("newsCount");
            printListSplitJson(response,"allNewses",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return "新闻";
    }
}
