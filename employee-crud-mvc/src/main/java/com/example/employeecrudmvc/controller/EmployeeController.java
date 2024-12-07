package com.example.employeecrudmvc.controller;

import com.example.employeecrudmvc.entity.Employee;
import com.example.employeecrudmvc.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/employee-delete")
    public String deleteEmployee(@RequestParam int id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
    @RequestMapping("/")
    public String listAllEmployee(Model model){
        model.addAttribute("employees",
                employeeService.listAllEmployee());
        model.addAttribute("success",model
                .containsAttribute("success"));
        model.addAttribute("update",model
                .containsAttribute("update"));
        return "index";
    }
    @GetMapping("/employee-update")
    public String updateEmployee(@RequestParam int id,Model model){
        model.addAttribute("employee"
                ,employeeService.findEmployeeById(id));
        this.id = id;
        return "employeeUpdate";
    }
    int id ;
    @PostMapping("/process-employee")
    public String processEmployee(@Valid Employee employee
            ,BindingResult result,RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
             return "employeeUpdate";
        }
        employeeService.updateEmployeeV2(employee,id);
        redirectAttributes.addFlashAttribute("update"
                ,true);
        return "redirect:/";
    }

    //the first face
    @GetMapping("/employee-form")
    public String employeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }
    //second face
    @PostMapping("/save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result,
                               RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "employeeForm";
        }
        employeeService.createEmployee(employee);
        redirectAttributes.addFlashAttribute("success"
                ,true);
        return "redirect:/";
    }

}
