package com.contactForm.contact.form.Service;

import com.contactForm.contact.form.Repository.ContactRepo;
import com.contactForm.contact.form.entity.FormData;
import com.contactForm.contact.form.entity.FormDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    private ContactRepo contactRepo;

    public FormDataResponse getFormData(int id ){
        FormData formData= contactRepo.getById(id);
        FormDataResponse formDataResponse = new FormDataResponse(formData.getId(),formData.getFirstName(), formData.getLastName(), formData.getBusinessName(), formData.getBusinessLocation(), formData.getBusinessType(), formData.getEmail(), formData.getPhone(), formData.getQuery());
        return  formDataResponse;
    }

    public int saveFormData(FormData formData){
       return contactRepo.saveAndFlush(formData).getId();
    }
}
