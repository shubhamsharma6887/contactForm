package com.contactForm.contact.form.Repository;

import com.contactForm.contact.form.entity.FormDataResponse;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormDataMapper implements RowMapper<FormDataResponse> {

    @Override
    public FormDataResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        FormDataResponse formDataResponse = new FormDataResponse();
        formDataResponse.setId(rs.getInt("id"));
        formDataResponse.setResolved(rs.getBoolean("is_resolved"));
        formDataResponse.setFirstName(rs.getString("first_name"));
        formDataResponse.setLastName(rs.getString("last_name"));
        formDataResponse.setBusinessLocation(rs.getString("business_location"));
        formDataResponse.setBusinessName(rs.getString("business_name"));
        formDataResponse.setBusinessType(rs.getString("business_type"));
        formDataResponse.setEmail(rs.getString("email"));
        formDataResponse.setPhone(rs.getString("phone"));
        formDataResponse.setQuery(rs.getString("query"));

        return formDataResponse;
    }
}
