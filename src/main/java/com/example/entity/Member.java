package com.example.entity;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document(collection = "members")
@Data
public class Member {

    @Id
        private String id;  // Unique member ID
        private String name;  // Member's name
        private String email;  // Member's email address
        private String phoneNumber;  // Member's phone number
        private LocalDate membershipDate;  // Date when the membership was created
        private LocalDate membershipExpiryDate;
        public LocalDate getMembershipExpiryDate() {
            return membershipExpiryDate;
        }

        // Constructors
        public Member() {}
    
        public Member(String name, String email, String phoneNumber, LocalDate membershipDate, LocalDate membershipExpiryDate) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.membershipDate = membershipDate;
            this.membershipExpiryDate = membershipDate.plusYears(3);
    
        }
    
        // Getters and Setters
        public String getId() {
            return id;
        }
    
        public void setId(String id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getPhoneNumber() {
            return phoneNumber;
        }
    
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
            public LocalDate getMembershipDate() {
                return membershipDate;
            }
        
    
    
        public void setMembershipDate(LocalDate membershipDate) {
            this.membershipDate = membershipDate;
        }
    
        
        public LocalDate getMembershipExpirationDate() {
            return getMembershipExpirationDate();
        }
    
        public void setMembershipExpirationDate(LocalDate membershipExpirationDate) {
            this.membershipExpiryDate = membershipExpirationDate;
        }
    
        // Utility method to extend membership by 4 years
        public void extendMembership() {
            this.membershipExpiryDate = this.membershipExpiryDate.plusYears(4);
        }
    
    @Override
    public String toString(){return "Member{"+ "Member ID : " + id +", Member Name :" + name + ",Member Email : " + email +", Member phone Number : " + phoneNumber +", Membership Date : "+ membershipDate +", Membership Expiry Date : "+ membershipExpiryDate+'\'' + '}';}
       
}


    
    
             
