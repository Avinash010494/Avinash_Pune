package com.mahindrafinance.assignment.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AdvisorDetails")
public class Advisor {

    @Id
    @Column(name = "id")
    String advisorId;
    @Column(name = "Name")
    String advisorName;
    @Column(name = "Profile_Pic")
    String advisorProfilePicUrl;

}
