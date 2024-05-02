package com.contactForm.contact.form.Controller;


import com.contactForm.contact.form.Service.FormService;
import com.contactForm.contact.form.entity.FormData;
import com.contactForm.contact.form.entity.FormDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/api/form")
    public ResponseEntity<Integer> saveForm(@RequestBody FormData formData){

        return ResponseEntity.ok().body(formService.saveFormData(formData));

    }
    @GetMapping("/api/form/{id}")
    public ResponseEntity<FormDataResponse>getFormData(@PathVariable int id){
        FormDataResponse form = formService.getFormData(id);
        if(Objects.isNull(form)){
            return  ResponseEntity.notFound().build();

        }
        else{
            return ResponseEntity.ok().body(form);
        }
    }


}
