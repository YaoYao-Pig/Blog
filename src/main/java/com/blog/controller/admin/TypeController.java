package com.blog.controller.admin;

import com.blog.pojo.Type;
import com.blog.service.TypeService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String list(@PageableDefault(size = 8,sort={"id"},direction = Sort.Direction.DESC) Pageable pageable,
                                        Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }
    //提交新的type
    @PostMapping("/types")
    public String post(Type type, RedirectAttributes attributes){
        System.out.println("111111111");
        //这里的Type对象，可以看到前端type-input中有一个name属性，会自动封装
        Type typeTest=typeService.getTypeByName(type.getName());
        //System.out.println(typeTest.getName());
        if(typeTest!=null){
            attributes.addFlashAttribute("message","该分类已存在");
        }
        else{
            Type t= typeService.saveType(type);
            if(t==null){
                attributes.addFlashAttribute("message","操作失败");
                //
            }
            else{
                attributes.addFlashAttribute("message","操作成功");
                //
            }

        }
        return "redirect:/admin/types";
    }
    @PostMapping("/types/{id}")
    public String post(Type type, @PathVariable Long id, RedirectAttributes attributes){
        System.out.println("111111111");
        //这里的Type对象，可以看到前端type-input中有一个name属性，会自动封装
        Type typeTest=typeService.getTypeByName(type.getName());
        //System.out.println(typeTest.getName());
        if(typeTest!=null){
            attributes.addFlashAttribute("message","该分类已存在");
        }
        else{
            Type t= typeService.updateType(id,type);
            if(t == null){
                attributes.addFlashAttribute("message","更新失败");
                //
            }
            else{
                attributes.addFlashAttribute("message","跟新成功");
                //
            }

        }
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }

}
