package com.nagarro.controller;

import com.nagarro.model.Book;
import com.nagarro.model.BookInput;
import com.nagarro.model.LoginCredentials;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookInputService;
import com.nagarro.service.BookService;
import com.nagarro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;
    @Autowired
    BookInputService bookInputService;

    @Autowired
    AuthorService authorService;
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("loginCredentials", new LoginCredentials());
        return "login";
    }
    @GetMapping("login")
    public  String goToLogin(){
        return "redirect:/";
    }

    @PostMapping("validate")
    public String checkLogin(@Valid @ModelAttribute("loginCredentials") LoginCredentials loginCredentials, BindingResult bindingResult,HttpSession httpSession){
        if(bindingResult.hasErrors()){
            return "login";
        }

        if(userService.checkValidUser(loginCredentials)){
            httpSession.setAttribute("loginData", loginCredentials);
            return "redirect:/books";
        }
        return "login";
        }
    @GetMapping("books")
    public  String showList(Model model){
        model.addAttribute("bookList",bookService.getAll());
        return "managebooks";
    }


    @GetMapping("formForAdd")
    public String addForm(Model model){
        BookInput bookInput=new BookInput();
        bookInput.setAuthorNameOptions(bookInputService.populateAuthorName());
        bookInput.setAddedDate(bookInputService.setCurrentDate());
        model.addAttribute("book",bookInput);
        return "add";
    }
    @PostMapping("validate-add-books")
    public String validateAdd(@Valid @ModelAttribute("book") BookInput bookInput,BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            return "add";
        }

        try {
            if(bookService.checkValidId(bookInput)){
                return "redirect:/formForAdd";
            }
        }catch (Exception e){
            return "redirect:/formForAdd";
        }
        Book book= bookService.getBookObject(bookInput);
        bookService.add(book);

        return "redirect:/books";
    }
    @GetMapping("formForUpdate/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("book" ,bookInputService.getBookInputObject(id));
        return "update";
    }

    @PostMapping("formForUpdate/validate-update-books")
    public String validateUpdate(@Valid @ModelAttribute("book") BookInput bookInput,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update";
        }
        bookService.add(bookService.getBookObject(bookInput));
        return "redirect:/books";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginData");
        session.invalidate();
        return "redirect:/";
    }


}
