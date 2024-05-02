package com.contactForm.contact.form.Service;

import com.contactForm.contact.form.Repository.ContactRepo;
import com.contactForm.contact.form.Repository.FormWriteRepository;
import com.contactForm.contact.form.entity.FormData;
import com.contactForm.contact.form.entity.FormDataResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private FormWriteRepository formWriteRepository;


    public FormDataResponse getFormData(int id ){


           try{
               Optional<FormData> optionalFormData = contactRepo.findById(id);
               FormData formData = optionalFormData.get();

               FormDataResponse formDataResponse = new FormDataResponse(formData.getId(),formData.getFirstName(), formData.getLastName(), formData.getBusinessName(), formData.getBusinessLocation(), formData.getBusinessType(), formData.getEmail(), formData.getPhone(), formData.getQuery(),formData.isResolved());
               return  formDataResponse;
           }
           catch(NoSuchElementException e){
               System.out.println("No data found for "+id);
               return null;
           }

    }

    public int saveFormData(FormData formData){
       return contactRepo.saveAndFlush(formData).getId();
    }

    public List<FormData> getAll() {
        List<FormData> alls= contactRepo.findAll();
        return alls;

    }

    public FormDataResponse updateFormData(int id){
        if(getFormData(id)==null){
            return null;

        }
        if(formWriteRepository.updateFormData(id)){
            FormDataResponse formData = formWriteRepository.getById(id);
//            FormDataResponse formDataResponse = new FormDataResponse(formData.getId(),formData.getFirstName(), formData.getLastName(), formData.getBusinessName(), formData.getBusinessLocation(), formData.getBusinessType(), formData.getEmail(), formData.getPhone(), formData.getQuery(),formData.isResolved());
            return  formData;
        }
        else {
            return null;
        }

    }
}
