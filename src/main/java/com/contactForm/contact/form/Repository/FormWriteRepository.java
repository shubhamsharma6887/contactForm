package com.contactForm.contact.form.Repository;

import com.contactForm.contact.form.entity.FormData;
import com.contactForm.contact.form.entity.FormDataResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FormWriteRepository extends JdbcDaoSupport {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() {
        setDataSource(dataSource);
    }
    public boolean updateFormData(int id){
       return getJdbcTemplate().update(String.format("UPDATE FORMDATA SET IS_RESOLVED =TRUE WHERE ID = %d",id))>0;
    }

    public FormDataResponse getById(int id) {
      String query=  String.format("SELECT * FROM FORMDATA WHERE ID = %d",id);
     List<FormDataResponse> rs = getJdbcTemplate().query(query, new FormDataMapper());
        System.out.println(rs.get(0).getBusinessLocation());
        return rs.get(0);
    }

    public List<FormDataResponse> getActiveQueries(String status) {
        String query=  String.format("SELECT * FROM FORMDATA WHERE is_resolved = %s",status);
        return getJdbcTemplate().query(query,new FormDataMapper());
    }
}
