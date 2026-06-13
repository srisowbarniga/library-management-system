package com.library.management.controller;

import com.library.management.entity.IssueBook;
import com.library.management.repository.IssueBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyAccountController {

    @Autowired
    private IssueBookRepository issueBookRepository;

    @GetMapping("/my-account")
    public String myAccount(Model model) {

        List<IssueBook> issueBooks = issueBookRepository.findAll();
        List<Map<String, Object>> accountData = new ArrayList<>();

        for (IssueBook issue : issueBooks) {
            Map<String, Object> row = new HashMap<>();
            row.put("bookId", issue.getBook_id());
            row.put("issueDate", issue.getIssue_date());
            row.put("returnDate", issue.getReturn_date());

            String dueDateStr = "-";
            double fine = 0;

            try {
                LocalDate issueDate = LocalDate.parse(issue.getIssue_date());
                LocalDate dueDate = issueDate.plusDays(14);
                dueDateStr = dueDate.toString();

                if (issue.getReturn_date() == null || issue.getReturn_date().isEmpty()) {
                    LocalDate today = LocalDate.now();
                    if (today.isAfter(dueDate)) {
                        long daysLate = ChronoUnit.DAYS.between(dueDate, today);
                        fine = daysLate * 5.0;
                    }
                }
            } catch (Exception e) {
                // if date format is invalid, skip due date/fine calculation
            }

            row.put("dueDate", dueDateStr);
            row.put("fine", fine);

            accountData.add(row);
        }

        model.addAttribute("accountData", accountData);
        return "my-account";
    }
}