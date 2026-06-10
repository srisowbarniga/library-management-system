package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.management.entity.IssueBook;

public interface IssueBookRepository extends JpaRepository<IssueBook, Long> {

}