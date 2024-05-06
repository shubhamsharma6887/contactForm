package com.contactForm.contact.form.Controller;


import com.contactForm.contact.form.Service.FormService;
import com.contactForm.contact.form.entity.FormData;
import com.contactForm.contact.form.entity.FormDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
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
        System.out.println("get one");
        FormDataResponse form = formService.getFormData(id);
        if(Objects.isNull(form)){
            return  ResponseEntity.notFound().build();

        }
        else{
            return ResponseEntity.ok().body(form);
        }
    }

    @GetMapping("/api/form")
    public ResponseEntity<List<FormDataResponse>>getFormData(@RequestParam String status){
        System.out.println("get all "+status);
        return ResponseEntity.ok().body( formService.getAll(status));
    }

    @PatchMapping("/api/form/{id}")
    public ResponseEntity<FormDataResponse>updateFormData(@PathVariable int id){
        FormDataResponse form = formService.updateFormData(id);
        if(Objects.isNull(form)){
            return  ResponseEntity.notFound().build();

        }
        else{
            return ResponseEntity.ok().body(form);
        }
    }


}
