package com.prj2.controller;

import com.prj2.domain.Board;
import com.prj2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/add")
    public String add() {
        return "board/add";
    }

    @PostMapping("/add")
    public String addPost(Board board) {
        service.add(board);

        return "redirect:/";
    }

    @GetMapping("/board")
    public String view(Integer id, Model model) {

        Board board = service.get(id);

        model.addAttribute("board", board);

        return "board/view";
    }

    @GetMapping("/")
    public String home(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        model.addAllAttributes(service.list(page));

        return "board/home";
    }

    @PostMapping("/delete")
    public String delete(Integer id) {
        service.remove(id);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modifyForm(Integer id, Model model) {
        Board board = service.get(id);

        model.addAttribute("board", board);

        return "board/modify";
    }

    @PostMapping("/modify")
    public String modifyPost(Board board, RedirectAttributes rttr) {
        service.modify(board);
        rttr.addAttribute("id", board.getId());

        return "redirect:/board";
    }
}