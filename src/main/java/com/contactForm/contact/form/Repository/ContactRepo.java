package com.contactForm.contact.form.Repository;

import com.contactForm.contact.form.entity.FormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepo extends JpaRepository<FormData,Integer> {
}
