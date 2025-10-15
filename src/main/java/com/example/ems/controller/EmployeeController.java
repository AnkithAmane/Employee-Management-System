package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Web UI: list employees
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> list = service.findAll();
        model.addAttribute("employees", list);
        return "employees/list";
    }

    // Show form to add
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("pageTitle", "Add New Employee");
        return "employees/form";
    }

    // Save new/updated employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
        service.save(emp);
        return "redirect:/employees";
    }

    // Show form to edit
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee emp = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", emp);
        model.addAttribute("pageTitle", "Edit Employee (ID: " + id + ")");
        return "employees/form";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/employees";
    }
}
