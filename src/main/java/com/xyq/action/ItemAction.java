package com.xyq.action;

import com.xyq.service.IItemService;
import com.xyq.util.action.DefaultAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/pages/item/*")
public class ItemAction extends DefaultAction {
    @Autowired
    private IItemService itemService;

    @RequestMapping(value = "item_list")
    public void list(HttpServletResponse response){
        try {
            printListJson(response,"allItems",itemService.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return "新闻类型";
    }
}
