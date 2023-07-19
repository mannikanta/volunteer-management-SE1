package com.volunteer.management.utility;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VolunteerEntityToDto {

    public List<VolunteerDto> convertEntityToDto(List<Volunteer> vol){
        List<VolunteerDto> dto = new ArrayList<>();

        for(int i = 0; i< vol.size(); i++) {
            VolunteerDto dto1 = new VolunteerDto();
            dto1.setId(vol.get(i).getId());
            dto1.setVolunteerFirstName(vol.get(i).getPersonalDetails().getVolunteerFirstName());
            dto1.setVolunteerId(vol.get(i).getVolunteerId());
            dto1.setEmailAddress(vol.get(i).getContactDetails().getEmailAddress());
            dto.add(dto1);
        }
        return dto;
    }
}
